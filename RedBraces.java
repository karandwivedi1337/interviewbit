import java.util.*;
import java.io.*;
public class RedBraces{

	public int braces(String a){
		
		java.util.Stack bracest = new java.util.Stack();
	
		java.util.Stack opst = new java.util.Stack();

		for(int i=0; i<a.length(); i++){
			char c = a.charAt(i);
			if(c == ' '){
				continue;
			}
			
			else if(c=='('){
				bracest.push(c);
			}

			else if(c=='+' || c=='-' || c=='*' || c=='/'){
				if(!bracest.isEmpty()){
					opst.push(c);
				}
			}

			else if(c==')'){
				if(opst.isEmpty()){
					return 1;
				}	
				else{
					opst.pop();
					bracest.pop();
				}		
			}

		}

		return 0;

	}

	public static void main(String args[])throws Exception{
		RedBraces rb = new RedBraces();
		System.out.println(rb.braces("(a*b)+(b*(d+(a)))"));
	}}
