package linkedLists;

import common_files.Node;

public class CircularList {
	
	private Node head;

	public CircularList(Node start) {
		// TODO Auto-generated constructor stub
		this.setHead(start);
	}

	public boolean IsListCircular(){
		Node slow;
		Node fast;
		slow = fast = this.getHead();
		
		// Traverse through the list to verify whether we have a loop or not.
		while(fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(slow == fast)
				return true;
		}// End of loop
		
		//we have exited the loop, which indicates list isn't circular.
		return false;
	}
	
	public Node findCircularNode(){
		Node slow;
		Node fast;
		slow = fast = this.getHead();
		
		// Traverse through the list to verify whether we have a loop or not.
		while(fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(slow == fast)
				break;
		}// End of loop
		
		// List is not circular.
		if(slow != fast)
			return null;
		
		//  List is circular.
		slow = this.getHead();
		
		while(slow != fast){
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return slow;
	}
	
	@SuppressWarnings("unused")
	public boolean IsCircularNoPointers(){
		
		Node start = this.getHead();
		
		
		return true;
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
		n6.setNext(n3);
		
		CircularList newCircularList = new CircularList(n1);
		if(newCircularList.IsListCircular())
			System.out.println("Yes! list is circular.");
		else
			System.out.println("No!");
		
		Node temp = newCircularList.findCircularNode();
		if(temp != null)
			System.out.println("List is circular at Node: "+ temp.getData());
		else
			System.out.println("No!");
		
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

}
