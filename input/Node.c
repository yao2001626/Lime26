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
void Node_add(int x,struct Node_struct *this){

if (this->left != NULL){
this->a = 1;
this->p =  x;

}
else if(x<this->key){
this->left = Node_init(x);
this->right =  Node_init(this->key);
this->key =  x;

}else if(x>this->key){
this->left = Node_init(this->key);
this->right =  Node_init(x);

}}

int Node_has(int x,struct Node_struct *this){

if (this->left == NULL){

return x == this->key;

}
else if(x<=this->key){

return Node_has(x,this->left);

}else {

return Node_has(x,this->right);

}
}


void Node_addToChild(struct Node_struct *this)
{

if (this->p<=this->key){
Node_add(this->p,this->left);
}
else {
Node_add(this->p,this->right);
}
this->a = 0;
}

