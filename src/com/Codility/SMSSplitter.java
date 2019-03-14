package com.Codility;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*To split the string S of word in K size where each word should not break
 *  return the max size of array it will consume to hold the SMS
 * eg i/p: ("SMS messages is really long" ,12) means 12 length max each
 * o/p: "SMS"
 * 		"messages is"
 * 		"really long"
 * 
 * if message is not splitted it should return -1;
 * eg: "SMS is very Longgggggggggggg"
 * o/p: -1
 * */
public class SMSSplitter {

	
public static int solution(String S, int K) {
	
	if(K<1 || S == null)
		return -1;
	
	String[] words = S.split("\\s+");
	
	
	List<String> res = new ArrayList<>();

    Pattern p = Pattern.compile("\\b.{1," + (K+1) + "}\\b\\W?");
    Matcher m = p.matcher(S);
    
    
    int wordCount = S.split("\\s+",12).length;
    /*   if(wordCount > m.groupCount()){
    	return -1;
    }*/
    while(m.find()) {
           System.out.println(m.group().trim());   
            if(m.group().trim().length() >(K)){
            	return -1;
            }
            res.add(m.group());
    }
    
    
    return res.size();
        
	 //return (size<1 || str==null) ? null : str.split("(?<=\\G.{"+size+"})");
	
	
    }
	
	
	public static void main(String args[]) {
		SMSSplitter T = new SMSSplitter();
	int res=	T.solution("SMS 12345678912345 are really short ",12);
	System.out.println(res);
	}

}
