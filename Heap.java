import java.util.*;
import java.io.*;
public class Heap{


	int arr[];	
	int capacity=10;	
	int pos = 1;
	Heap(){
		arr = new int[capacity];
	}

	public void insertHeap(int ele){		
	
		//TODO: expand heap size if pos == capacity
	
		arr[pos] = ele;
		
		int temppos = pos;	
		while((temppos/2 >= 1) && (temppos < capacity)){
			if(arr[temppos/2] > ele){
				arr[temppos] = arr[temppos/2];
				temppos/=2;	
			}
			else{
				break;
			}
		}			
		
		arr[temppos] = ele;
		pos++;
	}	

	public void printHeap(){
		for(int i=1; i<pos; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public int heapmin(){
		int min = arr[1];
		
			
	
		return min; 
	} 

	public boolean isEmpty(){
		if(pos <= 1){
			return true;
		}

		return false;
	}	

	public static void main(String args[])throws Exception{
		Heap h = new Heap();
		
		for(int i=8; i>=0; i--){
			h.insertHeap(i);
		}

		/*		
		h.insertHeap(6);	
		h.insertHeap(12);
		h.insertHeap(5);
		h.insertHeap(10);
		h.insertHeap(1);
		*/
		h.printHeap();
		//System.out.println();
	}}
