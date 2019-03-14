package com.HackerRank.WarmUpChallenges;


/* Emma is playing a new mobile game that starts with consecutively numbered clouds. 
 * Some of the clouds are thunderheads and others are cumulus.
 *  She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2. 
 *  She must avoid the thunderheads. 
 *  Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud.
 *   It is always possible to win the game.
 *   
 *   0 is safe 1 is not
 *   if c=[0100010]  0->2->4->6  [3 jumps] OR 0->2->3->4->6 [4 jumps] 
 *   min is 3.
 *   eg 0 0 1 0 0 1 0 o/p 4 
 *   eg 0 0 0 0 1 0   o/p 3
 */
public class JumpingOnTheClouds {

	static int jumpingOnClouds(int[] c) {
		int jumps = 0;
		
		for(int i = 0; i < c.length-1; i++,jumps++){
			if((i+2) < c.length  &&   c[i+2]==0  ){
				i++;
			}
		}
		
		/*int i=0;
		int n = c.length;
		 while(i < n-3) //goes through all clouds up until the last jump
	        {
	            i += (c[i+2] == 0) ? 2 : 1;
	            jumps++;                
	        }
		 jumps++;*/
		/*int i = 0;
		while (i < c.length - 1) {
			if (i + 2 < c.length && c[i + 2] == 0) {
				i = i + 2;
				jumps++;
			} else {
				i++;
				jumps++;
			}
		}*/
		
		return jumps;
    }
	public static void main(String[] args) {

		int[] cItems = { 0,0,1, 0, 0, 1, 0};
	      

	        int result = jumpingOnClouds(cItems);
	        for (int i : cItems) {
			System.out.print(i );	
			}
	        System.out.println( " = "+result);
	}

}
