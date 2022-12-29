package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	DealPage dealPage;
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	
	
	public HomePageTest()
	{
		super();
	}

	//Before running each test user will login and run test and close the browser. 
	
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		dealPage = new DealPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTest()
	{
		
		System.out.println("*** verify  home page **** "); 
		boolean flag1,flag2,flag3,flag4;
		
		flag1= homePage.verifyHomePageHeaderIcon();
		flag2= homePage.verifyHomePageDeals();
		flag3= homePage.verifyHomePageTwitter();
		flag4= homePage.verifyHomePageContActivity();
		
		System.out.println("HeaderIcon " +flag1);
		Assert.assertTrue(flag1);
		
		System.out.println("Deals " +flag2);
		Assert.assertTrue(flag2);
		
		System.out.println("twitter " +flag3);
		Assert.assertTrue(flag3);
	
		System.out.println("Contact activity " +flag4);
		Assert.assertTrue(flag4);
		
	}
	
	@Test(priority = 2)
	public void verifyUserTest()
	{
		System.out.println("username  " );
		Assert.assertTrue(homePage.verifyUserName());
		
	}	
	
	@Test(priority = 2)
	public void verifyDealsLinkTest()
	{
		System.out.println("verify deal  page link");

		dealPage = homePage.mouseOverOnDeals();
		
	}
	
	@Test(priority = 2)
	public void verifyContactsLinkTest()
	{
		System.out.println("verify contact list page link");
	    homePage.mouseOverOnContact();
		
	}	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}

