package sorting;

import java.util.Arrays;

public class FindMedian {

	private int[] arrayA;
	private int[] arrayB;
	
	public FindMedian(int[] arrayA, int[] arrayB) {
		// TODO Auto-generated constructor stub
		this.setArrayA(arrayA);
		this.setArrayB(arrayB);
	}
	
	
	public float findMedianExtraMemory(){
		int sizeA = this.getArrayA().length;
		int sizeB = this.getArrayB().length;
		int[] arrayC = new int[sizeA + sizeB];
		int sizeC = sizeA + sizeB;
		while(true){
			while(sizeA > 0 && sizeB > 0){
				//Merger two arrays into external array.
				if(this.getArrayA()[sizeA - 1] > this.getArrayB()[sizeB - 1]){
					arrayC[--sizeC] = this.getArrayA()[sizeA - 1];
					sizeA--;
				}else{
					arrayC[--sizeC] = this.getArrayB()[sizeB - 1];
					sizeB--;
				}
			}
			while(sizeA > 0){
				arrayC[--sizeC] = this.getArrayA()[sizeA - 1];
				sizeA--;
			}
			while(sizeB > 0){
				arrayC[--sizeC] = this.getArrayB()[sizeB - 1];
				sizeB--;
			}
			break;
		}
		System.out.println(Arrays.toString(arrayC));
		sizeC = arrayC.length;
		
		if(sizeC % 2 == 0){
			//even elements. find the two and take avg.
			return ((float)arrayC[sizeC/2 - 1]+ (float)arrayC[sizeC/2])/2;
		}else{
			return (arrayC[sizeC/2]);
		}
	}
	
	public float findMedianLinear(){
		int sizeA = this.arrayA.length;
		int sizeB = this.arrayB.length;
		
		int current = 0, previous = 0, loopVariable = 0;
		int medianStop;
		boolean flag = false;	//remains false if the there are odd number of elements in A+B.
		
		medianStop = (sizeA+sizeB);
		int i = 0;
		int j = 0;
		if(medianStop % 2 == 0)
			flag = true;		// Odd
		
		
		while(loopVariable <= (medianStop/2)){
			if(i == sizeA){
				previous = current;
				current = this.arrayB[j++];
			}else if(j == sizeB){
				previous = current;
				current = this.arrayA[i++];
			}else{
				if(this.arrayA[i] < this.arrayB[j]){
					previous = current;
					current = this.arrayA[i++];
				}else{
					previous = current;
					current = this.arrayB[j++];
				}
			}
			loopVariable++;
		}
		if(flag){
			return ((float)current + (float)previous)/2;
		}else{
			return ((float)current);
		}
	}
	
	public static void main(String args[]){
		int[] A = {0,1};
		int[] B = {2,3,4,5,6,7,8,9,10};
		
		FindMedian newFindMedian = new FindMedian(A, B);
		
		float median = newFindMedian.findMedianExtraMemory();
		System.out.println(median);
		
		median = newFindMedian.findMedianLinear();
		System.out.println(median);
	}
	
	

	/**
	 * @return the arrayA
	 */
	public int[] getArrayA() {
		return arrayA;
	}

	/**
	 * @param arrayA the arrayA to set
	 */
	public void setArrayA(int[] arrayA) {
		this.arrayA = arrayA;
	}

	/**
	 * @return the arrayB
	 */
	public int[] getArrayB() {
		return arrayB;
	}

	/**
	 * @param arrayB the arrayB to set
	 */
	public void setArrayB(int[] arrayB) {
		this.arrayB = arrayB;
	}

}
