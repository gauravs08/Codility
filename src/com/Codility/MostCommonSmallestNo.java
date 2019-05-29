package com.Codility;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Vaddin Question to find most common number in two array.
public class MostCommonSmallestNo {

	public static void main(String[] args) {
		MostCommonSmallestNo c = new MostCommonSmallestNo();
		int[] A = { 1, 5, 4, 6 };
		int[] B = { 1, 6, 5 };  
		long start = System.nanoTime();

		System.out.println(c.solution(A, B));
		long diff = System.nanoTime() - start;
		System.out.println("Time To execute: " + diff / 1000000 + "ms");
		
		start = System.nanoTime();
		System.out.println(c.solution2(A, B));
		diff = System.nanoTime() - start;
		System.out.println("Time To execute: " + diff / 1000000 + "ms");
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

	int solution2(int[] a,int []b) {
		Arrays.sort(a);
		Arrays.sort(b);
		
		List<Integer> list1 = Arrays.stream(a)
									.boxed()
									.collect(Collectors.toList());
		List<Integer> list2 = Arrays.stream(b)
				.boxed()
				.collect(Collectors.toList());
		
		return list1.stream()
	    .filter(list2::contains)
	    .collect(Collectors.toList()).get(0).intValue();

	}
}
