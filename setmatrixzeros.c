/**
 * @input A : 2D integer array 
 * @input n11 : Integer array's ( A ) rows
 * @input n12 : Integer array's ( A ) columns
 * 
 * @Output Void. Just modifies the args passed by reference 
 */
void setZeroes(int** A, int n11, int n12) {
    
    int i=0, j=0;
    int numrows=n11;
    int numcols=n12;
    int r1=1, c1=1;
    
    //first row status kept in r1
    //status = 1 or 0 (0 if any of the element is 0, else 1)
    for(i=0; i<numcols;i++){
        if(A[0][i] == 0){
            r1=0;
            break;
        }
    }
    //first column status kept in c1
    //status = 1 or 0 (0 if any of the element is 0, else 1)
    for(i=0; i<numrows;i++){
        if(A[i][0] == 0){
            c1=0;
            break;
        }
    }

    //scan rows 1 to n and store their status in the first column
    for(i=1;i<numrows;i++){
        for(j=0;j<numcols;j++){
            if(A[i][j] == 0){
                A[i][0]=0;
                break;
            }
        }
    }
    
    
    //scan cols 1 to m and store their status in the first row
    for(i=1;i<numcols;i++){
        for(j=0;j<numrows;j++){
            if(A[j][i] == 0){
                A[0][i]=0;
                break;
            }
        }
    }
    
    //set rows (1 to numrows) to zero if required
    for(i=1; i<numrows; i++){
        //if row's status is 0, set all elements in the row to 0
        if(A[i][0] == 0){
            for(j=0; j<numcols; j++){
                A[i][j]=0;
            }
        }
    }
    
    //set cols (1 to numcols) to zero if required
    for(i=1; i<numcols; i++){
        //if row's status is 0, set all elements in the row to 0
        if(A[0][i] == 0){
            for(j=0; j<numrows; j++){
                A[j][i]=0;
            }
        }
    }
    
    //set first row to zero if required
    if(r1==0){
        for(i=0;i<numcols;i++){
            A[0][i]=0;
        }
    }
    
    //set first col to zero if required
    if(c1==0){
        for(i=0;i<numrows;i++){
            A[i][0]=0;
        }
    }
    
}

