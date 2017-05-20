import java.util.*;
import java.io.*;
public class Permutations{

	public void recur(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> a, ArrayList<Integer> temp){

		if(a.size() == 0){
			res.add(new ArrayList<Integer>(temp));
		}		

		for(int i=0; i<a.size(); i++){
			temp.add(a.get(i));
			ArrayList<Integer> acopy = new ArrayList(a);
			acopy.remove(i);
			//System.out.println("recur called with res=" + res + " temp=" + temp + " acopy=" + acopy);
			recur(res, acopy, temp);
			temp.remove(temp.size() - 1);		
		}
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		recur(res, a, new ArrayList<Integer>());
		return res;				

	}

	public static void main(String args[])throws Exception{
		Permutations p = new Permutations();	
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));		
		System.out.println(p.permute(list));
	}}
