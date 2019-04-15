#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
 int importedFun(int,int,int);
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
void Reducer_reduce2(int, struct Reducer_struct *, void*);
void Reducer_reduce1(int, struct Reducer_struct *, void*);
void Mapper_map(int n,struct Mapper_struct *this, void* self){
this->e = n;
this->a = 1;
}

void Mapper_doMap(struct Mapper_struct *this, void* self)
{

if (this->index%2 == 0){
Reducer_reduce1(this->e*this->e,this->next, self);
}
else {
Reducer_reduce2(this->e*this->e,this->next, self);
}
this->a = 0;
}
