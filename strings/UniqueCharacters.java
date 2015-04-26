package strings;

public class UniqueCharacters {

	public UniqueCharacters() {
		// TODO Auto-generated constructor stub
	}

	public static boolean UniqueCharactersExtraBuffer(String input){
		int[] checker = new int[256];	// Consider the input as ASCII characters. 
										// So there can be only 256 different characters.
		
		// check if the input itself contains more than 256 characters.
		if((input.length()) > 256)
			return false;
		
		// If not lets validate. 
		for(int i=0; i<(input.length()); i++){
			if(checker[(input.charAt(i))] > 0)
				return false;
			else
				checker[(input.charAt(i))]++;
		}
		return true;
	}
	
	public static boolean UniqueCharactersWithoutBuffer(String input){
		
		
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(UniqueCharacters.UniqueCharactersExtraBuffer("abcdefghijk"));

	}

}
