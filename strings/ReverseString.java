package strings;

public class ReverseString {

	private String input;
	
	public ReverseString(String input) {
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

	
	public String reverseExtraMemory(char delimeter){
		char[] revertedString = new char[this.getInput().length()];
		int  size = this.getInput().length();
		int totalDelimeters = 0;
		int i=0, j;
		
		// Traverse the list to get the total number of words in our input.
		while(i<size){
			if(this.getInput().charAt(i) == delimeter)
				totalDelimeters++;
			i++;
		}
		j = 0;
		int k = size-1;
		int start;
		int end;
		
		// i -> for loop for total number of words.
		// j -> index for currently traversed string.
		// k -> current index of copied string.
		
		for(i=0;i <= totalDelimeters; i++){
			start = j;
			while(size > j && this.getInput().charAt(j) != delimeter)
				j++;
			end = j-1;
			while(start <= end)
				revertedString[k--] = this.getInput().charAt(end--);
			if(k > 0)
				revertedString[k--] = this.getInput().charAt(j);
			j++;
		}
		System.out.println(new String(revertedString));
		return new String(revertedString);
	}
	
	public void reverse(int start, int last, char[] input){
		char temp;
		while(start<last){
			// Swap the characters at start and last!
			temp = input[start];
			input[start] = input[last];
			input[last] = temp;
			start++;
			last--;
		}
	}
	
	public String reverseRecursion(char delimeter){
		char[] revertedString = this.getInput().toCharArray();
		int size = this.getInput().length();
		
		// Reverse the entire string.
		this.reverse(0, size-1, revertedString);
		
		// Reverse each word one by one.!
		for(int i=0; i< size; i++){
			// Mark start of the word.
			int start = i;
			// Get the end character for the word.
			while(i< size && revertedString[i] != delimeter)
				i++;
			// Now reverse the entire word.
			this.reverse(start, i-1, revertedString);
		}
		System.out.println(new String(revertedString));
		return new String(revertedString);
	}
	
	public static void main(String[] args) {
		ReverseString newReverseString = new ReverseString("copy");
		
		newReverseString.reverseExtraMemory(' ');
		newReverseString.reverseRecursion(' ');
	}
}
