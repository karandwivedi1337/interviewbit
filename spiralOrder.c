/**
 * @input A : Read only ( DON'T MODIFY ) 2D integer array ' * @input n11 : Integer array's ( A ) rows
 * @input n12 : Integer array's ( A ) columns
 * 
 * @Output Integer array. You need to malloc memory for result array, and fill result's length in length_of_array
 */
int* spiralOrder(const int** A, int n11, int n12, int *length_of_array) {
	 *length_of_array = n11 * n12; // length of result array
	 int *result = (int *) malloc(*length_of_array * sizeof(int));
	 // DO STUFF HERE
	 int m=n11, n = n12;
	 int c = 0;
	 int i=0, j=0, k=0, p=0;
	 int l=0, r=n, d=m, u=m;
	 while(c < *length_of_array){
	     
	     for(i=l; i<r;i++){
	         //printf("%d", A[l][i]);
	         result[c++] = A[l][i];
	     }
	     
	     if(c >= *length_of_array){
	         break;
	     }
	     
	     for(j=l+1; j<d; j++){
	         //printf("%d", A[j][r-1]);
	         result[c++] = A[j][r-1];
	     }
	     
	     if(c >= *length_of_array){
	         break;
	     }
	     
	     for(k=r-2; k>=l; k--){
	         //printf("%d", A[d-1][k]);
	         result[c++] = A[d-1][k];
	     }
	     
	     if(c >= *length_of_array){
	         break;
	     }
	     
	     for(p=u-2; p>l; p--){
	         //printf("%d", A[p][l]);
	         result[c++] = A[p][l];
	     }
	     
	     l++;
	     r--;
	     d--;
	     u--;
	     
	 }
	 
	 return result;
}
