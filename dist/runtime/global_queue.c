/*
 * global_queue.c
 *
 *  Created on: Feb. 19, 2019
 *      Author: yaos4
 */


#include <pthread.h>
#include "local_queue.h"
#include "global_queue.h"


//Global queue put:
// 1. link all the coroutines in the batch
// 2. <lock> add this list to the global queue <unlock>
void globrunqputbatch(void *batch_head, void *batch_tail, unsigned int n){
	*((void **)(batch_tail + 12)) = NULL;
	if(gq->tail!=NULL){
		*((void **)(gq->tail + 12)) = batch_head;
	}else{
		gq->head = batch_head;
	}
	gq->tail = batch_tail;
    gq->size += n;
}

//Global queue get:
// 1. <lock> add this list to the tmp array <unlock>
// 2. add the tmp array to the local queue (load acquire store release)

void * globrunqget(){
	void * obj_ptr =NULL;
	int i;
	void * tmp;
	if(gq->size==0){
		return NULL;
	}
	int num = gq->size/W + 1;

	if (num > gq->size) {
		num = gq->size;
	}

	if (num > MAX_RUNQ_SIZE/2) {
		num =  MAX_RUNQ_SIZE/ 2;
	}

	gq->size -= num;

	if (gq->size == 0) {
		gq->tail = NULL;
	}

	obj_ptr = gq->head;
	gq->head = *((void **)(gq->head+12));
	num = num - 1;
	for (i = 0; i < num; ++i)
	{
		tmp = gq->head;
		gq->head =  *((void **)(tmp+12));
		runqput(tmp);
	}
	while(!__sync_bool_compare_and_swap((int *)(obj_ptr+8), 0, 1));//busy waiting
	return obj_ptr;
}

