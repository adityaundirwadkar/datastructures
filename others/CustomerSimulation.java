package others;
import java.util.HashSet;


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
