package com.MorganStanleyQ;

public class Fabonacci {
	/*
	 * 0 1 1 2 3 5 8
	 */

	public static void main(String[] args) {

		Fabonacci.getFabonacciTillcount(10);
		//Fabonacci.fibonacci(10);

		// uses recursion
        int fibSeriesRec[] = fibByRec(10);
        for(int i :fibSeriesRec){
        	System.out.print(i +" ");
        }
        	
	}

	public static void getFabonacciTillcount(int number) {

		int last = 0, next = 1, j = 0, sum = 0;

		while (j < number) {
			System.out.println(last);
			sum = last + next;
			last = next;
			next = sum;

			j++;
		}

	}

	public static int fibonacci(int num)  {
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
