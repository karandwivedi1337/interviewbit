public class ReverseWords {
	public String reverseWords(String a) {
		
		StringBuffer tempstr = new StringBuffer();
		StringBuffer outstr = new StringBuffer();

		for(int i=a.length()-1; i>=0; i--){
			if(a.charAt(i) == ' '){
				//trailing spaces
				if(tempstr.length() == 0){
					continue;
				}
				//if str is not empty, reverse it and add to output string
			        tempstr.reverse();
			        outstr.append(tempstr);
				outstr.append(" ");
				tempstr.delete(0, tempstr.length());			
			}
			else{
			
				tempstr.append(a.charAt(i));
			}					
						
		}
		
		if(tempstr.length() > 0){
			tempstr.reverse();
			outstr.append(tempstr);
			return outstr.toString();	
		}
	
		outstr.deleteCharAt(outstr.length()-1);
		return outstr.toString();
	}

public static void main(String args[])throws Exception{

	ReverseWords rw = new ReverseWords();
	System.out.println(rw.reverseWords("   this     is  a  test "));		
}
}

