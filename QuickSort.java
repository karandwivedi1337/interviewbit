import java.util.*;
import java.io.*;
public class QuickSort{

	public void printArr(int arr[]){

		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	public void swap(int arr[], int first, int second){

		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

	public int partition(int arr[], int low, int high){	
		//38, 27, 43, 3, 9, 82, 10
		//3, 9, 10, 28, 27, 43, 82	
				
		int ele = arr[high];
	
		int startpos = low-1;

		for(int i=low; i<=high-1; i++){
	
			if(arr[i] <= ele){
				startpos++;
				swap(arr, i, startpos);
			}

		}		
	
		swap(arr, startpos+1, high);
		printArr(arr);
		return startpos+1;
	}

	public void quickSort(int arr[], int low, int high){

		System.out.println("quickSort called with low=" + low + " high=" + high);

		if(low < high){

			int pi = partition(arr, low, high);
			System.out.println("pi=" + pi);
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);

		}

	}

	public static void main(String args[])throws Exception{
		QuickSort qs = new QuickSort();
		int arr[] = new int[]{38, 27, 43, 3, 9, 82, 10};
		qs.quickSort(arr, 0, arr.length-1);
		qs.printArr(arr);
	}}
