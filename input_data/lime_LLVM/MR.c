#include <stddef.h>
struct Reducer_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int index;
struct Reducer_struct *next;
int a1;
int a2;
int e1;
int e2;
};
void Reducer_reduce1(int x,struct Reducer_struct *this){
this->e1 = x;
 this->a1 =  1;

}

void Reducer_reduce2(int x,struct Reducer_struct *this){
this->e2 = x;
 this->a2 =  1;

}


void Reducer_doReduce(struct Reducer_struct *this)
{

if (this->index%2 == 0){
Reducer_reduce1(this->e1 + this->e2,this->next);

}
else {
Reducer_reduce2(this->e1 + this->e2,this->next);

}
this->a1 = 0;
 this->a2 =  0;

}


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


