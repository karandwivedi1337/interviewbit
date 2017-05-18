import java.util.*;
class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x){ 
		val = x;
		next = null;
	}

	public static int getLength(ListNode head){
	
		int count = 0;
		
		ListNode temp = head;

		while(temp != null){
			temp = temp.next;
			count++;
		}

		return count;
	}

	public static void printList(ListNode head){
		
		ListNode temp = head;

		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	
		System.out.println();

	}

	public static ListNode removeFromEnd(ListNode head){
	
		ListNode temp = head;
		ListNode prev = null;
		
		if(temp == null){
			return temp;
		}		
		
		if(temp.next == null){
			head = null;
			return temp;
		}

		while(temp.next != null){
			prev = temp;
			temp = temp.next;
		}
		
		prev.next = null;
		return temp;
	}

	public static ListNode addNode(ListNode head, int ele){

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

		

	public static ListNode addNodeFromList(ListNode head, ArrayList<Integer> list){

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
