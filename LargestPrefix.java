public class LargestPrefix {
	
	public int findMinimumLength(ArrayList<String> list){
	    
	    int minlength= Integer.MAX_VALUE;
	    int minlengthIndex=-1;
	    for(int i=0; i<list.size(); i++){
	        if(list.get(i).length() < minlength){
	            minlength = list.get(i).length();
	            minlengthIndex=i;
	        }
	    }
	    
	    return minlengthIndex;
	}
	
	public boolean checkPrefixInAll(String prefix, ArrayList<String> list){
	   
	   for(int i=0; i<list.size(); i++){
	       
	       String currentStr = list.get(i);
	       
	       for(int j=0; j<prefix.length(); j++){
	           if(currentStr.charAt(j) != prefix.charAt(j)){
	               return false;
	           }
	           }
	       }
	       
	        return true;   
	   } 
	  
	public String longestCommonPrefix(ArrayList<String> a) {
	
	   String minString = a.get(findMinimumLength(a));
	   
	   int low = 0, high = minString.length()-1;
	   int mid = 0;
	   String prefix="";
	   
	   
	   while (low <= high){
	            mid = (low+high)/2;
	            
	            String midStr = minString.substring(low, mid+1);
	            if(checkPrefixInAll(prefix+midStr, a)){
	                low = mid + 1;
	                prefix+= midStr;
	            }
	            else{
	                high = mid - 1;
	            }
	            
	   }
	    
	    return prefix;
	}
}

