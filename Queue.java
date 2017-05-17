public class Queue{

	int arr[];
	int front;
	int rear;
	int capacity;
	int size;

	Queue(){
		arr = new int[10];
		front=0;
		rear=-1;
		capacity = 10;
		size=0;
	}

	public void enqueue(int ele){

		if(size == capacity){
			System.out.println("Queue is full");
			return;
		}
		rear++;
		if(rear == capacity){
			rear = 0;
		}

		arr[rear] = ele;
		size++;
	}

	public int dequeue(){

		int frontele = arr[front];
		size--;
		front++;
		return frontele;
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
		for(int i=0; i<size; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}


	public static void main(String args[])throws Exception{
		Queue q = new Queue();
		for(int i=0; i<10; i++){
			q.enqueue(i);
			q.printQueue();
		}

		for(int i=0; i<10; i++){
			q.dequeue();
			q.printQueue();
		}
	}}
