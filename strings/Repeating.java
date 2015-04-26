package strings;

public class Repeating {

	private String inputString;
	
	public Repeating(String inputString) {
		// TODO Auto-generated constructor stub
		this.setInputString(inputString);
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

	
	public char RepeatingCharacter(){
		//Find first repeating character from input string.
		
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
			if(characters[charArray[loopVariable]] > 1)
				return charArray[loopVariable];
			loopVariable++;
		}
		return '\0';
	}
	
	public static void main(String[] args) {
		Repeating newRepeating = new Repeating("a$bccdbcd$");
		char test = newRepeating.RepeatingCharacter();
		System.out.println("" + test);
	}
}
