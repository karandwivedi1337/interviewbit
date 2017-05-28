import java.util.*;
import java.io.*;
public class InvertTree{

	/*
	public void recur(TreeNode root1, TreeNode root2, TreeNode root1par, TreeNode root2par, char root1dir, char root2dir){


		if(root1 == null && root2 == null){
			return;
		}		

		TreeNode temproot1 = root1;
		TreeNode temproot2 = root2;
		if(root1dir == 'L'){
			//root2dir has to be 'R'
			root2par.right = temproot1;
			root1par.left = temproot2;
		}	

		else{
			//root1dir == 'R' and root2dir = 'L'
			root2par.left = temproot1;
			root1par.right = temproot2;
		}		

		if(root1 != null && root2 != null){
			recur(root1.left, root2.right, root1, root2, 'L', 'R');
			recur(root1.right, root2.left, root1, root2, 'R', 'L');
		}
	}	
	*/


	public void recur(TreeNode root){


		if(root == null){
			return;
		}	

		TreeNode templeft = root.left;
		root.left = root.right;
		root.right = templeft;

		if(root.left != null){
			recur(root.left);
		}	

		if(root.right != null){
			recur(root.right);
		}
	}
	public TreeNode invertTree(TreeNode root) {

		if (root == null){
			return null;
		}

		//recur(root.left, root.right, root, root, 'L', 'R');	
		recur(root);

		return root;
	}

	public static void main(String args[])throws Exception{
		InvertTree it = new InvertTree();

		TreeNode root = null;
		root = TreeNode.insert(root,7);	
		root = TreeNode.insert(root, 5);
		root = TreeNode.insert(root, 2);
		root = TreeNode.insert(root, 6);
		root = TreeNode.insert(root, 10);
		TreeNode.printLevelOrder(root);
		System.out.println();	
		it.invertTree(root);
		TreeNode.printLevelOrder(root);
	}}
