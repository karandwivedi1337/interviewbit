import java.util.*;
public class ArrayIntersect{

	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
		
		List<Integer> longlist=a;		
		List<Integer> shortlist=b;
	
		if(a.size() < b.size()){
			longlist = b;
			shortlist = a;
		}	

		ArrayList<Integer> res = new ArrayList<Integer>();

		int i=0, j=0;
		while(i<a.size() & j<b.size()){
		
			int ai = a.get(i);
			int bj = b.get(j);

			if(ai == bj){
				res.add(ai);
				i++;
				j++;
			}

			else if(ai < bj){
				i++;
			}
			else{
				j++;
			}
		}		

		return res;	
	}

public static void main(String args[])throws Exception{
ArrayList<Integer> a=new ArrayList<Integer>();
ArrayList<Integer> b=new ArrayList<Integer>();
a.add(1);
a.add(2);
a.add(3);
a.add(3);
a.add(4);
a.add(5);
a.add(6);

b.add(3);
b.add(3);
b.add(5);
ArrayIntersect ai=new ArrayIntersect();
System.out.println(ai.intersect(a,b));
}}
