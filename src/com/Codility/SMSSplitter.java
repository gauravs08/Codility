package com.Codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	String str ="";
	for(int i = 0; i < words.length ;i++) {
		
		if(words[i].length() > K) {
			return -1;
		}
		if(str.length() <= K-1 && str.length()+words[i].length()+1 <= K) {
			str += words[i]+" ";
		}else {
			res.add(str);
			str=words[i]+" ";
			
		}
		if(i==words.length -1) {
			res.add(str);
		}
	}
	System.out.println(Arrays.toString(res.toArray()));
	return res.size();
	
/*
    Pattern p = Pattern.compile("\\b.{1," + (K+1) + "}\\b\\W?");
    Matcher m = p.matcher(S);
    
    
    int wordCount = S.split("\\s+",12).length;
    /*   if(wordCount > m.groupCount()){
    	return -1;
    }*/
  /*  while(m.find()) {
           System.out.println(m.group().trim());   
            if(m.group().trim().length() >(K)){
            	return -1;
            }
            res.add(m.group());
    }
    
    
    return res.size();
     /*   int size =K;
        String str = S;
        String [] strarr =  str.split("(?<=\\G.{"+size+"})");
        Stream stream = Stream.of(strarr);
        stream.forEach(System.out::println);
	 return (size<1 || str==null) ? "-1" :"0";
	*/
	
    }
	
	
	public static void main(String args[]) {
		String str ="SMS messages is really long ";
		System.out.println(str);
	int res=	solution(str,12);
	System.out.println(res);
	}

}
