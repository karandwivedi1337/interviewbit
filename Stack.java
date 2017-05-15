public class Stack{

	int arr[];
	int size;
	int top;
	int initialsize;

	Stack(){
		arr = new int[10];
		top=-1;
		initialsize = 10;
		size=initialsize;
	}

	public void push(int ele){
		//TODO: resize arr if top = size-1;
		if(top == size - 1){
			size = size*2;
			int newarr[] = new int[size];
			
			for(int i=0; i<size/2; i++){
				newarr[i] = arr[i];
			}

			arr = newarr;
		}
		
		arr[++top] = ele;
	}

	public int pop(){
		
		//Caller should check for empty stack before calling po
		//Resize array if number of elements drop below size/2
		if(size > initialsize && top < size/2){
			size = size/2;
			int newarr[] = new int[size];	
			
			for(int i=0; i<size; i++){
				newarr[i] = arr[i];
			}

			arr = newarr;
		}
	
		return arr[top--];
	}

	public boolean isEmpty(){
		if(top==-1){
			return true;
		}
		return false;
	}

	public int peek(){
		//Caller should check if stack is empty before making this call
		return arr[top];

	}

public void printStack(){
	for(int i=top; i>=0; i--){
		System.out.print(arr[i] + " ");
	}
	System.out.println();
}

}
