import java.util.*;
import java.io.*;
public class MergeSort{	

	public void printArr(int arr[]){
			
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}

	public void merge(int[] arr, int low1, int high1, int low2, int high2){
		int temp[] = new int[(high1-low1) + (high2-low2)+2];							
		int start1= low1;
		int start2= low2;	
		int pos = 0;

		while(start1<=high1 && start2<=high2){

			if(arr[start1] < arr[start2]){
				temp[pos++] = arr[start1++];
			}		
			
			else{
				temp[pos++] = arr[start2++];
			}
		}	

		while(start1<=high1){
			temp[pos++] = arr[start1++];
		}					

		while(start2<=high2){
			temp[pos++] = arr[start2++];
		}		

		//printArr(temp);
		int temppos = 0;
		for(int i=low1; i<=high2; i++){
			arr[i] = temp[temppos++];
		}
	}

	public void partition(int[] arr, int low, int high){
		
		System.out.println("partition called with low=" + low +  " high=" + high);

		int n = arr.length;

		if(low < high){	
		
			int mid = (low + high)/2;
			partition(arr, low, mid);
			partition(arr, mid+1, high);
			System.out.println("merge low=" + low + " high=" + high);
			merge(arr, low, mid, mid+1, high);			
		}	
	}		

	public static void main(String args[])throws Exception{
		int arr[] = new int[]{38, 27, 43, 3, 9, 82, 10};
		MergeSort ms = new MergeSort();
		ms.partition(arr, 0, arr.length-1);
		ms.printArr(arr);
	}}
