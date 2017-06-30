import java.util.*;
import java.io.*;
public class Buysell{

	public int maxProfit(final List<Integer> a) {

		if(a.size() == 0){
			return 0;
		}

		int glow = a.get(0), ghigh=glow, gprof = 0;
		int low = glow, high =  ghigh, prof = 0;
		for(int i=1; i<a.size(); i++){	
			int ival = a.get(i);
			if(ival < low){
				low = ival;
				high = ival;
				prof = 0;	
			}		

			if(ival > high){
				high = ival;
				prof = high - low;
			}	
	
			
			if(prof > gprof){
				gprof = prof;
				glow = low;
				ghigh = high;	
			}
		}
		
		return gprof;
	}

	public static void main(String args[])throws Exception{
		Buysell bs = new Buysell();
		//List<Integer> a = new ArrayList<>(Arrays.asList(1,2));
		
		//List<Integer> a = new ArrayList<>(Arrays.asList(100, 10, 5, 1, 2, 9, 12i0));
	
	
		List<Integer> a = new ArrayList<>(Arrays.asList(5,1,10,7,9));
		System.out.println(bs.maxProfit(a));
	}}
