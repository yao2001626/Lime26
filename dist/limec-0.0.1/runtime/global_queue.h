/*
 * global_queue.h
 *
 *  Created on: Feb. 19, 2019
 *      Author: yaos4
 */

#ifndef INC_GLOBAL_QUEUE_H_
#define INC_GLOBAL_QUEUE_H_

#define GLOBAL_QUEUE_MAX 20000
#define LOCAL_QUEUE_MAX 64

//global queue
typedef struct gqueue_t {
  void * head; /* = 0 */
  void * tail; /* = 0 */
  unsigned int size;
}globalqueue;

//global variables
extern __thread int thread_id;
extern int debug_open;
extern pthread_mutex_t  threads_mutex;
extern pthread_cond_t  threads_cv;
extern int w;
extern int W;
extern globalqueue *gq;

void globrunqputbatch(void *batch_head, void *batch_tail, unsigned int n);
void * globrunqget();
void putsusobjs();
int getobjs();
void putobjs();

#endif /* INC_GLOBAL_QUEUE_H_ */
