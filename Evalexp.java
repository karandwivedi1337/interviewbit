import java.util.*;
public class Evalexp{


	public int evalRPN(ArrayList<String> a) {
		java.util.Stack st = new java.util.Stack();
		
		for(int i=0; i<a.size(); i++){
			String si = a.get(i);
			if(si.equals("+")){
				int n1 = (Integer)st.pop();
				int n2 = (Integer)st.pop();
				int res = n2 + n1;
				st.push(res);	
			}

			else if(si.equals("-")){
				int n1 = (Integer)st.pop();
				int n2 = (Integer)st.pop();
				int res = n2 - n1;
				st.push(res);	
			}
		

			else if(si.equals("*")){
				int n1 = (Integer)st.pop();
				int n2 = (Integer)st.pop();
				int res = n1 * n2;
				st.push(res);	
			}

	
			else if(si.equals("/")){
				int n1 = (Integer)st.pop();
				int n2 = (Integer)st.pop();
				int res = n2 / n1;
				st.push(res);	
			}
			
			else{
				st.push(Integer.parseInt(si));	
			}			

		}
	
		return (Integer)st.pop();
	}

	public static void main(String args[])throws Exception{
		Evalexp ee = new Evalexp();
		ArrayList<String> list = new ArrayList<>(Arrays.asList("-1"));
		System.out.println(ee.evalRPN(list));	
	}}
