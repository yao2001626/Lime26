#ifndef MAIN_H
#define MAIN_H 
//for the PQ tests
void *head;
int num;
int *input;
// system varibales
int debug_open = 0; 			// for debug, set to 1
int W;
int w;
int s;

int argc_g;
char **argv_g;

globalqueue 		*gq;
localqueue 		*lq;

pthread_t 			threads[64]; //set big enough
__thread int 		thread_id;
__thread int 		status;
pthread_attr_t 		attr;
pthread_mutex_t 	threads_mutex;
pthread_mutex_t 	runq_mutex;
pthread_cond_t 		threads_cv;
extern void switch_to(void *obj);
extern void *alpha_init();
void *init_threads(void *arg);
#endif
