#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct node{
	int n;
	struct node* left;
	struct node* right;
};

//side = 1 for left, 0 for right
struct parentnode{
	struct node* parent;
	int side;
};

typedef struct node node;
typedef struct parentnode parentnode;

node* getnode(){

	node* newnode = (node*)malloc(sizeof(struct node));	
	newnode->left = newnode->right = NULL;
	return newnode;
}

parentnode* findparent(node** root, node* childnode){

	node* tempnode = *root;

	//root has no parent
	if(tempnode == childnode){
		return NULL;
	}

	parentnode* parent = (parentnode*) malloc(sizeof(parentnode));

	while(tempnode != NULL){
		if(tempnode->left == childnode){
			parent->parent = tempnode;
			parent->side=1;
			return parent;	
		}
		else if(tempnode->right == childnode){
			parent->parent = tempnode;
			parent->side=0;
			return parent;	
		}
		else if( childnode->n < tempnode->n){
			tempnode = tempnode->left;
		}
		else{
			tempnode = tempnode->right;
		}	
	}

	//does not occur if childnode is in the tree
	return NULL;
}

node* findnode(node** root, int ele){

	node* tempnode = *root;
	while(tempnode != NULL){
		if(tempnode->n == ele){
			return tempnode; 
		}
		else if( ele < tempnode->n){
			tempnode = tempnode->left;
		}
		else{
			tempnode = tempnode->right;
		}	
	}

	return NULL;
}

int isLeafNode(node* tempnode){

	if(tempnode->left == NULL && tempnode->right==NULL){
		return 1;
	}	
	return 0;
}

void delete(node** root, int ele){

	node* tempnode = *root;
	node* nodetodelete = findnode(root, ele);	
	
	if(nodetodelete == NULL){
		printf("%s", "Node not found");
		return;
	}	

	printf("Node found at = %p, Value = %d\n", nodetodelete, nodetodelete->n);

	//case: if bst has only 1 node
	if(nodetodelete == *root && isLeafNode(nodetodelete)){
		*root = NULL;
		return;		
	}

	//case: if node to delete is a leaf
	if(isLeafNode(nodetodelete)){

		parentnode* parentnode = findparent(root, nodetodelete);

	printf("Parent Node found at = %p, Value = %d\n", parentnode, parentnode->parent->n);
		
		if(parentnode->side == 0){
			parentnode->parent->left=NULL;
		}
		else{
			parentnode->parent->right=NULL;
		}
		free(nodetodelete);	
		return;
	}

	//case: nodetodelete has only a left subtree
	if(nodetodelete->right == NULL){
	
		//special case: nodetodelete is root and has only left subtree	
		if(*root == nodetodelete){
			*root = nodetodelete->left;
			free(nodetodelete);
			return;			
		}
	
		parentnode* parentnode = findparent(root, nodetodelete);

	printf("Parent Node found at = %p, Value = %d\n", parentnode, parentnode->parent->n);
	
		parentnode->parent->left = nodetodelete->left;
		free(nodetodelete);
		return;
	
	}

	
	//case: nodetodelete has only a right subtree
	if(nodetodelete->left == NULL){

		//special case: nodetodelete is root and has only right subtree	
		if(*root == nodetodelete){
			*root = nodetodelete->right;
			free(nodetodelete);
			return;			
		}
		
		parentnode* parentnode = findparent(root, nodetodelete);

	printf("Parent Node found at = %p, Value = %d\n", parentnode, parentnode->parent->n);
	
		parentnode->parent->right = nodetodelete->right;
		free(nodetodelete);
		return;
	
	}
	//if node to delete is non-leaf, non-root
	

}

void insert(node** root, int ele){


	node* newnode = getnode();
	newnode->n=ele;	

	if(*root == NULL){
		*root=newnode;	
		printf("root is %d\n", (*root)->n);
		return;
	}		

	else{
		node* tempnode = *root;
		node* tempparent = *root;
		int left = 0;
		while(tempnode != NULL){

			if(ele < tempnode->n){
				tempparent = tempnode;
				tempnode = tempnode->left;
				left = 1;
			}
			else{
				tempparent = tempnode;
				tempnode = tempnode->right;
				left = 0;
			}

		}

		if(left == 0){
			tempparent->right = newnode;
			printf("inserted %d to the right of %d\n", ele, tempparent->n);

		}
		else{
			tempparent->left = newnode;
			printf("inserted %d to the left of %d\n", ele, tempparent->n);
		}

	}	


}

int main(){

	node* root = NULL;
	int i=0;
	srand(0);

	for(i=0; i<10;i++){
		int random = rand()/1000000;
		printf("inserting %d\n", random);
		insert(&root, random);	
		//printf("%d\n", find(&root, random)->n);
	}
	
	delete(&root, 1000);
}
