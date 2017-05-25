import java.util.*;
import java.io.*;
import java.util.Random;
public class TreeNode{

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x){ 
		val = x; 
		left = right = null;
	}

	public static TreeNode insert(TreeNode root, int ele){

		if(root == null){
			root = new TreeNode(ele);
			return root;
		}				

		else if(ele <= root.val){
			root.left = insert(root.left, ele);
		}
		else{
			root.right = insert(root.right, ele);
		}

		return root;
	}

	public static void printTree(TreeNode root){

		if(root == null){
			return;
		}
		
		if(root.left != null){
			printTree(root.left);
		}
		
		else if(root != null){
			System.out.print(root.val + " ");
		}

		if(root.right != null){
			printTree(root.right);
		}
	}

	public static void main(String args[])throws Exception{
		TreeNode root = null;
		Random rand = new Random();
		for(int i=0; i<10; i++){	
			int  n = rand.nextInt(50) + 1;
			System.out.println("Inserting " + n);
			root = TreeNode.insert(root, n);
		}
		
		TreeNode.printTree(root);
		System.out.println();	
	}}
