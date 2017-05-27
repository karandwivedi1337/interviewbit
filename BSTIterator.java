import java.util.*;
import java.io.*;
public class BSTIterator{

	java.util.Stack st;
	int currentmin = Integer.MAX_VALUE;

	public BSTIterator(TreeNode root) {
		st = new java.util.Stack();
		if(root != null){
			st.push(root);
			recur(root.left);
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {

		if(st.isEmpty()){
			return false;
		}

		return true;
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode topele = (TreeNode)st.pop();
		//System.out.println("popped " + topele.val);
		recur(topele.right);
		return topele.val;
	}	

	public void recur(TreeNode root){

		if(root != null){
			st.push(root);
			//System.out.println("pushed " + root.val);

			if(root.left != null){
				recur(root.left);
			}

		}

	}

	public static void main(String args[])throws Exception{
		TreeNode root = null;
		root = TreeNode.insert(root, 7);
		root = TreeNode.insert(root, 5);
		root = TreeNode.insert(root, 12);
		root = TreeNode.insert(root, 2);
		root = TreeNode.insert(root, 6);
		root = TreeNode.insert(root, 10);
		root = TreeNode.insert(root, 16);
		BSTIterator bst = new BSTIterator(root);
		for(int i=0; i<8; i++){


			System.out.println("hasnext=" + bst.hasNext());
			if(bst.hasNext()){
				System.out.println("nextval=" + bst.next());
			}
		}
	}}
