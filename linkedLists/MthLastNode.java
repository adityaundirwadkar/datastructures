package linkedLists;

import common_files.Node;

public class MthLastNode {

	private Node head;
	
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
	
	public MthLastNode(Node head) {
		// TODO Auto-generated constructor stub
		this.setHead(head);
	}

	public Node MthLastNode_1(int MthPlace){
		// This method finds out the length of the list by traversing the entire list
		// and then finds out (n-M) node.
		
		int size = 0;
		Node temp = this.getHead();
		
		while(temp != null){
			size++;
			temp = temp.getNext();
		}
		
		if(size < MthPlace)
			return null;
		
		size = size - (MthPlace+1);
		temp = this.getHead();
		int i = 0;
		while(i < size){
			i++;
			temp = temp.getNext();
		}
		return temp;
	}
	
	public Node MthLastNode_2(int MthPlace){
		// This function uses two pointers where 1st one moves M place first and then
		// second one starts from the head and by the time first one reaches to end
		// second one would reach Mth Place.
		
		Node first, second;
		
		first = this.getHead();
		second = this.getHead();
		
		int i = 0;
		
		while(first != null && i < MthPlace ){
			first = first.getNext();
			i++;
		}
		
		// Total list size is not big enough.
		if(first == null)
			return first;
		
		while(first.getNext() != null){
			second = second.getNext();
			first = first.getNext();
		}
		return second;
	}
	
	public static void main(String args[]){
		Node n1 = new Node('a');
		Node n2 = new Node('b');
		Node n3 = new Node('c');
		Node n4 = new Node('d');
		Node n5 = new Node('e');
		Node n6 = new Node('f');
	
		n1.setNext(n2);n2.setNext(n3);
		n3.setNext(n4);n4.setNext(n5);
		n5.setNext(n6);
		
		MthLastNode newMthLastNode = new MthLastNode(n1);
		Node MthNode = newMthLastNode.MthLastNode_1(3);
		
		System.out.println(MthNode.getData());
		
		MthNode = newMthLastNode.MthLastNode_2(7);
		System.out.println(MthNode.getData());
		
	}

}
