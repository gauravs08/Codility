package com.Codility;

import java.util.Arrays;

/*	PROBLEM:
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
•	The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
•	Write a function:
•	class Solution { public int[] solution(int[] A, int K); }
•	that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
•	For example, given
•	A = [3, 8, 9, 7, 6] K = 3
•	the function should return [9, 7, 6, 3, 8]. Three rotations were made:
•	[3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7] [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9] [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
•	For another example, given
•	A = [0, 0, 0] K = 1
•	the function should return [0, 0, 0]
•	Given
•	A = [1, 2, 3, 4] K = 4
•	the function should return [1, 2, 3, 4]
•	Assume that:
•	N and K are integers within the range [0..100];
•	each element of array A is an integer within the range [−1,000..1,000].
•	In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment. **/
/**
 * TEST CASES: Example tests ▶ example first example test ✔OK ▶ example2 second
 * example test ✔OK ▶ example3 third example test ✔OK ▶ extreme_empty empty
 * array ✔OK ▶ single one element, 0 <= K <= 5 ✔OK ▶ double two elements, K <= N
 * ✘WRONG ANSWER got [5, -1000] expected [-1000, 5] 1. 0.004 s WRONG ANSWER, got
 * [5, -1000] expected [-1000, 5] 2. 0.004 s OK ▶ small1 small functional tests,
 * K < N ✘WRONG ANSWER got [2, 3, 4, 5, 6, 7, 1] expected [6, 7, 1, 2, 3, 4, 5]
 * 1. 0.092 s WRONG ANSWER, got [2, 3, 4, 5, 6, 7, 1] expected [6, 7, 1, 2, 3,
 * 4, 5] 2. 0.092 s WRONG ANSWER, got [-5, -6, -1, -2, -3, -.. expected [-2, -3,
 * -4, -5, -6, -.. ▶ small2 small functional tests, K >= N ✘RUNTIME ERROR tested
 * program terminated with exit code 1 ▶ small_random_all_rotations small random
 * sequence, all rotations, N = 15 ✘WRONG ANSWER got [4, 6, 0, 0, -2, 10, ..
 * expected [-4, 4, 6, 0, 0, -2, .. ▶ medium_random medium random sequence, N =
 * 100 ✘WRONG ANSWER got [-450, -554, 473, 354.. expected [58, 943, 722, 279,
 * -.. ▶ maximal maximal N and K ✘WRONG ANSWER got [710, 807, 568, 560, ..
 * expected [155, 710, 807, 568, ..
 * 
 * 
 */
public class CyclicRotation {

	public int[] solution(int[] A, int K) {

		if (A.length < 1) {
			System.out.println("Length of array is less then 1!!!");
			return A;
		}
		if (K < 1 || K> A.length) {
			System.out.println("K index is less then 1 OR K index is more then length of array!!!");
			return A;
		}

		boolean allValSameCheck = Arrays.stream(A).distinct().count() == 1;
		if (allValSameCheck) {
			return A;
		}

		int size = A.length;
		int[] cyclic = new int[size];
		K %= size;
		for (int i = 0; i < K; ++i) {
			cyclic[i] = A[size - K + i];
		}

		
		for (int i = 0; i < size - K; ++i) {
			cyclic[K + i] = A[i];
		}

		
		return cyclic;
	}

	public static void main(String[] args) {
		CyclicRotation cr = new CyclicRotation();
		int[] A= {5,8,9,7,6,1};
		int i = 3;
		System.out.println(Arrays.toString(A));
		System.out.println("Shifting the list to >> "+ i +" Place");
		System.out.println(Arrays.toString(cr.solution(A, i)));
	}

}
