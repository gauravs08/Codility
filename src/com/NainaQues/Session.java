package com.NainaQues;

import java.util.Date;

class Session {
	public Leaks leaks;
	public int weekNum;	
	
	public Session(Leaks l,int weekCount){
		this.leaks=l;
		this.weekNum=weekCount;
	}

	
}

 class Leaks{
	public Date date;
	public boolean isLeak;
	public int leakcount;
	
	public Leaks(Date d,boolean b,int i){
		this.date=d;
		this.isLeak=b;
		this.leakcount=i;
	}
}
 
 