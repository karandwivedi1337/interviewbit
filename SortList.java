import java.util.*;
public class SortList{

	int getNumNodes(ListNode head, ListNode start, ListNode end){
		
		ListNode tempstart = start;
		int count = 1;
		while(tempstart != end){
			count++;
			tempstart=tempstart.next;
		}
	
		return count;
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

	ListNode getNodeAtIndex(ListNode head, int index){
		int tempi = 0;
		ListNode res = head;

		while(tempi < index){
			res = res.next;
			tempi++;
		}

		return res;
	}

	public ListNode getMidpointFast(ListNode head){

		ListNode fast = head;
		ListNode slow = head;

		while(slow.next != null && fast.next!= null && fast.next.next!= null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;	
	}

	ListNode getMidpoint(ListNode head, ListNode start, ListNode end){
		
		if(start == null){
			return null;
		}

		else if(start == end){
			return start;
		}
		
		ListNode temphead = head;
		int count = 0;
		while(temphead != null && temphead != end){
			temphead=temphead.next;
			count++;		
		}
		
		temphead = head;
		int tempcount = 0;

		while(tempcount <(count/2)){
			temphead = temphead.next;
			tempcount++;
		}

		return temphead;	
	}

	public void merge(ListNode head, ListNode start1, ListNode end1, ListNode start2, ListNode end2){
					
		System.out.println("Merge called with head="+head.val + " start1=" + start1.val + " end1=" + end1.val + " start2=" + start2.val + " end2="+end2.val);

		/*
		int len1 = getNumNodes(head, start1, end1);		
		int len2 = getNumNodes(head, start2, end2);
	        

		if(len2 > len1){
		
			ListNode starttemp = start1;
			start1=start2;
			start2=starttemp;

			ListNode endtemp = end1;
			end1=end2;
			end2=endtemp;	
		}

		*/

		ListNode start1copy = start1;
		ListNode start2copy = start2;
		ListNode end1copy = end1;
		ListNode end2copy = end2;

		ListNode newhead = null;
		ArrayList<Integer> arr = new ArrayList<Integer>();
	       	while(start1 != end1.next && start2 != end2.next){
			if(start1.val < start2.val){
				arr.add(start1.val);
				start1=start1.next;
			}
			else{
				arr.add(start2.val);
				start2=start2.next;
			}
			
		}

		while(start1 != end1.next){
			arr.add(start1.val);
			start1=start1.next;
		}
 	
		
		while(start2 != end2.next){
			arr.add(start2.val);
			start2=start2.next;
		}

		int index = 0;
		while(start1copy != end1copy.next){
			start1copy.val = arr.get(index);
			start1copy=start1copy.next;
			index++;
		}		

		while(start2copy != end2copy.next){
			start2copy.val = arr.get(index);
			start2copy=start2copy.next;
			index++;	
		}		

	}	

	public void sort(ListNode head, ListNode start, ListNode end){

		System.out.println("Sort called with head="+head.val + " start=" + start.val + " end=" + end.val);

		if(end == start){
			return;
		}	

		else if(end == start.next){
			if(start.val > end.val){
				int temp = start.val;
				start.val = end.val;
				end.val = temp;
			}
			return;
		}

		else{
			ListNode mid = getMidpoint(head, start, end);
			sort(head, start, mid);
			sort(head, mid.next, end);
			merge(head, start, mid, mid.next, end);			
		}
	}


	public ListNode sortList(ListNode a) {	

		ListNode last = getNodeAtIndex(a, a.getLength(a)-1);
		int len = getLength(a);
				
		sort(a, a, last);
		/*
		for(int i=0; i<len; i++){
			System.out.print(getNodeAtIndex(a, i).val + " ");
		}	
		
		System.out.println();		
		*/
		return a;
	}

	public static void main(String args[])throws Exception{
		ListNode head = null;
		//ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,5,3,7));
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 66, 68, 42, 73, 25, 84, 63, 72, 20, 77, 38, 8, 99, 92, 49, 74, 45, 30, 51, 50, 95, 56, 19, 31, 26, 98, 67, 100, 2, 24, 6, 37, 69, 11, 16, 61, 23, 78, 27, 64, 87, 3, 85, 55, 22, 33, 62));
		
		head = ListNode.addNodeFromList(head, list);
		ListNode.printList(head);
		SortList sl = new SortList();
		sl.sortList(head);
	}}
