import java.util.*;
import java.io.*;
public class MergeLists{

	public class Heap{


		int arr[];	
		int capacity=10;	
		int pos = 1;
		Heap(){
			arr = new int[capacity];
		}

		public void insertHeap(int ele){		

			//TODO: expand heap size if pos == capacity

			if(pos == capacity){
				int newcapacity = capacity*2;
				int newarr[] = new int[newcapacity];

				for(int i=1; i<pos; i++){
					newarr[i] = arr[i];
				}

				capacity = newcapacity;
				arr = newarr;
			}		

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

	}
	public int getLength(ListNode head){

		int count = 0;

		ListNode temp = head;

		while(temp != null){
			temp = temp.next;
			count++;
		}

		return count;
	}


	public ListNode addNode(ListNode head, int ele){

		if(head == null){
			ListNode newnode = new ListNode(ele);
			head = newnode;
			return head;
		}

		ListNode temp = head;

		while(temp.next != null){
			temp = temp.next;
		}

		ListNode newnode = new ListNode(ele);
		temp.next = newnode;

		return head;
	}

	public boolean isAllNulls(ArrayList<ListNode> a){
		
		for(int i=0; i<a.size(); i++){
			if(a.get(i) != null){
				return false;
			}
		}
		return true;
	}

	public ListNode mergeKLists(ArrayList<ListNode> a) {

		ListNode res = null;
		Heap h = new Heap();

		for(int i=0; i<a.size(); i++){
			if(a.get(i) != null){
				h.insertHeap(a.get(i).val);
			}
		}	
	
		while(!isAllNulls(a)){
					
			int min = h.getMin();			
			res = addNode(res, min);			
			for(int i=0; i<a.size(); i++){

				if(a.get(i) != null){
					int aval = a.get(i).val;
					if(aval == min){
						ListNode nextnode = a.get(i).next;
						a.set(i, a.get(i).next);
						if(nextnode != null){
							h.insertHeap(nextnode.val);
						}	
					}
				}
			}

		}
		return res;
	}	

	public static void main(String args[])throws Exception{
		MergeLists ml = new MergeLists();
		ArrayList<Integer> num1 = new ArrayList<>(Arrays.asList(1,10,20));
		ListNode list1 = ListNode.addNodeFromList(null, num1);		

		ArrayList<Integer> num2 = new ArrayList<>(Arrays.asList(4,11,13));
		ListNode list2 = ListNode.addNodeFromList(null, num2);		

		ArrayList<Integer> num3 = new ArrayList<>(Arrays.asList(3,8,9));
		ListNode list3 = ListNode.addNodeFromList(null, num3);		

		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		ListNode.printList(ml.mergeKLists(lists));
	}}
