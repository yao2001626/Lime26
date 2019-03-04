#include <stddef.h>
struct Mapper_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
struct Reducer_struct *next;
int a;
int e;
int index;
};
void *Mapper_init_code(int i){
struct Mapper_struct *this =(struct Mapper_struct *)malloc(sizeof(struct Mapper_struct));
this->index = i;
 this->a =  0;
return this;
}

void Mapper_map(int n,struct Mapper_struct *this){
this->e = n;
 this->a =  1;
}


void Mapper_doMap(struct Mapper_struct *this)
{

if (this->index%2 == 0){
Reducer_reduce1(this->e*this->e,this->next);
}
else {
Reducer_reduce2(this->e*this->e,this->next);
}
this->a = 1;
}

