import java.util.*;
import java.io.*;
public class BalancedTree{

	public static int findHeight(TreeNode node){

		if(node == null){
			return 0;
		}
		
		else if(node.left == null && node.right == null){
			return 1;
		}
		
		return Math.max(findHeight(node.left)+1, findHeight(node.right)+1);

	}		
	
	public static int levelOrderTraversal(TreeNode root){

		if(root == null){
			return 1;
		}

		java.util.Queue<TreeNode> q = new java.util.LinkedList<TreeNode>();
		
		q.add(root);
		
		while(!q.isEmpty()){

			TreeNode tn = q.remove();
			
			int leftheight = findHeight(tn.left);
			int rightheight = findHeight(tn.right);			
			
			//System.out.println("Node=" + tn.val + " LeftH=" + leftheight + " RightH=" + rightheight); 
			if(Math.abs(leftheight - rightheight) > 1){
				return 0;
			}

			if(tn.left != null){
				q.add(tn.left);
			}	
					
			if(tn.right != null){
				q.add(tn.right);
			}

		}

		return 1;

	}
			

	public int isBalanced(TreeNode a) {
		//call a traversal method that call height method
		return levelOrderTraversal(a);	
	}	

	public static void main(String args[])throws Exception{
		TreeNode root = null;
		root = TreeNode.insert(root, 6);
		
		root = TreeNode.insert(root, 3);

		root = TreeNode.insert(root, 7);
		root = TreeNode.insert(root, 2);
		root = TreeNode.insert(root, 5);
		root = TreeNode.insert(root, 9);

		BalancedTree bt = new BalancedTree();
	
		System.out.println(bt.isBalanced(root));
	}}
