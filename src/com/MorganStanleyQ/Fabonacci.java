package com.MorganStanleyQ;

public class Fabonacci {
	/*			
	 * 			0 	1	 1	 2	 3	 5	 8	 13	 21
	 * 	last,sum = 0   nxt = 1
	 * 		cur 0 ---> n
	 */

	public static void main(String[] args) {
		long sTime = 0;
		double totalTime = 0;

		System.out.println("=====Fabonacci using Dynamic Programing======");

		sTime = System.currentTimeMillis();

		Fabonacci.getFabonacciDP(35);
		System.out.println("\nTime taken = " + (System.currentTimeMillis() - sTime));
		// Fabonacci.fibonacci(35);

		// uses recursion
		System.out.println("=====Fabonacci using Recursive function======");
		sTime = System.currentTimeMillis();
		int fibSeriesRec[] = fibByRec(35);
		for (int i : fibSeriesRec) {
			System.out.print(i + " ");
		}
		totalTime = (System.currentTimeMillis() - sTime);
		System.out.println("\nRecurive fuc time taken = " + totalTime);
	}

	public static void getFabonacciDP(int number) {

		//int last = 0, next = 1, curr = 0, sum = 0;
		int last = 0, curr = 0 , sum = 0, next = 1;
		
		while (curr < number) {
			System.out.print(last + " ");
			
			sum = last + next;
			last = next;
			next = sum;

			curr++;
		}

	}

// -----Using recursion function-----------
	public static int fibonacci(int num) {
		if (num == 0) {
			return 0;
		} else if (num == 1 || num == 2) {
			return 1;
		} else {
			return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}

	public static int[] fibByRec(int num) {
		int fib[] = new int[num];

		for (int i = 0; i < num; i++) {
			fib[i] = fibonacci(i);
		}

		return fib;
	}

}
