import java.util.*;
public class ThreeSum{

	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a){

		Collections.sort(a);		
		System.out.println(a);			
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		boolean incrementi = false;
		
		for(int i=0; i<a.size(); i++){
			incrementi = false;			
			for(int j=a.size()-2; j>i; j--){
		
				for(int k=a.size()-1; k>j; k--){
					System.out.println("i="+i+" j="+j+" k="+k);
					int ni = a.get(i);
					int nj = a.get(j);
					int nk = a.get(k);

					int sum = ni + nj + nk;				
					if(sum == 0){
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(ni);
						temp.add(nj);
						temp.add(nk);
						if(!res.contains(temp)){
							res.add(new ArrayList(temp));
						}
					}
					else if(sum > 0){
						continue;
					}

				}

			}	

		}

		return res;
	}

	public static void main(String args[])throws Exception{

		ThreeSum ts = new ThreeSum();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(-1);
		arr.add(0);
		arr.add(1);
		arr.add(2);
		arr.add(-1);
		arr.add(-4);
		System.out.println(ts.threeSum(arr));
	}}
