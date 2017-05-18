public class Deque{

	ListNode head;
	int front;
	int rear;
	int capacity;
	int size;

	Deque(){
		head=null;
		front=0;
		rear=-1;
		capacity = 10;
		size=0;
	}

	public void addToRear(int ele){
		head = ListNode.addNode(head,ele);
		++size;
	}

	public ListNode dequeueFromRear(){
	
		if(!isEmpty()){
			ListNode ele = ListNode.removeFromEnd(head);
			--size;
			return ele;
		}

		return null;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public boolean isFull(){
		if(size == capacity){
			return true;
		}
		return false;
	}

	public void printQueue(){
		ListNode.printList(head);
	}

	public static void main(String args[])throws Exception{
		Deque deq = new Deque();
		for(int i=1; i<10; i++){
			deq.addToRear(i);
			deq.printQueue();
		}

		for(int i=1; i<10; i++){
			deq.dequeueFromRear();
			deq.printQueue();
		}
	}}
