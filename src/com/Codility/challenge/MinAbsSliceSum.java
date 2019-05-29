package com.Codility.challenge;

import java.util.Arrays;

public class MinAbsSliceSum {

/*Problem MinAbsSliceSum:
 * A non-empty array A of N integers is given. 
 * A pair of integers (P , Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
 *  The sum of a slice (P , Q) is the total of A[P] + A[P+1] + ... + A[Q].
 *   A min abs slice is a slice whose absolute sum is minimal.
 *    For example, array A such that: 
 *     A[0] = 2   
 *     A[1] = -4   
 *     A[2] = 6   
 *     A[3] = -3   
 *     A[4] = 9 contains the following slices, among others:
 * 
(0, 1), whose absolute sum = |2 + (−4)| = 2 
(0, 2), whose absolute sum = |2 + (−4) + 6| = 4 
(0, 3), whose absolute sum = |2 + (−4) + 6 + (−3)| = 1 
(1, 3), whose absolute sum = |(−4) + 6 + (−3)| = 1 
(1, 4), whose absolute sum = |(−4) + 6 + (−3) + 9| = 8 
(4, 4), whose absolute sum = |9| = 9
Both slices (0, 3) and (1, 3) are min abs slices and their absolute sum equals 1. 
Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N integers, returns the absolute sum of min abs slice.
 For example, given:  A[0] = 2   A[1] = -4   A[2] = 6   A[3] = -3   A[4] = 9 
 the function should return 1, as explained above.
 Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000]; 
each element of array A is an integer within the range [−10,000..10,000].
	 */
	public static void main(String[] args) {
		int A[] = { -2, -3, 4, -1, -2, 1, 5, -3 };//{ 2, -4, 6, -3, 9 };//
		System.out.println("A ="+Arrays.toString(A));
		
		System.out.println("--------minAbsSliceSoln-----");
		long start = System.nanoTime();
		
		minAbsSliceSoln(A);
		System.out.println(System.nanoTime() - start + " ns");
		System.out.println("-----minSubArraySumWithIndexes--------");
		
		start = System.nanoTime();
		minSubArraySumWithIndexes(A, A.length);
		System.out.println(System.nanoTime() - start + " ns");
		
		System.out.println("-----minSliceSumNotAbs-------");
		start = System.nanoTime();
		minSliceSumNotAbs(A);
		System.out.println(System.nanoTime() - start + " ns");
		
	}

	//100% solution Min Abs slice Sum in an array
	public static void minAbsSliceSoln(int A[]) {
		int min_so_far = Math.abs(A[0]);
		int cur_min = A[0];
		
		
		 System.out.print("[");
		  
		  String str = A[0]+""; System.out.print(str); System.out.println("] ="+str);
		 
		for (int i = 1; i < A.length ; i++) {
			
			  System.out.print("["); str = str+" + "+A[i]; System.out.print(str );
			 	
			
			cur_min += A[i];      //sum of all prev + curr A[i]
			System.out.print("] = "+cur_min);
			
			
			min_so_far = Math.min(Math.abs(cur_min), Math.abs(min_so_far));
			System.out.println(" || abs(min_so_far) ="+min_so_far);
			
			
		}
		//return min_so_far;
		System.out.println("MinAbsSliceSoln = "+min_so_far);
	}
	static void minSubArraySumWithIndexes(int a[], int size) 
    { 
        int min_so_far = Integer.MAX_VALUE, 
        cur_min = 0,start = 0, 
        end = 0, s = 0; 
  
        for (int i = 0; i < size; i++)  
        { 
            cur_min += a[i]; 
          
            if (min_so_far > cur_min)  
            { 
                min_so_far = cur_min; 
                start = s; 
                end = i; 
            } 
  
            if (cur_min < 0)  
            { 
                cur_min = 0; 
                s = i + 1; 
            } 
        } 
        System.out.println("Minimum contiguous sum is " 
                           + min_so_far); 
        System.out.println("Starting index " + start); 
        System.out.println("Ending index " + end); 
    } 
	public static void minSliceSumNotAbs(int A[]) {
		int min_so_far = A[0];
		int curr_min = A[0];

		for (int i = 1; i < A.length ; i++) {
						
			// MAX of (Current , sum of all previous elements +Current)
			// MAX of (A[i]	   , sum of(A[0],A[1]...A[i-1] )+A[i])
			curr_min = Math.min(A[i], curr_min + A[i]);
			
			//System.out.println(curr_min);

			min_so_far = Math.min(curr_min, min_so_far);

		}
		System.out.println(min_so_far);

	}
}
