import java.util.*;
import java.io.*;
public class CombinationSum{


	public boolean isValid(ArrayList<Integer> list){

		if(list.size() < 2){
			return true;
		}

		for(int i=1; i<list.size(); i++){
			if(list.get(i) < list.get(i-1)){
				return false;
			}		
		}

		return true;

	}

	public void recur(ArrayList<Integer> a, int b, int left, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
		
		if(left == 0){
			if(!res.contains(temp) && isValid(temp)){
				res.add(new ArrayList(temp));
			}
		}

		else if(left < 0){
			return;
		}	

		for(int i=0; i<a.size(); i++){
			temp.add(a.get(i));		
			recur(a, b, left-a.get(i), temp, res);
			temp.remove(temp.size()-1);
		}
			        
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		recur(a, b, b, new ArrayList<Integer>(), res);
		return res;
	}

	public static void main(String args[])throws Exception{
		CombinationSum cs = new CombinationSum();
		int sum = 7;
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,2,3,5));	
		ArrayList<ArrayList<Integer>> res = cs.combinationSum(list, sum);
		System.out.println(res);
	}}
