import java.util.*;
public class DifferentBits {


	public int countDiff(int a, int b){

		if(a==b){
			return 0;
		}

		int sum=0;
		for(int i=0; i<32; i++){
			int and = 1<<i;
			int abit = (a & and)>>i;
			int bbit = (b & and)>>i;
			sum += (abit ^ bbit);
		}

		return sum;

	}
	
	public boolean inCache(ArrayList a, HashMap<ArrayList, Integer> cache){
		
		if(cache.get(a) != null){
			return true;
		}
		
		return false;

	}

	public int cntBits(ArrayList<Integer> A) {

		HashMap<ArrayList, Integer> cache;
		cache = new HashMap<ArrayList, Integer>();
		int sum = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> tempalt = new ArrayList<Integer>();
		
		for(int i=0; i<A.size(); i++){
			for(int j=i; j<A.size(); j++){
				int first = A.get(i);
				int second = A.get(j);
				
				if(first == second){
					continue;
				}
		
				temp.add(first);
				temp.add(second);
				
				if(inCache(temp, cache)){	
					sum+=cache.get(temp);
					temp.clear();	
				}
				else{
					int result=countDiff(first, second);
					sum += result;
					tempalt.add(second);
					tempalt.add(first);
					cache.put(new ArrayList(temp), result);
					cache.put(new ArrayList(tempalt), result);
					temp.clear();
					tempalt.clear();	
				}
			}
		}
		sum*=2;
		return (sum%(1000000007));
	}

	public static void main(String args[])throws Exception{

		DifferentBits db = new DifferentBits();
		ArrayList<Integer> a= new ArrayList<Integer>();
		a.add(1);
		a.add(3);
		a.add(5);
		System.out.println(db.cntBits(a));

	}}
