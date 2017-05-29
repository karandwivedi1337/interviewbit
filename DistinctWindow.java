import java.util.*;
import java.io.*;
public class DistinctWindow{

	public void printTreeMap(TreeMap<Integer, Integer> tmap){
		 for (Map.Entry<Integer, Integer> entry : tmap.entrySet()) {
       		System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());
		 // entry.getKey() has the key, entry.getValue() has the value
    } 

	}

	public void addToMap(TreeMap<Integer, Integer> tmap, int ele){
		
		if(!tmap.containsKey(ele)){
			tmap.put(ele, 1);	
		}	
			
		else{
			int freq = tmap.get(ele);
			tmap.put(ele, freq+1);
		}
	}

	public void removeFromMap(TreeMap<Integer, Integer> tmap, int ele){

		if(!tmap.containsKey(ele)){
			return;
		}	

		int freq = tmap.get(ele);

		if(freq == 1){
			tmap.remove(ele);
		}

		else{
			tmap.put(ele, freq-1);
		}	
	
	}

	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

		ArrayList<Integer> res = new ArrayList<Integer>();		
		int k = B;

		if(k > A.size()){
			return res;
		}		

		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
			
		for(int i=0; i<k; i++){
			addToMap(tmap, A.get(i));
		}		
			
		res.add(tmap.size());

		for(int i=k; i<A.size(); i++){
			removeFromMap(tmap, A.get(i-k));
			addToMap(tmap, A.get(i));		
			res.add(tmap.size());			
		}
		
		return res;
	}


	public static void main(String args[])throws Exception{
		DistinctWindow dw = new DistinctWindow();
	
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
		int k = 3;	
	 	System.out.println(dw.dNums(a, k));
	}}
