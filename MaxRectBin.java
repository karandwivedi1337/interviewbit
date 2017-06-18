import java.util.*;
import java.io.*;
public class MaxRectBin{

	class Data{
		public int startx;
		public int starty;
		public int area;
			
		Data(){
			startx=starty=area=0;
		}

	}

	int maxarea;

	public void printArr(Data dp[][], int n){

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(dp[i][j].startx + "," + dp[i][j].starty + "," + dp[i][j].area + "  ");	
			}
			System.out.println();
		}
	}

	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		maxarea = 0;
		Data dp[][] = new Data[n][n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				dp[i][j] = new Data();
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){

				//check left or top element or both	
				int ele = a.get(i).get(j);
				if(ele == 0){
					continue;
				}

				int leftele = -1, rightele = -1;	
				//check element to the left
				if(j-1 >= 0){
					leftele = a.get(i).get(j-1);
				}
				//check element above it
				if(i-1 >= 0){
					rightele = a.get(i-1).get(j);
				}

				//both elements are valid, find common point (if exists), else take the max rectangle formed by either
				if(leftele == 1 && rightele ==1){
					Data leftdp = dp[i][j-1];
					Data topdp = dp[i-1][j];
					//common point
					if((leftdp.startx == topdp.startx) && (leftdp.starty == topdp.starty)){

						dp[i][j].startx = leftdp.startx;
						dp[i][j].starty = leftdp.starty;
						dp[i][j].area = (i - leftdp.startx + 1)*(j-leftdp.starty + 1);
						maxarea = Math.max(dp[i][j].area, maxarea);	
					}

					else{

						dp[i][j].startx = i;
						dp[i][j].starty = leftdp.starty;
						dp[i][j].area = (i - leftdp.startx + 1)*(j - leftdp.starty +1);
						maxarea = Math.max(dp[i][j].area, maxarea);	


						dp[i][j].startx = topdp.startx;
						dp[i][j].starty = j;
						dp[i][j].area = (topdp.startx - i + 1)*(j - topdp.starty + 1);
						maxarea = Math.max(dp[i][j].area, maxarea);

					}

				}		

				//only left one is valid, check rectangle in the same row
				else if(leftele == 1 && rightele != 1){
					Data leftdp = dp[i][j-1];
					dp[i][j].startx = i;
					dp[i][j].starty = leftdp.starty;
					dp[i][j].area = (i - leftdp.startx + 1)*(j - leftdp.starty +1);
					maxarea = Math.max(dp[i][j].area, maxarea);

				}

				//only element above is valid, check rectangle in the same column
				else if(leftele != 1 && rightele == 1){
					Data topdp = dp[i-1][j];
					dp[i][j].startx = topdp.startx;
					dp[i][j].starty = j;
					dp[i][j].area = (topdp.startx - i + 1)*(j - topdp.starty +1);
					maxarea = Math.max(dp[i][j].area, maxarea);

				}

				//handle special case of (i=0 && j=0) (left and top elements do not exist)
				//OR both of them are 0
				else{
					Data topleftdp = dp[i][j];
					topleftdp.startx = i;
					topleftdp.starty = j;
					topleftdp.area = 1;
					maxarea = Math.max(dp[i][j].area, maxarea);	
				}		

			}

		}		

		//printArr(dp, n);

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

		
		ArrayList<Integer> r1 = new ArrayList<>(Arrays.asList(0,0,0,0));

		ArrayList<Integer> r2 = new ArrayList<>(Arrays.asList(0,1,1,1));
		ArrayList<Integer> r3 = new ArrayList<>(Arrays.asList(0,1,1,1));
		
		ArrayList<Integer> r4 = new ArrayList<>(Arrays.asList(0,1,1,1));
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		a.add(r1);
		a.add(r2);
		a.add(r3);
		a.add(r4);

		System.out.println(mrb.maximalRectangle(a));

	}}
