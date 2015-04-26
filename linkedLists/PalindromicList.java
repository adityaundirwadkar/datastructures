package linkedLists;

import java.util.Stack;

import common_files.Node;

public class PalindromicList {

	public PalindromicList() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isPalindromicBuffer(Node head){
		Node secondHead = head;
		Node fast = head;
		Stack<Node> tempStack = new Stack<Node>();
		
		// Lets get to the middle.
		while(fast != null && fast.getNext() != null){
			secondHead = secondHead.getNext();
			fast = fast.getNext().getNext();
		}
		
		fast = secondHead;
		// Lets put all of the elements into the stack.
		while(fast != null){
			tempStack.push(fast);
			fast = fast.getNext();
		}
		fast = head;
		while(true){
			// Loop breaks if stack is empty or list is not palindromic.
			if(tempStack.size() < 1 || tempStack.peek().getData() != fast.getData()){
				// True if stack-top is not equal to next node.
				//		if stack is empty but we still have not reached to middle.
				return false;
			}
			
			// Move to next node.
			tempStack.pop();
			if((tempStack.size() == 1 && fast == secondHead) || (fast.getNext() == secondHead)){
				return true;
			}
			fast = fast.getNext();
		}
	}
	
	public static boolean isPalindrom(Node head){
		Node secondHead = head;
		Node fast = head;
		Node prev = null;
		
		// Lets get to the middle.
		while(fast != null && fast.getNext() != null){
			prev = secondHead;
			secondHead = secondHead.getNext();
			fast = fast.getNext().getNext();
		}
		
		// Lets break the list from the middle.
		prev.setNext(null);
		
		// Lets reverse the second list.
		Node temp = null;
		Node next;
		
		while(secondHead != null){
			next = secondHead.getNext();
			secondHead.setNext(temp);
			temp = secondHead;
			secondHead = next;
		}
		secondHead = temp;
		
		
		fast = head;
		// prev is tail of first list.
		
		while(true){
			// Loop breaks if list is palindromic or not.
			if(fast.getData() != secondHead.getData()){
				return false;
			}
			fast = fast.getNext();
			secondHead = secondHead.getNext();
			if(fast==null && (secondHead == null || secondHead.getNext() == null))
				return true;
		}
		
	}
	
	public static void main(String[] args){
		
		Node n1 = new Node('a');
		Node n2 = new Node('b');
		Node n3 = new Node('c');
		Node n4 = new Node('d');
		Node n5 = new Node('e');
		Node n6 = new Node('f');
		Node n7 = new Node('f');
		Node n8 = new Node('f');
		Node n9 = new Node('e');
		Node n10 = new Node('d');
		Node n11 = new Node('c');
		Node n12 = new Node('b');
		Node n13 = new Node('a');
		
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
		n12.setNext(n13);
		
		Node.traverseList(n1);
		System.out.print(PalindromicList.isPalindromicBuffer(n1));
		System.out.print("\n"+PalindromicList.isPalindrom(n1));
	}
	
}
