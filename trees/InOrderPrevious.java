package trees;

import common_files.Tree_Node;

public class InOrderPrevious {

	public InOrderPrevious() {
		// TODO Auto-generated constructor stub
	}
	
	public static Tree_Node getInOrderPrev(Tree_Node root, Tree_Node node){
		Tree_Node prev = null;
		
		//Case 1:
		if(root == null)
			return null;
		
		// Case 2: 
		if(node.getData() == root.getData()){
			// Our root is the node we are looking for. So prev node will be
			// max of left subtree.
			node = node.getLeft();
			while(node != null && node.getRight() != null){
				node = node.getRight();
			}
			return node;
		}else{
			while(node.getData() != root.getData() && root != null){
				if(node.getData() < root.getData()){
					root = root.getLeft();
				}else{
					prev = root;
					root = root.getRight();
				}
			}
			return prev;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree_Node n1 = new Tree_Node('d');
		//Level 1
		Tree_Node n2 = new Tree_Node('b');
		Tree_Node n3 = new Tree_Node('f');
		//Level 2
		Tree_Node n4 = new Tree_Node('a');
		Tree_Node n5 = new Tree_Node('c');
		Tree_Node n6 = new Tree_Node('e');
		Tree_Node n7 = new Tree_Node('g');

		//Level 0
		n1.setLeft(n2);
		n1.setRight(n3);
		//Level 1
		n2.setLeft(n4);
		n2.setRight(n5);
		//Level 2
		n3.setLeft(n6);
		n3.setRight(n7);
		
		Tree_Node.inOrder(n1);
		System.out.println();
		try{
			System.out.println(n5.getData()+":"+InOrderPrevious.getInOrderPrev(n1,n5).getData());
		}catch (NullPointerException npe){
			System.out.println("null");
		}
		try{
			System.out.println(n7.getData()+":"+InOrderPrevious.getInOrderPrev(n1,n7).getData());			
		}catch (NullPointerException npe){
			System.out.println("null");
		}
		try{
			System.out.println(n1.getData()+":"+InOrderPrevious.getInOrderPrev(n1,n1).getData());
		}catch (NullPointerException npe){
			System.out.println("null");
		}

	}
}
