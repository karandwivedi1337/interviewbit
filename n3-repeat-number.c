/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 */

//candidates and their respective count
int can[2];
int cancount[2];
//number of candidates
int cannum=0;

int isPresent(int num){
    
    int i=0;
    for(i=0; i<cannum; i++){
        if(can[i] == num){
            return 1;
        }
    }
    
    return 0;
}

void incrementCount(int num){
    int i=0;
    for(i=0; i<cannum; i++){
        if(can[i] == num){
            if(cancount[i]==-1){
                cancount[i]=1;
            }
            else{
                cancount[i]++;
            }
        }
    }
    
}

int hasSpaceForCandidate(){
    if(cannum < 2){
        return 1;
    }
    return 0;
}

void addCandidate(int newno){
    can[cannum]=newno;
    cancount[cannum]=1;
    cannum++;
}

void removeZeroCountCans(){
    int i=0;
    for(i=0; i<2; i++){
        if(cancount[i] == 0){
            can[i]=cancount[i]=-1;
            cannum--;
        }
    }
}

void processDistinctNumber(int newno){
    int i=0;
    for(i=0; i<cannum; i++){
        if(cancount[i]>0){
            cancount[i]--;
        }
    }
    removeZeroCountCans();
    
    if(hasSpaceForCandidate()){
        addCandidate(newno);
    }
}

int repeatedNumber(const int* A, int n1) {
    
    int i=0;
    int n=n1;
    
    //candidate and their count is initially set to -1
    for(i=0;i<2;i++){
        can[i]=cancount[i]=-1;
    }

    //get probable candidates 
    for(i=0; i<n; i++){
        if(isPresent(A[i])){
            incrementCount(A[i]);
        }
        else{
            if(hasSpaceForCandidate()){
                addCandidate(A[i]);
            }
            else{
                processDistinctNumber(A[i]);
            }
        }
    }
    
    //iterate through candidates and find actual frequency
    for(i=0; i<cannum; i++){
        int actualfreq=0, j=0;
        for(j=0; j<n; j++){
            if(A[j] == can[i]){
                actualfreq++;
            }
        }
        
        //compare frequency of each candidate with n/k (k=3). If greater, return the number
        if(actualfreq > (n/3)){
            return can[i];
        }
        
    }
    //no match found among candidates
    return -1;
    
}

