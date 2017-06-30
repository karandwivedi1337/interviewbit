import java.util.*;
class DListNode {
	public int val;
	public DListNode next;
	public DListNode prev;

	DListNode(){
		next = prev = null;
	}

	DListNode(int x){ 
		val = x;
		next = prev = null;
	}

	public static int getLength(DListNode head, DListNode tail){
		
		if(head == null){
			return 0;
		}
		
		DListNode temphead = head;
		int count = 0;

		while(temphead != tail){
			count++;
			temphead = temphead.next;
		}
				
		return (count+1);	
	}


	public static void printList(DListNode head, DListNode tail){
		
		DListNode temp = head;

		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	
		System.out.println();

	}


	public static ArrayList<DListNode> removeFromHead(DListNode head, DListNode tail){

		if(head != null){
			DListNode nextnode = head.next;
			if(nextnode != null){
				nextnode.prev = null;
			}
			head = nextnode;
		}	
		
		ArrayList<DListNode> res = new ArrayList<DListNode>();
		res.add(head);
		res.add(tail);

		return res;
	}

	public static ArrayList<DListNode> removeFromEnd(DListNode head, DListNode tail){
			
		if(head != null){		
			DListNode prev = tail.prev;
			if(prev != null){
				prev.next = null;
			}
			tail = prev;

			if(tail == null){
				head = null;
			}
		}

		ArrayList<DListNode> res = new ArrayList<DListNode>();
		res.add(head);
		res.add(tail);

		return res;
	}

	public static ArrayList<DListNode> addNodeAtEnd(DListNode head, DListNode tail, int ele){

		
		DListNode newnode = new DListNode(ele);
		
		if(head == null){
			head = tail = newnode;	
		}		

		else{
			tail.next = newnode;
			newnode.prev = tail;
			tail = newnode;
		}		

		ArrayList<DListNode> res = new ArrayList<DListNode>();
		res.add(head);
		res.add(tail);
		
		return res;
	}


	public static ArrayList<DListNode> addNodeAtHead(DListNode head, DListNode tail, int ele){

		
		DListNode newnode = new DListNode(ele);
		
		if(head == null){
			head = tail = newnode;	
		}		

		else{
			newnode.next = head;
			head.prev=newnode;
			head = newnode;
		}		

		ArrayList<DListNode> res = new ArrayList<DListNode>();
		res.add(head);
		res.add(tail);
		
		return res;
	}
		

	public static ArrayList<DListNode> addNodeFromList(DListNode head, DListNode tail, ArrayList<Integer> list){	

		ArrayList<DListNode> res = new ArrayList<DListNode>();
		for(int i=0; i<list.size(); i++){

			res = DListNode.addNodeAtEnd(head, tail, list.get(i));
			head = res.get(0);
			tail = res.get(1);
		}
		
		res.clear();
		res.add(head);
		res.add(tail);
		return res;	
		
	}

	public static void main(String args[])throws Exception{

		DListNode dln = new DListNode(-1);
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(9,8,5,2,1));
		DListNode head=null, tail=null;
		ArrayList<DListNode> res = new ArrayList<DListNode>();
		for(int i=0; i<list.size(); i++){
		res = DListNode.addNodeAtHead(head, tail, list.get(i)); 
		head = res.get(0);
		tail = res.get(1);
		DListNode.printList(head, tail);
		}

		for(int i=0; i<list.size(); i++){
		res = DListNode.removeFromEnd(head, tail); 
		head = res.get(0);
		tail = res.get(1);
		DListNode.printList(head, tail);
		}
					
	}}
