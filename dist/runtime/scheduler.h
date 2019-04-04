/*
 * scheduler.h
 *
 *  Created on: Feb. 19, 2019
 *      Author: yaos4
 */


#define WORKING 0
#define SEEKING 1

extern __thread int status;
extern int W;
extern int w;
extern int s;
extern int debug_open;
extern void switch_to(void * ptr);
extern void switch_to_sched();
extern void * init_thread(void * ptr);
int find_victim_thread(int id);
void * findrunnable();
void * schedule();
