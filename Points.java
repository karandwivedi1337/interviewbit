import java.util.*;
import java.io.*;
public class Points{

	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		HashMap<Double, Integer> hmap = new HashMap<Double, Integer>();
		
		if(a.size() < 2){
			return a.size();
		}
	
		int globalmax = 1;

		for(int i=0; i<a.size(); i++){
			hmap.clear();
			double slope;
			int maxcount = 0;
			int samepoint = 0;				
			for(int j=i+1; j<a.size(); j++){
				if((a.get(i) == a.get(j)) && (b.get(i) == b.get(j))){
					samepoint++;	
					continue;
				}
				else if((a.get(i) == a.get(j)) && (b.get(i) != b.get(j))){
					slope = Double.MAX_VALUE;
				}
				else if(b.get(i) == b.get(j)){
					slope = 0.0;
				}
				else{
					slope = (double)(b.get(j)-b.get(i))/(double)(a.get(j)-a.get(i));
				}
				
				if(hmap.containsKey(slope)){
					int newcount = hmap.get(slope) + 1;
					hmap.put(slope, newcount);
					if(newcount > maxcount){
						maxcount = newcount;
					}	
				}
				else{
					hmap.put(slope, 1);
					if(maxcount == 0){
						maxcount = 1;
					}
				}	
			}
				
				if(globalmax < maxcount + samepoint + 1){
					globalmax = maxcount + samepoint + 1;
				}	
		}	

		return globalmax;
	}	

	public static void main(String args[])throws Exception{
		Points p = new Points();
		ArrayList x = new ArrayList<>(Arrays.asList(1,1));			
		ArrayList y = new ArrayList<>(Arrays.asList(2,2));
		System.out.println(p.maxPoints(x,y));
	}}
