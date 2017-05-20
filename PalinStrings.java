import java.util.*;
import java.io.*;
public class PalinStrings{

	boolean isPalin(String s){

		if(s.length() == 0){
			return false;
		}

		if(s.length() == 1){
			return true;
		}

		String rev = new StringBuffer(s).reverse().toString();
		if(rev.equals(s)){
			return true;
		}

		return false;	
	}

	void recur(String a, ArrayList<String> templist, ArrayList<ArrayList<String>> res){
		if(a.isEmpty()){
			res.add(new ArrayList<String>(templist));
		}

		for(int i=1; i<= a.length(); i++){
			if(isPalin(a.substring(0,i))){
				templist.add(a.substring(0,i));
				System.out.println("calling recur with a="+a+ " templist=" + templist + " res=" + res);
				recur(a.substring(i), templist, res);
				templist.remove(templist.size()-1);
			}
		}	
		
	}

	public ArrayList<ArrayList<String>> partition(String a){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		recur(a, new ArrayList<String>(), res);
		return res;	
	}

	public static void main(String args[])throws Exception{
		PalinStrings ps = new PalinStrings();
		String a = "aab";
		System.out.println(ps.partition(a));
	}}
