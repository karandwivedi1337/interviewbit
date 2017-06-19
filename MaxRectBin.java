import java.util.*;
import java.io.*;
public class MaxRectBin{

	class Data{
		public int startx;
		public int starty;
		public int area;
		public int both;
		public int altstartx;
		public int altstarty;

		Data(){
			startx=starty=area=both=altstartx=altstarty=0;
		}

	}

	int maxarea;

	public void printArr(Data dp[][], int n, int m){

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(dp[i][j].startx + "," + dp[i][j].starty + "," + dp[i][j].area + "  ");	
			}
			System.out.println();
		}
	}

	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		
		if(n==0){
			return 0;
		}
		
		int m = a.get(0).size();
		
		maxarea = 0;
		Data dp[][] = new Data[n][m];

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				dp[i][j] = new Data();
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){

				System.out.println("i="+i + " j=" + j);
				//check left or top element or both	
				int ele = a.get(i).get(j);
				if(ele == 0){
					System.out.println("Skip");
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

				//both elements are valid, find common point (if exists), else take the max rectangle formed by either.
				//if both top and left form equal areas, then set both=1 and store both x and y coordinates
				if(leftele == 1 && rightele ==1){
					System.out.println("Both left and top elements exist");
					Data leftdp = dp[i][j-1];
					Data topdp = dp[i-1][j];
					
					//common point
					if((leftdp.startx == topdp.startx) && (leftdp.starty >= topdp.starty)){
						System.out.println("Common point");
						dp[i][j].startx = leftdp.startx;
						dp[i][j].starty = leftdp.starty;
						dp[i][j].area = (Math.abs(i - dp[i][j].startx) + 1)*(Math.abs(j-dp[i][j].starty) + 1);
						maxarea = Math.max(dp[i][j].area, maxarea);	
					}

					else{

						/*
						dp[i][j].startx = i;
						dp[i][j].starty = leftdp.starty;
						dp[i][j].area = (Math.abs(i - dp[i][j].startx + 1))*(Math.abs(j - dp[i][j].starty +1));
						maxarea = Math.max(dp[i][j].area, maxarea);	


						dp[i][j].startx = topdp.startx;
						dp[i][j].starty = j;
						dp[i][j].area = Math.abs((dp[i][j].startx - i + 1))*Math.abs((j - dp[i][j].starty + 1));
						maxarea = Math.max(dp[i][j].area, maxarea);
						*/
						System.out.println("No Common point");
						int leftarea = 1*(Math.abs(j - leftdp.starty) +1);
						int toparea = (Math.abs(topdp.startx - i) + 1)*1;

						if(leftarea > toparea){
								System.out.println("Left area is larger");
								dp[i][j].startx = i;
								dp[i][j].starty = leftdp.starty;
								dp[i][j].area = leftarea;
						}

						else if(toparea > leftarea){
								System.out.println("Top area is larger");
								dp[i][j].startx = topdp.startx;
								dp[i][j].starty = j;
								dp[i][j].area = toparea;		
						}
						//equal areas
						else{
							System.out.println("Equal areas, both set");
							dp[i][j].both = 1;
							dp[i][j].startx = i;
							dp[i][j].starty = leftdp.starty;
							dp[i][j].altstartx = topdp.startx;
							dp[i][j].altstarty = j;
							dp[i][j].area = leftarea;
						}
					}

				}		

				//only left one is valid, check rectangle in the same row
				else if(leftele == 1 && rightele != 1){
					System.out.println("only left one is valid");
					Data leftdp = dp[i][j-1];
					dp[i][j].startx = i;
					dp[i][j].starty = leftdp.starty;
					dp[i][j].area = (Math.abs(i - dp[i][j].startx) + 1)*(Math.abs(j - dp[i][j].starty) +1);
					maxarea = Math.max(dp[i][j].area, maxarea);
				}

				//only element above is valid, check rectangle in the same column
				else if(leftele != 1 && rightele == 1){
					System.out.println("only top one is valid");
					Data topdp = dp[i-1][j];
					if(topdp.both == 0){
					System.out.println("Both is not set");
					dp[i][j].startx = topdp.startx;
					dp[i][j].starty = j;
					dp[i][j].area = (Math.abs(dp[i][j].startx - i) + 1)*(Math.abs(j - dp[i][j].starty) +1);
					maxarea = Math.max(dp[i][j].area, maxarea);
					}

					else{
						System.out.println("Both is set");
						dp[i][j].startx = topdp.altstartx;
						dp[i][j].starty = j;
						dp[i][j].area = (Math.abs(dp[i][j].startx - i) + 1)*(Math.abs(j - dp[i][j].starty) +1);
						maxarea = Math.max(dp[i][j].area, maxarea);	
					}
				}

				//handle special case of (i=0 && j=0) (left and top elements do not exist)
				//OR both of them are 0
				else{
					System.out.println("Special case");
					Data topleftdp = dp[i][j];
					topleftdp.startx = i;
					topleftdp.starty = j;
					topleftdp.area = 1;
					maxarea = Math.max(dp[i][j].area, maxarea);	
				}		

			}

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
