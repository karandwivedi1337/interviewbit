public class Bulbs {
    public int bulbs(ArrayList<Integer> a) {
    
        int state = 0;
        int count = 0;
        for(int i=0; i<a.size(); i++){
                if(state == a.get(i)){
                    count++;
                    state = 1 - state;
                }
        }
        
        return count;
    }
}

