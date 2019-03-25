#include <stdlib.h>
#include <stdio.h>
#include "MR-test.h"
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
void buildMR(int num){
    r = (struct Reducer **) malloc (sizeof(struct Reducer *)*num);
    m = (struct Mapper **) malloc (sizeof(struct Mapper *)*num);
    int i = 0;
    int N = num;
    m[0] = (struct Mapper *)MAPPER_init(0);
    i = 1;
    while(i<N){
        m[i] = (struct Mapper *)MAPPER_init(i);
        r[i] = (struct Reducer *)REDUCER_init(i);
        i = i + 1;
    }
    i = 1;
    while(i<N/2){
        r[i*2]->r = r[i];
        r[i*2+1]->r = r[i];
        i = i + 1;
    }
    i = 0;
    while(i<N){
        m[i]->r = r[(i+N)/2];
        i = i + 1;
    }
    //return NULL;
}
struct Mapper * getMapper(int index){
	return (struct Mapper *)m[index];
}


void lime_main(void * self){
void *m;
int i;
int num;
int repeat;
num = getArg(2);
repeat = getArg(3);
buildMR(num);while(repeat>0){
	for(i = 0;i<= num; ++i){
	m = getMapper(i);
Mapper_map(i, m, self);
}
repeat = repeat - 1;

}
}
