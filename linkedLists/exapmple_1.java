package linkedLists;

import common_files.Node;

public class exapmple_1 {

	private Node head;
	
	public exapmple_1(Node start) {
		// TODO Auto-generated constructor stub
		this.setHead(start);
	}

	/**
	 * @return the head
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Node head) {
		this.head = head;
	}
	
	
	@SuppressWarnings("unused")
	public Node merge(){
		Node mid;
		Node prev = null;
		Node start;
		Node newRoot = null;
		Node newTail = null;
		int size = 0;
		int flag = 0;
		
		start = this.getHead();
		mid = this.getHead();
		
		while(start != null && start.getNext() != null){
			size += 2;
			start = start.getNext().getNext();
			prev = mid;
			mid = mid.getNext();
		}
		
		if(start != null && start.getNext() == null){
			// Odd length.
			size += 1;
			prev = mid;
			mid = mid.getNext();
		}
		
		
		// Break the list in two parts at mid as head node for other list. 
		if(prev != null)
			prev.setNext(null);
		
		start = this.getHead();
		newRoot = newTail = start;
		start = start.getNext();
		newTail.setNext(null);
		flag = 1;
		
		while(true){
			if(flag == 0){
				if(start != null){
					newTail.setNext(start);
					start = start.getNext();
					newTail = newTail.getNext();
					newTail.setNext(null);
				}else
					break;
			}else{
				if(mid != null){
					newTail.setNext(mid);
					mid = mid.getNext();
					newTail = newTail.getNext();
					newTail.setNext(null);
				}else
					break;
				}
			flag = 1 - flag;
		}
		
		if(start != null)
			newTail.setNext(start);

		return newRoot;
	}
	
	public static void main(String args[]){
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
		
		
		
		exapmple_1 newexapmple_1 = new exapmple_1(n1);
		
		Node.traverseList(n1);
		System.out.println();
		Node.traverseList(newexapmple_1.merge());
		
		
		
	}
}
