package com.NainaQues;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Testmain {

	public static void main(String args[]) {
		List<Session> sessionList = new ArrayList();

		Session s1 = new Session(new Leaks(new Date(),true,2),1);
		Session s2 = new Session(new Leaks(new Date(),true,3),1);
		Session s3 = new Session(new Leaks(new Date(),true,9),2);
		Session s4 = new Session(new Leaks(new Date(),true,5),2);
		Session s5 = new Session(new Leaks(new Date(),true,5),3);
		
		sessionList.add(s1);
		sessionList.add(s2);
		sessionList.add(s3);
		sessionList.add(s4);
		sessionList.add(s5);
		
		Testmain main = new Testmain();
		main.printSession(sessionList);
		main.calculateAverageperWeek(sessionList);
	}
	
	public void printSession(List<Session> sList){
		int i=1;
		for(Session s: sList){
			System.out.println("Session"+ i++ +" : Date="+s.leaks.date +", isLeak="+s.leaks.isLeak+", LeakCount="+s.leaks.leakcount);
			System.out.println(" WeekNum:: "+s.weekNum );
		}
	}
	public HashMap<Integer, Double>  calculateAverageperWeek(List<Session> sList){
		HashMap<Integer, Double> result = new HashMap();
		int oldWeekNum = 0;
		int totalLeakCount = 0;
		int count = 0;
		Double average = 0.0;
		
		for(Session s: sList){
			
			if(s.weekNum == oldWeekNum  ) {
				totalLeakCount =totalLeakCount+s.leaks.leakcount;
				count++;
				average = (double) (totalLeakCount/(double)count);
				
			}else{
				totalLeakCount =s.leaks.leakcount;
				count = 1;
				average = (double) (totalLeakCount/(double)count);
			}
			oldWeekNum = s.weekNum;
			result.put(s.weekNum, average);
			
			
		}
		System.out.println(result.entrySet());
		
		return null;
		
		
	}
	
	
	
	
	
	
	/*public Leaks populateLeaks(Date d,boolean isLeak,int leakCount){
		Leaks l = new Leaks();
		l.date=d;
		l.isLeak=isLeak;
		l.leakcount=leakCount;
		
		return l;
	}
	
	public Leaks populateSession(Leaks l, int weekCount){
		Session s = new Session();
		s.leaks=l;
		s.weekNum=weekCount;
		return s;
	}*/
}
