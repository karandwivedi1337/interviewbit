import java.util.*;
import java.io.*;
public class WordBreak{

	int state = 0;
	HashMap<String, String> hmap;

	public void recur(String a){

		System.out.println("recur called with a=" + a);

		if(a.equals("")){
			state = 1;
			return;
		}		

		if(a.length() > 0){
			for(int i=0; i<a.length(); i++){

				String substr = a.substring(0, i+1);
				System.out.println("substr=" + substr);
				if(hmap.containsKey(substr)){
					recur(a.substring(i+1));
				}
	
			}

		}

	}

	public int wordBreak(String a, ArrayList<String> b) {
		hmap = new HashMap<String, String>();
		
		for(int i=0; i<b.size(); i++){
			hmap.put(b.get(i), b.get(i));			}

		recur(a);						
		return state;
	}	

	public static void main(String args[])throws Exception{
		WordBreak wb = new WordBreak();	
		String a = "myinterviewtrainer";
		ArrayList<String> b = new ArrayList<>(Arrays.asList("interview", "my", "trainer"));	
		System.out.println(wb.wordBreak(a,b));
	}}
