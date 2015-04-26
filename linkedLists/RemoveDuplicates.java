package linkedLists;

import common_files.Node;
import java.util.*;

public class RemoveDuplicates {

	public RemoveDuplicates() {
		// TODO Auto-generated constructor stub
	}
	
	public static Node removeDuplicatesBuffer(Node head){
		HashSet<Character> tempBuffer = new HashSet<Character>();
		Node tempNode = head;
		Node prev = null;
		while(tempNode != null){
			if(tempBuffer.contains(tempNode.getData())){
				// Remove this node.
				prev.setNext(tempNode.getNext());
				
			}else{
				// Add this nodes data into HashSet.
				tempBuffer.add(tempNode.getData());
				prev = tempNode;
			}
			
			tempNode = tempNode.getNext();
		}
		return head;
	}
	
	public static void main(String[] args){
		Node n1 = new Node('a');
		Node n7 = new Node('a');
		
		Node n2 = new Node('b');
		Node n8 = new Node('b');
		
		Node n3 = new Node('c');
		Node n9 = new Node('c');
		
		
		Node n4 = new Node('d');
		Node n5 = new Node('e');
		Node n6 = new Node('f');
		Node n10 = new Node('d');
		Node n11 = new Node('e');
		Node n12 = new Node('f');
		
		n1.setNext(n7);
		n2.setNext(n8);
		n3.setNext(n9);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n11);
		n7.setNext(n2);
		n8.setNext(n3);
		n9.setNext(n4);
		n10.setNext(n11);
		n11.setNext(n12);
		
		Node.traverseList(n1);
		System.out.print("\n");
		Node temp = RemoveDuplicates.removeDuplicatesBuffer(n1);
		Node.traverseList(temp);
	}
}
