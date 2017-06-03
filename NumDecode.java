import java.util.*;
import java.io.*;
public class NumDecode{

	int cache[];
	boolean cacheset[];

	public boolean isValid(String s){

		if(s.length() == 1){
			if(s.charAt(0) == '0'){
				return false;
			}
			return true;
		}

		else{

			int twodigits = Integer.parseInt(s);
			//starts with 0 i.e. 00-09
			if(s.charAt(0) == '0'){
				return false;
			}

			else if(twodigits < 27){
				return true;
			}

			else if(twodigits >=27){			
				return false;
			}

			return false;

		}


	}

	public int recur(String a) {

		//System.out.println("Recur called with " + a);

		if(a.length() == 1 && a.charAt(0) == '0'){
			return 0;
		}

		else if(a.length() == 1 && a.charAt(0) != '0'){
			return 1;
		}		

		else if(a.length() == 2){

			int twodigits = Integer.parseInt(a);
			if(twodigits >= 0 && twodigits<10){
				return 0;
			}			

			else if(twodigits == 10 || twodigits == 20){
				return 1;
			}

			else if(twodigits < 27){
				return 2;
			}

			else if(twodigits >=27 && a.charAt(1) != '0'){			

				return 1;
			}
			return 0;
		}

		else if(cacheset[a.length()] != false){
			return cache[a.length()];
		}
		//System.out.println("Calling recur for " + a + "'s substring " + a.substring(1));

		if(isValid(a.substring(0,1))){
				cache[a.length()] += recur(a.substring(1));
				cacheset[a.length()] = true;
				}


		if(a.length() >= 2){
				//System.out.println("Calling recur twodigits of " + a + "'s substring " + a.substring(2));
				if(isValid(a.substring(0,2))){
				cache[a.length()] += recur(a.substring(2));
				cacheset[a.length()] = true;
				}
		}	

		return cache[a.length()]; 
	}


	public int numDecodings(String a) {
		cache = new int[a.length() + 1];
		cacheset = new boolean[a.length() + 1];
		Arrays.fill(cache, 0);
		Arrays.fill(cacheset, false);
		return recur(a);	
	}

	public static void main(String args[])throws Exception{
		NumDecode nd = new NumDecode();
		String a = "12";

		//String a = "5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190";
		System.out.println(nd.numDecodings(a));
		for(int i=0; i<a.length(); i++){
			System.out.print(nd.cache[i] + " ");
		}
	}}
