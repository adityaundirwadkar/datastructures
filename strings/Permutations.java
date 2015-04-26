package strings;

public class Permutations {

	private String input;
	private StringBuffer newBuffer;
	private boolean[] used;
	
	public Permutations(String input) {
		this.setInput(input);
		used = new boolean[input.length()];
		newBuffer = new StringBuffer();
		// TODO Auto-generated constructor stub
	}

	public void permute(){
		if(this.newBuffer.length() == this.getInput().length()){
			System.out.println(this.newBuffer.toString());
			return;
		}else{
			for(int i=0 ; i< this.input.length(); i++){
				if(this.used[i])
					continue;
				this.newBuffer.append(this.getInput().charAt(i));
				this.used[i] = true;
				permute();
				this.used[i] = false;
				this.newBuffer.setLength(this.newBuffer.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Permutations newPermutations = new Permutations("abc");
		newPermutations.permute();
		
	}


	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}


	/**
	 * @param input the input to set
	 */
	public void setInput(String input) {
		this.input = input;
	}


	/**
	 * @return the newBuffer
	 */
	public StringBuffer getNewBuffer() {
		return newBuffer;
	}


	/**
	 * @param newBuffer the newBuffer to set
	 */
	public void setNewBuffer(StringBuffer newBuffer) {
		this.newBuffer = newBuffer;
	}


	/**
	 * @return the used
	 */
	public boolean[] getUsed() {
		return used;
	}


	/**
	 * @param used the used to set
	 */
	public void setUsed(boolean[] used) {
		this.used = used;
	}
}
