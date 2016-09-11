#include <stdio.h>

/**
 * @input A : Integer
 * @input B : Integer
 * 
 * @Output Integer
 */
int count=0;


void uniquePathsRecur(int r, int c, int A, int B){
	if(r==A-1 && c==B-1){
		count++;
		return;
	}
	if(r<A-1){
		uniquePathsRecur(r+1,c,A,B);
	}
	if(c<B-1){
		uniquePathsRecur(r,c+1,A,B);
	}

}

int uniquePaths(int A, int B) {

	if(B==1 || A==1){
		return 1;
	}

	uniquePathsRecur(0,0,A,B);
	return count;
}


int main(){

	printf("%d\n", uniquePaths(12,5));

	return 0;
}
