package com.Codility.challenge;

import java.util.Arrays;

/*Kadane's Algorithm*/
public class LargestSumContiguousSubarray {

	public static void main(String[] args) {

		int A[] = { 2, -4, 6, -3, 9 };//{ -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("A ="+Arrays.toString(A));
		
		long start = System.nanoTime();
		System.out.println(solution(A));
		long end = (System.nanoTime() - start);
		System.out.println(end + " ns");

		System.out.println("-------------");
		
		start = System.nanoTime();
		System.out.println(solution2(A));
		end = (System.nanoTime() - start);
		System.out.println(end + " ns");
		
		System.out.println("-------------");
		
		start = System.nanoTime();
		maxSubArraySumWithIndexes(A, A.length);
		end = (System.nanoTime() - start);
		System.out.println(end + " ns");
		
	}

	// Time Complexity O(n) linear
	public static int solution(int A[]) {
		int max_so_far = 0;
		int max_ending_here = 0;

		for (int i = 0; i < A.length; i++) {
			max_ending_here = max_ending_here + A[i];
			// System.out.println(max_ending_here);
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}

	// Time Complexity O(n) linear faster  Kadane's Algorithm
	public static int solution2(int A[]) {
		int max_so_far = A[0];
		int curr_max = A[0];

		for (int i = 1; i < A.length ; i++) {
						
			// MAX of (Current , sum of all previous elements +Current)
			//MAX(A[i], sum of(A[0],A[1]...A[i-1] )+A[i])
			curr_max = Math.max(A[i], curr_max + A[i]);
			
			// System.out.println(curr_max);

			max_so_far = Math.max(curr_max, max_so_far);

		}
		return max_so_far;

	}
	static void maxSubArraySumWithIndexes(int a[], int size) 
    { 
        int max_so_far = Integer.MIN_VALUE, 
        cur_max = 0,start = 0, 
        end = 0, s = 0; 
  
        for (int i = 0; i < size; i++)  
        { 
            cur_max += a[i]; 
  
            if (max_so_far < cur_max)  
            { 
                max_so_far = cur_max; 
                start = s; 
                end = i; 
            } 
  
            if (cur_max < 0)  
            { 
                cur_max = 0; 
                s = i + 1; 
            } 
        } 
        System.out.println("Maximum contiguous sum is " 
                           + max_so_far); 
        System.out.println("Starting index " + start); 
        System.out.println("Ending index " + end); 
    } 

}
