psuedo-code for reversing linked list

prev=NULL;
current=head;
next=head;

while(next != NULL){

	next = current->next;
	current->next = prev;
	prev = current;
	current = next;
}

return prev;
