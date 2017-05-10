public class MinXor {
    
    public int findMinXor(ArrayList<Integer> A) {
    
        Collections.sort(A);
        int minxor = Integer.MAX_VALUE;
        
	    for(int i=0; i<A.size()-1; i++){
            int n1 = A.get(i);
            int n2 = A.get(i+1);
            
            int xorval = n1 ^ n2;
            if(xorval < minxor){
                minxor = xorval;
            }
            
	    }
	    
        return minxor;
    }
}

