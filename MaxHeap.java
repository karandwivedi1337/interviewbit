import java.util.*;
import java.io.*;
public class MaxHeap{

	int capacity=10;
	int pos=1;
	int arr[];

	MaxHeap(){
		arr = new int[capacity];
	}
	
	public void printArr(int arr[]){
		
		for(int i=1; i<pos; i++){
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	public void insert(int ele){
		
		if(pos == capacity){
			//expand array and copy elements
		}		

		arr[pos] = ele;

		//percolate upwards	
		int temppos = pos;
		while(temppos/2 >=1){

			if(arr[temppos/2] < ele){
				arr[temppos] = arr[temppos/2];
				temppos/=2;
			}

			else{
				break;
			}
		}

		arr[temppos] = ele; 	
		pos++;	
		
		printArr(arr);
	}

	public boolean isEmpty(){
		if(pos == 1){
			return true;
		}

		return false;
	}

	public int getMax(){

		if(isEmpty()){
			return Integer.MIN_VALUE;
		}

		int maxele = arr[1];
		int lastele = arr[pos-1];
		arr[1] = lastele;
		--pos;
		
		//percolate down the first element
		int temppos = 1;
		while(temppos*2<=pos && temppos<capacity){
			int childindex = temppos*2;
			
			if(childindex <= temppos*2+1 && arr[childindex+1] > arr[childindex]){
				childindex += 1;
			}
		
			if(arr[childindex] > lastele){
				arr[temppos] = arr[childindex];
				temppos=childindex;
			}
			else{
				break;
			}
		}

		arr[temppos]=lastele;	
		
		return maxele;	
	}	

	public static void main(String args[])throws Exception{
		MaxHeap mh = new MaxHeap();
		mh.insert(6);
		mh.insert(12);
		mh.insert(5);
		mh.insert(10);
		mh.insert(1);
		for(int i=0; i<4; i++){
			System.out.println("Max=" + mh.getMax());
			mh.printArr(mh.arr);
		}
		System.out.println();
	}}
