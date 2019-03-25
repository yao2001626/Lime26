extern int argc_g;
extern char ** argv_g;
int * input;
int getRand();
void setRand(int num);
void print(int x);
int getArg(int index);
void lime_main(void * self);
struct Reducer{
  void *ebp;
  void *doAction;
  int lock;
  void *next;
  int e2;
  int e1;
  int a2;
  int a1;
  struct Reducer *r;
  int index;
};

struct Mapper{
    void *ebp;
    void *doAction;
    int lock;
    void * next;
    int index;
    int e;
    int a;
    struct Reducer *r;
};

struct Mapper **m;
struct Reducer **r;
