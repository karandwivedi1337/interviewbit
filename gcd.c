/**
 * @input A : Integer
 * @input B : Integer
 * 
 * @Output Integer
 */
int gcd(int A, int B) {

    if(A>B){
        return gcdrecurse(A,B);
    }
    return gcdrecurse(B,A);
}

int gcdrecurse(int A, int B){
    
    if(B==0){
        return A;
    }
    
    gcdrecurse(B, A%B);
    
}
