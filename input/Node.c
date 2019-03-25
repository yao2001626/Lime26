#include <stddef.h>
#include <stdlib.h>
struct Node_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int key;
int p;
struct Node_struct *left;
struct Node_struct *right;
int a;
};
struct Node_struct * Node_init(int);
void Node_add(int x,struct Node_struct *this, void* self){

if (this->left != NULL){
this->a = 1;
this->p = x;

}
else if(x<this->key){
this->left = (struct Node_struct *) Node_init(x);
this->right = (struct Node_struct *) Node_init(this->key);
this->key = x;

}else if(x>this->key){
this->left = (struct Node_struct *) Node_init(this->key);
this->right = (struct Node_struct *) Node_init(x);

}}

int Node_has(int x,struct Node_struct *this, void* self){

if (this->left == NULL){

return x == this->key;

}
else if(x<=this->key){

return Node_has(x,this->left, self);

}else {

return Node_has(x,this->right, self);

}
}


void Node_addToChild(struct Node_struct *this, void* self)
{

if (this->p<=this->key){
Node_add(this->p,this->left, self);
}
else {
Node_add(this->p,this->right, self);
}
this->a = 0;
}

