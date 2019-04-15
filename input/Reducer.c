#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
 int importedFun(int,int,int);
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
void print(int x);
void Reducer_reduce2(int, struct Reducer_struct *, void*);
void Reducer_reduce1(int, struct Reducer_struct *, void*);
void Reducer_reduce1(int x,struct Reducer_struct *this, void* self){
this->e1 = x;
this->a1 = 1;
}
void Reducer_reduce2(int x,struct Reducer_struct *this, void* self){
this->e2 = x;
this->a2 = 1;
}

void Reducer_doReduce(struct Reducer_struct *this, void* self)
{

if (this->index == 1){
print(this->e1 + this->e2);this->e1 = 0;
this->e2 = 0;

}
else if(this->index%2 == 0){
Reducer_reduce1(this->e1 + this->e2,this->next, self);
}else {
Reducer_reduce2(this->e1 + this->e2,this->next, self);
}
this->a1 = 0;
this->a2 = 0;
}
