#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Santa_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int s;
int b;
int p;
};
void Santa_back(struct Santa_struct *this, void* self){
this->b = 1;
}
void Santa_harness(struct Santa_struct *this, void* self){
this->s = 2;
}
void Santa_pull(struct Santa_struct *this, void* self){
this->s = 0;
this->b = 0;
}
void Santa_puzzled(struct Santa_struct *this, void* self){
this->p = 3;
}
void Santa_enter(struct Santa_struct *this, void* self){
this->s = 4;
}
void Santa_consult(struct Santa_struct *this, void* self){
this->p = this->p - 1;

if (this->p>0){
this->s = 3;

}
else {
this->s = 0;

}
}

void Santa_action1(struct Santa_struct *this, void* self)
{
this->s = 1;
}

void Santa_action2(struct Santa_struct *this, void* self)
{
this->s = 3;
}
