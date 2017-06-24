import java.util.*;
import java.io.*;
public class CloneGraph{

	public static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	}

	UndirectedGraphNode createCopy(UndirectedGraphNode node){

		UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
		newnode.neighbors = new ArrayList(node.neighbors);

		return newnode;
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if(node == null){
			return node;
		}

		//tracks overall node in the original graph
		HashMap<Integer, UndirectedGraphNode> orighmap =  new HashMap<Integer, UndirectedGraphNode>();	
		
		//trackes visited nodes
		HashMap<Integer, UndirectedGraphNode> hmap =  new HashMap<Integer, UndirectedGraphNode>();		
		
		//trackes nodes yet to be visited
		java.util.Queue<UndirectedGraphNode> q = new java.util.LinkedList<UndirectedGraphNode>();			

		q.add(node);
		int firstval = node.label;
		while(!q.isEmpty()){

			UndirectedGraphNode ele = q.remove();
			if(!hmap.containsKey(ele.label)){
				UndirectedGraphNode elecopy = new UndirectedGraphNode(ele.label);
				hmap.put(elecopy.label, elecopy);			
				orighmap.put(ele.label, ele);
				for(int i=0; i<ele.neighbors.size(); i++){				
					q.add(ele.neighbors.get(i));			
				}							

			}
		}
		
		//go through each entry in original graph and fix neighbors list for its clone
		Set set = orighmap.entrySet();
		Iterator it = set.iterator();
				
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			int label = (Integer)pair.getKey();
			UndirectedGraphNode value = (UndirectedGraphNode)pair.getValue();		
			UndirectedGraphNode clonevalue = hmap.get(label);
			
			for(int i=0; i<value.neighbors.size(); i++){
				clonevalue.neighbors.add(hmap.get(value.neighbors.get(i).label));	
			}		
		}			

		return hmap.get(firstval);
	}	

	public static void main(String args[])throws Exception{
		CloneGraph cg = new CloneGraph();
		//cg.cloneGraph(new UndirectedGraphNode(0));	
		System.out.println();
	}}
