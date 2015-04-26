package trees;

import common_files.*;

class TreeNodeWrapper{
	private int index;
	private int max;
	private char[] nodes;
	public TreeNodeWrapper(String input){
		this.index = 0;
		this.max = input.length()-1;
		this.nodes = input.toCharArray(); 
	}
	
	public int getMax() {
		return max;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public char getNodes(int index) {
		return nodes[index];
	}
}

public class Serializable {

	private Tree_Node root;
	
	public Serializable(Tree_Node root) {
		// TODO Auto-generated constructor stub
		this.setRoot(root);
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
	
	public void toString(Tree_Node root, StringBuffer toStringTree){
		// Nothing to do here! Lets move up!
		if(root == null)
			return;
		
		toStringTree.append("" +root.getData());
		
		//Check if Leaf node!
		if(root.getLeft() == null && root.getRight() == null){
			toStringTree.append("#");
		}else{
			if(root.getLeft() != null){
				toString(root.getLeft(), toStringTree);
			}else{
				toStringTree.append("$");
			}

			if(root.getRight() != null){
				toString(root.getRight(), toStringTree);
			}else{
				toStringTree.append("$");
			}
		}
	}
	
	public String serialize(){
		String serializable = null;
		StringBuffer toStringTree;
		toStringTree = new StringBuffer();
		
		toString(this.root, toStringTree);
		serializable = toStringTree.toString();

		return serializable;
	}
	
	
	public Tree_Node createTree(TreeNodeWrapper treeNodeWrapper){
		
		//Build current node. 
		Tree_Node root = new Tree_Node(treeNodeWrapper.getNodes(treeNodeWrapper.getIndex()));
		// Move index to next one.
		treeNodeWrapper.setIndex(treeNodeWrapper.getIndex()+1);
		
		if(treeNodeWrapper.getIndex()>=treeNodeWrapper.getMax()  || treeNodeWrapper.getNodes(treeNodeWrapper.getIndex()) == '#'){
			//Check if leaf node or end of the string.
			treeNodeWrapper.setIndex(treeNodeWrapper.getIndex()+1);
		}else{
			//Check if left branch is null.
			if(treeNodeWrapper.getNodes(treeNodeWrapper.getIndex()) == '$'){
				root.setLeft(null);
				//Move forward.
				treeNodeWrapper.setIndex(treeNodeWrapper.getIndex()+1);
			}else{
				root.setLeft(createTree(treeNodeWrapper));
			}
			//Check if right branch is null.
			if(treeNodeWrapper.getNodes(treeNodeWrapper.getIndex()) == '$'){
				root.setRight(null);
				//Move forward.
				treeNodeWrapper.setIndex(treeNodeWrapper.getIndex()+1);
			}else{
				root.setRight(createTree(treeNodeWrapper));
			}
		}
		return root;
		
	}
	public Tree_Node deserialize(String input){
		Tree_Node root = null;
		TreeNodeWrapper treeNodeWrapper = new TreeNodeWrapper(input);
		
		if(input == null){
			return null;
		}
		root = createTree(treeNodeWrapper);
		return root;
	}
	
	public static void main(String args[]){
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
		
		Tree_Node.inOrder(t0);
		System.out.println("");
		Serializable newRoot = new Serializable(t0);
		String outputString ;
		outputString = newRoot.serialize();
		System.out.println("To string: "+outputString);
		
		
		Tree_Node root = null;
		root = newRoot.deserialize("abd#$c$g#");
		Tree_Node.inOrder(root);
	}
}
