package strings;

public class NonRepeating {

	private String inputString;
	
	public NonRepeating(String inputString) {
		// TODO Auto-generated constructor stub
		this.setInputString(inputString);
	}

	public char NonRepeatingCharacter(){
		//Find first non repeating character from input string.
		
		int[] characters = new int[265];
		char[] charArray = this.getInputString().toCharArray();
		int loopVariable = 0;
		
		while(loopVariable < charArray.length){
			// Traverse entire array character by character.
			characters[charArray[loopVariable]] += 1;
			loopVariable++;
		}
		
		loopVariable = 0;
		while(loopVariable < charArray.length){
			// Traverse entire array character by character.
			if(characters[charArray[loopVariable]] == 1)
				return charArray[loopVariable];
			loopVariable++;
		}
		return '\0';
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonRepeating newNonRepeating = new NonRepeating("abcdabcd");
		char test = newNonRepeating.NonRepeatingCharacter();
		System.out.println("" + test);
	}

	/**
	 * @return the inputString
	 */
	public String getInputString() {
		return inputString;
	}

	/**
	 * @param inputString the inputString to set
	 */
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

}
