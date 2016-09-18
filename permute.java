import java.io.*;

class permute{

static void permuteString(String begin, String end){

	if(end.length() <= 1){
		System.out.println(begin+end);
	}
	else{
		for(int i=0; i<end.length(); i++){
			String remainString = end.substring(0,i) + end.substring(i+1);
			permuteString(begin + end.charAt(i), remainString);	
		
		}
	}
}

public static void main(String args[])throws Exception{

BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

String s = br.readLine();
permuteString("",s);
}

}
