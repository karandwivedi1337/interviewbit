#include <stdio.h>
#include <string.h>

void swap(char* a, char* b){

	char temp = *a;
	*a = *b;
	*b = temp;

}

void permute(char* a, int l, int r){


	if(l==r){
		printf("%s\n",a);
	}

	else{
		int i=0;
		for(i=l; i<=r; i++){

			swap((a+l), (a+i));
			permute(a, l+1, r);
			swap((a+l), (a+i));	

		}
	}

}


int main(){

	char arr[]="abc";
	permute(arr,0,strlen(arr)-1);
	return 0;
}
