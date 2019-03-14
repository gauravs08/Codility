package com.HackerRank;

/*Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix arr is shown below:
[1 2 3
4 5 6
9 8 9 ]

1+5+9 =15  3+5+9 =17 absolute diff 15-17 =2
 * */
public class DiagonalDifference {

	 static int diagonalDifference(int[][] arr) {
		 int n = arr.length;
		 int sum1=0,sum2=0;
		 
		 for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	            	if(i==j){
	            		sum1+=arr[i][j];
	            	}
	            	
	            	if((i+j == n-1 )){
	            		sum2+=arr[i][j];
	            	}
	            }
	        }
		 
		return Math.abs(sum1-sum2);


	    }
	
	public static void main(String[] args) {
		int n=3;
		int[][] arr = new int[n][n];
		int k =0;
		String[] arrRowItems = {"11", "2", "4",
								"4", "5", "6",
								"10", "8", "-12"};
        for (int i = 0; i < n; i++,k+=n) {

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[k+j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);
System.out.println(result);
	}

}
