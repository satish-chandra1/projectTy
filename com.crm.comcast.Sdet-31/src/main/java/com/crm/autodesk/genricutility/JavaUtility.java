package com.crm.autodesk.genricutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Satish
 */
public class JavaUtility {
	/**
	 * its used to generate a random number
	 * @return int
	 */
	public int getRandDomNumber() {
		Random random = new Random();
		int intRandom =	random.nextInt(10000);
		return intRandom;	
	}
	
	/**
	 * used to get system date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date=new Date();
		return date.toString();
		
	}
	
	/**
	 * used to get the system date in YYYY-MM-DD format
	 * @return
	 * 
	 */
	 public String getSystemDateWithFormate() {
		 Date date=new Date();
		 String dateandtime = date.toString();
		 
		 String YYYY= dateandtime.split(" ")[5];
		 String DD= dateandtime.split(" ")[2];
		 int MM= date.getMonth()+1;
		  String finalFormat = YYYY+"-"+MM+"-"+DD;
		  
		  return finalFormat;
		 
	 }

}
