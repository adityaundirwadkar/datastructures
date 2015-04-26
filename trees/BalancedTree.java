package trees;

import common_files.Tree_Node;

public class BalancedTree {

	private Tree_Node root;
	
	public BalancedTree() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the root
	 */
	public Tree_Node getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Tree_Node root) {
		this.root = root;
	}
	
	public static int isTreeBalanced(Tree_Node root){
		int left, right;
		
		// Base condition.
		if(root == null)
			return 0;
		
		//Get the height of the left sub-tree.
		left = isTreeBalanced(root.getLeft());
		
		right = isTreeBalanced(root.getRight());
		
		if(left < 0 || right < 0)
			return -1;
		
		if(Math.abs(left-right) > 1)
			return -1;
		else 
			return (Math.max(left, right) + 1);
		
	}
	
	public static boolean isBST(Tree_Node root, int min, int max){
		// Function returns true or false value.
		
		// Base case.
		if(root == null)
			return true;
		
		if(!(root.getData() >= min && root.getData() <= max))
			return false;
		
		boolean left  = isBST(root.getLeft(),min, root.getData());
		if(!left)
			return left;
		
		boolean right = isBST(root.getRight(),root.getData(), max);
		if(!right)
			return right;
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree_Node t0 = new Tree_Node('d');		//Root
		Tree_Node t1 = new Tree_Node('b');
		Tree_Node t2 = new Tree_Node('f');
		Tree_Node t3 = new Tree_Node('a');
		Tree_Node t4 = new Tree_Node('c');
		Tree_Node t5 = new Tree_Node('e');
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
		System.out.println(BalancedTree.isTreeBalanced(t0));
		
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		System.out.println(BalancedTree.isBST(t0, min, max));
		
		
	}
}
