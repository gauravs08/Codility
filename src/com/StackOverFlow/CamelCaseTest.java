package com.StackOverFlow;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CamelCaseTest {
	private static final String WORD_SEPARATOR = " ";
	
	/*Question: CamelCase a given string in special way
	 * 
	 * "aabbccdd" 		  = "AaBbCc"
	 * "  aa bb  cc dd  " = "AaBbCcDd" 		 // Should avoid any tabs/spaces/nextline etc
	 * "aa111bb$$ccdd"    = "Aa111Bb$$CcDd" // Should handle all the digits and special character
	 * "___aa_bb_cc__dd"  = "__Aa_Bb_Cc__Dd" // Should avoid all underscore
	 * 
	 * */
	
	public static void main(String[] args) {
		String [] testStr2 = "this is one very long text".split(" ");

		String [] testStr = {"aabbccdd","  aa bb  cc dd  " ,"aa111bb$$ccdd","___aa_bb_cc__dd" };
		
		String result = Arrays
			      .stream(testStr2)
			      .map(word -> word.isEmpty()
			        ? word
			        : (Character.toTitleCase(word.charAt(0))  + word.substring(1).toLowerCase()))
			      .collect(Collectors.joining(WORD_SEPARATOR));
		System.out.println(result);
	}

}
