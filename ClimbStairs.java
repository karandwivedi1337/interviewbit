import java.util.*;
import java.io.*;
public class ClimbStairs{

	int cache[];
	boolean cacheset[];
	int recur(int n){
		
		if(n==0){
			return 0;
		}			
		
		else if(n<=2){
			return n;
		}

		if(cacheset[n] != false){
			return cache[n];
		}	

		cache[n] = recur(n-1) + recur(n-2);
		cacheset[n] = true;

		return cache[n];
	}

	public int climbStairs(int a) {
		cache = new int[a+1];
		cacheset = new boolean[a+1];
		return recur(a);	
	}	

	public static void main(String args[])throws Exception{
		ClimbStairs cs = new ClimbStairs();
		int a = 4;
		System.out.println(cs.climbStairs(a));
	}}
