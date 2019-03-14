package com.HackerRank.WarmUpChallenges;

/*Lilah has a string,s , of lowercase English letters that she repeated infinitely many times.

Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.

For example, if the string 'abcac' and  n =10, the substring we consider is 'abcacabcac', 
the first 10 characters of her infinite string. There are 4 occurrences of a in the substring.

eg: aba  10   			o/p 7      10 letter words will be 'abaabaabaa'  7 a's
	a 	 1000000000000  o/p 1000000000000  bcz all letter will be a
 * 
 */
public class RepeatedString {

	
	
	static long repeatedString(String s, long n) {
		
	long noOfStrUsed = n/s.length();
	//String infStr="";
	long remain = n % s.length();
	char[] c = s.toCharArray();
	int countA = 0;

	/*for(long i=0; i<noOfStrUsed ;i++){
		infStr+=s;
	}*/
		
	int extraCountA =0;
		
	for (char d : c) {
		if(Character.toString(d).equals("a")){
			countA++;
		}
		if(remain>0){
			if(Character.toString(d).equals("a")){
				extraCountA++;
			}
			//infStr+=d;
			remain --;
		}
		
	}
	
	//System.out.println("Infinite String with length "+n+":: "+infStr);
	
	
	
	
	return (noOfStrUsed*countA + extraCountA);	

    }
	public static void main(String[] args) {
		String s = "caa";
		System.out.println("String ="+s);

        long n = 1000000;
        long result = repeatedString(s, n);
        
        
        System.out.println(result);
	}

}
