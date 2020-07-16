#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Philosopher_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
struct Fork_struct *leftFork;
struct Fork_struct *rightFork;
};
void print(int x);
void  Fork_pickup(struct Fork_struct *, void*);
void  Fork_putdown(struct Fork_struct *, void*);

void Philosopher_eat(struct Philosopher_struct *this, void* self)
{
Fork_pickup(this->leftFork, self);Fork_pickup(this->rightFork, self);print(2);Fork_putdown(this->leftFork, self);Fork_putdown(this->rightFork, self);}

void Philosopher_think(struct Philosopher_struct *this, void* self)
{
print(3);}
