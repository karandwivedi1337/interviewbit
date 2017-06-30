import java.util.*;
import java.io.*;
public class MaxRectBin{

	int maxarea;

	public void printArr(int dp[][], int n, int m){

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
	}

	public int largestRectangleArea(ArrayList<Integer> A) {
	    java.util.Stack<Integer> stack = new java.util.Stack<>();
	    int n = A.size();
	    int res = 0;
	    int prevMin[], nextMin[];
	    int cur;
	    int idx;
	    int prev, next;
	    
	    prevMin = new int[n];
	    nextMin = new int[n];
	    
	    for (int i = 0; i < n; i++) {
	        
	        cur = A.get(i);
	        
	        while (!stack.isEmpty() && cur <= A.get(stack.peek())) {
	            stack.pop();
	        }
	        
	        if (stack.isEmpty()) {
	            prevMin[i] = -1;
	        } else {
	            prevMin[i] = stack.peek();
	        }
	        
            stack.push(i);
	        
	    }
	    
	    stack.clear();
	    
	    for (int i = n - 1; i >= 0; i--) {
	        cur = A.get(i);
	        
	        while (!stack.isEmpty() && cur <= A.get(stack.peek())) {
	            stack.pop();
	        }
	        
	        if (stack.isEmpty())
	            nextMin[i] = n;
	        else
	            nextMin[i] = stack.peek();
	            
	        stack.push(i);
	    }
	    
	    for (int i = 0; i < n; i++) {
	        prev = prevMin[i];
	        next = nextMin[i];
	        int area = (next - prev - 1) * A.get(i);
	        res = Math.max(res, area);
	    }
	    
	    
	    return res;
	}

	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		
		if(n==0){
			return 0;
		}
		
		int m = a.get(0).size();
		
		maxarea = 0;
		int dp[][] = new int[n][m];

		for(int i=0; i<n; i++){
			ArrayList<Integer> temprow = new ArrayList<Integer>();
			for(int j=0; j<m; j++){
				int ele = a.get(i).get(j);
				if(ele == 0){
					dp[i][j]=0;
					temprow.add(dp[i][j]);
					continue;		
				}
				
				dp[i][j] = (i==0)?1:dp[i-1][j]+1;
				temprow.add(dp[i][j]);	
			}
			
			//System.out.println(temprow);

			int ret = largestRectangleArea(temprow);
			maxarea = Math.max(maxarea, ret);
					
		}

		printArr(dp, n, m);		

		return maxarea;	

	}

	public static void main(String args[])throws Exception{
		MaxRectBin mrb = new MaxRectBin();
			
		/*
		ArrayList<Integer> r1 = new ArrayList<>(Arrays.asList(1,1,1));
		ArrayList<Integer> r2 = new ArrayList<>(Arrays.asList(0,1,1));
		ArrayList<Integer> r3 = new ArrayList<>(Arrays.asList(1,0,0));
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		a.add(r1);
		a.add(r2);
		a.add(r3);
		*/

		/*	
		ArrayList<Integer> r1 = new ArrayList<>(Arrays.asList(0,0,0,0));

		ArrayList<Integer> r2 = new ArrayList<>(Arrays.asList(0,1,1,1));
		ArrayList<Integer> r3 = new ArrayList<>(Arrays.asList(0,1,1,1));
		
		ArrayList<Integer> r4 = new ArrayList<>(Arrays.asList(0,1,1,1));
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		a.add(r1);
		a.add(r2);
		a.add(r3);
		a.add(r4);
		*/

		
		ArrayList<Integer> r1 = new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0, 0, 1, 0, 1));
		ArrayList<Integer> r2 = new ArrayList<>(Arrays.asList(0, 1, 1, 0, 0, 0, 0, 0, 0));
		ArrayList<Integer> r3 = new ArrayList<>(Arrays.asList(0, 0, 1, 0, 1, 0, 1, 0, 1));
		ArrayList<Integer> r4 = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 1, 1, 0, 1));
		ArrayList<Integer> r5 = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 0, 1, 1, 1));
		ArrayList<Integer> r6 = new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 0, 1, 1, 1));
		ArrayList<Integer> r7 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0, 1, 1, 1, 1));
		ArrayList<Integer> r8 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 0, 1, 0, 1));

		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		a.add(r1);
		a.add(r2);
		a.add(r3);
		a.add(r4);
		a.add(r5);
		a.add(r6);
		a.add(r7);
		a.add(r8);
			
		System.out.println(mrb.maximalRectangle(a));

	}}
