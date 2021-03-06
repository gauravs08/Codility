package com.Codility.challenge;


/* get Maximum contribution from Fornt-end and Back-end team with F count
 * given A = { 4, 2, 1 }
 * 		 B = { 2, 5, 3 } and F=2 means total no of workers from A will be F 
 * 						 and N-F from B  where N is no of workers in A or B 
 * o/p// 10 =[4,5,1] 
 * 
 */
public class MaxFontbackDeveloperFromArrays {

	public int solution(int[] A, int[] B, int F) {

		int N = B.length;
		int res = 0;
		int countA = 0,countB= 0;
		int[] equal = new int[N];
		
		int i = 0, j = 0;
		for (; (countA < F  && countB < N -F ) && i < A.length; i++, j++) {
			if (A[i] > B[j]) {
				System.out.println(A[i]);
				res += A[i];
				countA++;
			} else if (A[i] < B[j])  {
				System.out.println(B[j]);
				res += B[j];
				countB++;
			}
			if(A[i]==B[j]){
				equal[i] =1;
			}
		}
		int index =0; 
		for (int k : equal) {
			if(k ==1){
				if(countA <F){
					res += A[index];countA++;
				}else if(countB <N-F){
					res += B[index];countB++;
				}
			}
			index++;
		}
		
		
		while (countA < F) {
			System.out.println(A[i]);
			res += A[i++];
			countA++;
		}
		while (countB < N-F) {
			System.out.println(B[i]);
			res += B[i++];
			countB++;
		}

		return res;

	}

	public static void main(String[] args) {

		/*int[] A = { 4, 2, 1 };//10 =[4,5,1]
		int[] B = { 2, 5, 3 };//
		*/
		/*int[] A = {7,1,4,3};// 18=[7,3,4,4]
		int[] B = {5,3,4,4};//
		*/
		int[] A = {5,6,7};// 18=[5,4,7]
		int[] B = {1,4,3};//
		
		MaxFontbackDeveloperFromArrays max = new MaxFontbackDeveloperFromArrays();
		int res = max.solution(A, B, 2);
		System.out.println(res);

	}

}
