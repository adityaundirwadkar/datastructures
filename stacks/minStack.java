package stacks;

import common_files.Stacks;

public class minStack {

	private Stacks newStack;
	private Stacks auxStack;
	
	public minStack() {
		// TODO Auto-generated constructor stub
		this.newStack = new Stacks();
		this.auxStack = new Stacks();
	}

	/**
	 * @return the newStack
	 */
	public Stacks getNewStack() {
		return newStack;
	}

	/**
	 * @param newStack the newStack to set
	 */
	public void setNewStack(Stacks newStack) {
		this.newStack = newStack;
	}

	/**
	 * @return the auxStack
	 */
	public Stacks getAuxStack() {
		return auxStack;
	}

	/**
	 * @param auxStack the auxStack to set
	 */
	public void setAuxStack(Stacks auxStack) {
		this.auxStack = auxStack;
	}


	public boolean push(char data){
		this.newStack.push(data);
		if(this.auxStack.peek() == '\0' || this.auxStack.peek() > data){
			this.auxStack.push(data);
		}
		return true;
	}
	
	public char pop(){
		if(this.newStack.peek() != '\0'){
			char temp = this.newStack.pop();
			if(temp <= this.auxStack.peek())
				this.auxStack.pop();
			return temp;
		}else
			return '\0';
	}
	
	public char getMin(){
		return this.auxStack.peek();
	}
	
	
	
	public static void main(String args[]){
		minStack newminStack = new minStack();
		
		newminStack.push('i');
		newminStack.push('h');
		newminStack.push('g');
		newminStack.push('f');
		newminStack.push('e');
		newminStack.push('d');
		newminStack.push('c');
		newminStack.push('b');
		newminStack.push('a');
		
		while(newminStack.getMin() != '\0'){
			System.out.println(newminStack.getMin());
			newminStack.pop();
		}
	}
}
