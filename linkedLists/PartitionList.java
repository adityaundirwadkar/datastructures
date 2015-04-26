package linkedLists;

import common_files.Node;

public class PartitionList {

	public PartitionList() {
		// TODO Auto-generated constructor stub
	}
	
	public static Node partitionList(Node head, char pivot){
		Node firstHead;
		Node firstTail;
		Node secondHead;
		Node secondTail;
		Node current;
		firstHead = firstTail = secondHead = secondTail = current = null;
		
		while(head != null){
			current = head;
			head = head.getNext();		// Move head to next node.
			current.setNext(null);		// Break the node from the list.
			
			if(current.getData() < pivot){
				// This node belongs to first half.
				if(firstHead == null){	// Very first node.
					firstHead = firstTail = current;
				}else{
					firstTail.setNext(current);			// Append current to tail.
					firstTail = firstTail.getNext();	// Move the tail to next one.
				}
			}else{
				// This node belongs to second half.
				if(secondHead == null){	// Very first node.
					secondHead = secondTail = current;
				}else{
					secondTail.setNext(current);			// Append current to tail.
					secondTail = secondTail.getNext();		// Move the tail to next one.
				}
			}
		}
		firstTail.setNext(secondHead);
		return firstHead;
	}
	
	public static void main(String[] args){
		Node n1 = new Node('a');
		Node n2 = new Node('b');
		Node n3 = new Node('c');
		Node n4 = new Node('d');
		Node n5 = new Node('e');
		Node n6 = new Node('f');
		Node n7 = new Node('a');
		Node n8 = new Node('b');
		Node n9 = new Node('c');
		Node n10 = new Node('d');
		Node n11 = new Node('e');
		Node n12 = new Node('f');
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		n8.setNext(n9);
		n9.setNext(n10);
		n10.setNext(n11);
		n11.setNext(n12);
		
		Node.traverseList(n1);
		System.out.print("\n");
		Node temp = PartitionList.partitionList(n1, 'c');
		Node.traverseList(temp);
	}
		
		
}
