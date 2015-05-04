package trees;

import common_files.Tree_Node;

public class ParenthesizedTree {
	
	StringBuffer buffer = new StringBuffer();

	public ParenthesizedTree() {
		// TODO Auto-generated constructor stub
	}

	public boolean isLeafNode(Tree_Node node){
		if(node.getLeft() == null && node.getRight() == null)
			return true;
		else
			return false;
	}
	
	public void printParenthesizedTree(Tree_Node root){
		if(root == null)								// Null tree. 
			return;	
		if(isLeafNode(root)){							// Current node is a leaf node.
			buffer.append(root.getData());
		}else{	// Current node is non-leaf node. We can print "(" and ")" for it's children
			buffer.append(root.getData());
			buffer.append(" ( ");
			printParenthesizedTree(root.getLeft());		// Traverse through the Left-subtree.
			if(root.getRight() != null){					// Print comma only if we have right-subtree
				buffer.append(", ");
			}
			printParenthesizedTree(root.getRight());	// Traverse through right-subtree.
			buffer.append(" ) ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree_Node t0 = new Tree_Node('a');		//Root
		Tree_Node t1 = new Tree_Node('b');
		Tree_Node t2 = new Tree_Node('c');
		Tree_Node t3 = new Tree_Node('d');
		Tree_Node t4 = new Tree_Node('e');
		Tree_Node t5 = new Tree_Node('f');
		Tree_Node t6 = new Tree_Node('g');

		//		T0
		//	  /    \
		//	T1		T2
		t0.setLeft(t1);t0.setRight(t2);
		
		//			T0
		//		  /    \
		//		T1		T2
		//	  /    \
		//	T3		T4
		t1.setLeft(t3);
		t1.setRight(t4);
		
		//			T0
		//		  /    \
		//		T1		T2
		//	  /    \    /  \
		//	T3		T4 T5	T6
		t2.setLeft(t5);
		t2.setRight(t6);
		
		ParenthesizedTree parenthesizedTree = new ParenthesizedTree();
		
		parenthesizedTree.printParenthesizedTree(t0);
		System.out.print(parenthesizedTree.buffer.toString());
		
		
		
		t0.setLeft(t1);
		t0.setRight(null);
		t1.setLeft(t3);
		t1.setRight(null);
//		ParenthesizedTree.printParenthesizedTree(t0);
		
//		ParenthesizedTree.printParenthesizedTree(t6);
		
		// Test cases.
		// 1. Null tree.							-> ParenthesizedTree.printParenthesizedTree(null);
		// 2. Single Node.							-> ParenthesizedTree.printParenthesizedTree(t6);
		// 3. Nodes with either of the leaf nodes.	-> ParenthesizedTree.printParenthesizedTree(t0);
		// 4. Complete tree.						-> ParenthesizedTree.printParenthesizedTree(t0);
	}

}
