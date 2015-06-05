package arrays;

public class FindPairSumsUpToK {

	/*Problem: Given a sorted and rotated array, find if there is a pair with a given sum
	
	Given an array that is sorted and then rotated around an unknown point. Find if array 
	has a pair with given sum ‘x’. It may be assumed that all elements in array are distinct.
	
	Examples:
	
	Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
	Output: true
	There is a pair (6, 10) with sum 16
	
	Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35
	Output: true
	There is a pair (26, 9) with sum 35
	
	Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45
	Output: false
	There is no pair with sum 45.

	 * */
	
	private int[] input;
	
	public FindPairSumsUpToK(int[] input) {
		// TODO Auto-generated constructor stub
		this.setInput(input);
	}

	public int findMaxElementInArray(){
		int i=0;
		int size = this.input.length;
		for(i=0; i<size-1; i++){
			if(this.input[i]>this.input[i+1])
				break;
		}
		return i;
	}
	
	public boolean findPair(int K){
		int maxIndex = this.findMaxElementInArray();
		int minIndex = 0;
		int size  = this.input.length;
		if(maxIndex < size - 1)
			minIndex = maxIndex+1;
		
		while( maxIndex != minIndex ){
			// Loop will terminate only when we find the pair or no pair at all!
			if(this.input[maxIndex] + this.input[minIndex] == K){
				// Found the pair.
				return true;
			}else{
				if(this.input[maxIndex] + this.input[minIndex] > K){
					// Reduce the maxIndex.
					if(maxIndex == 0)
						maxIndex = size;
					maxIndex--;
				}else{
					if(minIndex == size-1)
						minIndex = -1;
					minIndex++;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = {11, 15, 6, 8, 9, 10};
		int arr[] = {11, 15, 26, 38, 9, 10};
		FindPairSumsUpToK newFindPairSumsUpToK = new FindPairSumsUpToK(arr);
		boolean result = newFindPairSumsUpToK.findPair(45);
		System.out.print(result);
	}

	/**
	 * @return the input
	 */
	public int[] getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(int[] input) {
		this.input = input;
	}

}
