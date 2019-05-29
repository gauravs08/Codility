package com.Codility.challenge;

import java.util.HashSet;

public class HyperInCodility {

	public static void main(String[] args) {
		// int[] A = { 1, 2, 5, 4, 5, -1 }; // {5,5,5,5,5,5};//{ 2, -4, 6, -3, 9 };
		int[] A = { 1, 2, -1 };
		System.out.println("length = " + solution(A));

	}

	public static int solution(int A[]) {
		int res = 1;
		int N = A.length;

		HashSet<Integer> set = new HashSet<Integer>();

		// N length is from 1 - 200000
		if (N > 200000) {
			return 0;
		}

		for (int i = 0; i < N;) {

			if (A[i] == -1) {
				System.out.println(A[i]);

				return res;
			} else {
				// Checking Infinite loop
				if (set.contains(A[i])) {
					return 0;
				} else {

					set.add(A[i]);
					i = A[i];
					System.out.println(i);
					if (i >= N) {
						return 0;
					}
				}

				res++;
			}
		}
		return res;
	}

}
