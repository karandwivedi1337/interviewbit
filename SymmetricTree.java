import java.util.*;
import java.io.*;
public class SymmetricTree{

	public boolean recur(TreeNode root1, TreeNode root2){
		
		if(root1 == null || root2==null){
			return root1==root2;
		}
		
		if(root1.val != root2.val){
			return false;
		}

		return recur(root1.left, root2.right) && recur(root1.right, root2.left);
	}	

	public int isSymmetric(TreeNode a) {
		if (a == null){
			return 1;
		}
		
		boolean res = recur(a.left, a.right);	
		if(res == true){
			return 1;
		}
	
		return 0;
	}	

	public static void main(String args[])throws Exception{
		SymmetricTree st = new SymmetricTree();
	
		TreeNode root = null;
		root = TreeNode.insert(root,1);	
		root = TreeNode.insert(root, 2);
		root = TreeNode.insert(root, 2);
		root = TreeNode.insert(root, 3);
		root = TreeNode.insert(root, 4);
		root = TreeNode.insert(root, 4);
		root = TreeNode.insert(root, 3);
		System.out.println(st.isSymmetric(root));
	}}
