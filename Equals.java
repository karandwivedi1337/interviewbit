import java.util.*;
import java.io.*;
public class Equals{

	void printHashMap(HashMap<Integer, ArrayList<ArrayList<Integer>>> hmap){

		for(Integer key: hmap.keySet()){
			System.out.println("key="+key+ " value=" + hmap.get(key));
		}		

	}

	public ArrayList<Integer> equal(ArrayList<Integer> a) {

		HashMap<Integer, ArrayList<ArrayList<Integer>>> hmap = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();

		ArrayList<Integer> res = new ArrayList<Integer>();

		for(int i=0; i<a.size(); i++){
			for(int j=0; j<a.size(); j++){
				if(i == j){
					continue;
				}
				int sum = a.get(i) + a.get(j);

				int firstindex = i;
				int secondindex = j;

				if(firstindex > secondindex){
					int temp = secondindex;
					secondindex = firstindex;
					firstindex = temp;
				}

				if(!hmap.containsKey(sum)){
					ArrayList<Integer> pair = new ArrayList<Integer>();
					pair.add(firstindex);
					pair.add(secondindex);
					ArrayList<ArrayList<Integer>> pairlist = new ArrayList<ArrayList<Integer>>();
					pairlist.add(new ArrayList(pair));
					hmap.put(sum, new ArrayList(pairlist));	
				}

				else{
					ArrayList<ArrayList<Integer>> pairlist = hmap.get(sum);
					int pairfound = 0;
					for(int k=0; k<pairlist.size(); k++){
						ArrayList<Integer> pair = pairlist.get(k);
						if(pair.get(0) == firstindex && pair.get(1) == secondindex){
							pairfound = 1;
							break;
						}	
					}

					if(pairfound == 1){
						continue;
					}
					else{

						ArrayList<Integer> newpair = new ArrayList<Integer>();
						newpair.add(firstindex);
						newpair.add(secondindex);
						pairlist.add(new ArrayList(newpair));
						hmap.put(sum, new ArrayList(pairlist));
					}				
				}

			}				
		}

		//printHashMap(hmap);			
		int mina1=Integer.MAX_VALUE;
		int minb1 = mina1, minc1=mina1, mind1=mina1;		

		//printHashMap(hmap);

		for(Integer key: hmap.keySet()){
			if(hmap.get(key).size() > 1){
				//System.out.println("key="+key+ " value=" + hmap.get(key));
				ArrayList<ArrayList<Integer>> pairlist = hmap.get(key);
				for(int x=0; x<pairlist.size(); x++){
					for(int y=x+1; y<pairlist.size(); y++){

						ArrayList<Integer> firstpair = pairlist.get(x);
						ArrayList<Integer> secondpair = pairlist.get(y);
						int a1 = firstpair.get(0);
						int b1 = firstpair.get(1);
						int c1 = secondpair.get(0);
						int d1 = secondpair.get(1);

						if((a1 < b1) && (c1 < d1) && (a1 < c1) && (b1 != d1) && (b1 != c1)){
							//System.out.println("a1=" + a1 + " b1=" + b1 + " c1=" +c1 + " d1=" + d1);
							if(a1 < mina1){
								mina1 = a1;
								minb1 = b1;
								minc1 = c1;
								mind1 = d1;
							}

							else if(a1 == mina1 && b1<minb1){
								mina1 = a1;
								minb1 = b1;
								minc1 = c1;
								mind1 = d1;
							}

							else if(a1 == mina1 && b1 == minb1 && c1 < minc1){

								mina1 = a1;
								minb1 = b1;
								minc1 = c1;
								mind1 = d1;
							}


							else if(a1 == mina1 && b1 == minb1 && c1 == minc1 && d1 < mind1){

								mina1 = a1;
								minb1 = b1;
								minc1 = c1;
								mind1 = d1;
							}

						}
					}
				}
			}
		}

		if(mina1 == Integer.MAX_VALUE && minb1 == mina1 && minc1 == mina1 && mind1 == mina1){
			return res;
		}

		res.add(mina1);
		res.add(minb1);
		res.add(minc1);
		res.add(mind1);
		return res;			
	}	

	public static void main(String args[])throws Exception{
		Equals eq = new Equals();
		//ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8));

		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,1,1,1,1));
		System.out.println(eq.equal(list));

	}}
