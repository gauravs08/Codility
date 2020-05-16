package com.Codility.challenge;

import java.util.Arrays;

/*
 * Create a 2 row Binary Martix with given  2 rows rows  and column sum
 *   1 1 0 0 1  U =3
 *   1 0 1 0 0  L = 2
 * -------------
 *   2 1 1 0 1  C
 * If not print IMPOSSIBLE
 * */
public class ZalandoTest3 {
    public static void main(String[] args) {

        int U = 2;
        int L = 3;
        int[] C = {0,0,1,1,2};
        solution(U, L, C);
    }

    public static void solution(int U, int L, int[] C) {
        int result = 0;
        int[] firstRow = new int[C.length];
        int[] secondRow = new int[C.length];

        for (int i = 0; i < C.length; i++) {
            if (C[i] == 2) {
                firstRow[i] = 1;
                U--;
                secondRow[i] = 1;
                L--;
            } else if (C[i] == 1) {
                if (U > 0) {
                    firstRow[i] = 1; U--;
                } else if (L > 0) {
                    secondRow[i] = 1; L--;
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }
        }

        if(U == 0 && L == 0) {
            System.out.println(Arrays.toString(firstRow));
            System.out.println(Arrays.toString(secondRow));
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
