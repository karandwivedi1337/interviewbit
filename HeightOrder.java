import java.util.*;
import java.io.*;
public class HeightOrder{

	public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		ArrayList<Integer> heightscopy = new ArrayList(heights);
		ArrayList<Integer> sortedinf = new ArrayList<Integer>();
		
		if(heights.size() < 1){
			return res;
		}	

		Collections.sort(heights);

		for(int i=0; i<heights.size(); i++){
			int h = heights.get(i);
			int indexh = heightscopy.indexOf(h);
			sortedinf.add(infronts.get(indexh));
		}	

		for(int i=0; i<heights.size(); i++){
			res.add(-1);	
		}					

		for(int i=0; i<heights.size(); i++){
			int places = sortedinf.get(i);
			int pos = -1;
			int poscount = 0;
			for(int k=0; k<res.size(); k++){
				if(res.get(k) != -1){
					continue;
				}
				if(poscount == places){
					pos = k;
					break;
				}
				else{
					poscount++;
				}
			}
			res.set(pos, heights.get(i));
		}
		
		return res;	
	}


	public static void main(String args[])throws Exception{
		HeightOrder ho = new HeightOrder();
		ArrayList<Integer> heights = new ArrayList<>(Arrays.asList(5, 3, 2, 6, 1, 4));
		ArrayList<Integer> infronts = new ArrayList<>(Arrays.asList(0,1,2,0,3,2));
		System.out.print(ho.order(heights, infronts));	
	}}
