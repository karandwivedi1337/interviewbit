import java.util.*;
import java.io.*;
public class MajorityEle{

	public int majorityElement(final List<Integer> a) {
	
	    if(a.size() <= 2){
	        return a.get(0);
	    }
	    
	    int res = 0, count=0;

	    for(int i=0; i<a.size(); i++){
		if(count == 0){
			res = a.get(i);
			count = 1;
		}
		else if(res == a.get(i)){
			count++;
		}
		else{
			count--;
		}
	    }
	    
	    return res;
	    
	}	

	public static void main(String args[])throws Exception{
		MajorityEle me = new MajorityEle();
		List<Integer> list = Arrays.asList(1,2,2,2,1);
		System.out.println(me.majorityElement(list));	
	}}
