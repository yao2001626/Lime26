#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Shop_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int s;
int c;
struct Santa_struct *st;
};
void Shop_puzzled(struct Shop_struct *this, void* self){
this->c = this->c + 1;

if (this->c == 3){
this->s = 1;
Santa_puzzled(this->st, self);
}
}
void Shop_enter(struct Shop_struct *this, void* self){
this->s = 2;
Santa_enter(this->st, self);}
void Shop_consult(struct Shop_struct *this, void* self){
this->c = this->c - 1;

if (this->c>0){
this->s = 1;

}
else {
this->s = 0;

}
Santa_consult(this->st, self);}
