package linkedLists;

import common_files.Node;

public class DeleteNodes {

	/*
	Problem: Delete nodes which have a greater value on right side

	Given a singly linked list, remove all the nodes which have a greater value on right side.

	Examples:
	a) The list 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL. 
	Note that 12, 10, 5 and 2 have been deleted because there is a greater value on the right 
	side.
	
	When we examine 12, we see that after 12 there is one node with value greater than 12 
	(i.e. 15), so we delete 12.
	When we examine 15, we find no node after 15 that has value greater than 15 so we keep 
	this node.
	When we go like this, we get 15->6->3
	
	b) The list 10->20->30->40->50->60->NULL should be changed to 60->NULL. Note that 
	10, 20, 30, 40 and 50 have been deleted because they all have a greater value on the 
	right side.
	
	c) The list 60->50->40->30->20->10->NULL should not be changed.

	 */
	
	
	public DeleteNodes() {
		// TODO Auto-generated constructor stub
	}

	public static Node deleteNextBigNode(Node root){
		if(root == null)
			return null;
		
		Node current = root;
		Node previous = null;
		Node next = null;
		
		//Execute the loop until we reach tail node.
		while(current.getNext() != null){
			next = current.getNext();
			if(next.getData() > current.getData()){
				// Handle root node separately.
				if(previous == null){
					// Lets remove the first node. since our previous is null.
					root = root.getNext();
					current = root;
				}else{
					// Other than second node this will be valid.
					previous.setNext(next);
					current = next;
				}
			}else{
				previous = current;
				current = current.getNext();
			}
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n1 = new Node('a');
		Node n2 = new Node('b');
		Node n3 = new Node('d');
		Node n4 = new Node('c');
		Node n5 = new Node('f');
		Node n6 = new Node('e');
	
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		
//		n6.setNext(n5);
//		n1.setNext(null);
//		n2.setNext(n1);
//		n3.setNext(n2);
//		n4.setNext(n3);
//		n5.setNext(n4);

		Node temp = DeleteNodes.deleteNextBigNode(n1);
		Node.traverseList(temp);
	}

}
