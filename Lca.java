import java.util.*;
import java.io.*;
public class Lca{

	ArrayList<ArrayList<TreeNode>> paths;

	public void printList(ArrayList<TreeNode> list){
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i).val + " ");
		}
		System.out.println();
	}

	public void find(TreeNode root, int target, ArrayList<TreeNode> path, int i){

		//System.out.print("Called with root=" + root.val + " Path=");
		//printList(path);

		if(root != null){	
			path.add(0, root);
			//System.out.print("Added " + root.val + " Path=");

			if(root.val == target){
				//System.out.print("Target found. Path=");
				//printList(path);
				paths.add(new ArrayList(path));
				return;	
			}

			//printList(path);

			if(root.left != null){
				find(root.left, target, path, i);
				path.remove(0);
			}		

			if(root.right != null){
				find(root.right, target, path, i);
				path.remove(0);
			}	
		}

	}

	public int lca(TreeNode a, int val1, int val2) {

		int iter = 0;
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		paths = new ArrayList<ArrayList<TreeNode>>();
		find(a, val1, path, iter);
		path.clear();
		find(a, val2, path, ++iter);
	
		if(paths.size() != 2){
			return -1;
		}		

		ArrayList<TreeNode> path1, path2;
		
		if(paths.get(0).size() > paths.get(1).size()){
			path1=paths.get(0);
			path2=paths.get(1);
		}
		else{
			path1=paths.get(1);
			path2=paths.get(0);
		}
		
		
		
		int lcaval = -1;			
		int pos1=0, pos2=0;
		
		while(pos1 < path1.size() && pos2<path1.size()){
			if(path1.get(pos1).val == path2.get(pos2).val){
				lcaval = path1.get(pos1).val;
				break;
			}
			else{
				if(path1.size() - pos1 > path2.size() - pos2){
					pos1++;
				}
				else if(path1.size() - pos1 < path2.size() - pos2){
					pos2++;
				}
				else{
					pos1++;
					pos2++;
				}
			}	
		}

		return lcaval;
	}	

	public static void main(String args[])throws Exception{
		Lca l = new Lca();
		TreeNode root = null;
		root = TreeNode.insert(root, 7);
		root = TreeNode.insert(root, 5);
		root = TreeNode.insert(root, 20);
		root = TreeNode.insert(root, 3);
		root = TreeNode.insert(root, 6);
		root = TreeNode.insert(root, 40);
		System.out.println("LCA=" + l.lca(root, 40, 7));
	}}
