package others;

public class CircularRobotPath {

	public CircularRobotPath() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isPathCircular(char[] input){
		int size = input.length;
		char[] totalDirections = {'N', 'E', 'S', 'W'};
		int currentDirection = 0;	// This will take N,E,S or W position.
		int[] currentPosition = {0,0};
		int i = 0;
		
		while(i < size){
			if(input[i] == 'L' || input[i] == 'R'){
				// Robot takes the turn.
				// Assign the direction.
				if(input[i] == 'L' ){
					// Decrement the current position.
					currentDirection--;
					if(currentDirection < 0)
						currentDirection = totalDirections.length - 1;
				}else{
					// increment the current position.
					currentDirection++;
					if(currentDirection == totalDirections.length)
						currentDirection = 0;
				}
			}else if(input[i] == 'G'){
				// Moves one unit depending upon the current direction.
				if(totalDirections[currentDirection] == 'N')
					currentPosition[0]++;
				else if(totalDirections[currentDirection] == 'S')
					currentPosition[0]--;
				else if(totalDirections[currentDirection] == 'E')
					currentPosition[1]++;
				else if(totalDirections[currentDirection] == 'W')
					currentPosition[1]--;
			}
			i++;
		}
		
		if(currentPosition[0] == 0 && currentPosition[1] == 0)
			return true;
		else 
			return false;
	}
	
	
	public static void main(String[] args){
		char[] input = ("GLGLGLG").toCharArray();
		System.out.println(CircularRobotPath.isPathCircular(input));
	}
}
