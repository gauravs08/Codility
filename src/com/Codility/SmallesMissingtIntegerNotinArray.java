package com.Codility;

import java.util.HashSet;

/*
 * Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

public class SmallesMissingtIntegerNotinArray {

	public static void main(String[] args) {
		int A[]= {2,1,3,4,6};	
		System.out.println(solution(A));
	}
//100%
	public static int solution(int[] A) {
		HashSet<Integer> collection = new HashSet<Integer>();
		int smallnum = 1;

		for (int i = 0; i < A.length; i++) {
			collection.add(A[i]);
		}

		while (collection.contains(smallnum)) {
			smallnum++;
		}

		return smallnum;
	}
}
