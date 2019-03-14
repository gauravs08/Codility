package com.Codility;

public class TimeComplexityReduction {

	public static void main(String[] args) {
		int[] A = new int[7];
		
		A[0]=4;
		A[1]=6;
		A[2]=2;
		A[3]=2;
		A[4]=6;
		A[5]=6;
		A[6]=4;
		for(int i=0;i<A.length;i++){
			System.out.println("A["+i+"]="+A[i]);
		}
		TimeComplexityReduction tf = new TimeComplexityReduction();
		
		int result = tf.solution(A);
		System.out.println(result);
	}
	
	int solution(int[] A) {
        int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = N-1; j >i;j-- ) {
                if (A[i] != A[j]) {
                	result = Math.max(result, j - i);
                	break;
                } 
            }                
        return result;
    }

}
