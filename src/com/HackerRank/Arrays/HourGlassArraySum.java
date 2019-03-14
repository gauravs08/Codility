package com.HackerRank.Arrays;


/*
 * HOURGLASS is this pattern in 3X3 array
1 1 1 0 0 0  0 1 1 1 0 0  0 0 1 1 1 0    0 0 0 1 1 1
0 1 0 0 0 0  0 0 1 0 0 0  0 0 0 1 0 0    0 0 0 0 1 0
1 1 1 0 0 0  0 1 1 1 0 0  0 0 1 1 1 0    0 0 0 1 1 1
0 0 0 0 0 0  0 0 0 0 0 0  0 0 0 0 0 0    0 0 0 0 0 0
0 0 0 0 0 0  0 0 0 0 0 0  0 0 0 0 0 0    0 0 0 0 0 0
0 0 0 0 0 0  0 0 0 0 0 0  0 0 0 0 0 0    0 0 0 0 0 0 ...

total 16 this type of patter can be present

eg:

1 1 1 0 0  0  		
0 1 0 0 0  0
1 1 1 0 0  0
0 0 [2 4 4 0
0 0 0 2 0  0
0 0 1 2 4] 0   

o/p 19
-1 -1 0 -9 -2 -2
-2 -1 -6 -8 -2 -5
-1 -1 -1 -2 -3 -4
-1 -9 -2 -4 -4 -5
-7 -3 -3 -2 -9 -9
-1 -3 -1 -2 -4 -5 
o/p -6

 * 
 */
public class HourGlassArraySum {

	static int hourglassSum(int[][] arr) {

		int max =Integer.MIN_VALUE;
		for(int i =0; i< arr.length -2; i++){
			for(int j=0; j< arr.length -2 ; j++){
				max = Math.max(max, getSum(arr, i,j));
			}
		}
		
		return max;

    }
	
	static int getSum(int[][]arr , int loc, int loc2){
		int sum =0;
		for(int i =loc; i< loc+3; i++){
			for(int j=loc2; j<loc2+3; j++){
				if((i==loc+1 && j==loc2+2) || (i==loc+1 && j==loc2)){
					continue;
				} else{
					sum +=arr[i][j];
				}
			}
		}
		System.out.println(sum);
		return sum;
	}
	
	public static void main(String[] args) {
		
		int n=6;
		int[][] arr = new int[n][n];
		int k =0;
		/*
		 int[] arrRowItems = {1,1,1,0,0,0,
				 			  0,1,0,0,0,0,
				 			  1,1,1,0,0,0,
				 			  0,0,2,4,4,0,
				 			  0,0,0,2,0,0,
				 			  0,0,1,2,4,0};*/
		 int[] arrRowItems = {-1,-1,0,-9,-2,-2,-2,-1,-6,-8,-2,-5,-1,-1,-1,-2,-3,-4,-1,-9,-2,-4,-4,-5,-7,-3,-3,-2,-9,-9,-1,-3,-1,-2,-4,-5};
			
	        for (int i = 0; i < n; i++,k+=n) {

	            for (int j = 0; j < n; j++) {
	                int arrItem = arrRowItems[k+j];
	                arr[i][j] = arrItem;
	            }
	        }

        int result = hourglassSum(arr);
System.out.println("Max sum of hourglass is :: "+result);
	}

}
