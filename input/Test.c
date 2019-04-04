#include <stddef.h>
#include <stdlib.h>
void print(int);
struct Test_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int v;
};
struct Test_struct * Test_init();
