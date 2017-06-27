import java.util.*;
import java.io.*;
public class Lcs{
	
	public int recurLCS(String a, String b){

		if(a.length() == 0 || b.length() ==0){
			return 0;
		}	
		
		if(a.charAt(a.length()-1) == b.charAt(b.length()-1)){
			return 1+recurLCS(a.substring(0, a.length()-1), b.substring(0, b.length()-1));
		}	
	
		else{
			
			return Math.max(recurLCS(a.substring(0, a.length()-1), b), recurLCS(a, b.substring(0, b.length()-1)));

		}

	}

	public int dpLCS(String a, String b){

		if(a.length() == 0 || b.length() ==0){
			return 0;
		}	

		int dp[][] = new int[a.length()+1][b.length()+1];
		
		for(int i=0; i<a.length(); i++){
			dp[i][0] = 0;
		}		
		
		for(int i=0; i<b.length(); i++){
			dp[0][i] = 0;
		}		
	
		for(int i=1; i<=a.length(); i++){
			for(int j=1; j<=b.length(); j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}					
	
		return dp[a.length()][b.length()];

	}


	public String dpLCSPrint(String a, String b){

		if(a.length() == 0 || b.length() ==0){
			return "";
		}	

		int dp[][] = new int[a.length()+1][b.length()+1];
		char solution[][] = new char[a.length()+1][b.length()+1];
		for(int i=0; i<a.length(); i++){
			dp[i][0] = 0;
			solution[i][0] = '0';
		}		
		
		for(int i=0; i<b.length(); i++){
			dp[0][i] = 0;
			solution[0][i] = '0';
		}		
	
		for(int i=1; i<=a.length(); i++){
			for(int j=1; j<=b.length(); j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
					solution[i][j] = 'd';
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					if(dp[i][j] == dp[i-1][j]){
						solution[i][j] = 't';
					}
					else{
						solution[i][j] = 'l';
					}
				}
			}
		}
	
		String res = "";
		int ai = a.length();
		int bj = b.length();
		char x = solution[ai][bj];
		while(x != '0'){

			if(solution[ai][bj] == 'd'){
				res = a.charAt(ai-1) + res;
				ai--;
				bj--;
			}

			else if(solution[ai][bj] == 't'){
				ai--;
			}

			else{
				bj--;
			}

			x = solution[ai][bj];
		}
								
			
		return res;

	}



	public static void main(String args[])throws Exception{
		Lcs l = new Lcs();
		System.out.println(l.recurLCS("abcdef", "azdae"));
		System.out.println(l.dpLCS("abcdef", "azdae"));
		System.out.println(l.dpLCSPrint("abcdef", "azdae"));
	}}
