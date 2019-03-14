package com.Codility;

import java.util.Arrays;

// Vaddin Question to find most common number in two array.
public class MostCommonSmallestNo {

	public static void main(String[] args) {
		MostCommonSmallestNo c = new MostCommonSmallestNo();
		int[] B = { 1, 4, 5 };
		int[] A = { 2, 3, 4 ,1};

		System.out.println(c.solution(A, B));

	}

	int solution(int[] A, int[] B) {

		int n = A.length;
		int m = B.length;

		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0, k = 0; k < n; k++) {
			if (i < m - 1 && B[i] < A[k])
				i++;
			if (A[k] == B[i])
				return A[k];
		}
		return -1;
	}

}
