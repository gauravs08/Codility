package com.Codility;

import java.util.Arrays;
import java.util.HashMap;

/*PROBLEM: A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
For example, in array A such that:
A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9
•	the elements at indexes 0 and 2 have value 9,
•	the elements at indexes 1 and 3 have value 3,
•	the elements at indexes 4 and 6 have value 9,
•	the element at index 5 has value 7 and is unpaired.
Write a function:
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
For example, given array A such that:
A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9
the function should return 7, as explained in the example above.
Write an efficient algorithm for the following assumptions:
•	N is an odd integer within the range [1..1,000,000];
•	each element of array A is an integer within the range [1..1,000,000,000];
•	all but one of the values in A occur an even number of times.

 * */
/*TEST CASE:
▶ simple1 simple test n=5 ✔OK
▶ simple2 simple test n=11 ✔OK
▶ extreme_single_item [42] ✔OK
▶ small1 small random test n=201 ✘WRONG ANSWER 
got 0 expected 42 
▶ small2 small random test n=601 ✔OK
medium random test n=2,001 ✘TIMEOUT ERROR 
running time: 0.11 sec., time limit: 0.10 sec.
1. 0.108 s TIMEOUT ERROR,  running time: 0.11 sec., time limit: 0.10 sec.
medium random test n=100,003 ✘WRONG ANSWER 
got 0 expected 500000
1. 0.624 s WRONG ANSWER,  got 0 expected 500000
▶ big1 
big random test n=999,999, multiple repetitions ✘WRONG ANSWER 
got 0 expected 700
1. 4.080 s WRONG ANSWER,  got 0 expected 700
▶ big2 
big random test n=999,999 ✔OK
1.	6.528 s OK

 * */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        HashMap<Integer,Integer> occurs = new HashMap<>();
        
         for(int i=0;i<A.length;i++){
            if(occurs.containsKey(A[i]) && occurs.get(A[i]) == 1){
                 occurs.remove(A[i]);  
             }else{
                 occurs.put(A[i],1);
             }
         }
         
	 	for(int key : occurs.keySet()){
	             return key;    
	         }
	         return 0;
	     }

	public static void main(String[] args) {
		OddOccurrencesInArray o = new OddOccurrencesInArray();
		int[] A= {9,9,9,9,9,9};
		System.out.println(Arrays.toString(A));
		System.out.println(o.solution(A));
	}

}
