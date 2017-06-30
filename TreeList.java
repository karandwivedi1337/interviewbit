import java.util.*;
import java.io.*;
public class TreeList{

	public void inorder(TreeNode root){

		if(root != null){
			System.out.println(root.val + " ");
		}

		if(root.left != null){
			inorder(root.left);
		}

		if(root.right != null){
			inorder(root.right);
		}

	}	

	//returns the rightmost element of the root
	//if root is the only element, returns root
	public TreeNode findRightmost(TreeNode root, TreeNode prev){

		if(root == null){
			return prev;
		}		

		return findRightmost(root.right, root);	

	}


	public void recur(TreeNode a) {

		if(a == null){
			return;
		}

		if(a.left != null){
			TreeNode rightmost = findRightmost(a.left, null);
			TreeNode rightnode = a.right;
			TreeNode leftnode = a.left;

			if(rightmost != leftnode){
				a.right = leftnode;
				rightmost.right = rightnode;	
			}
			else{
				a.right = leftnode;	
				leftnode.right = rightnode;
			}

			a.left = null;	
		}

		if(a.right != null){
			recur(a.right);	
		}	

	}	


	public TreeNode flatten(TreeNode a) {
		if(a == null){
			return null;
		}
		
		recur(a);
		return a;
	}


	public void checkFlatten(TreeNode root){

		if(root == null){
			return;
		}

		System.out.print(root.val + " ");

		checkFlatten(root.right);
	}

	public static void main(String args[])throws Exception{
		TreeList tl = new TreeList();
		TreeNode root = null;
		root = TreeNode.insert(root, 7);
		root = TreeNode.insert(root, 10);
		root = TreeNode.insert(root, 20);
		root = TreeNode.insert(root, 30);
		root = TreeNode.insert(root, 60);
		root = TreeNode.insert(root, 400);
		//tl.inorder(root);
		tl.flatten(root);
		tl.checkFlatten(root);
		//System.out.println();
	}}
