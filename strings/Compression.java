package strings;

public class Compression {

	private String input;
	
	public Compression(String input) {
		// TODO Auto-generated constructor stub
		this.setInput(input);
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

	public String compressString(){
		
		StringBuffer newBuffer = new StringBuffer();
		int size = this.getInput().length();
		int loopVariable = 0;
		char current = this.getInput().charAt(loopVariable);
		int count=0;
		
		
		for(; loopVariable <= size ; loopVariable++){
			if(loopVariable < size && current == this.getInput().charAt(loopVariable)){
				count++;
			}else{
				newBuffer.append(current);
				newBuffer.append(count);
				if(loopVariable < size){
					current = this.getInput().charAt(loopVariable);
				}
				count = 0;
			}
		}
		if(newBuffer.toString().length() < size)
			return newBuffer.toString();
		else
			return this.getInput();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compression newCompression = new Compression("abcd");
		String output = newCompression.compressString();
		System.out.println(output);
	}
}
