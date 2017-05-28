import java.util.*;
import java.io.*;
public class Trie{

	public class Node{
		char c;
		Node ptrs[] = new Node[26];

		Node(char c){
			this.c = c;
			for(int i=0; i<26; i++){
				ptrs[i] = null;
			}	
		}
	}

	public boolean isLeafNode(Node root){
		
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

		if(isLeafNode(root)){
			return false;
		}	

		if(pattern.length() < 1){
			return false;
		}
		
		for(int i=0; i<pattern.length(); i++){
			
			char c = pattern.charAt(i);
			int cindex = (int)(c-'a');
			
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
			int cindex = (int)(c - 'a');
	
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

	public static void main(String args[])throws Exception{
		Trie t = new Trie();
		Trie.Node root = t.new Node(' ');
		t.insertString("abc", root);
		t.insertString("def", root);
		t.insertString("abcdef", root);
		t.printTrie(root);
		System.out.println(t.searchString("", root));
	}}
