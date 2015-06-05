package trees;

import common_files.Tree_Node;

public class BSTtoThreadedBST {

	public BSTtoThreadedBST() {
		// TODO Auto-generated constructor stub
	}

	
	public static void convertBSTtoThreadedBST(Tree_Node root, Tree_Node parent){
		if(root == null)
			return;
		if(root.isLeaf()){
			if(parent != null){
				root.setRight(parent);			// Assign right pointer to its in-order successor.
				System.out.println("Assigning "+ parent.getData()+" as parent of " + root.getData());
			}
				
		}else{									// Recursively call same function on its left and right subtree.
			convertBSTtoThreadedBST(root.getLeft(), root);
			convertBSTtoThreadedBST(root.getRight(), parent);
		}
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
		t1.setLeft(t3);t1.setRight(t4);
		
		//			T0
		//		  /    \
		//		T1		T2
		//	  /    \    /  \
		//	T3		T4 T5	T6
		t2.setLeft(t5);t2.setRight(t6);
		BSTtoThreadedBST.convertBSTtoThreadedBST(t0, null);
		
		
		Tree_Node temp = t3;
		while(temp.getRight() != null){
			System.out.print(temp.getData()+ ", ");
			temp = temp.getRight();
		}
	}
}
