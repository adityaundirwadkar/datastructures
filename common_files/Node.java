package common_files;

public class Node {

	private char data;
	private Node next;
	
	public Node(char data) {
		// TODO Auto-generated constructor stub
		this.setData(data);
		this.setNext(null);
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
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	public static void traverseList(Node node){
		Node temp = node;
		
		while(temp != null){
			System.out.print(""+ temp.getData()+ ", ");
			temp = temp.getNext();
		}
	}
}
