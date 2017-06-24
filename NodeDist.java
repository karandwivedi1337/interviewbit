import java.util.*;
import java.io.*;
public class NodeDist{

	int maxnum;

	public int dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> adjheights, int currentindex){

		//System.out.println("called for index=" + currentindex);
		if(adj.get(currentindex).size() == 0){
			return 0;
		}			
			
		int maxheight = 0;
		for(int i=0; i<adj.get(currentindex).size(); i++){
			int indexheight = 1 + dfs(adj, adjheights, adj.get(currentindex).get(i));
			adjheights.get(currentindex).set(i, indexheight);	
			maxheight = Math.max(maxheight, indexheight);
		}
		
		//return max among all heights + 1
		//store maxnum as 2 max heights children + 1
		
		Collections.sort(adjheights.get(currentindex), Collections.reverseOrder());	
		int childmax = 0;
		for(int i=0; i<adjheights.get(currentindex).size() && i<2; i++){
			childmax += adjheights.get(currentindex).get(i);
		}

		maxnum = Math.max(maxnum, childmax);

		return maxheight;
	}

	public int solve(ArrayList<Integer> A) {
		
		if(A.size() == 0 || A.size() == 1){
			return 0;
		}		

		maxnum = 0;		

		//Create adjacency list	
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<ArrayList<Integer>> adjheights = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<A.size(); i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			adj.add(new ArrayList(temp));
			adjheights.add(new ArrayList(temp));
		}

		int root = -1;
		for(int i=0; i<A.size(); i++){
			if(A.get(i) == -1){
				root = i;
				continue;
			}
			
			int index = A.get(i);

			ArrayList<Integer> indexlist = adj.get(index);
			indexlist.add(i);
			adj.set(index, indexlist);				
			ArrayList<Integer> heightlist = adjheights.get(index);
			heightlist.add(0);
			adjheights.set(index, heightlist);
		}						
		
		//System.out.println(adj);
		//System.out.println(adjheights);
	
		int res = dfs(adj, adjheights, root);		
		
		//System.out.println(adj);
		//System.out.println(adjheights);
	
		return maxnum;
	}	
		
	public static void main(String args[])throws Exception{
		NodeDist nd = new NodeDist();
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 0, 0, 0, 3));
		System.out.println(nd.solve(A));	
	}}
