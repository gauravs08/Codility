package com.Codility.challenge;

public class CountBinaryInAfterMultiply {
    public static void main(String[] args) {
        System.out.println(solution(1,-1));
    }

    public static int solution(int A, int B){
        int max=0;

        if(A==0 || B ==0){
            return 0;
        }
        long product = A * B;
        String binary = Long.toBinaryString(product);
        System.out.println(product +" = "+binary);
        //return hammingWeight(product);
       return Long.bitCount(product);
        // return numberOfSetBits((int) product);
    }

    public static int numberOfSetBits(int i)
    {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
    }

    public static int hammingWeight(long n) {
        int count = 0;
        for (int i = 0; i < Long.SIZE; ++i) {
            if (((n >>> i) & 1) == 1) {
                ++count;
            }
        }
        return count;
    }

}
