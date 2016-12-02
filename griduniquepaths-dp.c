#include <stdio.h>
#include <stdlib.h>
/**
 * @input A : Integer
 * @input B : Integer
 * 
 * @Output Integer
 */
int count=0;

int uniquePaths(int A, int B, int** cache) {

	if(B==1 || A==1){
		return 1;
	}

	int i=0, j=0;
	for(i=0; i<B; i++){
		cache[0][i] = 1;
	}	

	for(i=0; i<A; i++){
		cache[i][0] = 1;
	}	

	for(i=1;i<A;i++){
		for(j=1; j<B; j++){
			cache[i][j] = cache[i-1][j] + cache[i][j-1];
		}
	}

	return cache[A-1][B-1];;
}


int** get2Darray(int A, int B){

	int** temp1 = (int**)malloc(sizeof(int*)*A);

	int i=0;

	for(i=0; i<A; i++){
		temp1[i] = (int*)malloc(sizeof(int)*B);
	}

	return temp1;

}

int main(){

	int A=6;
	int B=5;

	int** cache = get2Darray(A,B);

	printf("%d\n", uniquePaths(A,B,cache));

	return 0;
}
