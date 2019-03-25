extern int argc_g;
extern char ** argv_g;
int * input;
int getRand();
void setRand(int num);
void print(int x);
int getArg(int index);
void lime_main(void * self);
struct Reducer_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int index;
struct Reducer_struct *r;
int a1;
int a2;
int e1;
int e2;
};
struct Mapper_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
struct Reducer_struct *r;
int a;
int e;
int index;
};

struct Mapper **m;
struct Reducer **r;
