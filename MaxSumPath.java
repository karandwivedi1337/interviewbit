import java.util.*;
import java.io.*;
public class MaxSumPath{
	
	int maxsum = 0;

	public int recur(TreeNode node){
	
		if(node == null){
			return 0;
		}	

		if(node.left == null && node.right==null){
			return node.val;
		}		

		int leftval = recur(node.left);
		int rightval = recur(node.right);
		int maxchildval = Math.max(leftval, rightval);
		int maxrootchildval = Math.max(maxchildval, maxchildval + node.val);
		
		int maxsubtree = Math.max(maxrootchildval, node.val + leftval + rightval);
		
		maxsum = Math.max(maxsubtree, maxsum);
	
		return maxrootchildval;									
	}

	public int maxPathSum(TreeNode a) {

		recur(a);

		return maxsum;			
	}

	public static void main(String args[])throws Exception{
		MaxSumPath msp = new MaxSumPath();
		TreeNode root = null;
		root = TreeNode.insert(root, 2);
		root = TreeNode.insert(root, 1);
		root = TreeNode.insert(root, 3);
		System.out.println(msp.maxPathSum(root));
	}}
