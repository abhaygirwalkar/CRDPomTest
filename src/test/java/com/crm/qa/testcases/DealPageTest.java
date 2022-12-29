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

public class DealPageTest extends TestBase {
	

	LoginPage loginPage;
	HomePage homePage;
	DealPage dealPage;
	
	
	public DealPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		dealPage = new DealPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test(priority = 1)
	public void validateCreateNewDealTest()
	{
		System.out.println("*** creating new deal **** "); 
		homePage.clickOnnewDeal();
		System.out.println(" clicked on new deal");
		//String date = "30-December-2022";
		dealPage.createNewDeal("Abhay-Deal", 100);
		//Assert.assertEquals(titleString, "Cogmento CRM");
	}	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}

}
