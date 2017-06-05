public class Solution {

    	public int jump(ArrayList<Integer> a) {

		int n = a.size();
		int jumparr[] = new int[n];
		jumparr[n-1] = 0;		

		//System.out.println("n=" + n);
		for(int j=n-2; j>=0; j--){
			//populate the jumparr
			
			int jele = a.get(j);
			if(jele == 0){
				jumparr[j] = n;
				continue;
			}

			//direct jump is possible from index j to n-1
			if(jele+j+1 >= n){
				jumparr[j] = 1;
				continue;
			} 			

			int start = Math.min(jele, n-j-1);
			int end = 1;
			int min = n;
			
			//System.out.println("j=" + j + " start=" + start + " end=" + end + " k+j=" + (start+j)); 
			
			for(int k=start; k>=end; k--){
				//if(j==0)
				//System.out.println("k="+ k + " k+j=" + (k+j) + " jumparr[k+j]=" + jumparr[k+j] + " min=" + min);
				if(k+jumparr[k+j] < min){
						min = 1+jumparr[k+j];
					}
				
				}
			//System.out.println("min=" + min);
			jumparr[j] = min;			
		}
					
		//printArr(jumparr);
		if(jumparr[0] >=1 && jumparr[0] <=n-1){
			return jumparr[0];
		}		

		return -1;
	}

    
}
