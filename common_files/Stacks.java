package common_files;

public class Stacks {
	
	private Node top;

	public Stacks() {
		// TODO Auto-generated constructor stub
		this.setTop(null);
	}
	
	public boolean push(char data){
		Node newTop = new Node(data);
		newTop.setNext(this.getTop());
		this.setTop(newTop);
		return true;		
	}

	public char pop(){
		if(top == null)
			return '\0';
		Node temp = this.getTop();
		this.setTop(this.getTop().getNext());
		return temp.getData();
	}
	
	public char peek(){
		if(top == null)
			return '\0';
		return this.getTop().getData();
	}
	/**
	 * @return the top
	 */
	public Node getTop() {
		return top;
	}

	/**
	 * @param top the top to set
	 */
	public void setTop(Node top) {
		this.top = top;
	}

}
