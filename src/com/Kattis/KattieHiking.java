package com.Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KattieHiking {
    public static void main(String[] args) throws IOException {
        List<String[]> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while (!(temp = br.readLine()).equals("0")) { //check null reference
            String[] eachLine = temp.split(" ");
            String[] modifiedArray = Arrays.copyOfRange(eachLine, 1, eachLine.length);
            lines.add(modifiedArray);
        }

        processAllTrips(lines);
    }

    public static void processAllTrips(List<String[]> lineList) {
        for (String[] line : lineList) {
            int sumTotal = 0;
            int arr[] = parseIntArray(line);
            for (int i = 0; i < arr.length; i++)
                sumTotal += arr[i];
            subsetSumDynamic(arr, sumTotal);
        }
    }


    public static List<Integer> parseLinesToInteger(List<String> lineList) {
        return lineList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    static int[] parseIntArray(String[] arr) {
        return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
    }

    static Integer[] parseIntArrayNew(String[] arr) {

        int[] data = Stream.of(arr).mapToInt(Integer::parseInt).toArray();
        Integer[] ever = IntStream.of(data).boxed().toArray(Integer[]::new);
        return ever;
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
               // printSubsets(T, sum2, n, A);
                if (sum1 > sum2) {
                    System.out.print(sum1 + " ");
                    System.out.println(sum2);
                } else {
                    System.out.print(sum2 + " ");
                    System.out.println(sum1);
                }
                break;
            } else {
                sum1 = sum1 - 1;
                sum2 = sum - sum1;
                //System.out.print(sum1+":");
                // System.out.println(sum2);
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
