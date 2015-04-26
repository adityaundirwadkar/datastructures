package strings;

public class ReplaceString {
	
	private String input;
	

	public ReplaceString(String input) {
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
	
	public String replaceWithRegex(String orig, String replace){
		
		String regex = "["+orig+"]\\B";
		return this.getInput().replaceAll(regex, replace);
	}
	
	public String replaceWithArray(String orig, String replace){
		char[] replaceArray = replace.toCharArray();
		char[] outputArray;
		
		int inputLength = this.getInput().length();
		int replaceLength = replace.length();
		int loopVariable;
		int count = 0;
		
		for(loopVariable = 0; loopVariable < inputLength; loopVariable++){
			if(this.getInput().charAt(loopVariable) == orig.charAt(0))
				count++;
		}
		
		outputArray = new char[this.getInput().length()+ ((replace.length()-orig.length())*count) ];
		
		int k = outputArray.length-1;
		int j = 0;
		loopVariable--;
		while(loopVariable >= 0){
			if(this.getInput().charAt(loopVariable) ==  orig.charAt(0)){
				j = replaceLength - 1; 
				while(j >= 0){
					outputArray[k--] = replaceArray[j--];
				}
				loopVariable--;
				
			}else{
				outputArray[k--] = this.getInput().charAt(loopVariable--);
			}
		}
		return new String(outputArray);
	}

	public static void main(String[] args) {
		ReplaceString newReplaceString = new ReplaceString("Replace all spaces from this statement.");

		String newString = newReplaceString.replaceWithRegex("aeiou", "#");
//		System.out.println(newString);
		
		
		newString = newReplaceString.replaceWithArray(" ", "%20");
		System.out.println(newString);
	}
}
