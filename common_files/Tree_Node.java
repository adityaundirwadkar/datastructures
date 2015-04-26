package common_files;

public class Tree_Node {

	private char data;
	private Tree_Node left;
	private Tree_Node right;
	
	
	public Tree_Node(char data) {
		// TODO Auto-generated constructor stub
		this.setData(data);			// Set data information.
		this.setLeft(null);			// Set left child as null.
		this.setRight(null);		// Set right child as null.
	}
	/**
	 * @return the data
	 */
	public char getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(char data) {
		this.data = data;
	}


	/**
	 * @return the left
	 */
	public Tree_Node getLeft() {
		return left;
	}


	/**
	 * @param left the left to set
	 */
	public void setLeft(Tree_Node left) {
		this.left = left;
	}


	/**
	 * @return the right
	 */
	public Tree_Node getRight() {
		return right;
	}


	/**
	 * @param right the right to set
	 */
	public void setRight(Tree_Node right) {
		this.right = right;
	}

	
	public static void inOrder(Tree_Node root){
		if(root == null)
			return;
		
		inOrder(root.getLeft());
		System.out.print(root.getData()+",");
		inOrder(root.getRight());
	}
}
