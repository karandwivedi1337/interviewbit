import java.util.*;
import java.io.*;
public class UniquePrefix{

	ArrayList<String> prefixlist;

	public class Node{
		char c;
		Node ptrs[] = new Node[256];

		Node(char c){
			this.c = c;
			for(int i=0; i<256; i++){
				ptrs[i] = null;
			}	
		}
	}

	public boolean isLeafNode(Node root){

		if(root == null){
			return false;
		}

		boolean isleaf = true;
		if(root != null){

			for(int i=0; i<root.ptrs.length; i++){
				if(root.ptrs[i] != null){
					return false;
				}		

			}
		}		

		return true;	
	}

	public boolean searchString(String pattern, Node root){

		if(pattern.length() < 1){
			return false;
		}

		for(int i=0; i<pattern.length(); i++){

			char c = pattern.charAt(i);
			int cindex = (int)(c);

			if(root.ptrs[cindex] == null){
				return false;
			}

			else if(root.ptrs[cindex].c != c){
				return false;
			}

			root = root.ptrs[cindex];
		}		

		return true;
	}		

	public void printTrie(Node root){

		if(isLeafNode(root)){
			System.out.println(root.c);
			return;
		}

		if(root.c != ' '){
			System.out.print(root.c);
		}

		for(int i=0; i<root.ptrs.length; i++){
			if(root.ptrs[i] != null){
				printTrie(root.ptrs[i]);
			}			
		}
	}

	public void insertString(String s, Node root){	
		Node temproot = root;
		//assuming everything is lowercase
		for(int i=0; i<s.length(); i++){

			char c = s.charAt(i);
			int cindex = (int)(c);

			if(temproot.ptrs[cindex] == null){
				Node newnode = new Node(c);
				temproot.ptrs[cindex] = newnode;			
				temproot = newnode;
			}

			else{
				temproot = temproot.ptrs[cindex];
			}

		}	
	}					

	public boolean hasOneChild(Node root, String pattern){

		//System.out.println("HasOneChild called with root=" + root.c + " pattern=" + pattern);

		if(root == null){
			return false;
		}

		int count = 0;
		Node temproot = root;
		Node nextroot = null;
		for(int k=0; k<pattern.length(); k++){
			count = 0; 
			for(int i=0; i<root.ptrs.length; i++){
				if(root.ptrs[i] != null){
					count++;

					if(pattern.charAt(k) == root.ptrs[i].c){
						nextroot=root.ptrs[i];
					}
				}
			}	

			if(count != 1){
				//System.out.println("hasChild failed for k=" + k + " pattern=" + pattern);
				return false;
			}
			root = nextroot;	

		}

		return true;

	}

	public void recur(String pattern, Node root, String prefix){
		//System.out.println("recur called with pattern=" + pattern + " root=" + root.c + " prefix=" + prefix);

		if(pattern.length() == 0){	
			//System.out.println("prefix found from pattern.length()==0" + prefix);
			prefixlist.add(prefix);
			return;
		}

		if(isLeafNode(root)){
			prefix += root.c;
			//System.out.println("prefix found from isLeafNode(root)=" + prefix);
			prefixlist.add(prefix);
			return;	
		}	

		if(hasOneChild(root, pattern)){
			//prefix += root.c;
			//System.out.println("prefix found from hasOneChild(root)=" + prefix);
			prefixlist.add(prefix);
			return;	
		}	

		for(int i=0; i<root.ptrs.length; i++){

			if(root.ptrs[i] != null){
				if(pattern.charAt(0) == root.ptrs[i].c){
					recur(pattern.substring(1), root.ptrs[i], prefix+pattern.charAt(0));
				}
			}	
		}	

	} 

	public ArrayList<String> prefix(ArrayList<String> a) {

		ArrayList<String> res = new ArrayList<String>();		
		Node root = new Node(' ');
		for(int i=0; i<a.size(); i++){
			insertString(a.get(i), root);
			//System.out.println("inserted " + a.get(i));	
		}	

		prefixlist = new ArrayList<String>();

		for(int k=0; k<a.size(); k++){
			//System.out.println("calling recur with string=" + a.get(k));
			recur(a.get(k), root, "");	
		}				

		return prefixlist;		
	}

	public static void main(String args[])throws Exception{
		UniquePrefix up = new UniquePrefix();
		ArrayList<String> a = new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"));

		//ArrayList<String> a = new ArrayList<>(Arrays.asList("bearcat", "bert"));
		System.out.println(up.prefix(a));	

	}}
