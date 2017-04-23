public class JustifyText {
	public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
	    
	    int L = b;
	    
	    ArrayList<Integer> strlenlist = new ArrayList<Integer>();
	    
	    for(int i=0; i<a.size(); i++){
	        strlenlist.add(a.get(i).length());
	    }
	    
	    ArrayList<String> justified = new ArrayList<String>();
	    
	    int cumsum = 0, currentstart=0;
	    for(int i=0; i<strlenlist.size(); i++){
	        
	        if(cumsum + strlenlist.get(i) > L){
	                
	                int currentend = i-1;
	                int numspaces = i - currentstart;
	                int numchars = L - cumsum - numspaces;
	                
	                int spaceperslot = (L - numchars)/numspaces;
	                int extraspace = (L-numchars)%numspaces;
	                String strspace = "";
	       
	                for(int k=0;k<spaceperslot; k++){
	                    strspace+=" ";    
	                }
	                
	                String strextraspace = strspace; 
	                for(int k=0;k<extraspace; k++){
	                    strextraspace+=" ";    
	                }
	               
	                StringBuilder sb = new StringBuilder();                
	                for(int j=currentstart; j<=currentend; j++){
	                    sb.append(a.get(j));
	                    
	                    if(j==currentstart){
	                        sb.append(strextraspace);
	                        continue;
	                    }
	                    
	                    if(j != currentend){
	                        sb.append(strspace);
	                    }
	                }
	                
	                justified.add(sb.toString());
	                
	                currentstart = i;
	                cumsum = 0;
                    --i;
                    continue;
	        }
	        
	        else if(cumsum + strlenlist.get(i) == L){
	           
	           int currentend = i;
	           int numspaces = i - currentstart;
	           int numchars = L - cumsum - numspaces - strlenlist.get(i);
	                
	           int spaceperslot = (L - numchars)/numspaces;
	           int extraspace = (L-numchars)%numspaces;
	           
	           String strspace = "";
	       
	           for(int k=0;k<spaceperslot; k++){
	                strspace+=" ";    
	            }
	                
	           String strextraspace = strspace; 
	           for(int k=0;k<extraspace; k++){
	                strextraspace+=" ";    
	           }
	       
	           StringBuilder sb = new StringBuilder();                
	           for(int j=currentstart; j<=currentend; j++){
	               sb.append(a.get(j));
	                    
	               if(j==currentstart){
	                    sb.append(strextraspace);
	                    continue;
	                }
	                
	               if(j != currentend){        
	                    sb.append(strspace);
	                }
	           }
	                
	                justified.add(sb.toString());
	                
	            currentstart = i+1;
	            cumsum = 0;
	            continue;
	        }
	        
	        else{
	            cumsum += strlenlist.get(i)+1;
	        }
	     
	    }
	    
	    //check if cumsum !=0 for last string to be appended
	    
	    if(cumsum != 0){
	        int currentend = strlenlist.size()-1;
	        int numspaces = currentend - currentstart;
	        int numchars = L - cumsum - numspaces - 1;
	        
	        if(numspaces == 0){
	            StringBuilder sb=new StringBuilder();
	            sb.append(a.get(strlenlist.size()-1));
	            
	            String strspace = "";
	       
	            for(int k=0;k<(L - strlenlist.size()-1); k++){
	                strspace+=" ";    
	            }
                
                sb.append(strspace);
                justified.add(sb.toString());
	        }   
	        
	        else{
	        int spaceperslot = (L - numchars)/numspaces;
	        int extraspace = (L-numchars)%numspaces;
	                
	        String strspace = "";
	       
	        for(int k=0;k<spaceperslot; k++){
	            strspace+=" ";    
	        }
	                
	        String strextraspace = strspace; 
	        for(int k=0;k<extraspace; k++){
	            strextraspace+=" ";    
	        }
	        
	         StringBuilder sb = new StringBuilder();                
	         for(int j=currentstart; j<=currentend; j++){
	            sb.append(a.get(j));
	                    
	            if(j==currentstart){
	               sb.append(strextraspace);
	               continue;
	             }
	                
	             if(j != currentend){        
	               sb.append(strspace);
	             }
	           }
	                
	           justified.add(sb.toString());
	        }   
	    }
	    
	    return justified;
	}
}


