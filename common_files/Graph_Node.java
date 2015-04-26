package common_files;

import java.util.LinkedHashSet;

public class Graph_Node {

	private int data;
	private LinkedHashSet<Graph_Node> next;
	
	public Graph_Node(int data) {
		// TODO Auto-generated constructor stub
		this.setData(data);
		this.next = new LinkedHashSet<Graph_Node>(); 
	}

	/**
	 * @return the next
	 */
	public Graph_Node[] getNext() {
		return next.toArray(new Graph_Node[next.size()]);
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Graph_Node next) {
		this.next.add(next);
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	
	
	

}
