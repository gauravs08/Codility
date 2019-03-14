package com.HackerRank;

public class AVeryBigSum {

	static long aVeryBigSum(long[] ar) {

		int count =0;
		long sum = 0;
		while(count < ar.length){
			sum+=ar[count++];
		}
		return sum;
    }
	
	public static void main(String[] args) {
		int arCount =5;
			long[] ar = new long[arCount];

	        String[] arItems = {"1000000001" ,"1000000002" ,"1000000003" ,"1000000004" ,"1000000005"}; 

	        for (int i = 0; i < arCount; i++) {
	            long arItem = Long.parseLong(arItems[i]);
	            ar[i] = arItem;
	        }

	        long result = aVeryBigSum(ar);
	        System.out.println(result);

	}

}
