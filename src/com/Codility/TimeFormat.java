package com.Codility;

public class TimeFormat {
	int first ,last;
	
	

    public String solution(int T) {
	       String result="";
	       
	       int hr =0,min=0,sec=0;
	       
	       hr = T/3600;
	       min = (T % 3600) / 60;
	       sec = T % 60; 
	       result =hr+"h"+min+"m"+sec+"s";
	       
	    	return result;
	    }
	
public static void main(String[] args) {
		
		
		TimeFormat tf = new TimeFormat();
		String s = tf.solution(350);
		System.out.println(s);
		
	}    

	    
}



