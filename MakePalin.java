import java.util.*;
public class MakePalin{

 public boolean isPalin(String str){

	String revstr = new StringBuffer(str).reverse().toString();
	  if(revstr.equals(str)){
		return true;
	  }
	 return false;
 }


 public int solve(String A) {
 
	if(isPalin(A)){
		return 0;
	}	

	String revA = new StringBuffer(A).reverse().toString();

	//String revA=A;
	String combined = revA+A;

	for(int i=0; i<revA.length(); i++){
		String prefix = revA.substring(0, i+1);
		System.out.println("prefix="+prefix);
		String newstr = prefix + A;
		
		System.out.println("newstr="+newstr);
		if(isPalin(newstr)){
			System.out.println("palinstr="+newstr);
			int len = newstr.length() - A.length();
			return len;
		}
	}
	
	return A.length();
 }

public static void main(String args[])throws Exception{

MakePalin mp = new MakePalin();
System.out.println(mp.solve("AAbAAA"));
}} 
