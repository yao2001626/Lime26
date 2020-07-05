#include <pthread.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "global_queue.h"
#include "local_queue.h"
#include "scheduler.h"
#include "main.h"
void *head;

void print_reduce(int r){
	printf("%d\n", r);
}

void *init_threads(void *arg){
	thread_id = (int) arg;
	pthread_setcancelstate(PTHREAD_CANCEL_ENABLE, NULL);
	pthread_setcanceltype(PTHREAD_CANCEL_ASYNCHRONOUS, NULL);
	status = 0;
	schedule();
	pthread_exit(NULL);
	return NULL;
}

void init_queues(){
	gq = (globalqueue *)malloc(sizeof(globalqueue));
    	memset(gq, 0, sizeof(globalqueue));
    	lq = (localqueue *)malloc(sizeof(localqueue)*W);
    	memset(lq, 0, sizeof(localqueue)*W);
    	return;
}

int main (int argc, char *argv[])
{	
	void * t;
	void * ret;
	int i;

    	if(argc < 4){
		printf("The Usage: %s has at least three args :nums [repeat|inputdata_dir] workers\n", argv[0]);
		exit(1);
	}

    	W = atoi(argv[3]);
   	argc_g = argc;
	argv_g = argv;
	w = W;
	pthread_mutex_init(&threads_mutex, NULL);
	pthread_cond_init (&threads_cv, NULL);
	pthread_attr_init(&attr);
	pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
    
    	init_queues();
	alpha_init();
	//runqput(t);
	
    	//create the workers
	for(i=1; i<W; i++){
		pthread_create(&threads[i], &attr, init_threads, (void *)i);
	}
	threads[0] =  pthread_self();
	ret = init_threads((void *)0);
	pthread_exit(NULL);
	return 0;
}



