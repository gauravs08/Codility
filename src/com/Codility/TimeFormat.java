package com.Codility;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeFormat {
	int first ,last;
	
	

    public String solution(int T) {
	       String result="";
	       
	       int hr =0,min=0,sec=0;
	       
	       hr = T/3600;
	       min = (T % 3600) / 60;
	       sec = T % 60; 
	       result = hr+"h"+min+"m"+sec+"s";
	       
	    	return result;
	    }
	
public static void main(String[] args) {
		
		
		TimeFormat tf = new TimeFormat();
		String s = tf.solution(350);
		System.out.println(s);
		
		
		//java 8
		DateTimeFormatter timeFormat=DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime twelveFifteenPM = LocalTime.ofSecondOfDay(350);
		System.out.println(twelveFifteenPM.format(timeFormat));
		
		
		
	}    

	    
}



