#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
struct Elf_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
struct Shop_struct *sh;
};
void  Shop_consult(struct Shop_struct *, void*);
void  Shop_puzzled(struct Shop_struct *, void*);
void  Shop_enter(struct Shop_struct *, void*);

void Elf_action1(struct Elf_struct *this, void* self)
{
Shop_puzzled(this->sh, self);Shop_enter(this->sh, self);Shop_consult(this->sh, self);}
