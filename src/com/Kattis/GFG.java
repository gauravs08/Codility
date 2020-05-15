package com.Kattis;

import java.util.*;

class GFG {
    private static int sum1 = 0, sum2 = 0;

    // Function to find the minimum sum
    public static int findMinRec(int arr[], int i, int sumCalculated, int sumTotal) {
        // If we have reached last element. 
        // Sum of one subset is sumCalculated, 
        // sum of other subset is sumTotal- 
        // sumCalculated.  Return absolute  
        // difference of two sums. 
        if (i == 0) {
            return Math.abs((sumTotal - sumCalculated) -
                    sumCalculated);
        }

        sum1 = sumTotal - sumCalculated;
        sum2 = sumCalculated;

        // For every item arr[i], we have two choices 
        // (1) We do not include it first set 
        // (2) We include it in first set 
        // We return minimum of two choices
        System.out.println(sum2);
        return Math.min(findMinRec(arr, i - 1, sumCalculated + arr[i - 1], sumTotal),
                findMinRec(arr, i - 1, sumCalculated, sumTotal));
    }

    // Returns minimum possible difference between 
    // sums of two subsets 
    public static int findMin(int arr[], int n) {
        // Compute total sum of elements 
        int sumTotal = 0;
        for (int i = 0; i < n; i++)
            sumTotal += arr[i];

        // Compute result using recursive function 
        return findMinRec(arr, n, 0, sumTotal);
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        //int arr[] ={1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int arr[] = {1, 6, 11, 5};
        //int arr[] = { 10,20,15,5,25,33 };
        //int arr[] = {529, 382, 130, 462, 223, 167, 235, 529};
        int arr[] = {528, 129, 376, 504, 543, 363, 213, 138, 206, 440, 504, 418};

        int n = arr.length;
       // System.out.println("The minimum difference between two sets is " +findMin(arr, n));
       // System.out.println("Sum1:" + sum1);
       // System.out.println("Sum2:" + sum2);
        int sumTotal = 0;
        for (int i = 0; i < n; i++)
            sumTotal += arr[i];

        subsetSumDynamic(arr,sumTotal);
           /* for(ArrayList<Integer> r:res){
                System.out.println(r.toString());
                System.out.println(r.stream()
                        .reduce(0, Integer::sum));
            }*/
    }

    //overall O(n^2) time and O(n) space solution using a greedy approach
    public static ArrayList<Integer>[] findEqualPartitionMinSumDif(int A[]){
        //first sort the array - O(nlgn)
        Arrays.sort(A);
        ArrayList<Integer> partition1 = new ArrayList<Integer>();
        ArrayList<Integer> partition2 = new ArrayList<Integer>();

        //create index table to manage largest unused and smallest unused items
        //O(n) space and O(nlgn) time to build and query the set
        TreeSet<Integer> unused = new TreeSet<>();
        for(int i = 0; i<A.length; i++){
            unused.add(i);
        }

        int i = 0;
        int j = A.length-1;
        int part1Sum = 0;
        int part2Sum = 0;
        int diffSum = 0;

        //O(n^2) processing time
        while(unused.size() > 0){
            i = unused.first();
            j = unused.last();
            diffSum = part1Sum-part2Sum;

            //in case of size of the array is not multiple of 4 then we need to process last 3(or 2 or 1)
            //element to assign partition. This is special case handling
            if(unused.size() < 4){
                switch(unused.size()){
                    case 1:
                        //put the 1 remaining item into smaller partition
                        if(diffSum > 0){
                            partition2.add(A[i]);
                            part2Sum += A[i];
                        }
                        else{
                            partition1.add(A[i]);
                            part1Sum += A[i];
                        }
                        break;
                    case 2:
                        //among the remaining 2 put the max in smaller and min in larger bucket
                        int max = Math.max(A[i], A[j]);
                        int min = Math.min(A[i], A[j]);
                        if(diffSum > 0){
                            partition2.add(max);
                            partition1.add(min);
                            part2Sum += max;
                            part1Sum += min;
                        }
                        else{
                            partition1.add(max);
                            partition2.add(min);
                            part1Sum += max;
                            part2Sum += min;
                        }
                        break;
                    case 3:
                        //among the remaining 3 put the two having total value greater then the third one into smaller partition
                        //and the 3rd one to larger bucket
                        unused.remove(i);
                        unused.remove(j);
                        int middle = unused.first();

                        if(diffSum > 0){
                            if(A[i]+A[middle] > A[j]){
                                partition2.add(A[i]);
                                partition2.add(A[middle]);
                                partition1.add(A[j]);
                                part2Sum += A[i]+A[middle];
                                part1Sum += A[j];
                            }
                            else{
                                partition2.add(A[j]);
                                partition1.add(A[i]);
                                partition1.add(A[middle]);
                                part1Sum += A[i]+A[middle];
                                part2Sum += A[j];
                            }
                        }
                        else{
                            if(A[i]+A[middle] > A[j]){
                                partition1.add(A[i]);
                                partition1.add(A[middle]);
                                partition2.add(A[j]);
                                part1Sum += A[i]+A[middle];
                                part2Sum += A[j];
                            }
                            else{
                                partition1.add(A[j]);
                                partition2.add(A[i]);
                                partition2.add(A[middle]);
                                part2Sum += A[i]+A[middle];
                                part1Sum += A[j];
                            }
                        }
                        break;
                    default:
                }

                diffSum = part1Sum-part2Sum;
                break;
            }

            //first take the largest and the smallest element to create a pair to be inserted into a partition
            //we do this for having a balanced distribute of the numbers in the partitions
            //add pair (i, j) to the smaller partition
            int pairSum = A[i]+A[j];
            int partition = diffSum > 0 ? 2 : 1;
            if(partition == 1){
                partition1.add(A[i]);
                partition1.add(A[j]);
                part1Sum += pairSum;
            }
            else{
                partition2.add(A[i]);
                partition2.add(A[j]);
                part2Sum += pairSum;
            }

            //update diff
            diffSum = part1Sum-part2Sum;
            //we have used pair (i, j)
            unused.remove(i);
            unused.remove(j);
            //move j to next big element to the left
            j = unused.last();
            //now find the buddy for j to be paired with such that sum of them is as close as to pairSum
            //so we will find such buddy A[k], i<=k<j such that value of ((A[j]+A[k])-pairSum) is minimized.
            int buddyIndex = unused.first();
            int minPairSumDiff = Integer.MAX_VALUE;
            for(int k = buddyIndex; k<j; k++){
                if(!unused.contains(k))
                    continue;

                int compPairSum = A[j]+A[k];
                int pairSumDiff = Math.abs(pairSum-compPairSum);

                if(pairSumDiff < minPairSumDiff){
                    minPairSumDiff = pairSumDiff;
                    buddyIndex = k;
                }
            }

            //we now find buddy for j. So we add pair (j,buddyIndex) to the other partition
            if(j != buddyIndex){
                pairSum = A[j]+A[buddyIndex];
                if(partition == 2){
                    partition1.add(A[j]);
                    partition1.add(A[buddyIndex]);
                    part1Sum += pairSum;
                }
                else{
                    partition2.add(A[j]);
                    partition2.add(A[buddyIndex]);
                    part2Sum += pairSum;
                }

                //we have used pair (j, buddyIndex)
                unused.remove(j);
                unused.remove(buddyIndex);
            }
        }

        //if diffsum is greater than zero then we can further try to optimize by swapping
        //a larger elements in large partition with an small element in smaller partition
        //O(n^2) operation with O(n) space
        if(diffSum != 0){
            Collections.sort(partition1);
            Collections.sort(partition2);

            diffSum = part1Sum-part2Sum;
            ArrayList<Integer> largerPartition = (diffSum > 0) ? partition1 : partition2;
            ArrayList<Integer> smallerPartition = (diffSum > 0) ? partition2 : partition1;

            int prevDiff = Math.abs(diffSum);
            int largePartitonSwapCandidate = -1;
            int smallPartitonSwapCandidate = -1;
            //find one of the largest element from large partition and smallest from the smaller partition to swap
            //such that it overall sum difference in the partitions are minimized
            for(i = 0; i < smallerPartition.size(); i++){
                for(j = largerPartition.size()-1; j>=0; j--){
                    int largerVal = largerPartition.get(j);
                    int smallerVal = smallerPartition.get(i);

                    //no point of swapping larger value from smaller partition
                    if(largerVal <= smallerVal){
                        continue;
                    }

                    //new difference if we had swapped these elements
                    int diff = Math.abs(prevDiff - 2*Math.abs(largerVal - smallerVal));
                    if(diff == 0){
                        largerPartition.set(j, smallerVal);
                        smallerPartition.set(i, largerVal);
                        return new ArrayList[]{largerPartition, smallerPartition};
                    }
                    //find the pair to swap that minimizes the sum diff
                    else if (diff < prevDiff){
                        prevDiff = diff;
                        largePartitonSwapCandidate = j;
                        smallPartitonSwapCandidate = i;
                    }
                }
            }

            //if we indeed found one such a pair then swap it.
            if(largePartitonSwapCandidate >=0 && smallPartitonSwapCandidate >=0){
                int largerVal = largerPartition.get(largePartitonSwapCandidate);
                int smallerVal = smallerPartition.get(smallPartitonSwapCandidate);
                largerPartition.set(largePartitonSwapCandidate, smallerVal);
                smallerPartition.set(smallPartitonSwapCandidate, largerVal);
                return new ArrayList[]{largerPartition, smallerPartition};
            }
        }

        return new ArrayList[]{partition1, partition2};
    }

    private static boolean subsetSumDynamic(int[] A, int sum) {
        int n = A.length;
        boolean[][] T = new boolean[n + 1][sum + 1];


        // sum2[0][0]=true;

        for (int i = 0; i <= n; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (A[i - 1] > j) {
                    T[i][j] = T[i - 1][j];
                } else {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - A[i - 1]];
                }
            }
        }

        int sum1 = sum / 2;
        int sum2 = sum - sum1;
        while (true) {
            if (T[n][sum1] && T[n][sum2]) {
                //printSubsets(T, sum1, n, A);
                //printSubsets(T, sum2, n, A);
                System.out.println(sum1);
                System.out.println(sum2);
                break;
            } else {
                sum1 = sum1 - 1;
                sum2 = sum - sum1;
                //System.out.println(sum1);
                //System.out.println(sum2);
            }
        }


        return T[n][sum];
    }

    private static void printSubsets(boolean[][] T, int sum, int n, int[] A) {
        List<Integer> sumvals = new ArrayList<Integer>();
        int i = n;
        int j = sum;
        while (i > 0 && j > 0) {
            if (T[i][j] == T[i - 1][j]) {
                i--;
            } else {
                sumvals.add(A[i - 1]);

                j = j - A[i - 1];
                i--;

            }
        }


        System.out.println();
        for (int p : sumvals) {
            System.out.print(p + " ");
        }
        System.out.println();
    }


}
    