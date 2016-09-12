
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
 
int kthsmallest(const int* A, int n1, int k) {

    int kindex = k-1;
    int low = 0;
    int high = n1-1;
    
    int *arrcopy = (int*)malloc(sizeof(int)*n1);
    int i=0;
    for(i=0; i<n1; i++){
        arrcopy[i] = A[i];
    }
    
    for(;;){
        if(low == high){
            return arrcopy[low];
        }    
        
        int pos = partition(arrcopy, low, high);
        
        if(kindex == pos){
            return arrcopy[pos];
        }
        
        else if(kindex < pos){
            high = pos -1;
        }
        else{
            low = pos + 1;
        }
    }
    
}

