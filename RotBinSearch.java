import java.util.*;
import java.io.*;
public class RotBinSearch{


	public int binsearch(int arr[], int ele){

		int start = 0;
		int end = arr.length-1;

		while(start <= end){
			
			int mid = (start + end)/2;

			if(arr[mid] == ele){
				return mid;
			}


			//non-rotated right half
			else if(arr[mid] <= arr[end]){
				if(arr[mid] < ele && arr[end] >= ele){
					start = mid+1;
					continue;
				}
				else{
					
					end = mid - 1;
					continue;
				}
			}
			//non-rotated left half
			else if(arr[start] <= arr[mid]){

				if(arr[start] <= ele && arr[mid] >= ele){
					end = mid -1;
					continue;
				}
				else{
					
					start = mid + 1;
				}

			}		

		}
	
		return -1;
	}

	public static void main(String args[])throws Exception{
		RotBinSearch rbs = new RotBinSearch();
		int arr[] = new int[]{7,8,9,1,2,3,4,5,6};	
		for(int i=0; i<arr.length; i++){
			System.out.println(rbs.binsearch(arr, arr[i]));
		}
	}}
