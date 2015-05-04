package trees;

import common_files.Tree_Node;


public class InOrderSuccessor extends Tree_Node{
	
	private Tree_Node parent;
	
	/**
	 * @return the parent
	 */
	public Tree_Node getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(InOrderSuccessor parent) {
		this.parent = parent;
	}
	
	public InOrderSuccessor(char data, InOrderSuccessor parent) {
		// TODO Auto-generated constructor stub
		super(data);
		this.setParent(parent);
	}
	
	// This function takes input as root of the tree and node whose inorder
	// successor is to be found out.
	public static Tree_Node getInOrderSuccessor(Tree_Node node){
		Tree_Node temp = null;
		if(node == null)
			return null;
		else if(node.getRight() != null){
			// This node has left subtree and InOrder successor will be the
			// leaf node of that subtree.
			node = node.getRight();
			while (node != null && node.getLeft() != null){
				node = node.getLeft();
			}
			return node;
		}else{
			// Given node doesnt have a left subtree.
			// i.e. 1. Node is leftmost leaf node . So we can return its parent node.
			//		2. Node is in right subtree and has no inorder successor.
			//			or node is in left subtree but is right most node where,
			//			inorder successor lies at the root.
			
			temp = ((InOrderSuccessor) node).getParent();
			while(temp.getLeft() != node && temp != null){
				node =  temp;
				temp = ((InOrderSuccessor) temp).getParent();
			}
			return temp;
		}
	}
	
	
	public static Tree_Node InOrderSuccessorNoPartent(Tree_Node root, Tree_Node node){
		// This function considers two cases.
		// 1. If nodes right subtree != null then find leftmost child.
		// 2. If right subtree == null, then start from root, and while traversing tree
		//	  if moving towards left, then update successor with current node.
		//	  else just move towards right.
		
		Tree_Node successor = null;
		if(root == null)
			return null;
		
		if(node.getRight() != null){
			node = node.getRight();
			while(node != null && node.getLeft() != null){
				node = node.getLeft();
			}
			return node;
		}else{
			while(node.getData() != root.getData()){
				if(node.getData() < root.getData()){
					successor = root;
					root.getLeft();
				}else{
					root.getRight();
				}
			}
			return successor;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InOrderSuccessor n1 = new InOrderSuccessor('d', null);
		//Level 1
		InOrderSuccessor n2 = new InOrderSuccessor('b', n1);
		InOrderSuccessor n3 = new InOrderSuccessor('f', n1);
		//Level 2
		InOrderSuccessor n4 = new InOrderSuccessor('a', n2);
		InOrderSuccessor n5 = new InOrderSuccessor('c', n2);
		InOrderSuccessor n6 = new InOrderSuccessor('e', n3);
		InOrderSuccessor n7 = new InOrderSuccessor('g', n3);
		
		n1.setLeft(n2);
		n1.setRight(n3);
		
		n2.setLeft(n4);
		n2.setRight(n5);
		
		n3.setLeft(n6);
		n3.setRight(n7);
		
		try{
			System.out.println(InOrderSuccessor.getInOrderSuccessor(n5).getData());
		}catch (NullPointerException npe){
			System.out.println("null");
		}
		try{
			System.out.println(InOrderSuccessor.getInOrderSuccessor(n7).getData());			
		}catch (NullPointerException npe){
			System.out.println("null");
		}
		try{
			System.out.println(InOrderSuccessor.getInOrderSuccessor(n1).getData());
		}catch (NullPointerException npe){
			System.out.println("null");
		}
		
		
		try{
			System.out.println(InOrderSuccessor.getInOrderSuccessor(n7).getData());
		}catch (NullPointerException npe){
			System.out.println("null");
		}
	}

	

}
