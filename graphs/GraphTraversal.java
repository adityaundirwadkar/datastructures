package graphs;

import java.util.ArrayList;
import java.util.HashSet;

import common_files.Graph_Node;

public class GraphTraversal {

	public GraphTraversal() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean BFS(Graph_Node source, Graph_Node target){
		HashSet<Graph_Node> traversed = new HashSet<Graph_Node>();
		ArrayList<Graph_Node> queue = new ArrayList<Graph_Node>();
		
		
		traversed.add(source);	// Add source node as traversed node.
		queue.add(source);		// Add source node at the front of the queue.
		
		
		while(queue.size() > 0){
			// Loop will terminate once all of the node have been traversed
			// we have reached to our destination node.
			Graph_Node temp = queue.remove(0);
			
			if(temp.getData() == target.getData())
				// We have found our destination node.
				return true;
			
			Graph_Node[] tempNextNodes = temp.getNext();
			int i =0;
			while(i < tempNextNodes.length){
				// Check if next node exists in the traversed set. If not then
				// Add it up in queue as well as in HashSet.
				if(!traversed.contains(tempNextNodes[i])){
					traversed.add(tempNextNodes[i]);
					queue.add(tempNextNodes[i]);
				}
				i++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph_Node gn0 = new Graph_Node(1);
		Graph_Node gn1 = new Graph_Node(2);
		Graph_Node gn2 = new Graph_Node(3);
		Graph_Node gn3 = new Graph_Node(4);
		Graph_Node gn4 = new Graph_Node(5);
		
		gn0.setNext(gn3);
		gn0.setNext(gn1);
		gn0.setNext(gn2);
		
		gn1.setNext(gn2);
		
		gn2.setNext(gn3);
		
		gn4.setNext(gn3);
		gn4.setNext(gn0);
		gn4.setNext(gn1);
		gn4.setNext(gn2);
		
		System.out.println(GraphTraversal.BFS(gn4, gn2));
	}

}
