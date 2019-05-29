package com.Codility;
/*PROBLEM:
 * Count minimal number of jumps from position X to Y.
A small frog wants to get to the other side of the road. 
The frog is currently located at position X and wants to get to a position greater than or equal to Y.
The small frog always jumps a fixed distance, D.
Count the minimal number of jumps that the small frog must perform to reach its target.
Write a function:
class Solution { public int solution(int X, int Y, int D); }
that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
For example, given:
X = 10 Y = 85 D = 30
the function should return 3, because the frog will be positioned as follows:
•	after the first jump, at position 10 + 30 = 40
•	after the second jump, at position 10 + 30 + 30 = 70
•	after the third jump, at position 10 + 30 + 30 + 30 = 100
Write an efficient algorithm for the following assumptions:
•	X, Y and D are integers within the range [1..1,000,000,000];
•	X ≤ Y.

 * */
/*TEST CASE:
 * ▶ example 
example test ✔OK
expand allCorrectness tests
▶ simple1 
simple test ✔OK
▶ simple2 ✔OK
▶ extreme_position 
no jump needed ✔OK
▶ small_extreme_jump 
one big jump ✔OK
expand allPerformance tests
▶ many_jump1 
many jumps, D = 2 ✘TIMEOUT ERROR 
running time: 5.36 sec., time limit: 0.10 sec.
▶ many_jump2 
many jumps, D = 99 ✘TIMEOUT ERROR 
running time: >6.00 sec., time limit: 0.10 sec.
▶ many_jump3 
many jumps, D = 1283 ✘TIMEOUT ERROR 
running time: 5.36 sec., time limit: 0.10 sec.
▶ big_extreme_jump 
maximal number of jumps ✘TIMEOUT ERROR 
running time: >6.00 sec., time limit: 0.10 sec.
▶ small_jumps 
many small jumps ✘TIMEOUT ERROR 
running time: 1.54 sec., time limit: 0.10 sec.*/
public class FrogJmp {

	public int solution(int X, int Y, int D) {

		int count = 0;
		if (Y < X) {
			return 0;
		}
		if (X <= 0 || Y <= 0) {
			return 0;
		}
		for (; X < Y; X += D, count++);

		return count;
	}

	// 100% Score solution
	public int solution2(int X, int Y, int D) {
		int count = 0;
		if (Y < X) {
			return 0;
		}
		if (X <= 0 || Y <= 0) {
			return 0;
		}
		//for x =10 y =85 and D=30  (85-10)/30
		return Double.valueOf(Math.ceil((Y - X) / (double) D)).intValue();
	}

	public static void main(String[] args) {
		FrogJmp fj = new FrogJmp();
		long start = System.nanoTime();

		// int count =fj.solution(10, 100000000, 30);
		int count = fj.solution2(10, 85, 30);

		long diff = System.nanoTime() - start;
		System.out.println("Time To execute: " + diff / 1000000 + "ms");
		System.out.println(count);
	}

}
