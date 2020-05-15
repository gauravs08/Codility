package com.Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiceGame {
    private static String EMMA = "Emma", GUNNAR = "Gunnar", TIE = "Tie";
    private static int gunSum = 0, emaSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] gunnerRoll = reader.readLine().split(" ");
        String[] emmaRoll = reader.readLine().split(" ");

        calculateSum(gunnerRoll, emmaRoll);

        generateResult();

    }

    public static void calculateSum(String[] gunnerRoll, String[] emmaRoll) {
        for (int i = 0; i < gunnerRoll.length; i++) {
            gunSum += Integer.parseInt(gunnerRoll[i]);
            emaSum += Integer.parseInt(emmaRoll[i]);
        }
    }

    public static void generateResult() {
        if (emaSum > gunSum) {
            System.out.println(EMMA);
        } else if (emaSum < gunSum) {
            System.out.println(GUNNAR);
        } else {
            System.out.println(TIE);
        }
    }
}
