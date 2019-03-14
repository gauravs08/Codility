package com.HackerRank.WarmUpChallenges;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
 * For example,  there are n=7  socks with colors ar =[1,2,1,2,1,3,2].
 *  There is one pair of color 1  and one of color 2. There are three odd socks left, one of each color. 
 *  The number of pairs is  2.
 *  Function Description

Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

sockMerchant has the following parameter(s):

n: the number of socks in the pile
ar: the colors of each sock
Output Format

Return the total number of matching pairs of socks that John can sell.
 */
public class SockMerchant {

	// Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
    	
    	for (int i : ar) {
			if(hm.containsKey(i)){
				int old = hm.get(i);
				hm.put(i,(old+1));
			} else{
				hm.put(i, 1);
			}
		}
    	int count = 0;
    	for (int val: hm.values())
            if(val >1){
            	count += val/2;
            }
    	
    	//Using Stream and Lambda
    	int sum = hm.entrySet().stream()
    			.filter(m -> m.getValue() > 1 )  // remove all single pair socks
    			.map(m -> m.getValue()/2)       // reduce map to only complete pair means if 3 that mean 1 complete pair if 4 means 2 complete pair
    			.mapToInt(i -> i)
				.sum();
    	
    	
    	return count;

    }
	public static void main(String[] args) {
		 

		String[] arItems = {"1","2","2","1","1","3","5","1","2"};
		int n = arItems.length;   
	        int[] ar = new int[n];

	        //10 20 20 10 10 30 50 10 20

	        for (int i = 0; i < n; i++) {
	            int arItem = Integer.parseInt(arItems[i]);
	            ar[i] = arItem;
	        }

	        int result = sockMerchant(n, ar);
	        System.out.println(result);

	}

}
