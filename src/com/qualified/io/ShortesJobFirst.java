package com.qualified.io;

import java.util.Arrays;
import java.util.List;

public class ShortesJobFirst {
	
	//To execute small job first  

	// jobs 		index 	Return Value
	// [3,10,20,1,2]	 0	 6   (1+2+3)
	// [3,10,10,20,1,2]  2   26  (1+2+3+10)

	public static Integer sjf(List<Integer> jobs, Integer index) {
		Integer totalTime = 0;

		Integer job = jobs.get(index);
		if (jobs.size() == 1) {
			return job;
		}

		boolean allEqualJobs =  jobs.stream().distinct().limit(2).count () <=1;
		
		if(allEqualJobs){
			
			return job *(index+1);
		}
		
		for (Integer t : jobs) {
			if (t <=job) {
				totalTime += t;
			}

		}

		return totalTime;

	}
	

	public static void main(String[] args) {

		ShortesJobFirst c = new ShortesJobFirst();
		Integer actual; 
		//actual = Challenge.sjf(Arrays.asList(3, 10, 20, 1, 2), 0);

		//System.out.println(actual);
		//actual = Challenge.sjf(Arrays.asList(100), 0);

		//System.out.println(actual);
		actual = ShortesJobFirst.sjf(Arrays.asList(7,2,7,15,4,2), 2);

		System.out.println(actual);

	}

}
