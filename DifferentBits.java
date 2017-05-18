import java.util.*;
public class DifferentBits {

	public int cntBits(ArrayList<Integer> A) {

		int sum = 0;
		int totalele = A.size();
		for(int i=0; i<32; i++){
			int count = 0;
			for(int j=0; j<totalele; j++){
				int n = A.get(j);
				if( (n & (1<<i)) > 0){
					count++;
				}	
			}
			
		        sum += (count * (totalele-count) * 2);					
		
		}
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
