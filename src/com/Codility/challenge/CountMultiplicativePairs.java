package com.Codility.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

/*		int[] A = { 0, 1, 2, 2, 3, 5 };

		int[] B = { 500000, 500000, 0, 0, 0, 20000 } 
 * 		
 * 	C[] =A+ (B/1000000)  eg 0+ 5000000/500000 = 0.50
 * so C[] = {0.5,1.5,2.0,2.0,3.0,5.02};
 * 
 * if any C[P]*C[Q] >= C[P]+C[Q]  then count++;
 * 
 * */
public class CountMultiplicativePairs {

	public int solution(int[] A, int[] B) {
		// write your code in Java SE 8
		int count = 0;
		int N = A.length;

		if (N == 0 || N == 1)
			return 0;
		if (B.length <= 1)
			return 0;
		
		Set<String> all = new HashSet<String>();
		float C[] = new float[N];
		// C = A + B /1000000

		for (int i = 0; i < N; i++) {
			// C[i] = new BigDecimal((double) A[i] + B[i] / 1000000f).setScale(2,
			// RoundingMode.HALF_UP);
			C[i] = A[i] + ((float) B[i] / 1000000);
			System.out.println(C[i]);

		}

		for (int i = 0; i <= N - 1; i++) {
			for (int P = i; P <= N - 1; P++) {
				
				if (C[i] * C[P] >= (C[i] + C[P]) && !all.contains(C[i] * C[P] + "-"+(C[i] + C[P]))) {
					//System.out.println(C[i] * C[P] + ">=" + (C[i] + C[P]));
						count++;
						all.add(C[i] * C[P] + "-"+(C[i] + C[P]));
					}
				}
		}
		if (count > 1000000000)
			return 1000000000;

		return count;
	}

	public int solution2(int[] A, int[] B) {
		// write your code in Java SE 8
		int n = A.length;
		if (n == 0 || n == 1)
			return 0;
		if (B.length <= 1)
			return 0;

		int count = 0;
		float[] C = new float[n];
		for (int i = 0; i < n; i++) {
			C[i] = A[i] + ((float) B[i] / 1000000);
			// System.out.println(C[i]);
		}
		for (int i = 0; i < n - 1; i++) {
			if (C[i] >= 2.0 && C[i + 1] >= 2.0) {
				count += ((n - 1 - i) * (n - i)) / 2;
				// System.out.println(C[i]+"---"+count);
				i = n;
			} else {
				for (int j = i + 1; j < n; j++) {
					// System.out.println(C[i]+"---"+C[j]+"--"+(C[i]*C[j]));
					// System.out.println(C[i].multiply(C[j]));
					// System.out.println(C[i].add(C[j]));
					if ((C[i] * C[j]) >= (C[i] + (C[j]))) {
						count++;
						// System.out.println(C[i]+"---"+C[j]);
					}
				}
			}
		}

		if (count > 1000000000)
			return 1000000000;

		return count;
	}

	public static void main(String[] args) {
		CountMultiplicativePairs obj = new CountMultiplicativePairs();
		int[] A = {5,5};//{ 0, 1, 2, 2, 3, 5 };// {5,5};////{ 0, 1, 2, 2, 3, 5 };// {5,5,5,5,5,5};//{ 2, -4, 6, -3, 9 };

		int[] B = {5,5};//{ 500000, 500000, 0, 0, 0, 20000 };// {5,5};//{999999};//{ 500000, 500000, 0, 0, 0, 20000 };//
														// {5,5,5,5,5,5};//{ 2, -4, 6, -3, 9 };
		System.out.println(obj.solution(A, B));

	}
}
