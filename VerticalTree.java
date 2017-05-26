import java.util.*;
import java.io.*;
public class VerticalTree{

	int minwidth;
	int maxwidth;

	private class Pair{
		TreeNode node;
		int depth;

		Pair(TreeNode node, int depth){
			this.node = node;
			this.depth = depth;
		}	
	}


	public void populateResult(HashMap<Integer, ArrayList<Integer>> hmap, ArrayList<ArrayList<Integer>> res){

		for(int i=minwidth; i<=maxwidth; i++){
			if(hmap.containsKey(i)){
				res.add(new ArrayList(hmap.get(i)));
			}	
		}	

	}

	public void addPairToHashMap(Pair p, HashMap<Integer, ArrayList<Integer>> hmap){

		if(p.depth < minwidth){
			minwidth = p.depth;
		}

		if(p.depth > maxwidth){
			maxwidth = p.depth;
		}


		if(!hmap.containsKey(p.depth)){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(p.node.val);
			hmap.put(p.depth, new ArrayList(temp));
		}

		else{

			ArrayList<Integer> temp = hmap.get(p.depth);
			temp.add(p.node.val);
			hmap.put(p.depth, new ArrayList(temp));
		}

	}

	public void levelOrderTraversal(TreeNode root, HashMap<Integer, ArrayList<Integer>> hmap, ArrayList<ArrayList<Integer>> res){

		if(root == null){
			return;
		}	

		minwidth = Integer.MAX_VALUE;
		maxwidth = Integer.MIN_VALUE;

		java.util.Queue<Pair> q =  new java.util.LinkedList<Pair>();
		int count = 0;
		Pair p = new Pair(root, count);	

		q.add(p);

		while(!q.isEmpty()){

			Pair phead = q.remove();
			//System.out.println("pair=" + phead.node.val);
			addPairToHashMap(phead, hmap);

			if(phead.node.left != null){

				q.add(new Pair(phead.node.left, (phead.depth)-1));
			}		

			if(phead.node.right != null){
				q.add(new Pair(phead.node.right, (phead.depth)+1));
			}

		}

	}	


	void printHashMap(HashMap<Integer, ArrayList<Integer>> hmap){

		for(Integer key: hmap.keySet()){
			System.out.println("key="+key+ " value=" + hmap.get(key));
		}
	}


	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

		HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();		

		levelOrderTraversal(A, hmap, res);	
		populateResult(hmap, res);
		return res;
	}

	public static void main(String args[])throws Exception{
		TreeNode root = null;
		root = TreeNode.insert(root,6);	
		root = TreeNode.insert(root, 3);
		root = TreeNode.insert(root, 7);
		root = TreeNode.insert(root, 2);
		root = TreeNode.insert(root, 5);
		root = TreeNode.insert(root, 9);
		//TreeNode.printTree(root);
		VerticalTree vt = new VerticalTree();
		System.out.println(vt.verticalOrderTraversal(root));
	}}
