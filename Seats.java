import java.util.*;
import java.io.*;
public class Seats{

	public int findMedian(String a){
		int medianpos = 0;
		for(int i=0; i<a.length(); i++){
			if(a.charAt(i) == 'x'){
				medianpos++;
			}			
		}

		int medianval = -1;
		if(medianpos == 0){
			return -1;
		}

		medianpos = (medianpos + 1)/2; 	
		
		int mediancounter = 0;
		for(int i=0; i<a.length(); i++){

			if(a.charAt(i) == 'x'){
				mediancounter++;
				if(mediancounter == medianpos){						medianval = i;	
					 break;
				}
			}	

		}

		return medianval;

	}

	public int shiftElements(char[] a, int medianpos){
		
		int j=0;
		int k=medianpos;
		int count=0;

		while(j<k){

			if(a[j] == '.'){
				j++;
			}

			else if(a[k] == 'x'){
				k--;
			}
			else{
				a[k] = a[j];
				a[j] = '.';
				count = (count + (k-j))%10000003;
				j++;
				k--;
			}
		}

		k = a.length-1;
		j = medianpos;	
		
		while(k > j){
			if(a[j] == 'x'){
				j++;
			}
			else if(a[k] == '.'){
				k--;
			}
			else{
				a[j] = a[k];
				a[k] = '.';
				count = (count + (k-j))%10000003;
				j++;
				k--;
			}	
		}
		
		return count%10000003;
	}

	public int seats(String a) {
	
		int medianpos = findMedian(a);
		
		if(medianpos == -1){
			return 0;
		}		

		return shiftElements(a.toCharArray(), medianpos);
	
	}

	public static void main(String args[])throws Exception{
		String a = "....x..xx...x..";
		Seats s = new Seats();
		System.out.println(s.seats(a));
	}}
