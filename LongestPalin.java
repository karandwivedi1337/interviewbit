public class LongestPalin {


	public void printArray(int[][] palinarr, int rowsize){

		for(int i=0; i<rowsize; i++){
			for(int j=0; j<rowsize; j++){
				System.out.print(palinarr[i][j]);
			}
			System.out.println();
		}
	}

	public void initArray(int[][] palinarr, int rowsize){

		for(int i=0; i<rowsize; i++){
			for(int j=0; j<rowsize; j++){
				if(i==j){
					palinarr[i][j]=1;
				}
				else{
					palinarr[i][j]=0;
				}	
			}
		}
	}

	public int checkForPalin(String a, String substr, int start, int end, int[][] palinarr){

		if(palinarr[start][end] == 1){
			return 1;
		}

		if(start == end){
			palinarr[start][end] = 1;
			return 1;
		}

		if(end == start + 1){
			if(a.charAt(start) == a.charAt(end)){
				palinarr[start][end]=1;
				return 1;
			}		
		}					

		if(end > start+1){
			if(a.charAt(start) == a.charAt(end)){
				if(palinarr[start+1][end-1] == 1){
					palinarr[start][end] = 1;
					return 1;
				}
				return 0;
			}
			return 0;
		}			

		return 0;	
	}
	
	public String longestPalindrome(String a) {

		int pos = Integer.MAX_VALUE;
		String lonpal = "";
		int len = Integer.MIN_VALUE;
		
		int palinarr[][] = new int[a.length()][a.length()];
		initArray(palinarr, a.length());		
		for(int x=0; x<a.length(); x++){
			for(int i=0; i<a.length()-x; i++){
				int j = i+x;
				String substr = a.substring(i,j+1);

				if(checkForPalin(a, substr, i, j, palinarr) == 1){
					if((j-i+1) > len){
						pos = i;
						lonpal = substr;
						len=j-i+1;
					}
					else if((j-i+1) == len){
						if(i <= pos){		
							pos = i;
							lonpal = substr;
							len=j-i+1;
						}
					}
				}	
			}
		}

		return lonpal;			
	}

	public static void main(String args[])throws Exception{
		LongestPalin lp = new LongestPalin();
		System.out.println(lp.longestPalindrome("aaaabaaa"));
	}}
