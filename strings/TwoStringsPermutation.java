package strings;

public class TwoStringsPermutation {

	private String input_1;
	private String input_2;
	
	/**
	 * @return the input_1
	 */
	public String getInput_1() {
		return input_1;
	}

	/**
	 * @param input_1 the input_1 to set
	 */
	public void setInput_1(String input_1) {
		this.input_1 = input_1;
	}

	/**
	 * @return the input_2
	 */
	public String getInput_2() {
		return input_2;
	}

	/**
	 * @param input_2 the input_2 to set
	 */
	public void setInput_2(String input_2) {
		this.input_2 = input_2;
	}
	
	public TwoStringsPermutation(String input_1, String input_2) {
		// TODO Auto-generated constructor stub
		this.setInput_1(input_1);
		this.setInput_2(input_2);
	}
	
	public boolean checkPermutation(){
		int[] input_1_char = new int[256];
		int loopVariable = 0;
		int input1Size = this.getInput_1().length();
		
		if(input1Size != this.getInput_2().length())
			return false;
		
		while(loopVariable < input1Size){
			input_1_char[this.getInput_1().charAt(loopVariable++)] += 1;
		}
		
		loopVariable = 0;
		while(loopVariable < input1Size){
			if((--input_1_char[this.getInput_2().charAt(loopVariable++)]) < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStringsPermutation newTwoStringsPermutation = new TwoStringsPermutation("abcd", "ddcb");
		boolean temp = newTwoStringsPermutation.checkPermutation();
		System.out.println(temp);
	}

}
