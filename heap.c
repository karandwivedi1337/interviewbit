#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int heapsize=0;
int heapcapacity=1;
int maxelement=-INT_MAX;
int* heap=0;
int* resizeheap(int* heap){

	heapcapacity*=2;
	int* newheapptr = (int*)malloc(heapcapacity*(sizeof(int)));
	int i=0;
	for(i=0; i<=heapsize; i++){
		newheapptr[i] = heap[i];
	}

	return newheapptr;
}

void insert(int num){

if(heapsize == heapcapacity-1){
	int* newheapptr = resizeheap(heap);
	heap = newheapptr;
}

if(num > maxelement){
	maxelement = num;
}

heapsize++;
heap[heapsize] = num;

int now = heapsize;

//percolate upwards (min-heap) if parent is greater than the child
while(heap[now/2] > num){
	heap[now] = heap[now/2];
	now /= 2;
}

heap[now] = num;
}

int deletemin(){

	int minelement = heap[1];
	int newroot = heap[heapsize--];
	int now, child;
	//now = current index in the heap being traversed to find the correct positin for the new root
	for(now =1; now*2 <= heapsize; now=child){
		
		//find the min child among the children of the new root
		child = now*2;
		if(child != heapsize && heap[child+1] < heap[child]){
			child++;
		}

		//if newroot is greater than current child, percolate child upto the current root
		if(newroot > heap[child]){
			heap[now] = heap[child];	
		}
		//else this is the correct position for the new root
		else{
			break;
		}
		
	}

	heap[now] = newroot;
	return minelement;

}

void printheap(){
int i=0;
for(i=0; i<=heapsize; i++){
	printf("%d ", heap[i]);
}
	printf("%s","\n");
}

int main(){

heap = (int*)malloc(sizeof(int)*1);
heap[0] = -INT_MAX;
int i=0;
for(i=10; i>=3; i--){
	insert(i);
}
printheap();

printf("%d\n", deletemin());
}
