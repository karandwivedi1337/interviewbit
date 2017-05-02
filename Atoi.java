public class Atoi{

	int findnonspaceindex(String a, int startindex){

		int ret = -1;

		for(int i=startindex; i<a.length(); i++){
			if(a.charAt(i) != ' '){
				return i;
			}
		}

		return ret;
	}

	int findspaceindex(String a, int startindex){

		int ret = -1;

		for(int i=startindex; i<a.length(); i++){
			if(a.charAt(i) == ' '){
				return i;
			}
		}

		return ret;
	}




	int validateNum(String a){

		for(int i=0; i<a.length(); i++){
			int num = (int)a.charAt(i)-48;

			//negative number is allowed
			if(i==0 && (a.charAt(i)=='-' | a.charAt(i)=='+')){
				continue;
			}

			if(num >=0 && num <=9){
				continue;
			}
			else{
				return i;
			}
		}

		return a.length();
	}

	int getsign(String possiblenum){

		int signval = possiblenum.charAt(0);

		if(signval == '-'){
			return -1;
		}		

		return 1;
	}

	int BoundsCheck(String a, int sign){

		//strip leading zeros
		int i=0;
		for(i=0; i<a.length(); i++){
			if(a.charAt(i) == '0'){
				continue;
			}
			else{
				break;
			}
		}	

		a = a.substring(i);	

		if(a.length() <= 9){
			return -1;
		}


		String int_min = "2147483648";
		String int_max = "2147483647";	

		//compare with INT_MIN
		if(sign == -1){

			if(a.length() > 10){
				return Integer.MIN_VALUE;
			}
			
			int aint = (int)a.charAt(i)-48;
			int intminint = (int)int_min.charAt(i)-48;
			//length is equal to 10, do char by char matching
		        for(i=0; i<10; i++){
				if(aint < intminint){
					return -1;
				} 
				else if(aint == intminint){
					continue;
				}
				else{
					return Integer.MIN_VALUE;
				}
			}				
			
			return Integer.MIN_VALUE;
		}

		//compare with INT_MAX or zero
		else{

			if(a.length() > 10){
				return Integer.MAX_VALUE;
			}
			
			//length is equal to 10, do char by char matching
		        for(i=0; i<10; i++){
				int aint = (int)a.charAt(i)-48;
				int intmaxint = (int)int_max.charAt(i)-48;
				if(aint < intmaxint){
					return -1;
				} 
				else if(aint == intmaxint){
					continue;
				}
				else{
					return Integer.MAX_VALUE;
				}
			}				
			
			return Integer.MAX_VALUE;
		          		
		}		


	}

	public int atoi(final String a) {

		int firstcharpos = findnonspaceindex(a, 0);

		//if a does not have any non space characters
		if(firstcharpos == -1){
			return 0;
		}

		int secondspacepos = findspaceindex(a, firstcharpos+1);

		//the number is between indexes firstcharpos and secondspacepos - 1	    

		if(secondspacepos == -1){
			secondspacepos = a.length();
		}		

		String possiblenum = a.substring(firstcharpos, secondspacepos);

		int validtillindex = validateNum(possiblenum);

		if(validtillindex == 0){
			return 0;
		}		

		possiblenum = possiblenum.substring(0, validtillindex);


		int sign = getsign(possiblenum);

		String numonlystr = possiblenum;

		if(sign == -1 | possiblenum.charAt(0)=='+'){
			numonlystr = possiblenum.substring(1);
		}	

		int res = BoundsCheck(numonlystr, sign);

		//if bounds check failed i.e. overflow detected, res is the return value
		if(res != -1){
			return res;
		}	

		//else calculate value as usual i.e. within integer's range
		int intval = 0;
		
		for(int i=0; i<numonlystr.length(); i++){
			int n = ((int)numonlystr.charAt(i))-48;
			intval = intval*10 + n;		
		}	
		
		return (sign)*intval;
	}


	public static void main(String args[])throws Exception{

		Atoi at = new Atoi();

		String a = "5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3  5 14703818 776366059B9O43393";
		System.out.println(at.atoi(a));

	}
}

