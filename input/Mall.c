#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Mall_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int s;
int firstCol;
int sndCol;
struct Chameneos_struct *firstCham;
struct Chameneos_struct *sndCham;
int repeat;
int N;
};
void Mall_arrive(Chameneos_struct *ch,int c,struct Mall_struct *this, void* self){

if (this->s == 0){
this->firstCol = c;
this->firstCham = ch;
this->s = 1;

}
else if(this->s == 1){
this->sndCol = c;
this->sndCham = ch;
this->repeat = this->repeat + 1;
this->s = 2;

}}

void Mall_mutate(struct Mall_struct *this, void* self)
{
Chameneos_meet(this->sndCol,this->firstCham, self);Chameneos_meet(this->firstCol,this->sndCham, self);
if (this->repeat<this->N){
this->s = 0;

}
else {
this->s = 3;

}
}
