package bit_manipulation;

public class MultipleOf3 {

	/*
		Problem: Write an Efficient Method to Check if a Number is Multiple of 3
		
		The very first solution that comes to our mind is the one that we learned in school. 
		If sum of digits in a number is multiple of 3 then number is multiple of 3 e.g., for 
		612 sum of digits is 9 so it’s a multiple of 3. But this solution is not efficient. You 
		have to get all decimal digits one by one, add them and then check if sum is multiple of 
		3.
		
		There is a pattern in binary representation of the number that can be used to find if 
		number is a multiple of 3. If difference between count of odd set bits (Bits set at 
		odd positions) and even set bits is multiple of 3 then is the number.
		
		Example: 23 (00..10111)
		1) Get count of all set bits at odd positions (For 23 it’s 3).
		2) Get count of all set bits at even positions (For 23 it’s 1).
		3) If difference of above two counts is a multiple of 3 then number is also a multiple 
		of 3. 
	 */
	public MultipleOf3() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isMultipleOf3(int number){
		number = Math.abs(number);	// Remove the negative sign from the number.
		if(number < 1)				// Number is 0.
			return true;
		if(number < 3)				// Number is 1 or 2.
			return false;
		
		// Else the number is >= 3.
		int flag = 0;
		int odd_bits = 0;
		int even_bits = 0;
		while(number > 0){
			// Right shift the number bit by bit and add the bit value to odd_bits/even_bits
			// depending upon the value of flag value.
			if(flag == 0)
				odd_bits += (number & 1);
			else
				even_bits += (number & 1);
			number = (number >> 1);
			flag = 1 - flag;
		}
		if(isMultipleOf3(odd_bits-even_bits))
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result = isMultipleOf3(-24);
		System.out.print(result);
	}
}
