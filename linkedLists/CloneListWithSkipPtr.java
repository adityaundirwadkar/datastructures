package linkedLists;

import java.util.HashMap;

public class CloneListWithSkipPtr {
	NewNode root;
	
	public CloneListWithSkipPtr() {
		// TODO Auto-generated constructor stub
	}

	public void getCopy(NewNode root){
		if(root == null)
			return;

		NewNode tempOldList = root;
		NewNode tempNewList	= null;
		NewNode prev = null;
		HashMap<NewNode, NewNode> map = new HashMap<NewNode, NewNode>();
		// Traverse the old list and copy it to new list without copying skip pointers.
		while(tempOldList != null){
			tempNewList = new NewNode(tempOldList.getData());
			if(this.root == null)
				this.root = tempNewList;
			else
				prev.setNext(tempNewList);
			map.put(tempOldList, tempNewList);
			prev = tempNewList;
			tempOldList = tempOldList.getNext();
		}
	    
		tempOldList = root;                              // Start with root node of old list.
		tempNewList = this.root;           	       	     // get start pointer of our new list.
	    while(tempOldList!= null){
	        if(tempOldList.getSkip() != null){       		         // If the old list doesn't have a skip pointer, then proceed.
	            NewNode value = map.get(tempOldList.getSkip()); 		 // Retrieve the node from the new list which corresponds to  the node pointed by skip pointer in original list 
	            tempNewList.setSkip(value);               		 // Assign it to current node's skip pointer.
	        }
	        tempOldList = tempOldList.getNext();              // Move ahead in the old list.
	        tempNewList = tempNewList.getNext();              // Move ahead in new list as well.
	    }
	    // this.root will be pointing to new list.
	}
	
	public static void printList(NewNode root, int flag){
		// Flag value will decide which pointer to choose.
		NewNode temp = root;
		NewNode next = null;
		
		while(temp != null){
			
			// To decide whether to pick next or skip pointer depending upon flag value.
			switch(flag){
				case 1: // move with next pointer.
					next = temp.getNext();
					break;
				case 2: // move with skip pointer.
					next = temp.getSkip();
					break;
			};
			
			// If loop just for printing -> characters for other than tail node.
			if(next != null)
				System.out.print(temp.getData()+ " -> ");
			else
				System.out.print(temp.getData()+ ".");
			
			// Move ahead in the list.
			switch(flag){
			case 1: // move with next pointer.
				temp = temp.getNext();
				break;
			case 2: // move with skip pointer.
				temp = temp.getSkip();
				break;
			};
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloneListWithSkipPtr original = new CloneListWithSkipPtr();
		CloneListWithSkipPtr clone = new CloneListWithSkipPtr();

		NewNode n1 = new NewNode(1);
		NewNode n2 = new NewNode(2);
		NewNode n3 = new NewNode(3);
		NewNode n4 = new NewNode(4);
		NewNode n5 = new NewNode(5);
		
		n1.setNext(n2);n1.setSkip(n3);
		n2.setNext(n3);n2.setSkip(n5);
		n3.setNext(n4);n3.setSkip(n2);
		n4.setNext(n5);n4.setSkip(null);
		n5.setNext(null);n5.setSkip(n4);
		
		original.setRoot(n1);
		CloneListWithSkipPtr.printList(original.getRoot(), 1);
		CloneListWithSkipPtr.printList(original.getRoot(), 2);
		
		clone.getCopy(n1);
		CloneListWithSkipPtr.printList(clone.getRoot(), 1);
		CloneListWithSkipPtr.printList(clone.getRoot(), 2);
	}
	
	/**
	 * @return the root
	 */
	public NewNode getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(NewNode root) {
		this.root = root;
	}
}


class NewNode {
	private int data;
	private NewNode next;
	private NewNode skip;

	public NewNode(int i) {
		// TODO Auto-generated constructor stub
		this.setData(i);
		this.setNext(null);
		this.setSkip(null);
	}

	/**
	 * @return the skip
	 */
	public NewNode getSkip() {
		return skip;
	}

	/**
	 * @param skip the skip to set
	 */
	public void setSkip(NewNode skip) {
		this.skip = skip;
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

	/**
	 * @return the next
	 */
	public NewNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(NewNode next) {
		this.next = next;
	}
	
}