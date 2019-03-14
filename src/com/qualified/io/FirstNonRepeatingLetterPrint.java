package com.qualified.io;

import java.util.LinkedHashMap;

/*
 * Q: To print First non-repeating leterr from a word 
 * eg: Stress  print S
 * eg: STrTeSs print r
 * eg: stress print t */

public class FirstNonRepeatingLetterPrint {

	public static String firstNonRepeatingLetter(String str) {

		LinkedHashMap<Character, Integer> dictornary = new LinkedHashMap<Character, Integer>();

		// build table [char -> count]
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			/*if ( dictornary.containsKey(Character.toUpperCase(c))
					|| dictornary.containsKey(Character.toLowerCase(c))) {*/
				if ( dictornary.containsKey(c)) {
				dictornary.put(c, dictornary.get(c) + 1);
			} else {
				dictornary.put(c, 1);
			}
		}
		// since HashMap doesn't maintain order, going through string again
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (dictornary.get(c) == 1) {
				return c + "";
			}
		}
		return "";

	}

	public static void main(String args[]) {
		FirstNonRepeatingLetterPrint T = new FirstNonRepeatingLetterPrint();
	String res=	T.firstNonRepeatingLetter("STrTeSs");
	System.out.println(res);
	}

}
