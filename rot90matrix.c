/**
 * @input A : 2D integer array 
 * @input n11 : Integer array's ( A ) rows
 * @input n12 : Integer array's ( A ) columns
 * 
 * @Output Void. Just modifies the args passed by reference 
 */

#include <stdio.h>
#include <stdlib.h>
void rot90(int** arr, int lr, int lc, int br, int bc){
    
    if(lr == br & lc == bc){
        return;
    }    
    
    int inc = 0, i=0;
    for(i=lc; i<bc; i++){
        
        int a00 = arr[lr][i];
        int a02 = arr[lr+inc][bc];
        int a20 = arr[br-inc][lc];
        int a22 = arr[br][bc-inc];
        
        arr[lr][i] = a20;
        arr[lr+inc][bc] = a00;
        arr[br-inc][lc] = a22;
        arr[br][bc-inc] = a02;
        
        inc++;
    }
    
}

void rotate(int** A, int n11, int n12) {

    int i =0;

    for(i=1; i<n11; i++){
        rot90(A, i-1, i-1, n11-i, n12-i);
    }
    
}

int main(){

int i=0,j=0, c=0, n=2;
int** arr = (int**)malloc(n*sizeof(int*));
for(i=0; i<n; i++){
	arr[i] = (int*)malloc(n*sizeof(int));
}

for(i=0; i<n; i++){
	for(j=0; j<n; j++){
		arr[i][j] = c++;
		printf("%d",arr[i][j]);
}
	printf("\n");

}


rotate(arr, n, n);


for(i=0; i<n; i++){
	for(j=0; j<n; j++){
		printf("%d",arr[i][j]);
}
	printf("\n");

}

return 0;
}

