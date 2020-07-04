#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Supervisor_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int replies;
int min;
int max;
};
void Supervisor_done(int this->pingpong,struct Supervisor_struct *this, void* self){

if (this->pingpong<this->min){
this->min = this->pingpong;

}
else if(this->pingpong>this->max){
this->max = this->pingpong;

}this->replies = this->replies + 1;

if (this->replies == 100*10){
1;
}
}
