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

	//pre-order traversal
	public static void printTree(TreeNode root){

		if(root == null){
			return;
		}
		
		if(root.left != null){
			printTree(root.left);
		}
		
		//else if(root != null){
			System.out.print(root.val + " ");
		//}

		if(root.right != null){
			printTree(root.right);
		}
	}

	public static void printLevelOrder(TreeNode root){

		if(root == null){
			return;
		}

		java.util.Queue<TreeNode> q = new java.util.LinkedList<TreeNode>();
		
		q.add(root);
		
		while(!q.isEmpty()){

			TreeNode tn = q.remove();
			
			System.out.print(tn.val + " height=" + TreeNode.findHeight(tn) + " ");

			if(tn.left != null){
				q.add(tn.left);
			}	
					
			if(tn.right != null){
				q.add(tn.right);
			}

		}

	}
			
	public static int findHeight(TreeNode node){

		if(node == null){
			return 0;
		}
		
		else if(node.left == null && node.right == null){
			return 0;
		}
		

		return Math.max(findHeight(node.left)+1, findHeight(node.right)+1);

	}		

	public static void main(String args[])throws Exception{
		TreeNode root = null;
		Random rand = new Random();
		for(int i=0; i<10; i++){	
			int  n = rand.nextInt(50) + 1;
			System.out.println("Inserting " + n);
			root = TreeNode.insert(root, n);
		}
		
		//TreeNode.printTree(root);
		TreeNode.printLevelOrder(root);
		System.out.println();	
	}}
