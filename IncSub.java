import java.util.*;
import java.io.*;
public class IncSub{

	public void printArr(int arr[]){

		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}		

		System.out.println();
	}		

	//Longest Increasing Subsequence
	public int lis(final List<Integer> a) {
		int n = a.size();
			
		if(n<=1){
			return n;
		}
		
		int dp[] = new int[n];	
		dp[n-1] = 1;
		int globalmax = 1;
		for(int i=n-2; i>=0; i--){
			
			int maxval = 1;
			int ai = a.get(i);
			for(int j=i+1; j<n; j++){
				if(a.get(j) > ai){
					if(dp[j]+1>maxval){
						maxval = dp[j]+1;
					}	
				}
			}

			dp[i] = maxval;
			if(maxval > globalmax){
				globalmax = maxval;
			}	
		}			

		//printArr(dp);
		return globalmax;	
	}

	public static void main(String args[])throws Exception{
		IncSub is = new IncSub();
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15));
		System.out.println(is.lis(a));	
	}}
