#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Fork_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int avail;
};
void Fork_pickup(struct Fork_struct *this, void* self){
this->avail = 0;
}
void Fork_putdown(struct Fork_struct *this, void* self){
this->avail = 1;
}
