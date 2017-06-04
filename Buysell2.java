import java.util.*;
import java.io.*;
public class Buysell2{

	public void printArray(int[] arr, int n){
		for(int i=0; i<n; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public int maxProfit(final List<Integer> a) {

		if(a.size() == 0){
			return 0;
		}

		int prev [] = new int [a.size()];
		
		prev[0] = a.get(0);
		for(int i=1; i<a.size(); i++){
			prev[i] = a.get(i) - a.get(i-1);
		}

		//printArray(prev, a.size());

		int glow = 0, ghigh = 0, gprof = 0;
		int low = glow, high = ghigh, prof = 0;
		int bought = 0;
		for(int i=1; i<a.size(); i++){	
			int ival = a.get(i);
			
			if(bought==0 && prev[i] >=0 && prev[i] >= prev[i-1]){
				low = a.get(i-1);
				bought = 1;
			} 

			if(bought == 1 && prev[i]<0 && prev[i] < prev[i-1]){
				high = a.get(i-1);
				gprof += high - low;
				bought = 0;
			}
			
			if(i==a.size() - 1){

				if(bought == 1 && prev[i] >=0){
					high = a.get(i);
					gprof += high - low;
					bought = 0;	
				}
		
			}
		}
	
		return gprof;
	}

	public static void main(String args[])throws Exception{
		Buysell2 bs = new Buysell2();
		//List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
		
		//List<Integer> a = new ArrayList<>(Arrays.asList(100, 10, 5, 1, 2, 9, 12));
	
	
		//List<Integer> a = new ArrayList<>(Arrays.asList(5,1,10,7,9));

				
		List<Integer> a = new ArrayList<>(Arrays.asList(1,5,7,11,15));

		System.out.println(bs.maxProfit(a));
	}}
