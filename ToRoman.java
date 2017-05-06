import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class ToRoman {
	
	HashMap<Integer, String> hmap;
	int numList[] = {1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100,200,300,400,500,600,700,800,900,1000,2000,3000};
	
	void createMap(){
	    
	    hmap = new HashMap<Integer, String>();   
	    hmap.put(1, "I");
	    hmap.put(2, "II");
	    hmap.put(3, "III");
	    hmap.put(4, "IV");
	    hmap.put(5, "V");
	    hmap.put(6, "VI");
	    hmap.put(7, "VII");
	    hmap.put(8, "VIII");
	    hmap.put(9, "IX");
	    hmap.put(10, "X");
	    hmap.put(20, "XX");
	    hmap.put(30, "XXX");
	    hmap.put(40, "XL");
	    hmap.put(50, "L");
	    hmap.put(60, "LX");
	    hmap.put(70, "LXX");
	    hmap.put(80, "LXXX");
	    hmap.put(90, "XC");
	    hmap.put(100, "C");
	    hmap.put(200, "CC");
	    hmap.put(300, "CCC");
	    hmap.put(400, "CD");
	    hmap.put(500, "D");
	    hmap.put(600, "DC");
	    hmap.put(700, "DCC");
	    hmap.put(800, "DCCC");
	    hmap.put(900, "CM");
	    hmap.put(1000, "M");
	    hmap.put(2000, "MM");
	    hmap.put(3000, "MMM");
	}
	
	public String intToRoman(int a) {
	 	
	   createMap(); 	   
    
	   StringBuffer roman = new StringBuffer();
	   
	   int n = a;
	   
	   while(n > 0){
	   
	       int i=0, pos=0;
	   
	       for(i=0; i<numList.length; i++){
	               
	               if(n >= numList[i]){
	                   continue;
	               }
			
			break;
	        }
	        
	        pos = i;

	        --pos;

		if(pos < 0){
			pos=0;
		}
	  		
	        roman.append((String)hmap.get(numList[pos]));
	       
	        n-=numList[pos];
	       
	   }    
	   
	    return roman.toString();
	    
	}

public static void main(String args[])throws Exception{

	ToRoman tr = new ToRoman();
	System.out.println(tr.intToRoman(11));	

}
}

