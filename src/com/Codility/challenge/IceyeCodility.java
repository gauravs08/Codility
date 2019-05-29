package com.Codility.challenge;

import java.util.stream.IntStream;

/*minAbsSliceSoln
 * if int[] A = { 2, -4, 6, -3, 9 }
 *  * 
 * find min abs summation of slice of A 
 * eg  (0,1) =  2 + -4 = abs(-2) 		= 2
 * 		(0,2) = 2 + -4 + 6 				= 4
 * 		(0,3) = 2 + -4 + 6 + -3 		= 1
 * 		(1,3) = -4 + 6 + -3 = abs(-1) 	= 1 
 *		...
 *		so min is 1	 
 *
 * */
public class IceyeCodility {

	public int solution(int[] A) {
		// write your code in Java SE 8
		
		int N = A.length;
		int newSum = 0;

		int minSum  = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 1; i++) {
			for (int P = i; P <= N - 1; P++) {
				newSum += A[P];

				minSum = Math.min(minSum, Math.abs(newSum));
				if(minSum==0) {
					return 0;
				}
			}

			//System.out.println("---next loop ::" + i);
			newSum = 0;
		}
		return minSum;

	}
	/*public int solution3(int[] A) {
	    // write your code in Java SE 8
	    int sum = 0;
	    for(int i=0; i<A>=0; i--) {
	        if(rest == 0)
	            break;
	        if(A[i] > rest) {
	            continue;
	        }
	        rest -= A[i];
	        toSum += A[i];
	    }
	    int result1 = Math.abs(sum - 2*toSum);
	    int sum2 = 0;
	    for(int i=0; i<A.length; i++) {
	         if(i%2 == 0) {
	             sum2  += A[i];
	         }else {
	             sum2 -=A[i];
	         }
	     }
	    return Math.min(Math.abs(sum2),result1);
	}*/
	public int solution3(int[] A) {
		// write your code in Java SE 8
		int N = A.length;

		if (N == 1)
		return Math.abs(A[0] * 2);
		java.util.Arrays.sort(A);

		if(A[0] >= 0 && A[N-1] >= 0) // all positive
		return (int) Math.abs((long) A[0] * 2);
		if(A[0] <= 0 && A[N-1] <= 0) // all negative
		return (int) Math.abs((long) A[N-1] * 2);

		long currAbsSum = 0;
		long minAbsSum = Long.MAX_VALUE;

		for (int i = 0; i < N; i++) {
		int j = N - 1;
		while (j >= i) {

		currAbsSum = Math.abs((long) A[i] + (long) A[j]);
		if(currAbsSum == 0) 
		return 0;
		minAbsSum = Math.min(currAbsSum, minAbsSum);

		if (Math.abs(A[i]) >= Math.abs(A[j])) 
		i++;
		else
		j--;
		}
		if(A[i] > 0) break;
		}

		return (int) minAbsSum;
		}
	public int solution2(int [] A) {
		int sums[] = new int[A.length];
		var minAbsSum = Integer.MAX_VALUE;

		sums[0] = 0;
		
		for (var i = 0; i < A.length-1; i++) {
			sums[i + 1] = A[i] + sums[i];
		//	System.out.println(sums[i]);
		}
		sums = IntStream.of(sums).sorted().toArray();
		//sums.sort();
		for (var i = 1; i < sums.length-1; i++) {
			minAbsSum = Math.min(minAbsSum, Math.abs(sums[i] - sums[i - 1]));
		}
	  
	  return minAbsSum;
	}
	public static void main(String[] args) {
		IceyeCodility obj = new IceyeCodility();
		int[] A = {-1,2,3,-4};//{5,5,5,5,5,5};//{ 2, -4, 6, -3, 9 };
		long start = System.nanoTime();

		System.out.println(obj.solution(A));

		long end = System.nanoTime() -start;
		System.out.println(end/1000000+"ms");
	}
}
