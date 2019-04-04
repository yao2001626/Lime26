/*
 * scheduler.c
 *
 *  Created on: Feb. 19, 2019
 *      Author: yaos4
 */
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "global_queue.h"
#include "local_queue.h"
#include "scheduler.h"

void * schedule(){
    while(1){
        void * ptr = findrunnable();
        if(status == WORKING &&  ptr != NULL){ // case 1
        	if(debug_open) printf("scheduler: switch_to to %p thread %d\n", ptr, thread_id);
        	switch_to(ptr);
            if(debug_open) printf("scheduler: switch_sched_to from %p thread %d\n", ptr, thread_id);
        }else if(status == WORKING &&  ptr == NULL){ // case 2 WORKING ->SEEKING or TERMINATING or SLEEPING
            pthread_mutex_lock(&threads_mutex);
            //if((s==1 && w==1) || (s==0 && W==1)){ // terminal
            if((s==1 && w==1) ){ // terminal
            	if(debug_open)printf("Terminating!, s: %d w: %d W: %d thread: %d ptr: %p\n", s, w, W, thread_id, ptr);
                exit(1);
            }else if(s==0 && w==W){
                w--;
                s++;
                status=SEEKING;
                if(debug_open)printf("scheduler: becomes seeking  %p, thread %d\n", ptr, thread_id);
            }else if(s==1 && w>1 && w<W){
                w--;
                pthread_cond_wait(&threads_cv, &threads_mutex);
                status=SEEKING;
                if(debug_open)printf("scheduler: wait seeking 2  %p, thread %d\n", ptr, thread_id);
            }else{
                printf("Should not be here! \n Case 2: working -> seeking or terminating\n");
                exit(1);
            }
            pthread_mutex_unlock(&threads_mutex);
        }else if(status == SEEKING &&  ptr != NULL){// case 3
            pthread_mutex_lock(&threads_mutex);
            if(w<W-1){
                w++;
                status=WORKING;
                pthread_cond_signal(&threads_cv);
                if(debug_open)printf("scheduler: working and signal %p, thread %d\n", ptr, thread_id);
            }else if(w==W-1){
                w++;
                s--;
                status=WORKING;
                if(debug_open)printf("scheduler: working %p thread %d\n", ptr, thread_id);
            }else{
                printf("Should not be here! \n Case 3 \n");
                exit(1);
            }
            pthread_mutex_unlock(&threads_mutex);
            if(debug_open)printf("scheduler: switch_to to %p thread %d\n", ptr, thread_id);
            switch_to(ptr);
            if(debug_open)printf("scheduler: switch_sched_to from %p thread %d\n", ptr, thread_id);
        }else if(status == SEEKING &&  ptr == NULL){// case 4
            // continue;
        	pthread_mutex_lock(&threads_mutex);
        		if(s==1&&w==0){
        			printf("Terminating!, s: %d w: %d W: %d thread: %d ptr: %p\n", s, w, W, thread_id, ptr);
        			exit(1);
        		}
        	pthread_mutex_unlock(&threads_mutex);
        	if(debug_open)printf("thread %d is seeking\n", thread_id);
        }else{
            //printf("Should not be here! \n Case 4\n");
            exit(1);
        }
    }
    printf("Error: scheduler should not return\n");
    exit(1);
}

void * findrunnable(){
    void * obj_ptr;
    // local runq
	if(NULL != (obj_ptr = runqget())) {
		if(debug_open) printf("runqget: get one coroutine %p from thread %d\n", obj_ptr, thread_id);
		return obj_ptr;
	}

	// global runq
	if(gq->size>0){
		pthread_mutex_lock(&threads_mutex);
		obj_ptr = globrunqget();
		pthread_mutex_lock(&threads_mutex);
		if(obj_ptr!=NULL){
			if(debug_open) printf("globrunqget: get coroutine %p from global queue thread %d\n", obj_ptr, thread_id);
			return obj_ptr;
		}
	}

    //steal some coroutines from the other worker threads
    int thread_vic = find_victim_thread(thread_id);
    if(-1 != thread_vic){
    	if(debug_open) printf("Try to steal coroutines from thread %d (%d) to thread %d\n", thread_vic, lq[thread_vic].runqtail-lq[thread_vic].runqhead, thread_id);
		if(NULL != (obj_ptr = runqsteal(thread_vic))){
			if(debug_open) printf("runqsteal: steal corotuines (%p) from thread %d to thread %d\n", obj_ptr, thread_vic, thread_id);
			return obj_ptr;
		}
    }
    /*
    // local susq
    if(lq[thread_id].susqhead != lq[thread_id].susqtail){
		if(NULL != (obj_ptr = susqget())) {
			if(debug_open) printf("susqget: get one coroutine %p from thread %d\n", obj_ptr, thread_id);
			return obj_ptr;
		}
    }
    */
    return NULL;
}

int find_victim_thread(int id){
	int start = rand()%W;
	int i = 0;
	for(int vic=start; i<W&&i<2; ++i, ++vic){
		int x = vic%W;
		if(x == id) continue;
		if(lq[x].runqtail-lq[x].runqhead > 40){
			if(debug_open) printf("Try to steal coroutines from thread %d (%d) to thread %d\n", vic%W, lq[vic%W].runqtail-lq[vic%W].runqhead, thread_id);
			return x;
		}
	}
	return -1;
}