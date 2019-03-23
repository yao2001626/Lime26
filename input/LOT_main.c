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

void lime_main(void * self){
void *root;
int num;
int i;
num = getArg(2);
for(i = 0;i<= num; ++i){
	Node_add(rand(), root, self);
}
for(i = 0;i<= num; ++i){
	
if (Node_has(i, root, self)){
print(i);
}

}

}
