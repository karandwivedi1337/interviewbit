/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in length_of_array
 */

#include <stdio.h>
#include <stdlib.h>

void updateResult(int* tempstart, int* tempend, int* tempsum, int* start, int* end, int* sum){
    
    if(*tempsum > *sum){
        *start = *tempstart;
        *end = *tempend;
        *sum = *tempsum;
    }
    else if(*tempsum == *sum){
        if(*tempend - *tempstart > *end - *start){
                *start = *tempstart;
                *end = *tempend;
                *sum = *tempsum;
        }
        else if(*tempend - *tempstart == *end - *start){
            if(*tempstart <= *start){
                *start = *tempstart;
                *end = *tempend;
                *sum = *tempsum;
            }
        }
    }
}
 
int* maxset(int* A, int n1, int *length_of_array) {
    /*
     * Sample Code : 
     *  *length_of_array = 1;
     *  int * ret = (int *) malloc(sizeof(int) * *length_of_array);
     *  ret[0] = 1;
     *  return ret;
     */
     
    int i=0; 
    int tempstart=0, tempend=0, tempsum=0;
    int start=0, end=0, sum=0;
    
    for(i=0; i<n1; i++){
        if(A[i] >= 0){
            tempsum += A[i];
            tempend = i;
        }
        
        else{
            updateResult(&tempstart, &tempend, &tempsum, &start, &end, &sum);
            
            if(i+1 < n1){
                tempstart = tempend = i + 1;
                tempsum = 0;
            }
            else{
                tempstart = tempend = i;
                tempsum = A[i];
            }           
            
        }
    }     
    
    updateResult(&tempstart, &tempend, &tempsum, &start, &end, &sum);
    
    if(sum < 0){
        return NULL;
    }
    
    if(A[start]<0 | A[end]<0){
        return NULL;
    }
    /*
    if(A[end]<0){
        return NULL;
    }
    */
    *length_of_array = (end - start)+1;
    int *ret = (int*)malloc(sizeof(int) * (*length_of_array));
    
    
    int index = 0;
    
    for(i=start; i<=end; i++){
        ret[index++] = A[i]; 
    }
    
    return ret;
}
int main(){

int n = 6;
int* arr=(int[6]){1,2,5,-7,2,3};

/*
int* arr = (int*)malloc(n*sizeof(int));
arr[0]=1;
arr[1]=2;
arr[2]=5;
arr[3]=-7;
arr[4]=2;
arr[5]=3;
*/
int len=0;
int* ret = maxset(arr, n, &len);

return 0;
}

