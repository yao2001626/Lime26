#include <stdlib.h>
#include <stdio.h>
#include "PQ_main.h"
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
void setRand(int num){
    char *dir = argv_g[2];
	 char filename[100];
    char * line = NULL;
    size_t len = 0;
    ssize_t read;
    snprintf(filename, 100, "%s/%s", dir, argv_g[1]);
    FILE *file= fopen(filename, "r");
    if (file == NULL) exit(EXIT_FAILURE);
    input = (int *)malloc(sizeof(int)*num);
    int i = 0;
    while ((read = getline(&line, &len, file)) != -1) {
        input[i]=atoi(line);
        i++;
    }
    fclose(file);
}
int getRand(int index){
	return input[index];
}

void lime_main(void * self){
void *head;
int i;
int num;
num = getArg(2);
for(i = 0;i<= num; ++i){
	PQ_add(rand(), head, self);
}
for(i = 0;i<= num; ++i){
	print(PQ_remove(head, self));
}

}
