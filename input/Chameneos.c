#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Chameneos_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int s;
int col;
struct Mall_struct *mall;
};
void Chameneos_meet(int otherCol,struct Chameneos_struct *this, void* self){

if (this->col != otherCol){
this->col = 3 - this->col - otherCol;

}
this->s = 1;
}

void Chameneos_GoingToMall(struct Chameneos_struct *this, void* self)
{
this->s = 2;
Mall_arrive(this->col,this->mall, self);}

void Chameneos_BackToForest(struct Chameneos_struct *this, void* self)
{
this->s = 0;
}
