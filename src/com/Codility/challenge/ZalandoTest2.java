package com.Codility.challenge;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
* Given two array A ={ 4,-1, 0, 3 } & B={ -2, 5, 0, 3 };
* find no of indexes where both can be divided into equal sum of sub array
* for eg.
* */
public class ZalandoTest2 {

    public static void main(String[] args) {


       /* int[] A = { 4,-1, 0, 3 };
        int[] B = { -2, 5, 0, 3 };  // 2, 3 indexes split both into two half with sum 3*/

       /* int[] A = { 2,-2, -3, 3 };
        int[] B = { 0, 0, 4, -4 };  // index 2*/

        /*int[] A = { 4, -1, 0, 3 };  // No index can divide in equal sum sub array
        int[] B = { -2, 6, 0, 4 };/*

        int[] A = { 3, 2, 6 }; // NO index can divide in equal sum sub array
        int[] B = { 4, 1, 6 };*/

        int[] A = { 1, 4, 2,-2, 5 };  //2,4 index divide them into equal parts
        int[] B = { 7,-2,-2, 2, 5 };

        System.out.println("A= "+Arrays.toString(A));
        System.out.println("B= "+Arrays.toString(B));
        System.out.println(findEqualIndexes(A,B,A.length));
        //System.out.println(solution(A,B));
    }

   /* public static int solution(int[] A, int[] B){
        int result =0;
        //if both sum are not equal then return 0

        //int[] arr = { 6, -4, -3, 2, 3 };

        // get index i that points to starting of second sub-array
        int i = partition(A,B);


       *//* if (i != -1)
        {
            // print the first sub-array [0, i-1]
            printSubArray(arr, 0, i - 1);

            // print the second sub-array [i, arr.length)
            printSubArray(arr, i, arr.length - 1);
        }
        else {
            System.out.print("The array can't be partitioned");
        }*//*

        return result;

    }*/

    /*public static int partition(int[] A, int[] B)
    {
        // calculate sum of all elements present in the array
        int total_sum = Arrays.stream(A).sum();

        int [] indexes = new int[A.length];
        int [] sum = new int[A.length];

        // variable to maintain sum of processed elements
        int sum_so_far = 0;
        int count =0;
        // do for each element of the array
        for (int i = 0,j=0; i < A.length; i++)
        {
            // if sum of A[0..i-1] is equal to A[i, n-1]
            if (sum_so_far == total_sum - sum_so_far) {
                //return i;
                indexes[j] =i;
                sum[j] =sum_so_far;
                j++;
                sum_so_far =0;
                count ++;
            }
            // update sum_so_far by including value of the current element
            sum_so_far += A[i];
        }
        System.out.print("Indexes= "+Arrays.toString(indexes));
        System.out.print("Sum= "+Arrays.toString(sum));
        for (int i = 0; i <= count; i++) {
            int [] subArrayB = Arrays.copyOfRange(B, 0, i);

            if(sum[i] != Arrays.stream(subArrayB).sum());
                return 0;

        }

        return 0;
    }*/
    static int findEqualIndexes(int A[], int B[], int n)
    {

        // traverse array element and compute sum
        // of whole array
        int leftSum = 0;
        int [] indexes = new int[A.length];
        int [] sum = new int[A.length];

        for (int i = 0 ; i < n ; i++)
            leftSum += A[i];

        // again traverse array and compute right
        // sum and also check left_sum equal to
        // right sum or not
        int rightSum = 0;
        int count =0;
        for (int i = n-1, j=0; i >= 0; i--)
        {
            // add current element to right_sum
            rightSum += A[i];

            // exclude current element to the left_sum
            leftSum -= A[i] ;

            if (rightSum == leftSum) {
                indexes[j] =i;
                sum[j] =rightSum;
                j++;

                count ++;
            }
        }

        System.out.println("Indexes= "+Arrays.toString(indexes));
        System.out.println("Sum= "+Arrays.toString(sum));
        count = count--;
        int begin =0;
        for (int i = 0; i < count; i++) {

            int [] subArrayB = Arrays.copyOfRange(B, begin, indexes[i]);
            int [] subArrayB2 = Arrays.copyOfRange(B, indexes[i], B.length);

            System.out.println("sub B's = "+Arrays.toString(subArrayB)+ " | "+Arrays.toString(subArrayB2));

            //if both subsets of B are not equal or any subSet of B is not equal to Sum[i] then return no index found.
            if(Arrays.stream(subArrayB).sum() != Arrays.stream(subArrayB2).sum()
                    || sum[i] != Arrays.stream(subArrayB).sum()){
                return 0;
            }
        }
        return count;

    }
    // Utility function to print the sub-array arr[i,j]
    public static void printSubArray(int[] arr, int i, int j)
    {
        System.out.println(IntStream.range(i, j + 1)
                .mapToObj(k -> arr[k])
                .collect(Collectors.toList()));
    }
}
