package others;
import java.util.Scanner;

public class SudokuVerifyer {
	/* Problem: Given a string of 81 integers, verify if the numbers represented in a 9x9 grid is a valid sudoku or not.
	*/
	public SudokuVerifyer() {
		// TODO Auto-generated constructor stub
	}
	
	private static boolean checkGrid(int arr[][], int startRow , int startCol, int gridSize){
        
        boolean found[] = new boolean[9]; // default value is false
        for(int i= startRow; i<startRow+gridSize;++i){
            for (int j=startCol; j<startCol+gridSize;++j){
                if(!found[(arr[i][j]-1)]){
                    found[(arr[i][j]-1)] = true;
                }
                else
                    return false;//since the duplicate is found
            }
        }        
        return true; // no duplicate found
    }
    
    private static boolean checkForALLGrids(int arr[][]){
        // Check that the grid contain no duplicate values
        for (int startRow = 0; startRow < 7; startRow += 3){
          for (int startCol = 0; startCol < 7; startCol += 3){
            if (!checkGrid(arr, startRow, startCol, 3)){
              //System.out.println(false);
              return false;
            }
          }
        }                
        return true;
    }
    
    public static int[][] getSudokuMatrix(String input){
    	int[][] sudoku = new int[9][9];
    	int count = 0;
    	for(int i=0; i<9; i++){
			for(int j=0; j<9;j++){
				sudoku[i][j] = Character.getNumericValue(input.charAt(count++));
			}
		}
    	return sudoku;
    }
    
    public static boolean checkRows(int[][] sudoku, int flag){
    	int val =0;
    	for(int i = 0; i<9 ;i++){
			boolean[] flagArray = new boolean[9];
			for(int j=0;j<9;j++){
				if(flag == 1){
					val = sudoku[i][j]-1;
				}else{
					val = sudoku[j][i]-1;
				}
				if(flagArray[val] == false)
					flagArray[val] = true;
				else{
					//Error;
					return false;
				}
			}
		}
    	return true;
    }
    
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[][] sudoku = new int[9][9];
	
		sudoku = getSudokuMatrix(input);
		boolean result = checkRows(sudoku, 1);
		if(result){
			result = checkRows(sudoku, 2);
			if(result){
				result = checkForALLGrids(sudoku);
				if(result){
					System.out.print("1");
					return;
				}
			}
		}
		System.out.print("0");
	}
}
