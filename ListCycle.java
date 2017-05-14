public class ListCycle {
	public ListNode detectCycle(ListNode a) {
	    
	    if(a==null){
	        return null;
	    }
	    
	    ListNode slow = a;
	    ListNode fast = a;

	    while(true){
	        
	        slow = slow.next;
	        fast = fast.next;
	       
	         if(fast != null){
	            fast=fast.next;
	         }
	         else{
                return null;
	         }
	        
	        if(slow == null || fast == null){
                    return null;
	        }
	       
	         if(slow == fast){
	            break;
	        }
	        
	        
	    }
	    
	    //find start of cycle
	    slow=a;
	    while(slow != fast){
	        slow = slow.next;
	        fast = fast.next;
	    }
	    
	    return slow;
	}
}

