package arrays;

public class FindDuplicates {

	/* 
	Problem: Find duplicates in O(n) time and O(1) extra space

	Given an array of n elements which contains elements from 0 to n-1, with any of these 
	numbers appearing any number of times. Find these repeating numbers in O(n) and using 
	only constant memory space.

	For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 
	and 6.
	
	*/
	public FindDuplicates() {
		// TODO Auto-generated constructor stub
	}

	public static void printDuplicates(int[] input){
		// The idea is to negate the number present at the index 'i'
		// If you encounter negative number then that has already been present. 
		// The problem statement states that we have input from 0 to (n-1)
		int size = input.length;
		for(int i=0; i<size; i++){
			if(input[Math.abs(input[i])] < 0)
				System.out.print(Math.abs(input[i]));
			else{
				input[Math.abs(input[i])] = 0 - input[Math.abs(input[i])];
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 1, 3, 6, 6};
		FindDuplicates.printDuplicates(input);
	}
}
