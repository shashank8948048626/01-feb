package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;
/**
 * This class contains java specific generic libraries
 * @author shashank
 *
 */
public class JavaUtility {
	
	/** 
	 * This  method will generate a random number with in the boundary of 0 to 10000
	 * @return int Data
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
			
	}
	/**
	 * this method will return curent date & time
	 * 
	 * @return
	 */
	public  String getCurrentdate() {
		Date date = new Date();
		String currentDate = date.toString();
		return currentDate;
	}
	/**
	 * This method will return date in Specified format
	 * @return
	 */
	public String getFinalDateFormat() {
		Date date = new Date();
		String d = date.toString();
		String[] dte = d.split(" ");
		String YYYY = dte[5];
		String DD = dte[2];
		String MM = dte[1];
	 String today = YYYY+ "-"+MM+"-"+00;
	return today;	
	}
	
}
