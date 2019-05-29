package com.LeetCode;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/largest-sum-of-averages/
 * 
 * We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group. What is the largest score we can achieve?

Note that our partition must use every number in A, and that scores are not necessarily integers.

Example:
Input: 
A = [9,1,2,3,9]
K = 3
Output: 20
Explanation: 
The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
We could have also partitioned A into [9, 1], [2], [3, 9], for example.
That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 */
public class LargestSumOfAverages {

	public static void main(String[] args) {
		int[] A = { 9, 1, 2, 3, 9 };
		int K = 3;
		double res = largestSumOfAverages(A, K);
		System.out.println(res);
	}

	public static double largestSumOfAverages(int[] A, int K) {
		int N = A.length;
		double[] P = new double[N + 1];
		for (int i = 0; i < N; ++i) {
			P[i + 1] = P[i] + A[i];
			
		}
		System.out.println(Arrays.toString(P));
		double[] dp = new double[N];
		for (int i = 0; i < N; ++i)
			dp[i] = (P[N] - P[i]) / (N - i);
		System.out.println(Arrays.toString(dp));
		for (int k = 0; k < K - 1; ++k)
			for (int i = 0; i < N; ++i)
				for (int j = i + 1; j < N; ++j)
					dp[i] = Math.max(dp[i], (P[j] - P[i]) / (j - i) + dp[j]);

		return dp[0];
	}
}
