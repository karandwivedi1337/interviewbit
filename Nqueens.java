import java.util.*;
import java.io.*;
public class Nqueens{

	boolean testboard(String[][] board, int a){
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		for(int i=0; i<a; i++){
			for(int j=0; j<a; j++){
				if(board[i][j].equals("Q")){
					//2 Queens on the same row collide
					if(!rows.contains(i)){
						rows.add(i);
					}
					else{
						return false;
					}	
					cols.add(j);	
				}
			}
		}
		
		/*
		for(int i=0; i<rows.size(); i++){
			System.out.print("(" + rows.get(i) + "," + cols.get(i) + ") ");
		}
		System.out.println();
		*/

		//now each Queen is on a separate row, hence check diagonals

		//check up left diagonal
		for(int i=0; i<rows.size(); i++){
			int r = rows.get(i);
			int c = cols.get(i);

			if(r==0 || c==0){
				continue;
			}

			while(r> 0 && c>0){
				r=r-1;
				c=c-1;
				for(int k=0; k<rows.size(); k++){
					if(rows.get(k) == r && cols.get(k) == c){
						//System.out.println("Up Left diagonal check failed");
						return false;
					}
				}
			}		
		}				


		//check down left diagonal
		for(int i=0; i<rows.size(); i++){
			int r = rows.get(i);
			int c = cols.get(i);

			if(r==a-1 || c==0){
				continue;
			}

			while(r< a && c>0){
				r=r+1;
				c=c-1;

				for(int k=0; k<rows.size(); k++){
					if(rows.get(k)==r && cols.get(k)==c){
						//System.out.println("Down Left diagonal check failed");
						return false;
					}
				}
			}		
		}				


		//check up right diagonal
		for(int i=0; i<rows.size(); i++){
			int r = rows.get(i);
			int c = cols.get(i);

			if(r==0 || c==a-1){
				continue;
			}

			while(r> 0 && c<a){
				r=r-1;
				c=c+1;
				for(int k=0; k<rows.size(); k++){
					if(rows.get(k)==r && cols.get(k)==c){
						//System.out.println("Up right diagonal check failed");
						return false;
					}
				}
			}		
		}				

		//check down right diagonal
		for(int i=0; i<rows.size(); i++){
			int r = rows.get(i);
			int c = cols.get(i);

			if(r==a-1 || c==a-1){
				continue;
			}

			while(r< a && c<a){
				r=r+1;
				c=c+1;
				for(int k=0; k<rows.size(); k++){
					if(rows.get(k)==r && cols.get(k)==c){
						//System.out.println("Down right diagonal check failed");
						return false;
					}
				}		
			}				
		}

		return true;	

	}

	void addArrayToList(String[][] board, int a, ArrayList<ArrayList<String>> res){

		//list contains board array in row order
		ArrayList<String> temp = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<a; i++){
			for(int j=0; j<a; j++){
				sb.append(board[i][j]);
			}
			temp.add(sb.toString());
			sb.delete(0, sb.length());
		}
			
		res.add(temp);
	}

	void recur(int a, String[][] board, ArrayList<ArrayList<String>> res, int count)	{

		if(count == a && testboard(board, a)){
			addArrayToList(board, a, res);
			count=0;
			return;
		}	

		else if(count < a){	
			for(int i=0; i<a; i++){
				board[i][count] = "Q";
				//System.out.println("Calling recur with a=" + a + " board=" + board + " res=" + res + " count = " + count);
				recur(a, board, res, ++count);
				--count;
				board[i][count] = ".";
			}
		}

	}

	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		String board[][] = new String[a][a];
		for(int i=0; i<a; i++){
			for(int j=0; j<a; j++){
				board[i][j] = ".";
			}
		}
		recur(a, board, res, 0);
		return res;
	}	

	public static void main(String args[])throws Exception{
		Nqueens nq = new Nqueens();
		System.out.println(nq.solveNQueens(9));
	}}
