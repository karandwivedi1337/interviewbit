import java.util.*;
import java.io.*;
public class MaxSumPath{
	
	long maxsum = Integer.MIN_VALUE;

	public int recur(TreeNode node){

        if(node == null){
            return Integer.MIN_VALUE;
        }

		if(node.left == null && node.right==null){
			return node.val;
		}		

		long leftval = recur(node.left);
		long rightval = recur(node.right);
		long maxchildval = Math.max(leftval, rightval);
		long maxrootchildval = Math.max(node.val, Math.max(maxchildval, maxchildval + node.val));
		
		long maxsubtree = Math.max(maxrootchildval, node.val + leftval + rightval);
		
		maxsum = Math.max(maxsubtree, maxsum);
	
		return (int)maxrootchildval;									
	}

	public int maxPathSum(TreeNode a) {
        
        maxsum = Integer.MIN_VALUE;
        
        if(a == null){
            return 0;
        }

        else if(a.left == null && a.right == null){
            return a.val;
        }

		recur(a);

		return (int)maxsum;			
	}

	public static void main(String args[])throws Exception{
		MaxSumPath msp = new MaxSumPath();
		TreeNode root = null;
		root = TreeNode.insert(root, 2);
		root = TreeNode.insert(root, 1);
		root = TreeNode.insert(root, 3);
		System.out.println(msp.maxPathSum(root));
	}}
