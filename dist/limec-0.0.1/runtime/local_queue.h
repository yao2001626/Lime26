/*
 * local_queue.h
 *
 *  Created on: Feb. 19, 2019
 *      Author: yaos4
 */

#ifndef INC_LOCAL_QUEUE_H_
#define INC_LOCAL_QUEUE_H_
#define MAX_RUNQ_SIZE 102400
#define MAX_SUSQ_SIZE 1024

typedef struct lqueue_t {
	unsigned int runqhead; /* = 0 */
	unsigned int runqtail; /* = 0 */
	unsigned int susqhead;
	unsigned int susqtail;
  	void * runq[MAX_RUNQ_SIZE];
  	void * susq[MAX_SUSQ_SIZE];
}localqueue;

extern __thread int thread_id;
extern pthread_mutex_t  threads_mutex;
extern localqueue *lq;
extern int debug_open;
void runqput(void * ptr);
void susqput(void * ptr);
void * runqget();
void * susqget();
int runqgrab(int victim_id, void ** batch, unsigned int batchHead);
int runqputslow(void *cur_obj, unsigned int h, unsigned int t);
void * runqsteal(int t_id);


#endif /* INC_LOCAL_QUEUE_H_ */
