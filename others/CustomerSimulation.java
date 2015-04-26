import java.util.HashSet;
/*

Function to find Number of customers who could not get a computer

Write a function “runCustomerSimulation” that takes following two inputs
a) An integer ‘n': total number of computers in a cafe and a string:
b) A sequence of uppercase letters ‘seq': Letters in the sequence occur in pairs. The first occurrence indicates the arrival of a customer; the second indicates the departure of that same customer.

A customer will be serviced if there is an unoccupied computer. No letter will occur more than two times.
Customers who leave without using a computer always depart before customers who are currently using the computers. There are at most 20 computers per cafe.

For each set of input the function should output a number telling how many customers, if any walked away without using a computer. Return 0 if all the customers were able to use a computer.

runCustomerSimulation (2, “ABBAJJKZKZ”) should return 0

runCustomerSimulation (3, “GACCBDDBAGEE”) should return 1 as ‘D’ was not able to get any computer

runCustomerSimulation (3, “GACCBGDDBAEE”) should return 0

runCustomerSimulation (1, “ABCBCA”) should return 2 as ‘B’ and ‘C’ were not able to get any computer.

runCustomerSimulation(1, “ABCBCADEED”) should return 3 as ‘B’, ‘C’ and ‘E’ were not able to get any computer.

*/

public class CustomerSimulation {

	public CustomerSimulation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(CustomerSimulation.runCustomerSimulation(3, ("GACCBGDDBAEE").toCharArray()));
		
	}
	
	public static int runCustomerSimulation(int slots, char[] sequence){
		HashSet<Character> current = new HashSet<Character>();
		HashSet<Character> waiting = new HashSet<Character>();
		int available = slots;
		int size = sequence.length;
		int left = 0;
		int i = 0;
		StringBuffer newBuffer = new StringBuffer();
		while(i< size){
			// Customer is either present in current queue or not.
			if(current.contains(sequence[i])){
				// Remove him from the current and make a slot available.
				current.remove(sequence[i]);
				if(waiting.size() > 0){
					// We have some one who is waiting for the slot. Give him one.
					char temp = newBuffer.charAt(0);
					newBuffer.deleteCharAt(0);
					current.add(temp);
					left--;
				}else{ 
					available++;
				}
			}else if(waiting.contains(sequence[i])){
				// customer was waiting and now is leaving. did not get any of the slot.
				waiting.remove(sequence[i]);
			}else{
				// now depending upon the available slots process.
				if(available > 0){
					current.add(sequence[i]);
					available--;
				}else{
					waiting.add(sequence[i]);
					newBuffer.append(sequence[i]);
					left++;
				}
			}
		i++;
		}
		return left;
	}
}
