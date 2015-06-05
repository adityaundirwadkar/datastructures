package linkedLists;

import common_files.Node;

public class PairwiseSwap {

	public PairwiseSwap() {
		// TODO Auto-generated constructor stub
	}

	public static Node SwapPairs(Node head){
		if(head == null)					// Empty List.
			return null;
		if(head.getNext() == null)			// Single length.
			return head;
		
		Node current = head;
		Node prev = null;
		Node temp = null;
		while(current!= null && current.getNext() != null){		// Else proceed until you get odd length list or even length list. 
			temp = current.getNext();							// Store the next element of current node.
			if(prev != null)									
				prev.setNext(temp);								// We have already traversed past head node.
			else
				head = temp;									// We are at head node.
			current.setNext(temp.getNext());					// Move current at temp's position.
			temp.setNext(current);								// Move temp to current's position.
			prev = current;										// We are done swapping lets move ahead, but before that lets mark the prev node
			current = current.getNext();						// Lets move ahead in the list.
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n1 = new Node('a');
		Node n2 = new Node('b');
		Node n3 = new Node('c');
		Node n4 = new Node('d');
		Node n5 = new Node('e');
		Node n6 = new Node('f');
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		
		Node.traverseList(n1);
		System.out.println();
		Node temp = PairwiseSwap.SwapPairs(n1);
		Node.traverseList(temp);
	}
}
