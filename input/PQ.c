#include <stddef.h>
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
void *PQ_init_code(){
struct PQ_struct *this =(struct PQ_struct *)malloc(sizeof(struct PQ_struct));
this->l = NULL;
 this->a =  0;
 this->r =  0;
return this;
}

int PQ_empty(struct PQ_struct *this){

return this->l == NULL;
}

void PQ_add(int e,struct PQ_struct *this){

if (this->l == NULL){
this->p = e;
 this->l =  PQ_init();

}
else {
this->p = e;
 this->a =  1;

}
}

int PQ_remove(struct PQ_struct *this){
this->r = 1;

return this->m;
}


void PQ_doAdd(struct PQ_struct *this)
{

if (this->m<this->p){
PQ_add(this->p,this->l);
}
else {
PQ_add(this->m,this->l);this->m = this->p;

}
this->a = 0;
}


void PQ_doRemove(struct PQ_struct *this)
{

if (PQ_empty(this->l)){
this->l = NULL;

}
else {
this->m = PQ_empty(this->l);

}
this->r = 0;
}

