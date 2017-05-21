import java.util.*;
import java.io.*;
public class PermSeq{

	public ArrayList<Integer> calculatePrefix(int n, int k){	
		//TODO: handle n==1 separately
		long fact[] = new long[n-1];
		int temp = 1;
		for(int i=1; i<=n-1; i++){
			temp*=i;
			fact[i-1]=temp;
			System.out.println(fact[i-1]);
		}		
		
		ArrayList<Integer> fixed = new ArrayList<Integer>();
		for(int i=0; i<n-1; i++){
			fixed.add(0);
		}			

		//System.out.println(fixed);

		int kcopy = k;
		int index = 0;
		while(kcopy != 0 && n-index-2 >=0){
			if(kcopy >= fact[n-index-2]){
				long divisor = fact[n-index-2];
				fixed.set(index, (int)(kcopy/divisor));
				kcopy = (int)(kcopy % divisor);	
			}
			else{
				index++;
			}	
		}
		
		System.out.println(fixed);		

		return fixed;
	}

	public void deleteElement(ArrayList<Integer> list, int ele){

		for(int i=0; i<list.size(); i++){
			if(list.get(i) == ele){
				list.remove(i);
				break;
			}
		}

	}

	ArrayList<Integer> createPrefix(ArrayList<Integer> ind, int n){

		ArrayList<Integer> intlist = new ArrayList<Integer>();
		
		for(int i =0; i<n; i++){
			intlist.add(i+1);
		}

		int ncopy = n;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		System.out.println(ind);
		
		int nonzeroseen = 0;	

		for(int i=0; i<ind.size()-1; i++){	
			if(nonzeroseen == 1){
				break;
			}
	
			if(ind.get(i) == 0 && nonzeroseen == 0){
				temp.add((i+1));
				deleteElement(intlist, i+1);
				continue;
			}
			else{
				int ele = i+1+ind.get(i);

				temp.add(ele);
				deleteElement(intlist, ele);
				nonzeroseen = 1;
			}
		}		
	
		for(int i=0; i<intlist.size(); i++){
			temp.add(intlist.get(i));
		}
	
		System.out.println("temp="+temp);		
		System.out.println("intlist="+intlist);	
		return temp;	
	}

	int fact(int n){
	
		int fact = 1;
		for(int i=1; i<=n; i++){
			fact*=i; 
		}
		return fact;
	}	


	public String permute(ArrayList<Integer> cand, int k){
		int n = cand.size();	
		if(n == 0){
			return "";
		}				
		
		if(k > fact(n)){
			return "";
		}

		int f = fact(n-1);
		int pos = k/f;
		k %= f;
		String ch = String.valueOf(cand.get(pos));
		cand.remove(pos);
		
		return ch + permute(cand, k);

	}

	public String getPermutation(int n, int k) {
	
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		
		for(int i=1; i<=n; i++){
			intlist.add(i);
		}
			
		return permute(intlist, k-1);
	}	

	public static void main(String args[])throws Exception{
		PermSeq ps = new PermSeq();
		System.out.println(ps.getPermutation(9,5));
		//System.out.println();
	}}
