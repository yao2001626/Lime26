#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Reindeer_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
struct Sleigh_struct *sl;
};
void  Sleigh_pull(struct Sleigh_struct *, void*);
void  Sleigh_back(struct Sleigh_struct *, void*);
void  Sleigh_harness(struct Sleigh_struct *, void*);

void Reindeer_action1(struct Reindeer_struct *this, void* self)
{
Sleigh_back(this->sl, self);Sleigh_harness(this->sl, self);Sleigh_pull(this->sl, self);}
