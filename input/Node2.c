#include <stddef.h>
#include <stdlib.h>
struct Node2_struct{
int pre_ebp;
int pre_esp;
int lock;
int system_next;
int key;
int p;
struct Node2_struct *left;
struct Node2_struct *right;
int a;
};
void Node2_add(int x,struct Node2_struct *this){

if (this->left != NULL){
this->a = 1;
this->p =  x;

if (this->p<=this->key){
Node2_add(this->p,this->left);
}
else {
Node2_add(this->p,this->right);
}
this->a = 0;

}
else if(x<this->key){
this->left = Node2_init(x);
this->right =  Node2_init(this->key);
this->key =  x;

}else if(x>this->key){
this->left = Node2_init(this->key);
this->right =  Node2_init(x);

}}

int Node2_has(int x,struct Node2_struct *this){

if (this->left == NULL){

return x == this->key;

}
else if(x<=this->key){

return Node2_has(x,this->left);

}else {

return Node2_has(x,this->right);

}
}
