import java.util.*;
import java.io.*;
public class BuildTree{

	public TreeNode recur(ArrayList<Integer> inorder, int instart, int inend, ArrayList<Integer> postorder, int poststart, int postend, TreeNode root){		

		//System.out.println("Function called with instart="+ instart + " iend=" + inend + " poststart=" + poststart + " postend=" + postend);

		if(inend < instart){
			//System.out.println("returning null");
			return null;
		}

		if(inend == instart){
			TreeNode tn = new TreeNode(inorder.get(instart));
			//System.out.println("Created new node =" + tn.val);
			return tn;	
		}		

		int currentrootval = postorder.get(postend);
		int currentrootpos = inorder.indexOf(currentrootval);
		
		for(int k=instart; k<=inend; k++){
		    if(inorder.get(k) == currentrootval){
		        currentrootpos = k;
		    }
		}		

		//System.out.println("Rootval=" + currentrootval + " rootpos=" + currentrootpos); 

		TreeNode tn = new TreeNode(currentrootval);
		root = tn;
		//System.out.println("Set root as " + tn.val);		

		//rootpos in position of root in inorder traversal
		int i = currentrootpos;

		//root.left = recur(inorder, instart, i-1, postorder, poststart, i-1, root);	
		root.left = recur(inorder, instart, i-1, postorder, poststart, poststart+(i-instart-1), root);	
		//System.out.println("Set " + root.val + ".left=" + root.left.val);
		//root.right = recur(inorder, i+1, inend, postorder, i, postend-1, root);		
		root.right = recur(inorder, i+1, inend, postorder, poststart+(i-instart), postend-1, root);		
		//System.out.println("Set " + root.val + ".right=" + root.right.val);
		return root;
	}

	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
		TreeNode tn = null;
		
		if(inorder.size() == 0 || postorder.size() == 0){
			return null;
		}	

		return recur(inorder, 0, inorder.size()-1, postorder, 0, postorder.size()-1, tn);

	}	

	public static void main(String args[])throws Exception{
		ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(7, 5, 6, 2, 3, 1, 4));
		ArrayList<Integer> postorder = new ArrayList<>(Arrays.asList(5, 6, 3, 1, 4, 2, 7));
		
		//ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(4));
		//ArrayList<Integer> postorder = new ArrayList<>(Arrays.asList(4));
		
			
		//ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(4,2,5,1,6,3,7));
		//ArrayList<Integer> postorder = new ArrayList<>(Arrays.asList(4,5,2,6,7,3,1));

	
		//ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(17, 12, 24, 13, 2, 22, 9, 20, 18, 23, 3, 15, 21, 10, 4, 11, 19, 14, 16, 7, 1, 5, 6, 8));
		//ArrayList<Integer> postorder = new ArrayList<>(Arrays.asList(17, 13, 2, 22, 24, 18, 20, 9, 15, 3, 11, 4, 10, 14, 16, 19, 1, 7, 21, 23, 12, 6, 8, 5));

		BuildTree bt = new BuildTree();
		TreeNode root = bt.buildTree(inorder, postorder);	
		TreeNode.printLevelOrder(root);
	}}
