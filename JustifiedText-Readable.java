//Readable solution to JustifiedText problem
public class JustifiedText {
	public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
	
    ArrayList<String> justified = new ArrayList<String>();
	ArrayList<String> temp = new ArrayList<String>();
	String str;
	int L = b;
	
	int len = 0;
	for(int i=0; i<a.size(); i++){
	    
	    if(len + temp.size() + a.get(i).length() <= L){
	        temp.add(a.get(i));
	        len += a.get(i).length();
	    }
	    
	    else{
	        
	        if(temp.size() == 1){
	            str = temp.get(0);
	            int numspaces = L - temp.get(0).length();
	            
	            for(int j=0; j<numspaces; j++){
	                str+=" ";
	            }
	            
	            justified.add(str);
	        }//if temp.size() == 1 close
	        
	        else if(temp.size() > 1){
	            
	            int div = (L - len)/(temp.size() - 1);
	            int mod = (L - len)%(temp.size() - 1);
	            str = temp.get(0);
	            
	            for(int k=1; k<temp.size(); k++){
	                if(k<=mod){
	                    //add div+1 spaces
	                    for(int s=0; s<div+1; s++){
	                        str += " ";
	                    }
	                }
	                else{
	                    //add div spaces
	                    for(int s=0; s<div+1; s++){
	                        str += " ";
	                    }
	                }
	                
	                str += temp.get(k);
	            }
	            
	            justified.add(str);
	        }
	        
	        temp.clear();
	        len = a.get(i).length();
	        temp.add(a.get(i));
	    }
	    
	}
	
	//process last line
	str = temp.get(0);
	
	for(int i=1; i<temp.size(); i++){
	    str += " " + temp.get(i);
	}
	//add L - len spaces
	int numspaces = L - str.length();
	for(int s=0; s<numspaces; s++){
	   str += " ";
	}
	
	justified.add(str);
	
	return justified;
	
}
}
