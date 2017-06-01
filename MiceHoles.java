public class MiceHoles {
    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
    
        if(a.size() == 0){
            return 0;
        }
    
        Collections.sort(a);
        Collections.sort(b);
        
        int sum = 0;
        
        for(int i=0; i<a.size(); i++){
            int tempsum = Math.abs(b.get(i) - a.get(i));
            if(tempsum > sum){
                sum = tempsum;
            }
            
        }
        
        return sum;
    }
}
