import java.util.*;
import java.io.*;
public class EqualAvg{

	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> respos = new ArrayList<ArrayList<Integer>>();

	public float findAvg(ArrayList<Integer> list){
		
		int n = list.size();
		
		if(n==0){
			return 0;
		}

		int sum = 0;
		float avg = 0;

		for(int i=0;i<n; i++){
			sum+=list.get(i);		
		}
			
		avg = ((float)sum)/n;
		return avg;				
	}

	public float findQuickAvg(int sum, int n){
		
		if(n==0){
			return 0;
		}
	
		return ((float)sum)/n;	
	}

	public boolean isEvenSum(ArrayList<Integer> list){
		
		int n = list.size();
		
		if(n==0){
			return true;
		}

		int sum = 0;

		for(int i=0;i<n; i++){
			sum+=list.get(i);		
		}
			
		if(sum % 2 == 0){
			return true;
		}

		return false;				
	}

	public void recur(ArrayList<Integer> a, int numele, int start, int end, float avg, ArrayList<Integer> temp, ArrayList<Integer> temppos, int tempsum){

		//float curavg = findAvg(temp);
		float curavg = findQuickAvg(tempsum, temp.size());
		if(numele==0 && curavg == avg){
			//System.out.println("curavg=" + curavg + "avg = " + avg);
			if(!res.contains(temp) && temp.size() != a.size()){
				res.add(new ArrayList(temp));
				respos.add(new ArrayList(temppos));
			}
			return;
		}

		else if(numele==0 || curavg > avg){
			return;
		}	

		for(int j=start; j<end; j++){
			temp.add(a.get(j));
			temppos.add(j);		
			recur(a, numele-1, j+1, end, avg, temp, temppos, tempsum+a.get(j));
			temp.remove(temp.size()-1);
			temppos.remove(temppos.size()-1);
		}	

	}	

	public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> a) {
		int n = a.size();
		if(n == 0){
			return res;
		}  
		
		if(!isEvenSum(a)){
			return res;
		}	

		float avg = findAvg(a);		
		Collections.sort(a);

		for(int i=1; i<=n; i++){	
			recur(a, i, 0, n, avg, new ArrayList<Integer>(), new ArrayList<Integer>(), 0);	
			//System.out.println("Res after i="+ i + res + " respos = " + respos);	
			if(!res.isEmpty()){
				break;
			}
		}

		if(!res.isEmpty()){

			ArrayList<Integer> firstlist = new ArrayList(res.get(0));
			ArrayList<Integer> remainlist = new ArrayList<Integer>();
			for(int i=0; i<n; i++){
				if(!respos.get(0).contains(i)){
					remainlist.add(a.get(i));
				}	
			}

			res.clear();
			res.add(firstlist);
			res.add(remainlist);
			return res;			
		}		

		return res;	
	}	

	public static void main(String args[])throws Exception{
		EqualAvg eq = new EqualAvg();
		//ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,7,15,29,11,9));
		
		//ArrayList<Integer> a = new ArrayList<>(Arrays.asList(13, 30, 9, 13, 17, 42, 28, 20, 9, 24, 14, 20, 1, 28, 24, 26, 45, 27, 34, 38, 48, 38, 7, 34));
		
		//ArrayList<Integer> a = new ArrayList<>(Arrays.asList(28, 14, 34, 18, 20, 34, 17, 24, 7, 22, 17, 49, 49, 20, 46, 22, 18, 46, 45, 39, 50, 40, 17, 48, 23));

		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(47, 14, 30, 19, 30, 4, 32, 32, 15, 2, 6, 24));
		
		System.out.println(eq.avgset(a));				
	}}
