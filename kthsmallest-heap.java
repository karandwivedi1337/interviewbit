public class Solution {
    
int heapsize=0;
int heapcapacity=1;
int minelement=Integer.MAX_VALUE;
List<Integer> heap;

void insert(int num){

	heapsize++;
	heap.add(heapsize, num);

	int now = heapsize;

	//percolate upwards (max-heap) if parent is less than the child
	while(heap.get(now/2) < num){
		heap.set(now, heap.get(now/2));
		now /= 2;
	}

	heap.set(now, num);

	//store min element
	if(num < minelement){
		minelement = num;
	}

}

int deletemax(){

	int maxelement = heap.get(1);
	int newroot = heap.get(heapsize--);
	int now, child;
	//now = current index in the heap being traversed to find the correct positin for the new root
	for(now =1; now*2 <= heapsize; now=child){

		//find the max child among the children of the new root
		child = now*2;
		if(child != heapsize && heap.get(child+1) > heap.get(child)){
			child++;
		}

		//if newroot is greater than current child (max-heap), percolate child upto the current root
		if(newroot <  heap.get(child)){
			heap.set(now, heap.get(child));
		}
		//else this is the correct position for the new root
		else{
			break;
		}

	}

	heap.set(now, newroot);
	return maxelement;

}

	public int kthsmallest(final List<Integer> a, int k) {
	
	//heap = (int*)malloc(sizeof(int)*(k+1));
	heap = new ArrayList<Integer>(k+1);

	//heap[0] = Integer.MAX_VALUE;
    heap.add(0, Integer.MAX_VALUE);

	int i=0, n=a.size();

	for(i=0; i<n; i++){
		if(heapsize < k){
			insert(a.get(i));
			//printf("inserted %d\n", A[i]);
		}

		else{
			if(a.get(i) < heap.get(1)){
				int deletednum = deletemax();
				//printf("deleted %d and insert %d\n", deletednum, A[i]);
				insert(a.get(i));
			}
		}

	}
	//printheap();
	return heap.get(1);
	    
	    
	}
}

