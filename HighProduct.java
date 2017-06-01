public class HighProduct {
    public int maxp3(ArrayList<Integer> a) {
    
        Collections.sort(a, Collections.reverseOrder());
        int posproduct = 1;
        int negprodset = 0;
        for(int i=0; i<3; i++){
            posproduct *= a.get(i);
        }     
        
        int len = a.size();
        int negproduct = a.get(0);
        if(a.get(len-1) < 0 && a.get(len-2) < 0){
            negproduct*= (a.get(len-1) * a.get(len-2));
            negprodset = 1;
        }
        
        if((negprodset == 1) && (negproduct > posproduct)){
            return negproduct;
        }
        
        return posproduct;
    }
}

