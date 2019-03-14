package NitroCabs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NitroCabsMain {

	/**
	 * @param args
	 */
	final int SECTOR_DIFF = 2;	//TWO SECTORS DISTANCE
	final int FAIR = 10;		//10/Km
	final double SPEED = .5;       // 1km in 2 min 
	final double	REACH_BEFORE_TIME = 15;		// 15 min before time.
	final int no_of_milliseconds_in_second = 1000;
	final int no_of_seconds_in_min = 60;
	
	final Double CHARGE_PER_KM = (double)8;			// CHARGE AS PER COMPANY
	final Double CHARGE_PER_KM_ACTUAL = (double)5;	// ACTUAL PRICE PER KMS
	String SystemInfoMsg = "Welcome";
	final Double GAIN_PERCENT = (double)20;
	public static void main(String[] args) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		//cal.add(Calendar.HOUR, 2);
		//System.out.println(dateFormat.format(cal.getTime()));
		Date currentDate = cal.getTime();
		
		CabsClass nearestCab =null;
		
		
		List<CabsClass> cabsLoclist = new ArrayList<CabsClass>();
		CabsClass c1 = new CabsClass("DL01HB001", 100020);
		CabsClass c2 = new CabsClass("DL01HB002", 100040);
		CabsClass c3 = new CabsClass("DL01HB003", 100060);
		CabsClass c4 = new CabsClass("DL01HB004", 100080);
		
		
		cabsLoclist.add(c1);
		cabsLoclist.add(c2);
		cabsLoclist.add(c3);
		cabsLoclist.add(c4);
		
		
		List<RequestClass> requestList = new ArrayList<RequestClass>();
		RequestClass r1 = new RequestClass("BR001", 100025, 100036, currentDate,(double)450);
		/*cal.add(Calendar.HOUR, 1);currentDate = cal.getTime();
		RequestClass r2 = new RequestClass("BR002", 100056, 100042, currentDate,(double)500);cal.add(Calendar.HOUR, 1);currentDate = cal.getTime();
		RequestClass r3 = new RequestClass("BR003", 100044, 100056, currentDate,(double)600);cal.add(Calendar.HOUR, 3);currentDate = cal.getTime();
		RequestClass r4 = new RequestClass("BR004", 100028, 100036, currentDate, (double)700);*/		
		
		NitroCabsMain obj = new NitroCabsMain();
		nearestCab = obj.getMinDistCabforRequest(cabsLoclist, r1);
		
		Double timeToReach = obj.getMinTimetoreachDestination(nearestCab, r1);
		
		boolean ToServer = obj.requestAcceptOrNot(timeToReach, r1);
		
		Double ToProfit = obj.calculateProfit(nearestCab,r1);
		
		
	}
	
	public Double calculateProfit(CabsClass cab, RequestClass reqobj) {
		//if profit is not > 20% reject the request.
	
		Date minTimeReq = null;
		Integer cabLoc = cab.getCurrLoc();
		Integer pickup = reqobj.getPickUpLoc();
		Double timetotravelforpickup = null;
		Double totalAmt = null; 
		Double ActualAmt = null;
		Double Gain =null;
		Integer cabtoPickupDist = Math.max(pickup-cabLoc,cabLoc -pickup);
		cabtoPickupDist = cabtoPickupDist * SECTOR_DIFF;			//Actual Distance 
		//timetotravelforpickup = cabtoPickupDist / SPEED;
		
		totalAmt = cabtoPickupDist * CHARGE_PER_KM;
		
		ActualAmt =cabtoPickupDist * CHARGE_PER_KM_ACTUAL;
		 Gain = totalAmt - ActualAmt;
		
		 
		double profitPercentage = 0;
		
		profitPercentage = (Gain/ActualAmt)*100;
		
		if( profitPercentage >= GAIN_PERCENT ) {
			SystemInfoMsg = "PROFIT";
			System.out.println("Profit Percentage ::" + profitPercentage);
			return profitPercentage;
		}
		System.out.println("LOSS Percentage !!!!::" + profitPercentage);
		return profitPercentage;
	}
	
	public boolean requestAcceptOrNot(Double timeToReach , RequestClass regobj) {
		//if cab not reachable before 15 min dont accept the request
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		
		long diff =  regobj.getPickUpTime().getTime() - (new java.util.Date()).getTime();
		diff = diff /(no_of_milliseconds_in_second*no_of_seconds_in_min);
		//timeToReach = timeToReach * no_of_milliseconds_in_second*no_of_seconds_in_min;
		if(timeToReach < diff) {
			SystemInfoMsg = "Request Time is reachable!!!";
			System.out.println("Request Time is reachable diff is::" + timeToReach);
			return true;
		}
		
		return false;
		
	}

	public Double getMinTimetoreachDestination(CabsClass cab,RequestClass reqobj) {
		//diff of time for cab to reach the destination.
		
		Date minTimeReq = null;
		Integer cabLoc = cab.getCurrLoc();
		Integer pickup = reqobj.getPickUpLoc();
		Double timetotravelforpickup = null;
		
		
		Integer cabtoPickupDist = Math.max(pickup-cabLoc,cabLoc -pickup);
		cabtoPickupDist = cabtoPickupDist * SECTOR_DIFF;			//Actual Distance 
		timetotravelforpickup = cabtoPickupDist / SPEED;
		timetotravelforpickup  = timetotravelforpickup + REACH_BEFORE_TIME;
		
		
		return timetotravelforpickup; 
	}
	public CabsClass getMinDistCabforRequest(List<CabsClass> cabs,RequestClass regobj) {
		//choose cab from cablist to server the request
		Integer pickup = regobj.getPickUpLoc();
		Integer lowestdiff =Integer.MAX_VALUE;
		CabsClass nearestCabid = null;
		
		Integer cabLoc ;
		CabsClass c1;
		
		Iterator it =  cabs.iterator();
		while(it.hasNext()) {
			c1 =(CabsClass)it.next();
			cabLoc = c1.getCurrLoc();
			if(Math.max(pickup-cabLoc,cabLoc -pickup)< lowestdiff) {
				lowestdiff = Math.max(pickup-cabLoc,cabLoc -pickup);
				nearestCabid = c1;
			}
			
		}
		System.out.println("Nearest cab is ::" +nearestCabid.getRegNo());
		return nearestCabid;
		
	}
	
	
}
