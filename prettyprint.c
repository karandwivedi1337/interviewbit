#include <stdio.h>
#include <stdlib.h>

/**
 * @input A : Integer
 * 
 * @Output 2D int array. You need to malloc memory for result 2D array. 
 * Fill in number_of_rows as row, number_of_columns as columns 
 */
 
void storeA(int tl, int tr, int bl, int br, int A, int** arr){
    
    int i=0;
    
    for(i=tl; i<tr; i++){
        arr[tl][i]=A;
    }
    
    for(i=tl; i<br; i++){
        arr[i][tr-1]=A;
    }
    
    for(i=br-1; i>=tl; i--){
        arr[br-1][i]=A;
    }
    
    for(i=bl; i>=tl; i--){
        arr[i][tl]=A;
    }
    
} 
 
int ** prettyPrint(int A, int *number_of_rows, int *number_of_columns) {
	// SAMPLE CODE
	/*
	 * *number_of_rows = A;
	 * *number_of_columns = A;
	 * int **result = (int **)malloc(A * sizeof(int *));
	 * // DO STUFF HERE
	 * return result;
	 */
    int newsize=(2*A)-1;
    *number_of_rows = newsize;
    *number_of_columns = newsize;
    
    int i=0;
    int **result = (int**)malloc(newsize*sizeof(int*));
    
    for(i=0; i<newsize; i++){
        result[i] = (int*)malloc(newsize*sizeof(int));
    }
    
    for(i=0; i<A; i++){
        storeA(i, newsize-i, newsize-i-1, newsize-i, A-i, result);
    }
    
    return result;
}
 

int main(){

int numrows=0, numcols=0, A=4;

prettyPrint(A, &numrows, &numcols);

return 0;
}
