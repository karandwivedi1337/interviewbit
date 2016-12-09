import java.io.*;
import java.lang.Math.*;

class substring{

static void doCharByCharMatch(String text, String pattern, int start, int end){

System.out.println("Hash match - " + start + " to " + end);

int i,j=0;
for(i=start; i< end; i++){

	if(text.charAt(i) != pattern.charAt(j++)){
		break;
	}	
}


if(i==end){
	System.out.println("Match at index " + start);
}

}

static int intmod(int a, int b){
	return ((a % b) + b) % b;
}

static int hashonce(String text, int start, int end){

	int B = 13;
	int m = end - start;
	int currenthash = 0;
	int M = 1301081;
	for(int i=start; i<=end; i++){
		currenthash += ((int)text.charAt(i))*((int)Math.pow(B,m));
		currenthash %= M;
		m--;
	}

	return currenthash%M;
}

static int rollhash(int prevhash, int prevend, String text,  int m){

int M = 1301081;
int B = 13;
int newhash = ((prevhash % M) -  (((int)text.charAt(prevend))*((int)Math.pow(B,m-1)) % M)) % M;

newhash = (newhash*B) % M;
newhash = (newhash + ((int)text.charAt(prevend+m))) % M;

return newhash;

}

static void rabinKarp(String text, String pattern){

		
		int n=text.length();
		int m=pattern.length();

		if(m > n){
			System.out.println("pattern exceeds text");
			return;
		}	
		
		int i,j;
	
		int patthash = hashonce(pattern, 0, pattern.length()-1);	
		
		int texthash = hashonce(text, 0, pattern.length()-1);				        			
	
		if(patthash == texthash){

			doCharByCharMatch(text, pattern, 0, pattern.length());
				
		}


		for(i=m; i<n; i++){

		texthash = rollhash(texthash, i-m, text, m-1 );	
		
		if(patthash == texthash){

			doCharByCharMatch(text, pattern, i, pattern.length());
				
		}

		}		

}

	static void naiveAlgorithm(String text, String pattern){

		int n=text.length();
		int m=pattern.length();

		if(m > n){
			System.out.println("pattern exceeds text");
			return;
		}	
		int i,j;
		for(i=0; i< n-m+1; i++){

			for(j=0; j<m; j++){

				if(text.charAt(i+j) != pattern.charAt(j)){
					break;
				}		
			}


			if(j==m){
				System.out.println("Match at " + i);
			}

		}
	}	

public static void main(String args[]){

	String text = "cocaBScolaSBcolacoca";
	String pattern = "lac";
	//naiveAlgorithm(text, pattern);	
	rabinKarp(text, pattern);
}}
