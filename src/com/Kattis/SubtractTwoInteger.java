package com.Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubtractTwoInteger {
    public static void main(String[] args) throws IOException {
        List<String[]> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while (!(temp=br.readLine()).equals("0")) { //check null reference
            String[] eachLine = temp.split(" ");
            lines.add(eachLine);
        }
        System.out.println(" Receiving from server: " + lines.toString());


       /* Scanner scn = new Scanner(System.in);
                while(scn.hasNextLong()){
                    Long num1 = scn.nextLong();
                    Long num2 = scn.nextLong();
                    System.out.println(Math.abs(num1-num2));
                }*/
    }
}
