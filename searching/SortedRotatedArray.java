package searching;

public class SortedRotatedArray {

	public SortedRotatedArray() {
		// TODO Auto-generated constructor stub
	}
	
	public static int getIndex(int[] input, int start, int last, int item){
		if(last < start)
			return -1;
		
		int mid = (last+start)/2;
		if(input[mid] == item)
			return mid;
		
		// Case where first half is sorted.
		if(input[mid] > input[start]){
			// Check whether item resides in the first half or second.
			if(item<input[mid] && input[start]<item)
				return getIndex(input, start, mid-1, item);
			else
				return getIndex(input, mid+1, last, item);
		}
		// If the second half is sorted.
		else if(input[mid] < input[start]){
			// Check whether item resides in the first half or second.
			if(item<input[mid] && input[start]>item)
				return getIndex(input, start, mid-1, item);
			else
				return getIndex(input, mid+1, last, item);
		}
		// If the either of the half has repeated elements.
		//{ 2,2,2,3,4,2}
		else if(input[mid] == input[start]){
			// Right half is sorted array with distinct elements.
			if(input[mid] != input[last]){
				// Search in right half
				return getIndex(input, mid+1, last, item);
			}else{
				// Search entire array starting from start to mid and then mid to last.
				int result = getIndex(input, start, mid-1, item);		// Search first half.
				if(result < 0){
					return getIndex(input, mid+1, last, item);		// Search second half.
				}
				else
					return result;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] input = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 21, 1, 2, 3, 4, 5};
		int[] input = {2,2,2,3,4,2};
		int result = SortedRotatedArray.getIndex(input, 0, input.length-1, 2);
		
		System.out.println(result);
	}

}
