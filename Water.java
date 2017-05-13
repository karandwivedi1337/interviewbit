import java.util.*;
public class Water{

	public int maxArea(ArrayList<Integer> a) {
	
		int start=0;
		int end = a.size()-1;
		int maxarea = 0;
		
		while(start < end){
			
			int minh = Math.min(a.get(start), a.get(end));
		       	int base = end-start;
			int area = minh*base;
			if(area > maxarea){
				maxarea = area;
			}
			
			if(a.get(start) < a.get(end)){	
				start++;
			}
			else{
				end--;
			}
	
		}

		return maxarea;
	}

	public static void main(String args[])throws Exception{
		Water w = new Water();
		ArrayList<Integer> a=new ArrayList<Integer>();

		a.add(1);
		a.add(5);
		a.add(4);
		a.add(3);
		System.out.println(w.maxArea(a));
	}}
