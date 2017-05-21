import java.util.*;
import java.io.*;
public class TwoSum{

	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {

		HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>();

		ArrayList<Integer> res = new ArrayList<Integer>();

		for(int i=0; i<a.size(); i++){
			if(hmap.containsKey(a.get(i))){
				ArrayList<Integer> poslist = hmap.get(a.get(i));
				poslist.add(i);
				Collections.sort(poslist);
				hmap.put(a.get(i), new ArrayList<Integer>(poslist));	
			}	
			else{
				ArrayList<Integer> poslist = new ArrayList<Integer>();
				poslist.add(i);
				hmap.put(a.get(i), new ArrayList<Integer>(poslist));
			}
		}

		int minfirst=a.size();
		int minsecond=a.size();

		for(int i=0; i<a.size(); i++){
			if(hmap.containsKey(b-a.get(i))){
				System.out.println(a.get(i)+","+(b-a.get(i)));
				int first = a.get(i);
				int firstindex = i;
				int second = b-a.get(i);
				ArrayList<Integer> secondlist = hmap.get(b-a.get(i));
				int secondindex = a.size();
			
				for(int j=0; j<secondlist.size(); j++){
					if(secondlist.get(j) != i){
						secondindex = secondlist.get(j);
						break;
					}		
				}

				if(secondindex == a.size()){
					continue;
				}			

				
				if(firstindex > secondindex){
					int temp = second;
					second = first;
					first = temp;

					temp = secondindex;
					secondindex = firstindex;				
					firstindex = temp;
				}
				
				if((secondindex < minsecond) || ((secondindex == minsecond) && (firstindex<minfirst))){
					minfirst = firstindex;
					minsecond = secondindex;	
				}			

				System.out.println("minfirst="+minfirst+" minsecond="+minsecond);			
			}
		}
		if(minfirst==a.size() || minsecond == a.size()){
			return res;
		}

		res.add(minfirst+1);
		res.add(minsecond+1);
		return res;
	}

	public static void main(String args[])throws Exception{
		TwoSum ts = new TwoSum();
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,1,1));
		int b=2;
		System.out.println(ts.twoSum(list, b));
	}}
