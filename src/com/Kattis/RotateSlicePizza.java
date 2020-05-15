package com.Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/*
https://www.hackerrank.com/contests/round-1-holiday-cup/challenges/biggest-slice
* You are sharing a large, circular pizza with n − 1 of your friends.
* Your technique for slicing the pizza is shown in Figure 1;
* you rotate the pizza clockwise about its center by angle θ,
* and then you make a slice from the center of the pizza straight to the right.
*  You repeat this process, rotating by the same angle θ and
* slicing to the right until you have done it a total of n times.

i1.png

Of course, this isn’t really a good way to divide a pizza (unless θ is well-chosen).
* Some of the resulting slices may be larger than others, and you may not even end up with n different slices.
* You don’t care so much about fairness. You just want to know how big the largest slice will be,
* so you can take it for yourself.

Input Format

Input begins with an integer 1 ≤ m ≤ 200 indicating the number of test cases that follow.
* The following m lines each contain one test case. Each test case gives the pizza radius in centimeters, r,
* followed by the number of people sharing the pizza, n, followed by the rotation angle, θ. The quantities r,
* n and θ are all positive. The value r is an integer no greater than 100, and n is an integer no greater than 108.
*  The angle θ is given as an integer number of degrees, followed by an integer number of minutes and an integer number
* of seconds. Degrees are between 0 and 359 (inclusive), while minutes and seconds are between 0 and 59 (inclusive).

Output Format

For each test case, print the area in square centimeters of the largest resulting slice of pizza.
*  You do not need to worry about the precise formatting of the answer (e.g. number of places past the decimal),
*  but the absolute error of your output must be smaller than 10−4.

Sample Input

4
20 6 60 0 0
20 6 59 59 59
30 20 33 30 0
40 200 120 0 0

Sample Output

209.439510
209.444358
263.108385
1675.516082

Explanation

Source: 2013 ICPC North America Qualifier*/
public class RotateSlicePizza {

    public static void main(String[] args) throws IOException {
        List<String[]> lines = new ArrayList<>();
        try {
            lines = readInput();
            computeEachInputLines(lines);
        } catch (NumberFormatException nfe) {
            // Incorrect Number
        } catch (Exception e) {
            //Some other exception
        }
    }

    static void computeEachInputLines(List<String[]> lines) {
        for (String[] line : lines) {
            BigDecimal result = calculateBiggestSlice(Integer.parseInt(line[0]), Integer.parseInt(line[1]),
                    Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]));
            //BigDecimal result = calculateBiggestSlice(20,6,60,0,0); //mySliceLargest: 209.4395102359172
            //BigDecimal result = calculateBiggestSlice(20,6,59,59,59); //mySliceLargest: 209.4443583761306
            //BigDecimal result = calculateBiggestSlice(30,20,33,30,0); //mySliceLargest: 263.10838473814516
            //BigDecimal result = calculateBiggestSlice(40, 200, 120, 0, 0); //mySliceLargest: 1675.5160819145563
            result = result.setScale(6, RoundingMode.HALF_UP);
            System.out.println(result.toString());
        }

    }

    static List<String[]> readInput() throws IOException {
        List<String[]> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineCounter = Integer.MAX_VALUE;
        int currentLineNo = 1;
        while (currentLineNo <= lineCounter) { //check null reference
            //1. First read no of line to read.
            if (lineCounter == Integer.MAX_VALUE) {
                String[] firstLine = br.readLine().split(" ");
                if (firstLine.length > 1) {
                    //This is Incorrect Input
                } else {
                    lineCounter = Integer.parseInt(firstLine[0]);
                }
            }
            //2. Read all lines untill count reaches lineCounter
            String[] eachLine = br.readLine().split(" ");
            lines.add(eachLine);
            currentLineNo++;
        }
        return lines;
    }

    //DD= D + (M/60) + (S/3600)
    static double calculateDegreeFromDMS(int degree, int min, int sec) {
        return degree + (min / 60d) + (sec / 3600d);
        //return new BigDecimal(degree).add(new BigDecimal(min / 60)).add(new BigDecimal(sec / 3600));
    }

    //Area of sector = Q* Pie/360*radius*radius
    static BigDecimal areaOfSlice(double r, double degree) {
        return BigDecimal.valueOf(degree * Math.PI * r * r / 360d);
    }

    static BigDecimal calculateBiggestSlice(double r, int n, int d, int m, int s) {
        //1. calculate DD from DMS
        double DD = calculateDegreeFromDMS(d, m, s);
        System.out.println("DD: " + DD);

        //2.Area of whole circle.
        BigDecimal AA = new BigDecimal(Math.PI * r * r);
         System.out.println("AA: " + AA);

        //3.Equal share  = AA /n
        BigDecimal equalShare = new BigDecimal(AA.doubleValue() / n);
         System.out.println("equalShare: " + equalShare);

        //4. Area of Sector
        BigDecimal sliceArea = areaOfSlice(r, DD);
         System.out.println("sliceArea: " + sliceArea);

        //5. sum of all sector area
        double sumOfSliceArea = sliceArea.doubleValue() * n;
        System.out.println("sumOfSliceArea: " + sumOfSliceArea);

        //6. difference of allSlice area vs AA
        BigDecimal diff = AA.subtract(new BigDecimal(sumOfSliceArea));
         System.out.println("diff: " + diff);

        BigDecimal mySliceLargest = sliceArea.add(diff);
        System.out.println("mySliceLargest: " + mySliceLargest);

        //if slice are negative, take average slice
        mySliceLargest = mySliceLargest.setScale(6, RoundingMode.HALF_UP);
        equalShare = equalShare.setScale(6, RoundingMode.HALF_UP);

        if (mySliceLargest.compareTo(equalShare) < 0) {
            mySliceLargest = sliceArea;
        }

        return mySliceLargest;
    }
}
