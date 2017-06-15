import java.util.*;
import java.io.*;
public class GridObs{

	int count;

	public void recur(ArrayList<ArrayList<Integer>> a, int x, int y, int m, int n){	

		if(a.get(x).get(y) == 1){
			return;
		}	

		else if(a.get(x).get(y) == 0){

			if(x==m-1 && y==n-1){
				count++;
				return;
			}
		}
		

		if(x+1 < m){
			recur(a, x+1, y, m, n);
		}
		if(y+1 < n){
			recur(a, x, y+1, m, n);
		}
		
	}	

	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
	
		int rowlen = a.size();
		if(rowlen == 0){
			return 0;
		}		

		else if(a.get(0).get(0) == 1){
			return 0;
		}
		
		count = 0;
		int colslen = a.get(0).size();
		recur(a, 0, 0, rowlen, colslen);		
		return count;
	}	

	public static void main(String args[])throws Exception{
		GridObs go = new GridObs();
		ArrayList row1 = new ArrayList<>(Arrays.asList(0,0,0));

		ArrayList row2 = new ArrayList<>(Arrays.asList(0,1,0));
		ArrayList row3 = new ArrayList<>(Arrays.asList(0,0,0));
		
		ArrayList matrix = new ArrayList();
		matrix.add(row1);
		matrix.add(row2);
		matrix.add(row3);
		System.out.println(go.uniquePathsWithObstacles(matrix));
	}}
