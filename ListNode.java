import java.util.*;
class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x){ 
		val = x;
		next = null;
	}

	int getLength(ListNode head){
	
		int count = 0;
		
		ListNode temp = head;

		while(temp != null){
			temp = temp.next;
			count++;
		}

		return count;
	}

	void printList(ListNode head){
		
		ListNode temp = head;

		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

	}

	ListNode addNode(ListNode head, int ele){

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

	ListNode addNodeFromList(ListNode head, ArrayList<Integer> list){

		if(head == null){

			if(list.size() > 0){
							
				ListNode newnode = new ListNode(list.get(0));
				head = newnode;
			}		
			
			else{
				return head;
			}

			ListNode temp = head;

			for(int i=1; i<list.size(); i++){

				ListNode newnode = new ListNode(list.get(i));
				temp.next = newnode;
				temp = newnode;
			}	
		}	

		else{
			ListNode temp = head;

			while(temp.next != null){
				temp = temp.next;
			}

			for(int i=0; i<list.size(); i++){

				ListNode newnode = new ListNode(list.get(i));
				temp.next = newnode;
				temp = newnode;
			}	
		}
		return head;
	}

} 
