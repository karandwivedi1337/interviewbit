import java.util.*;
import java.io.*;
public class WindowString{

	public boolean hasSubstring(String S, String T){
		
		if(T.length () > S.length()){
			return false;
		}
		
		StringBuffer sb = new StringBuffer(T);
		
		for(int i=0; i<S.length(); i++){
		 	char c = S.charAt(i);
			int sbindex = sb.toString().indexOf(c);
			if(sbindex >= 0){
				sb.deleteCharAt(sbindex);
			}
		}

		if(sb.length() == 0){
			return true;
		}	
		
		return false;
	}

	public String minWindow(String S, String T) {
	
		if(T.length () > S.length()){
			return "";
		}

		int start = 0;
		int end = T.length()-1;
		int minstart = Integer.MAX_VALUE;
		int minlength = Integer.MAX_VALUE;
	
		while(start < S.length() && end < S.length()){
			//System.out.println("start=" + start + "end=" + end);				
			String substr = S.substring(start, end+1);
			if(hasSubstring(substr, T)){
				//System.out.println("Match at start=" + start + " end=" + end);
				int len = end - start + 1;
				if(len < minlength){
					minstart=start;
					minlength = len;
				}
				else if(len == minlength && start < minstart){
					minstart = start;
					minlength = len;
				}

				start++;
				continue;
			}
			else{
				end++;
			}
			 
		}

		//System.out.println("minstart=" + minstart + "  minlength=" + minlength);
		
		if(minstart == Integer.MAX_VALUE){
			return "";
		}	

		return S.substring(minstart, minstart+minlength);	
	}

	public static void main(String args[])throws Exception{
		WindowString ws = new WindowString();
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.println(ws.minWindow(S, T));
	}}
