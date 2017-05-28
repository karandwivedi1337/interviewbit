import java.util.*;
import java.io.*;
public class Zigzag{

	public static void printLevelOrder(TreeNode root, ArrayList<ArrayList<Integer>> res){

		if(root == null){
			return;
		}

		java.util.Queue<TreeNode> q = new java.util.LinkedList<TreeNode>();
		java.util.Stack<Integer> st = new java.util.Stack<Integer>();
		int count = 0;
		int iter = 0;
		q.add(root);
		int newcount = 1;

		while(!q.isEmpty()){

			count = newcount;
			newcount = 0;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i=0; i<count; i++){
				TreeNode tn = q.remove();
				
				if(iter % 2 == 0){
					temp.add(tn.val);
				}
				else{
					st.push(tn.val);
				}	

				if(tn.left != null){
					q.add(tn.left);
					++newcount;
				}

				if(tn.right != null){
					q.add(tn.right);
					++newcount;
				}

			}

			while(!st.isEmpty()){
				temp.add(st.pop());	
			}
			
			res.add(new ArrayList(temp));

			iter++;	
		}

	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		if(a == null){
			return res;
		}
		
		printLevelOrder(a, res);
		return res;	
	}


	public static void main(String args[])throws Exception{
		Zigzag zz = new Zigzag();
		TreeNode root = null;
		root = TreeNode.insert(root, 9);	
		root = TreeNode.insert(root, 7);	
		root = TreeNode.insert(root, 20);	
		root = TreeNode.insert(root, 5);	
		root = TreeNode.insert(root, 8);	
		root = TreeNode.insert(root, 40);	
		System.out.println(zz.zigzagLevelOrder(root));
	}}
