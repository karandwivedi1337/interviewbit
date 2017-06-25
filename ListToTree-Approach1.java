import java.util.*;
import java.io.*;
public class ListToTree{

	ListNode listhead = null;

	ListNode midNode(ListNode start, ListNode end){

		ListNode slow = start;
		ListNode fast = start;

		if(start == end){
			return start;
		}

		while(fast != null && fast.next != null && fast != end){

			slow = slow.next;
			fast = fast.next.next;		

		}	

		return slow;
	}

	public static ListNode getLastNode(ListNode head){

		if(head == null || head.next == null){
			return head;
		}

		ListNode temphead = head;

		while(temphead.next != null){
			temphead = temphead.next;
		}

		return temphead;
	}

	ListNode getPreviousNode(ListNode mid, ListNode listhead){

		//if trying to find previous element before the head
		if(mid == listhead){
			return null;
		}

		ListNode temphead = listhead;

		while(temphead.next != mid){
			temphead = temphead.next;
		}		

		return temphead;
	}	

	public TreeNode getTreeNode(ListNode listnode){

		TreeNode tn = new TreeNode(listnode.val);
		return tn;
	}

	public TreeNode recur(ListNode start, ListNode end, ListNode listhead, ListNode lasthead){

		//System.out.println("Recur called with start=" + start.val +"  end=" + end.val +  " listhead=" + listhead.val);

		if(end == start && start != null){
			return getTreeNode(start);
		}

		if(end == null && start != null){
			return getTreeNode(start);
		}

		if(start == null && end!= null){
			return getTreeNode(end);
		}		

		ListNode mid = midNode(start, end);

		if(mid != null){
			TreeNode root = getTreeNode(mid);		
			ListNode prevNode = getPreviousNode(mid, listhead);
			System.out.println("Mid=" + mid.val + " Previous=" + prevNode.val);
			if(prevNode != null && start != null){
				root.left = recur(start, prevNode, listhead, lasthead);
			}
			else{
				root.left = null;
			}

			if(mid != null && end != null){	
				root.right = recur(mid.next, end, listhead, lasthead);
			}
			else{
				root.right = null;
			}	


			return root;
		}

		else{
			return null;
		}		

	}

	public TreeNode sortedListToBST(ListNode a) {

		if(a== null || a.next == null){
			return getTreeNode(a);		
		}	

		ListNode lastele = getLastNode(a);

		return recur(a, lastele, a, lastele);		
	}	

	public static void main(String args[])throws Exception{
		ListToTree ltt = new ListToTree();
		ListNode head = null;
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		head = ListNode.addNodeFromList(head, list);
		TreeNode root = ltt.sortedListToBST(head);	
		TreeNode.printTree(root);
	}}
