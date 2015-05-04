package trees;

import common_files.Tree_Node;

public class BSTBalancing {

	public BSTBalancing() {
		// TODO Auto-generated constructor stub
	}
	
	public Tree_Node balanceRight(Tree_Node root){
		Tree_Node rightRoot = root.getRight();
		root.setRight(rightRoot.getLeft());
		rightRoot.setLeft(root);
		return rightRoot;
	}
	
	public Tree_Node balanceLeft(Tree_Node root){
		Tree_Node leftRoot = root.getLeft();
		root.setLeft(leftRoot.getRight());
		leftRoot.setRight(root);
		return leftRoot;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
