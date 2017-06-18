import java.util.*;
import java.io.*;
public class WordBreak{

	int state = 0;
	HashMap<String, String> hmap;

	/*
	public void recur(String a){

		System.out.println("recur called with a=" + a);

		if(a.equals("")){
			state = 1;
			return;
		}		

		if(a.length() > 0){
			for(int i=0; i<a.length(); i++){
				if(state == 1){
					break;
				}
				String substr = a.substring(0, i+1);
				System.out.println("substr=" + substr);
				if(hmap.containsKey(substr)){
					recur(a.substring(i+1));
				}
	
			}

		}

	}
	*/

	public void printArr(boolean[] dp){

		for(int i=0; i<dp.length; i++){
			if(dp[i] == true){
				System.out.print("1 ");
			}

			else{
				System.out.print("0 ");
			}
		}
		System.out.println();
	}

	public void recur(String a){

		boolean dp[] = new boolean[a.length()+1];
		for(int i=0; i<dp.length; i++){
			dp[i] = false;
		}
		
		dp[0] = true;	

		for(int i=1; i<=a.length(); i++){
			for(int j=0; j<i; j++){
				if(dp[j] && hmap.containsKey(a.substring(j, i))){
					dp[i] = true;
					printArr(dp);
			}
			}
		}				
		
		if(dp[a.length()] == true){
			state =1;
		}
	
		
	}

	public int wordBreak(String a, ArrayList<String> b) {
		hmap = new HashMap<String, String>();
		
		for(int i=0; i<b.size(); i++){
			hmap.put(b.get(i), b.get(i));			}

		recur(a);						
		return state;
	}	

	public static void main(String args[])throws Exception{
		WordBreak wb = new WordBreak();	
		String a = "myinterviewtrainer";
		ArrayList<String> b = new ArrayList<>(Arrays.asList("interview", "my", "trainer", "m"));	
		System.out.println(wb.wordBreak(a,b));
	}}
