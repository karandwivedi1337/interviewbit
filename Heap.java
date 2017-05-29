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

		//percolate upwards
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

	public int getMin(){

		if(pos == 2){
			return arr[--pos];
		}

		int min = arr[1];
		arr[1] =  arr[pos-1];
		arr[pos-1] = min;

		--pos; 	

		//percolate down
		int temppos = 1;
		while((temppos*2 < pos) && (temppos < capacity)){			

			//has both left and right child
			if(temppos*2 + 1 < pos){
				//left child is smaller than right and left child is < parent
				if((arr[temppos*2] < arr[temppos*2+1]) && (arr[temppos*2] < arr[temppos])){
					int temp = arr[temppos*2];
					arr[temppos*2] = arr[temppos];
					arr[temppos] = temp;
					temppos*=2;

				}	
				//right child is smaller than left and right child is < parent
				else if((arr[temppos*2+1] < arr[temppos*2]) && (arr[temppos*2+1] < arr[temppos])){
					int temp = arr[temppos*2+1];
					arr[temppos*2+1] = arr[temppos];
					arr[temppos] = temp;
					temppos=temppos*2+1;

				}
			}

			//has only left child
			else if(arr[temppos*2] < arr[temppos]){
				int temp = arr[temppos*2];
				arr[temppos*2] = arr[temppos];
				arr[temppos] = temp;
				temppos*=2;
			}

			else{
				break;
			}
		}	

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

		h.printHeap();
		for(int i=1; i<=9; i++){
			System.out.println("min=" + h.getMin() + " ");
			System.out.println("After deletion");
			h.printHeap();
		}
		/*		
				h.insertHeap(6);	
				h.insertHeap(12);
				h.insertHeap(5);
				h.insertHeap(10);
				h.insertHeap(1);
		 */
	}}
