package com.HackerRank.WarmUpChallenges;

/*
 * Complete the countingValleys function in the editor below. 
 * It must return an integer that denotes the number of valleys Gary traversed.

countingValleys has the following parameter(s):

n: the number of steps Gary takes
s: a string describing his path
Input Format

The first line contains an integer n, the number of steps in Gary's hike. 
The second line contains a single string s, of n characters that describe his path.
Sample i/p
8
UDDDUDUU
O/p
1
Explanation of problem
_/\      _
   \    /
    \/\/
 */
public class CountingValleys {
	
    static int countingValleys(int n, String s) {

    	int seaLevel =0;
    	boolean valleyCheck = false;
    	int valleyCount=0;
    	
    	char[] stringToCharArray = s.toCharArray();
    	 
		for (char c : stringToCharArray) {
			if(Character.toString(c).equals("U")){
    			seaLevel++;
    			if(valleyCheck && seaLevel==0){
    				valleyCount++;
    				valleyCheck =false;
    			}
    		}else if(Character.toString(c).equals("D")){
    			seaLevel--;
    		}
    		
    		if(seaLevel < 0){
    			valleyCheck = true;
    		}
		}
    	
    	return valleyCount;
    }
	public static void main(String[] args) {
		 int n = 8;
        String s ="UDDDUDUU";

        int result = countingValleys(n, s);

        System.out.println(result);

	}

}
