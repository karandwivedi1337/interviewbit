import java.util.*;
import java.io.*;
public class Buysell3{

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
		
		int maxprofit = 0;	
		int n = a.size();
		int left[] = new int[n];	
		int right[] = new int[n];	

		left[0] = right[n-1] = 0;	
		int leftmin = a.get(0);
		for(int i=1; i<n; i++){
			leftmin = Math.min(leftmin, a.get(i));
			left[i] = Math.max(left[i-1], a.get(i)-leftmin);
		}
		
	
		int rightmax = a.get(n-1);
		for(int i=n-2; i>=0; i--){
			rightmax = Math.max(rightmax, a.get(i));
			right[i] = Math.max(right[i+1], rightmax-a.get(i));
		}


		for(int i=0; i<n; i++){
			maxprofit = Math.max(maxprofit, left[i] + right[i]);
		}

		return maxprofit;
	}

	public static void main(String args[])throws Exception{
		Buysell3 bs = new Buysell3();
		//List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
		
		//List<Integer> a = new ArrayList<>(Arrays.asList(100, 10, 5, 1, 2, 9, 12));
	
	
		//List<Integer> a = new ArrayList<>(Arrays.asList(5,1,10,7,9));

				
		//List<Integer> a = new ArrayList<>(Arrays.asList(1,5,7,11,15));

		//List<Integer> a = new ArrayList<>(Arrays.asList(1,2,1,2));

		List<Integer> a = new ArrayList<>(Arrays.asList(1,4,5,7,6,3,2,9));

		System.out.println(bs.maxProfit(a));
	}}
