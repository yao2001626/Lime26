/*
 * local_queue.c
 *
 *  Created on: Feb. 19, 2019
 *      Author: yaos4
 */

//Local Queue
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>
#include "global_queue.h"
#include "local_queue.h"
#include "atomic_instr.h"

// Put the suspended coroutine on the local queue
// Executed only by the worker thread.
void susqput(void * ptr){
	unsigned int h, t;
	h = atomic_Load(&lq[thread_id].susqhead); // load acquire
	t = lq[thread_id].susqtail;
	if(t-h >= MAX_SUSQ_SIZE){
		printf("susqpput: suspended queue of thread %d overflow\n", thread_id);
		exit(1);
	}
	lq[thread_id].susq[t%MAX_SUSQ_SIZE] = ptr;
	lq[thread_id].susqtail = t + 1;
}

// get one suspended coroutine on the local queue
// Executed only by the worker thread.
void * susqget(){
	void * obj_ptr;
	unsigned int h, t;
	h = lq[thread_id].susqhead;
	t = lq[thread_id].susqtail;
	if(h == t){
		return NULL;
	}
	obj_ptr = lq[thread_id].susq[h%MAX_RUNQ_SIZE];
	lq[thread_id].susqhead = h + 1;
	while(!__sync_bool_compare_and_swap((int *)(obj_ptr+8), 0, 1));//busy waiting
	return obj_ptr;
}

// Put one coroutine on the local queue
// If the run queue is full, puts half of the coroutines on the global queue.
// Executed only by the worker thread.
void runqput(void * ptr){
    unsigned int h, t;
    //inqueue
retry:
    h = atomic_Load(&lq[thread_id].runqhead); // load acquire
    t = lq[thread_id].runqtail;
    if(t-h < MAX_RUNQ_SIZE){
        lq[thread_id].runq[t%MAX_RUNQ_SIZE] = ptr;
        atomic_Store(&lq[thread_id].runqtail, t+1); // store release
        if(debug_open) printf("runqput: put the coroutine %p on the thread %d local queue\n", ptr, thread_id );
        return;
    }
    if(runqputslow(ptr, h, t)){
    	printf("runqputslow\n");
        return;
    }
    goto retry;
}

// Get one coroutine from local queue
// Executed only by the owner worker thread.
void* runqget(){
    unsigned int h, t;
    void *obj_ptr;

    while(1){
        h = atomic_Load(&lq[thread_id].runqhead); // load-acquire, synchronize with other consumers
        t = lq[thread_id].runqtail;
        if(t==h){
            return NULL;
        }
        obj_ptr = lq[thread_id].runq[h%MAX_RUNQ_SIZE];
        //while(!__sync_bool_compare_and_swap((int *)(obj_ptr+8), 0, 1));//busy waiting
        if(atomic_Cas(&lq[thread_id].runqhead, &h, h+1)){// CAS-release, commit the consumption
        	if(debug_open) printf("runqget: get a coroutine %p from worker thread %d\n", obj_ptr, thread_id);
        	while(!__sync_bool_compare_and_swap((int *)(obj_ptr+8), 0, 1));//busy waiting
        	return obj_ptr;
        }
    }
}



// Put current coroutine and a batch of coroutines from local queue on global queue.
// Executed only by the owner worker thread.
int runqputslow(void *cur_obj, unsigned int h, unsigned int t){
    void * batch[MAX_RUNQ_SIZE/2 + 1];
    unsigned int n, i;
    n = t - h;
	n = n / 2;

    if (n!=MAX_RUNQ_SIZE/2) {
		printf("runqputslow: queue is not full\n");
        exit(1);
        //return 0;
	}

    for (i=0; i<n; i++) {
		batch[i] = lq[thread_id].runq[(h+i)%MAX_RUNQ_SIZE];
	}

    if (!atomic_Cas(&lq[thread_id].runqhead, &h, h+n)) { // cas-release, commits consume
		return 0;
	}
    batch[n] = cur_obj;

    // link the coroutines
    for(i=0;i<n;++i){
		*((void **)(batch[i]+12)) = batch[i+1];
    }

    // Now put the batch on global queue.
    pthread_mutex_lock(&threads_mutex);
	globrunqputbatch(batch[0],batch[n], n+1);
	pthread_mutex_unlock(&threads_mutex);
    return 1;
}


// Steal half of elements from local runnable queue of victim worker threads
// and put onto local runnable queue of current worker thread.
// Returns one of the stolen elements
// modified: void * runqsteal(int t_id)

void * runqsteal(int t_id){
    unsigned int t, h, n;
    void *obj_ptr;

    t = lq[thread_id].runqtail;
	n = runqgrab(t_id, lq[thread_id].runq, t);
    if (n == 0) {
		return NULL;
	}
	n--;
    obj_ptr = lq[thread_id].runq[(t+n)%MAX_RUNQ_SIZE];

    if (n > 0) {
		h = atomic_Load(&lq[thread_id].runqhead); // load-acquire, synchronize with consumers
		if (t-h+n >= MAX_RUNQ_SIZE) {
			printf("runqsteal: runq overflow");
			exit(1);
		}
		atomic_Store(&lq[thread_id].runqtail, t+n); // store-release, makes the item available for consumption
    }
	if(debug_open)printf("thread %d steals %d coroutines from thread %d\n", thread_id, n+1, t_id);
	while(!__sync_bool_compare_and_swap ((int *)(obj_ptr+8), 0, 1));//busy waiting
	return obj_ptr;
}


// Grabs a batch of coroutines from worker thread's runnable queue into batch.
// Batch is a ring buffer starting at batchHead.
// Returns number of grabbed coroutines.
// Can be executed by any worker thread.

int runqgrab(int victim_id, void ** batch, unsigned int batchHead){
    unsigned int h, t, n, i;
    void * obj_ptr;
    while(1){
        h = atomic_Load(&lq[victim_id].runqhead); // load-acquire, synchronize with other consumers
        t = atomic_Load(&lq[victim_id].runqtail); // load-acquire, synchronize with the producer
        n = t - h;
        n = n - n/2;
        if(n > MAX_RUNQ_SIZE/2){ // read inconsistent h and t
            continue;
        }
        for(i=0; i<n; ++i){
            obj_ptr = lq[victim_id].runq[(h+i)%MAX_RUNQ_SIZE];
            batch[(batchHead+i)%MAX_RUNQ_SIZE] = obj_ptr;
        }
        if(atomic_Cas(&lq[victim_id].runqhead, &h, h+n)){ // cas-release, commits consume
            return n;
        }

    }
}
