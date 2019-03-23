#include <stdlib.h>
#include <stdio.h>

#include "builtin.h"


int rand(){
	// This is the default built-in function: rand
	int res = rand() % 10000；
	return res;
}

void print(int x){
	// This is the default built-in function: print
	printf("%d\n", x);
	return;
}

int getArg(int index){
	// This is the default built-in function: getArg
	// System global variables: int argc_g, char **argv_g
	return atoi(argv_g[index]);
}
int hello(int){
	printf("Imported method hello did not implement");
	 return 0; 
}
void lime_main(void * self){
int i;
int j;
void *root;
i = 0;
root = (void *) Node2_init(10);
for(i = 10;i<= 100; ++i){
	Node2_add(i, root, self);
}
for(i = 1;i<= 100; ++i){
	Node2_has(i, root, self);
}
print(Node2_has(9, root, self));
}
