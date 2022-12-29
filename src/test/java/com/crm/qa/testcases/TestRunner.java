package com.crm.qa.testcases;

import org.testng.TestNG;

public class TestRunner {

	static TestNG testng;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testng = new TestNG();
		
		//testng.setTestClasses(new Class[] {LoginPageTest.class,DealPageTest.class,HomePageTest.class,ContactsPageTest.class});
		
		testng.setTestClasses(new Class[] {LoginPageTest.class});
		
		testng.run();
		
	}

}
