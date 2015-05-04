package sorting;

import java.util.Arrays;

/*	Question:	You are given two sorted arrays, A and B, where A has a large enough 
 * 				buffer at the end to hold B. Write a method to merge B into A in sorted order
 * */
public class MergeAinB {


	public MergeAinB() {
		// TODO Auto-generated constructor stub
	}

	public static void mergeTwoArrays(int[] A, int[] B){
		int sizeA = A.length-1;
		int sizeB = B.length-1;
		
		int lastElementA = sizeA;
		
		while(A[lastElementA] == -1)
			lastElementA--;
		
		if(sizeB > sizeA)
			return ;
		
		while(sizeB >= 0){
			if(B[sizeB] > A[lastElementA]){
				A[sizeA--] = B[sizeB--];
			}else{
				A[sizeA--] = A[lastElementA--];
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] B = {2,4,6,8,10,12,14,16};
		int[] A = {1,3,5,7,9,11,13,15,17,19,21,-1,-1,-1,-1,-1,-1,-1,-1};
		MergeAinB.mergeTwoArrays(A, B);
		System.out.println(Arrays.toString(A));
	}

}
