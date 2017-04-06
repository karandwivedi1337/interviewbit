/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */

#include <stdio.h>
#include <stdlib.h>

int bin_srch_right(int low, int high, const int* A, int n1, int B){
	
	int mid=-1;
	int currentpos = -1;
	while(low <= high){

		mid = (low + high)/2;
		
		if(A[mid] == B){
			currentpos=mid;
			low = mid + 1;
		}
		else{
			high = mid - 1;
		}		
	}

	return currentpos;
}

int bin_srch_left(int low, int high, const int* A, int n1, int B){
	
	int mid=-1;
	int currentpos = -1;
	while(low <= high){

		mid = (low + high)/2;
		
		if(A[mid] == B){
			currentpos=mid;
			high = mid - 1;
		}
		else{
			low = mid + 1;
		}		
	}

	return currentpos;
}
int bin_srch(const int* A, int n1, int B, int *len1){
	
	int low = 0, high=n1-1, mid=-1;
	
	while(low <= high){

		mid = (low + high)/2;
		
		if(A[mid] == B){
			return mid;
		}
		else if(A[mid] < B){
			low = mid + 1;
		}				
		else{
			high = mid - 1;
		}		
	}

	return -1;
}


int* searchRange(const int* A, int n1, int B, int *len1){
	
	len1=(int*)malloc(2*sizeof(int));

	int ret = bin_srch(A, n1, B, len1);
		
	if(ret == -1){
		len1[0]=len1[1]=-1;
		return len1;
	}

	int leftret = bin_srch_left(0, ret-1, A, n1, B);
	
	int leftrange;
	if(leftret == -1){
		leftrange = ret;
	}
	else{
		leftrange=leftret;
	}
	
	int rightret = bin_srch_right(ret+1, n1-1, A, n1, B);
	int rightrange;
	if(rightret == -1){
		rightrange = ret;
	}
	else{
		rightrange=rightret;
	}

	len1[0] = leftrange;
	len1[1] = rightrange;
	return len1;
	
}

int main(){

	int n=1;
	int* arr = (int*)malloc(n*sizeof(int));

	arr[0]=1;
	/*
	arr[1]=7;
	arr[2]=7;
	arr[3]=8;
	arr[4]=8;
	arr[5]=10;
	*/
	int* len1=searchRange((const int*) arr, n, 1, NULL); 
	printf("[%d,%d]", len1[0], len1[1]);	
	return 0;
}
