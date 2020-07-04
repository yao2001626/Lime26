#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Worker_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int id;
struct Worker_struct *neighbours;
struct Supervisor_struct *sup;
int rand;
int pingpong;
int r;
};
int Worker_recipient(struct Worker_struct *this, void* self){
}
void Worker_start(struct Worker_struct *this, void* self){
this->r = 10000;
}
void Worker_ping(Worker_struct *w,int this->id,struct Worker_struct *this, void* self){
Worker_ping(this->id,this->w, self);}
void Worker_pong(int this->id,struct Worker_struct *this, void* self){
this->pingpong = this->pingpong - 1;
}

void Worker_pingNeighbour(struct Worker_struct *this, void* self)
{
n = ;
this->id;this->r = this->r - 1;
this->pingpong = this->pingpong + 1;
}

void Worker_callSupervisor(struct Worker_struct *this, void* self)
{
Supervisor_done(this->pingpong,this->sup, self);this->r = -1;
}
