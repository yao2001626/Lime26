#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Sleigh_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int s;
int c;
struct Santa_struct *st;
};
void Sleigh_back(struct Sleigh_struct *this, void* self){
this->c = this->c - 1;

if (this->c == 0){
this->s = 1;
this->c = 9;
Santa_back(this->st, self);
}
}
void Sleigh_harness(struct Sleigh_struct *this, void* self){
this->c = this->c - 1;

if (this->c == 0){
this->s = 2;
this->c = 9;
Santa_harness(this->st, self);
}
}
void Sleigh_pull(struct Sleigh_struct *this, void* self){
this->c = this->c - 1;

if (this->c == 0){
this->s = 0;
this->c = 9;
Santa_pull(this->st, self);
}
}
