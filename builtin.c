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
