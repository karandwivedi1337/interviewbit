import java.util.*;
import java.io.*;
public class RevLinkedList{

	ListNode newhead;

	public ListNode recur(ListNode head, ListNode prev){

		if(head != null){
			recur(head.next, head);
		}
		
		if(newhead == null){
			newhead = head;
		}
	
		if(head != null){	
			head.next = prev;
		}
		return newhead;

	}	

	public ListNode iterate(ListNode head){

		ListNode prev = null;
		ListNode current = head, next = head;

		while(next != null){

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;			

		}			
			
		return prev;		

	}	

	public static void main(String args[])throws Exception{
		RevLinkedList rll = new RevLinkedList();
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));	
		ListNode head = ListNode.addNodeFromList(null, list);	
		ListNode.printList(head);
		head = rll.iterate(head);
		ListNode.printList(head);
		rll.newhead = null;
		rll.recur(head, null);
		ListNode.printList(rll.newhead);
	}}
