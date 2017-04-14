/**
 * @input x : Integer
 * @input n : Integer
 * @input d : Integer
 * 
 * @Output Integer
 */

#include <stdio.h>

int normalizeans(int x, int d){
    
    if(x >=0){
        return x%d;
    }
    
    return (x+d)%d;
    
}

int findans(int x, int n, int d){
    
    if(n==2){
        return (x*x)%d;
    }
   
    if(n%2 == 0){ 
    	return (findans(x, n/2, d) * findans(x, n/2, d))%d;
    }
    
    return (x * (findans(x, (n-1)/2, d) * findans(x, (n-1)/2, d))%d) %d;

}

int powmod(int x, int n, int d) {

    if(x == 0 | d==1){
        return 0;
    }

    if(n == 0){
        return 1;
    }

    if(n==1){
        return normalizeans(x%d, d);
    }

    if(n%2==0){
        return normalizeans(findans(x,n,d), d);
    }
    
    return normalizeans((x*findans(x,n-1,d))%d, d);
    
}

int main(){

int x=213, n=231, d=1;

int ans= powmod(x,n,d); 

printf("ans=%d", ans);

return 0;
}
