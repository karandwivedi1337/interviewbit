import java.util.*;
public class ArrayIntersect{

	int binsearch(List<Integer> list, int ele, int start, int end){
	
		while(start <= end){
			
			int mid = (start+end)/2;
			if(list.get(mid) == ele){
				return mid;
			}		
			
			else if(list.get(mid) < ele){
				start = mid +1;                       		}
			else{
				end = mid - 1;
			}
			
		}	
		return -1;		
	}

	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
		
		List<Integer> longlist=a;		
		List<Integer> shortlist=b;
	
		if(a.size() < b.size()){
			longlist = b;
			shortlist = a;
		}	

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		for(int i=0; i<shortlist.size(); i++){
			if(!res.contains(shortlist.get(i))){
				int pos = binsearch(longlist, shortlist.get(i), 0, longlist.size()-1);
				if(pos != -1){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(shortlist.get(i));
					temp.add(pos); 
					res.add(new ArrayList(temp));
				}
			}
			else{
				int modstart = res.get(res.size()-1).get(1);
				int pos = binsearch(longlist, shortlist.get(i), modstart, longlist.size()-1);			
				if(pos != -1){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(shortlist.get(i));
					temp.add(pos); 
					res.add(new ArrayList(temp));
				}
					        		
			}
		}

		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<res.size(); i++){
			result.add(res.get(i).get(0));
		}

		return result;	
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
