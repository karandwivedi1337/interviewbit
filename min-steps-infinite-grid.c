/**
 * @input X : Integer array corresponding to the X co-ordinate
 * @input n1 : Integer array's ( X ) length
 * @input Y : Integer array corresponding to the Y co-ordinate
 * @input n2 : Integer array's ( Y ) length
 *
 * Points are represented by (X[i], Y[i])
 * 
 * @Output Integer
 *
 */
 
int min(int a, int b){
    if(a<b){
        return a;
    }
    else{
        return b;
    }
} 
 
int coverPoints(int* X, int n1, int* Y, int n2) {

    int steps = 0, i=0;
    
    if(n1 <= 1){
        return 0;
    }
    
    int currentx = X[0];
    int currenty = Y[0];
    
    for(i=1; i<n1; i++){
        
        if(currentx == X[i]){
            steps += abs(currenty - Y[i]);
        }
        
        else if(currenty == Y[i]){
            steps += abs(currentx - X[i]);
        }
     
        //points are not collinear
        else{
            int xdiff = abs(X[i] - currentx);
            int xdiffsign = (X[i] - currentx)/xdiff;
            int ydiff = abs(Y[i] - currenty);
            int ydiffsign = (Y[i] - currenty)/ydiff;
            int xymindiff = min(xdiff, ydiff);
            
            int tempx = currentx;
            int tempy = currenty;
            
            if(xymindiff == xdiff){
                tempx = X[i];
                tempy += ydiffsign*xymindiff;
                steps += xymindiff;
                steps += abs(tempy - Y[i]);
            }
            
            else{
                tempy = Y[i];
                tempx += xdiffsign*xymindiff;
                steps += xymindiff;
                steps += abs(tempx - X[i]);
            }
            
        }
        
        currentx = X[i];
        currenty = Y[i];
        
    }
    
    return steps;
}
