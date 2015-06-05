package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class OrderedArray {
	/* Problem: Group multiple occurrence of array elements ordered by first occurrence
		
		Given an unsorted array with repetitions, the task is to group multiple occurrence 
		of individual elements. The grouping should happen in a way that the order of first 
		occurrences of all elements is maintained.
		
		Examples:
		
		Input: arr[] = {5, 3, 5, 1, 3, 3}
		Output:        {5, 5, 3, 3, 3, 1}
		
		Input: arr[] = {4, 6, 9, 2, 3, 4, 9, 6, 10, 4}
		Output:        {4, 4, 4, 6, 6, 9, 9, 2, 3, 10}
	 */
	
	private int[] input;
	public OrderedArray(int[] input) {
		// TODO Auto-generated constructor stub
		this.setInput(input);
	}

	
	public int[] getOrderedArrayByOccurance(){
		HashMap<Integer, Integer> map;			// Map to store the elements and their respective count.
		map = new HashMap<Integer, Integer>(); 
		int i= 0;
		int count = 0;
		int j = 0;
		int size = this.getInput().length;
		int[] tempbuffer = new int[size];
		for(i=0; i<size; i++){
			if(map.containsKey(this.input[i])){
				// Map contains the element
				count = map.get(this.input[i]) + 1;
			}else{
				count = 1;
			}
			map.put(this.input[i], count);			// Add new entry into the map.
		}
		for(i=0; i<size; i++){
			if(map.containsKey(this.input[i])){
				// Map contains the element
				count = map.get(this.input[i]);
				while(count > 0){
					tempbuffer[j++] = this.input[i];
					count--;
				}
				map.remove(this.input[i]);			// Add new entry into the map.
			}
		}
		return tempbuffer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = {5, 3, 5, 1, 3, 3};
		int arr[] = {4, 6, 9, 2, 3, 4, 9, 6, 10, 4};
		OrderedArray newOrderedArray = new OrderedArray(arr);
		int[] temp = newOrderedArray.getOrderedArrayByOccurance();
		System.out.println(Arrays.toString(temp));
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
