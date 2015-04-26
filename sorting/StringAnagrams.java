package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringAnagrams {
	
	private String[] input;
	

	public StringAnagrams(String[] input) {
		// TODO Auto-generated constructor stub
		this.setInput(input);
	}

	public void sortAnagramwise(){
		HashMap<String, ArrayList<String>> sortedInput = new HashMap<String, ArrayList<String>>();
		
		int loopVariable = 0;
		int inputSize = this.getInput().length;
		char[] tempKey;
		ArrayList<String> tempValue;
		
		while(loopVariable<inputSize){
			tempKey = this.input[loopVariable].toCharArray();
			Arrays.sort(tempKey);
			
			if(sortedInput.containsKey(new String(tempKey))){
				//Similar strings already exists.
				tempValue = sortedInput.get(new String(tempKey));
				tempValue.add(this.input[loopVariable]);
				sortedInput.remove(new String(tempKey));
			}else{
				tempValue = new ArrayList<String>();
				tempValue.add(this.input[loopVariable]);
			}
			sortedInput.put(new String(tempKey), tempValue);
			loopVariable++;
		}
		
		
		for(Map.Entry<String, ArrayList<String>> entry : sortedInput.entrySet()){
			loopVariable = entry.getValue().size();
			for(int i=0; i<loopVariable; i++){
				System.out.println(entry.getValue().get(i));
			}
		}
	}
	
	
	public static void main(String args[]){
		
		String[] sample = { "efd", "abc", "dbc", "bcd", "bac", "bca", "def"};
		
		StringAnagrams newStringAnagrams = new StringAnagrams(sample);
		newStringAnagrams.sortAnagramwise();
	}
	
	
	/**
	 * @return the input
	 */
	public String[] getInput() {
		return input;
	}


	/**
	 * @param input the input to set
	 */
	public void setInput(String[] input) {
		this.input = input;
	}

}
