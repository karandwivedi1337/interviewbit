/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer
 * 
 * @Output Integer
 */
 
void swap(int* a, int* b){

int temp = *b;
*b = *a;
*a = temp;
}

int heapsize=0;
int heapcapacity=1;
int minelement=INT_MAX;
int* heap=0;


void insert(int num){

heapsize++;
heap[heapsize] = num;

int now = heapsize;

//percolate upwards (max-heap) if parent is less than the child
while(heap[now/2] < num){
	heap[now] = heap[now/2];
	now /= 2;
}

heap[now] = num;

//store min element
if(num < minelement){
	minelement = num;
}

}

int deletemax(){

	int maxelement = heap[1];
	int newroot = heap[heapsize--];
	int now, child;
	//now = current index in the heap being traversed to find the correct positin for the new root
	for(now =1; now*2 <= heapsize; now=child){
		
		//find the min child among the children of the new root
		child = now*2;
		if(child != heapsize && heap[child+1] < heap[child]){
			child++;
		}

		//if newroot is less than current child (max-heap), percolate child upto the current root
		if(newroot < heap[child]){
			heap[now] = heap[child];	
		}
		//else this is the correct position for the new root
		else{
			break;
		}
		
	}

	heap[now] = newroot;
	return maxelement;

}

void printheap(){
int i=0;
for(i=0; i<=heapsize; i++){
        printf("%d ", heap[i]);
}
        printf("%s","\n");
}
 
int kthsmallest(const int* A, int n1, int k) {

heap = (int*)malloc(sizeof(int)*(k+1));
heap[0] = INT_MAX;

int i=0, n=n1;

for(i=0; i<n; i++){
    if(heapsize < k){
        insert(A[i]);
    }
    else{
        if(A[i]<heap[1]){
            deletemax();
            insert(A[i]);
        }
    }
}
    printheap();
    return heap[1];
}

