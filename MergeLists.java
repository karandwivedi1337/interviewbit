import java.util.*;
import java.io.*;
public class MergeLists{

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


	public ListNode mergeKLists(ArrayList<ListNode> a) {

		ListNode res = null;	
		for(int i=0; i<a.size(); i++){
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
