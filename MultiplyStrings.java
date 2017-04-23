public class MultiplyStrings {
	public String multiply(String a, String b) {
	
	    int res[] = new int[a.length() + b.length()];
	    for(int i=a.length() + b.length()-1; i>=0; i--){
	        res[i]=0;
	     }
	    
	    String first=a, second=b;
	    if(a.length() < b.length()){
	        first=b;
	        second=a;
	    }
	    
	    int count=0;
	    for(int i=second.length()-1; i>=0; i--){
	        
	        int seci = Character.getNumericValue(second.charAt(i));
	   
	        //temporary array to store intermediate multiplication results     
	        int tempresult[] = new int[first.length()+1];
	        for(int ii=first.length(); ii>=0; ii--){
	            tempresult[ii]=0;
	         }
	   
	        int temppos=0, carry=0;
	        for(int j=first.length()-1; j>=0; j--){
	            int firi = Character.getNumericValue(first.charAt(j));
	            int product =  seci*firi;
	            product+=carry;
	            tempresult[temppos++] = product%10;
	            carry = product/10;
	        }
	        
	        if(carry != 0){
	            tempresult[temppos]= carry;
	        }
	        
	        int k=0, addcarry=0, z=0;
	        for(z=count; k<first.length()+1; k++){
	            int sum = res[z] + tempresult[k] + addcarry;
	            res[z] = sum % 10;
	            addcarry = sum/10;
	            z++;
	        }
	        
	        if(addcarry != 0){
	            res[z]+=addcarry;
	        }
	        
	        ++count;
	    }
	   
	    
	    
	    //Section to print output
	    StringBuilder sb=new StringBuilder();
	    int firstbitset=0;
	    for(int i=a.length() + b.length()-1; i>=0; i--){
	 	
       
	        if(i==0 && firstbitset==0){
	            sb.append(res[i]);
	            continue;
	        }
	        
	        if(res[i] == 0){
		    if(firstbitset == 0){
	            	continue;
	        	}
		    else{
			sb.append(res[i]);
			continue;
		    }
		}
	        
	        if(res[i] != 0){
	            firstbitset = 1;
	            sb.append(res[i]);
	        }
	        
	        
	    }
	  
	    return sb.toString();
	}

public static void main(String args[])throws Exception{

MultiplyStrings ms = new MultiplyStrings();
System.out.println(ms.multiply("99999", "99999"));

}}
