import java.util.*;
import java.io.*;
public class SumRootLeaf{

	long sum;

	public void recur(TreeNode root, long number){

		if(root != null){
			number = number*10 + root.val;
			if(root.left == null && root.right == null){
				long tempnumber = number % 1003;
				sum += tempnumber;
				sum%= 1003;
				//System.out.println(number);
			}
			
		}	
		else{
			return;
		}
		
		recur(root.left, number);
		recur(root.right, number);
		
	}

	public int sumNumbers(TreeNode a) {
		sum = 0;
		if(a == null){
			return 0;
		}	

		recur(a, 0);

		return (int)sum;
	}	

	public static void main(String args[])throws Exception{
		SumRootLeaf srl = new SumRootLeaf();
                TreeNode root = null;
                root = TreeNode.insert(root, 5);
                root = TreeNode.insert(root, 3);
                root = TreeNode.insert(root, 1);
                root = TreeNode.insert(root, 4);
                root = TreeNode.insert(root, 8);
                root = TreeNode.insert(root, 7);
                root = TreeNode.insert(root, 9);
		System.out.println(srl.sumNumbers(root));	
	}}
