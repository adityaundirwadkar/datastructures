package sorting;

import java.util.Arrays;

public class MergeInPlace {

	private int[] arrayA;
	private int[] arrayB;
	private int sizeA;
	
	public MergeInPlace(int[] arrayA, int[] arrayB, int sizeA) {
		// TODO Auto-generated constructor stub
		this.setSizeA(sizeA);
		this.setArrayB(arrayB);
		this.setArrayA(arrayA);
	}
	
	public void mergeInPlace(){
		int endA, endB;
		endA = this.getSizeA() - 1;
		
		int sizeA = this.arrayA.length - 1;
		endB = this.arrayB.length - 1;
		if(endA < endB)
			return;
		
		while(endB >= 0){
			while(this.arrayA[endA] > this.arrayB[endB]){
				this.arrayA[sizeA--] = this.arrayA[endA--];
			}
			this.arrayA[sizeA--] = this.arrayB[endB--];
		}
		System.out.println(Arrays.toString(this.arrayA));
		
	}

	public static void main(String args[]){
		int[] A = {1,2,3,4,5,6,7,8,9,10};
		int[] B = {2,4,6,8,10,11,12,14};
	
		//{1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 10, 10, 11, 12, 14}
		
		MergeInPlace newMergeInPlace = new MergeInPlace(A, B, A.length);
		newMergeInPlace.mergeInPlace();
	}
	
	
	public int getSizeA() {
		return sizeA;
	}

	public void setSizeA(int sizeA) {
		this.sizeA = sizeA;
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
		int sizeA = arrayA.length + this.arrayB.length;
		this.arrayA = new int [sizeA];
		for(int i=0; i<arrayA.length; i++){
			this.arrayA[i] = arrayA[i];
		}
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
