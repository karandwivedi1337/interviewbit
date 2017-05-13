import java.util.*;
public class ArrDuplicates{

	public int removeDuplicates(ArrayList<Integer> a) {
		int uniquepos = 0;
		for(int i=0; i<a.size(); i++){
			int ai = a.get(i);
			int j = i+1;

			while(j<a.size() && a.get(j) == ai){
				j++;
			}
			
			System.out.println("j="+j);
			if(j == i+1){
				a.set(uniquepos, ai);
			}
			else{
				i = j-1;
				a.set(uniquepos,ai);
			}
			uniquepos++;	
		}
		a.subList(uniquepos, a.size()).clear();
		System.out.println(a);
		return a.size();				   
	}	

	public static void main(String args[])throws Exception{
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5000);
		list.add(5000);
		list.add(5000);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(5);
		ArrDuplicates ad = new ArrDuplicates();
		System.out.println(ad.removeDuplicates(list));
	}}
