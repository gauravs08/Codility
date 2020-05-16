package com.Codility.challenge;

/*
 * Given a integer number N return smallest integer > N and Sum of whose number digits  equal to sum of digit of N.
 * for eg. 28
 *  2 + 8 =10
 * next possible same sum will be 29(2+9=11) , 30(3+0=3) , 31(3+1=4) ,32 .... 37(10)
 * o/p 37
 *  for 1000 o/p 10000
 * */
public class ZalandoTest1 {

    public static void main(String[] args) {
        int A = 11;
        //int B = 0;
        System.out.println(solution(A));
    }

    //86% codility evaluation
    public static int solution(int N) {
        int sum = calculateSum(N);

        //if A =100 -> 1000 add 0 and return
        if (sum == 1) {
            return Integer.parseInt(N + "0");
        }

        int nextSum = 0, nextNum = N;
        /*for (int i = 1; nextSum != sum; i++) {
            nextSum = calculateSum(A + i);
            nextNum = i;
        }*/

        for (int i = N + (sum / 2); nextSum != sum; i++) {
            nextSum = calculateSum(N + (i - N));
            nextNum = i;
        }
        return nextNum;
    }

    static int calculateSum(int n) {
        int sum;
        for (sum = 0; n > 0; sum += n % 10, n /= 10) ;
        return sum;
    }
}
