#include <stdio.h>
#include <stdlib.h>
void Mapper_map(int, void*, void*);
void *Reducer_init(int,void *);
void *Mapper_init(int,void *);
extern int argc_g;
extern char ** argv_g;
int * input;
int getRand(int);
void setRand(int);
void print(int x);
int getArg(int);
void lime_main(void * self);
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
int importedFun(int,int,int);
void lime_main(void * self){
int i;
int num;
int repeat;
void ** marray;
void ** rarray;
num = getArg(1);
repeat = getArg(2);
marray = (void **)malloc(sizeof(void *) * num);
rarray = (void **)malloc(sizeof(void *) * num);
rarray[0] = NULL;
for(i = 1;i<= num - 1; ++i){
	rarray[i] = (void *)Reducer_init(i, rarray[i/2]);

}
for(i = 0;i<= num - 1; ++i){
	marray[i] = (void *)Mapper_init(i, rarray[(i + num)/2]);

}
while(repeat>0){
	for(i = 0;i<= num - 1; ++i){
	Mapper_map(i, marray[i], self);
}
repeat = repeat - 1;

}
}