import java.util.*;
import java.io.*;
public class Subsets{

	public void subsets(ArrayList<Integer> first, ArrayList<Integer> second){

		System.out.println(first);
		
		for(int i=0; i<second.size(); i++){
			int ele = second.get(i);
			first.add(ele);
			second.remove(i);
			subsets(first, second);
			second.add(i, ele);
			first.remove(first.size()-1);
		}			

	}

	public static void main(String args[])throws Exception{
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		Subsets ss = new Subsets();
		ss.subsets(new ArrayList<Integer>(), list);
		System.out.println();
	}}
