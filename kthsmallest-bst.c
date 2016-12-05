#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct node{
	int n;
	int lcount;
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
	newnode->lcount=0;
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


//return the minimum value from the right subtree of newroot
node* minValueRightSubtree(node* newroot){

	if(newroot->left == NULL){
		return newroot;
	}

	return minValueRightSubtree(newroot->left);
}

void delete(node** root, node* nodetodelete){

	node* tempnode = *root;
	//node* nodetodelete = findnode(root, ele);	

	if(nodetodelete == NULL){
		printf("%s", "Node not found");
		return;
	}	

	//case: if bst has only 1 node
	if(nodetodelete == *root && isLeafNode(nodetodelete)){
		printf("%s", "case: if bst has only 1 node\n");
		*root = NULL;
		return;		
	}

	//case: if node to delete is a leaf
	if(isLeafNode(nodetodelete)){

		printf("%s", "case: if node to delete is a leaf\n");
		parentnode* parentnode = findparent(root, nodetodelete);

		printf("Parent Node found at = %p, Value = %d\n", parentnode, parentnode->parent->n);

		if(parentnode->side == 1){
			parentnode->parent->left=NULL;
			printf("%s","set parent's left side as NULL\n");
		}
		else{
			parentnode->parent->right=NULL;
			printf("%s","set parent's right side as NULL\n");
		}
		free(nodetodelete);	
		return;
	}

	//case: nodetodelete has only a left subtree
	if(nodetodelete->right == NULL){

		printf("%s","case: nodetodelete has only a left subtree\n");

		//special case: nodetodelete is root and has only left subtree	
		if(*root == nodetodelete){
			printf("%s","special case: nodetodelete is root and has only left subtree\n");	
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

		printf("%s","case: nodetodelete has only a right subtree\n");
		//special case: nodetodelete is root and has only right subtree	
		if(*root == nodetodelete){
			printf("%s","special case: nodetodelete is root and has only right subtree\n");	
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


	//if node to delete has both subtrees (root or non-root)
	printf("%s","node to delete has both subtrees (root or non-root)\n");
	node* minValNode = minValueRightSubtree(nodetodelete->right);
	nodetodelete->n = minValNode->n;
	delete(root, minValNode);		

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
				tempparent->lcount++;
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

void printTree(node* root){

	if(root->left != NULL){
		printTree(root->left);
	}

	printf("%d %d\n", root->n, root->lcount);

	if(root->right != NULL){
		printTree(root->right);
	}

}

//O(n) time, no extra space
void kthsmallest(node* root, int k, int* out){

	if(k == root->lcount + 1){
		*out = root->n;
		return;	
	}				

	else if(k < root->lcount + 1){
		kthsmallest(root->left, k, out);
	}

	else{
		k = k - root->lcount - 1;
		kthsmallest(root->right, k, out); 
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
	
	printTree(root);
	
	
	for(i=1; i<=10; i++){
		int out;
		kthsmallest(root, i, &out);
		printf("%d ", out);
	}
	

	//node* nodetodelete = findnode(&root, 520);
	//delete(&root, nodetodelete);
}
