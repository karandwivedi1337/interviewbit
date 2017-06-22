import java.util.*;
public class LargeHist{

	public int largestRectangleArea(ArrayList<Integer> a) {

		int maxarea = 0;
		java.util.Stack<Integer> st = new java.util.Stack();
		int i=0;
		int area = 0;
		for(i=0; i<a.size();){

			if(st.isEmpty() || a.get(st.peek()) <= a.get(i)){
				System.out.println("pushing "+i);
				st.push(i++);
			}

			else{
				int top = st.pop();
				if(st.isEmpty()){
					area = a.get(top) * i;					     }
				else{
					area = a.get(top) * (i-st.peek()-1);
				}	

				maxarea = Math.max(maxarea, area);
			}

		}//for close	


		System.out.println("exiting loop");
		while(!st.isEmpty()){

			int top = st.pop();
			if(st.isEmpty()){
				area = a.get(top) * i;					     }
			else{
				area = a.get(top) * (i-st.peek()-1);
			}	

			maxarea = Math.max(maxarea, area);
		}

		return maxarea;		
	}

	public static void main(String args[])throws Exception{
		LargeHist lh = new LargeHist();
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,1,5,6,2,3));	
		System.out.println(lh.largestRectangleArea(list));
	}}
