public class StrStr{
	public int strStr(final String haystack, final String needle) {

		if(haystack.length() == 0 || needle.length() ==0){
			return -1;
		}	
		int i=0, j=0;
		for(i=0; i<haystack.length() - needle.length() + 1; i++){
			for(j=0; j<needle.length(); j++){
				if(haystack.charAt(i+j) == needle.charAt(j)){
					continue;
				}
				break; 
			}
			if(j == needle.length()){
				return i+1;
			}
		}

		return -1;
	}

	public static void main(String args[])throws Exception{

		StrStr s = new StrStr();
		System.out.println(s.strStr("this is a haystack", " ha"));
	}}
