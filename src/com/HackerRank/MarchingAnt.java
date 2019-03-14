package com.HackerRank;
 import java.io.*;
import java.util.*;
public class MarchingAnt {
public static void main(String args[] ) throws Exception {
   
    Scanner sc = new Scanner(System.in);
    int length = sc.nextInt();
    int count = sc.nextInt();
    List<Integer> CockroachPos= new ArrayList<Integer>();
    for(int i=0;i<count;i++){
        CockroachPos.add(sc.nextInt());
    }
    
    int mintime=0;
    for(int i=0;i<count;i++){
        if(Math.min(CockroachPos.get(i),length-CockroachPos.get(i))>mintime){
            mintime=Math.min(CockroachPos.get(i),length-CockroachPos.get(i));
        }
    }
    System.out.print(mintime+" ");
    
    int maxtime=0;
    for(int i=0;i<count;i++){
        if(Math.max(CockroachPos.get(i),length-CockroachPos.get(i))>maxtime){
            maxtime=Math.max(CockroachPos.get(i),length-CockroachPos.get(i));
        }
    }
    System.out.print(maxtime+" ");
}
}


