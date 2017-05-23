import java.util.*;
import java.io.*;
public class SubstrConcat{

	int calcHash(String s){

		int value = 0;

		for(int i=0; i<s.length(); i++){
			value = (value*31 + (int)s.charAt(i))%Integer.MAX_VALUE; 
		}

		return value;
	}

	void printHashMap(HashMap<String, Integer> hmap){

		for(String key: hmap.keySet()){
			System.out.println("key="+key+" value=" + hmap.get(key));
		}
	}

	boolean allStringsUsed(ArrayList<String> templist, ArrayList<String> b){
		
		if(templist.size() != b.size()){
			return false;
		}

		Collections.sort(templist);
		Collections.sort(b);
		
		for(int i=0; i<templist.size(); i++){
			if(!templist.get(i).equals(b.get(i))){
				return false;
			}
		}
			
		return true;	
			
	}

	public ArrayList<Integer> findSubstring(String a, final List<String> b) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		int wordlen = 0;
		if(b.size() > 0){
			wordlen = b.get(0).length();		
		}
		else{
			return res; 
		}

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();

		for(int i=0; i<b.size(); i++){
			int hashvalue = calcHash(b.get(i));
			hmap.put(b.get(i), hashvalue);			
		}	

		//printHashMap(hmap);		
		int firstmatch = 0;
		int counter = 0;
		ArrayList<String> tempStr = new ArrayList<String>();
		
		for(int i=0; i<a.length(); i++){
			firstmatch = 0;
			counter = 0;
			tempStr.clear();
			for(int j=i; j<a.length()-wordlen+1; j+=wordlen){
				String substr = a.substring(j, j+wordlen);
				if(hmap.containsKey(substr)){
					if(firstmatch == 0){
						firstmatch = 1;
						counter++;
						//System.out.print("Matched " + substr);
						tempStr.add(substr);	
					}
					else if(firstmatch == 1){
						counter++;	
						//System.out.print("Matched " + substr);
						tempStr.add(substr);
					}

					if(counter == b.size() && allStringsUsed(new ArrayList(tempStr), new ArrayList(b))){
						//System.out.println("Index i=" + i + " matched");
						res.add(i);
					}	
				}
				else{
					break;
				}
			}	
		}

		return res;

	}

public static void main(String args[])throws Exception{
	SubstrConcat sc = new SubstrConcat();
	String a = "barfoothefoobarman";
	List<String> list = new ArrayList<String>();
	list.add("foo");
	list.add("bar");
	System.out.println(sc.findSubstring(a, list));
}}
