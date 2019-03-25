#include <stddef.h>
#include <stdlib.h>
struct PQ_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int m;
int p;
struct PQ_struct *l;
int a;
int r;
};
struct PQ_struct * PQ_init();
int PQ_empty(struct PQ_struct *this, void* self){

return this->l == NULL;
}

void PQ_add(int e,struct PQ_struct *this, void* self){

if (this->l == NULL){
this->m = e;
this->l =  (struct PQ_struct *) PQ_init();

}
else {
this->p = e;
this->a =  1;

}
}

int PQ_remove(struct PQ_struct *this, void* self){
this->r = 1;

return this->m;
}


void PQ_doAdd(struct PQ_struct *this， void* self)
{

if (this->m<this->p){
PQ_add(this->p,this->l, self);
}
else {
PQ_add(this->m,this->l, self);this->m = this->p;

}
this->a = 0;
}


void PQ_doRemove(struct PQ_struct *this， void* self)
{

if (PQ_empty(this->l, self)){
this->l = NULL;

}
else {
this->m = PQ_remove(this->l;

}
this->r = 0;
}

