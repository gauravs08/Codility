package com.StackOverFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*https://stackoverflow.com/questions/55472107/how-to-use-string-join-nested
 * 
 */
public class StringJoinSOF {

	public static void main(String[] args) {
		
		double[] d1 = new double[] {5.1,5.2};
		double[] d2 = new double[] {5.3,5.4};
		double[] d3 = new double[] {5.5,5.6};
		double[] d4 = new double[] {5.7,5.8};
		List<String> list = Arrays.asList(Arrays.toString((d1)),Arrays.toString(d2),Arrays.toString(d3),Arrays.toString(d4));

		String joined = String.join("X", list);
		List<String> listJoined = new ArrayList<String>(Arrays.asList(joined));
		String strJoined = String.join(",", listJoined);
		System.out.println(strJoined);

		//Creating String array from double
		String[] s = new String[d1.length];

		for (int i = 0; i < s.length; i++)
		    s[i] = String.valueOf(d1[i]);
		String str1 = String.join("X", s);

		System.out.println(str1);

		//Creating String array from double 
		String[] s2 = new String[d2.length];
		for (int i = 0; i < s.length; i++)
		    s2[i] = String.valueOf(d2[i]);
		String str2 = String.join("X", s2);

		System.out.println(str2);
		
		//Output for first two  5.1X5.2,5.3X5.4
		System.out.println(String.join(",", str1,str2));

	}

}
