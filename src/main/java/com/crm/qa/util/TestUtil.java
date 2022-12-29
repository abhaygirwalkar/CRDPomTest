package com.crm.qa.util;



public class TestUtil {
	
	static public long PAGE_LOAD_TIMEOUT = 20;
	static public long PAGE_LOAD_IMPLICITWAIT = 10;
	//static long PAGE_LOAD_TIMEOUT = 20;
	

	public static void selectDate(String exday, String exmonth, String exyear, String monthYear)
	{
		System.out.println("  testutil " +monthYear);
		getMonthYear(monthYear);
		while(!(getMonthYear(monthYear)[0].equals(exmonth) 
				&& (getMonthYear(monthYear)[0].equals(exyear))))		
		{
			
			System.out.println("while loop monthYear " +monthYear);//December 2022
			
			
		}
		System.out.println("after while loop monthYear " +monthYear);
	}
	
	public static String [] getMonthYear(String monthYear)
	{
		return monthYear.split(" ");
		 
	}
}
