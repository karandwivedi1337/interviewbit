#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void swap(int* a, int* b){
    
    int temp = *b;
    *b = *a;
    *a = temp;
}
 
int partition(int* arr, int l, int r){
    
    int pivot = arr[r];
    int i = l, j=0;
    
    for(j=l; j<=r-1; j++){
        if(arr[j] <= pivot){
            swap(&arr[i], &arr[j]);
            i++;
        }
    }
    
    swap(&arr[i], &arr[j]);
    return i;
    
    
} 
 
int kthsmallest(int* arr, int low, int high, int k){
     /* low = 0 and high = #elements - 1 */
     /* k is in between 1 to high + 1 */
    
     if (k>0 & k<=high-low+1)     {
        // pos is partitioning index, arr[p] is now  at right place
        int pos = partition(arr, low, high);

        // Separately sort elements before / partition and after partition
        
	if(pos-low == k-1){
		return arr[pos];
	}		
	//if position returned is greater than k, recurse left subarray		
	else if(pos-low > k-1){
		return kthsmallest(arr, low, pos-1, k);
	}
 	
	return kthsmallest(arr, pos+1, high, k-(pos+1)+low);

    }
    
}

int main(){

int arr[] = {-2,9,1,7,100,5,1,0,-1,-3};
int k = kthsmallest(arr, 0, sizeof(arr)/sizeof(int), 5);
printf("%d\n", k);
}
