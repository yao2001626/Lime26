#include <stdlib.h>
#include <stdio.h>
#include "MR_main.h"
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
    //snprintf(filename, 100, "%s/%s", dir, argv_g[1]);
    snprintf(filename, 100, "%s/", dir);
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
    r = (struct Reducer_struct **) malloc (sizeof(struct Reducer_struct *)*num);
    m = (struct Mapper_struct **) malloc (sizeof(struct Mapper_struct *)*num);
    int i = 0;
    int N = num;
    m[0] = (struct Mapper_struct *)Mapper_init(0);
    i = 1;
    while(i<N){
        m[i] = (struct Mapper_struct *)Mapper_init(i);
        r[i] = (struct Reducer_struct *)Reducer_init(i);
        i = i + 1;
    }
    i = 1;
    while(i<N/2){
        r[i*2]->next = r[i];
        r[i*2+1]->next = r[i];
        i = i + 1;
    }
    i = 0;
    while(i<N){
        m[i]->next = r[(i+N)/2];
        i = i + 1;
    }
    //return NULL;
}
struct Mapper_struct * getMapper(int index){
	return (struct Mapper_struct *)m[index];
}
void lime_main(void * self){
void *mp;
int i;
int num;
int repeat;
num = getArg(1);
repeat = getArg(2);
buildMR(num);while(repeat>0){
	for(i = 0;i<= num - 1; ++i){
	mp = getMapper(i);
Mapper_map(i, mp, self);
}
repeat = repeat - 1;

}
}