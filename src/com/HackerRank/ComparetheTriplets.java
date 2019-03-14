package com.HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/*We define the rating for Alice's challenge to be the triplet a=(a[0],a[1],a[2]) , b=(b[0],b[1],b[2])
 * and the rating for Bob's challenge to be the triplet .
 * Your task is to find their comparison points by comparing  with ,  with , and  with .

If a[i]>b[i], then Alice is awarded  point.
If a[i]<b[i], then Bob is awarded  point.
If a[i==b[i], then neither person receives a point.
Comparison points is the total points a person earned.

Given  and , determine their respective comparison points.

For example,  and . For elements , Bob is awarded a point because . For the equal elements  and , no points are earned. Finally, for elements ,  so Alice receives a point. Your return array would be  with Alice's score first and Bob's second.

o/p should be like [ACounts,BCounts]
 * */
public class ComparetheTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
int m = a.size();

List<Integer> res = new ArrayList();
    	int countA = 0 ,countB = 0 ;
    	
    	for(int i =0; i< m;i++){
    		if(a.get(i) > b.get(i) ){
    			countA++;
    		}else if(a.get(i) < b.get(i) ){
    			countB++;
    		}
    	}
    	
    	res.add(0, countA);
    	res.add(1, countB);
    	
    	return res;
    }

    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());*/
 List<Integer> a1 = Arrays.asList(11,12,13);
 List<Integer> b1 = Arrays.asList(10,14,1);
        List<Integer> result = compareTriplets(a1, b1);

        System.out.println(result);
     /*   bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
