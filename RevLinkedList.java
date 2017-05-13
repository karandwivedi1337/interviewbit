/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class RevLinkedList{

public ListNode reverseBetween(ListNode a, int m, int n){
	    
	        if (m == n){
	            return a;    
	        }
	        
	        ListNode head = a;
	        ListNode mnode = head;
	        ListNode mprev = null;
	        int tempm = 1;
	        
	        //traverse to the mth node
	        while(tempm < m){
	            mprev = mnode;
	            mnode = mnode.next;
	            tempm++;
	        }
	        
	        ListNode nthNode = mnode;
	        int tempn = m;
	        ListNode currentprev = mprev;
	        ListNode currentnode = mnode;
	        ListNode nextnode = currentnode.next;
	        ListNode nextnextnode = null;
	        
	        while(tempn < n && nextnode != null){
	               nextnextnode = nextnode.next;
	               nextnode.next = currentnode;
	               currentprev=currentnode;
	               currentnode=nextnode;
	               nextnode=nextnextnode;
	               ++tempn;
	        }
	        
	        if(mprev!=null){
	            mprev.next=currentnode;
	            mnode.next=nextnode;
	        }
	        else{
	               a=currentnode;
	               mnode.next=nextnode;
	        }
	        
	
	        return a;
	    
	}
}
