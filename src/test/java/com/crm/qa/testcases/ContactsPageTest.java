package com.crm.qa.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	
	public ContactsPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.mouseOverOnContact();
		
	}
	
	@Test(priority = 1)
	public void verifyContactsPageTest()
	{
		System.out.println("*** validate contact page **** "); 

		boolean flag1,flag2,flag3;
		
		flag1= contactsPage.verifyContactsLabel();
		flag2= contactsPage.verifyContactsNameLabel();
		flag3= contactsPage.verifyContactsAddressLabel();
		
		System.out.println("Contact label " +flag1);
		Assert.assertTrue(flag1);
		
		System.out.println("Name lable on list " +flag2);
		Assert.assertTrue(flag2);
		
		System.out.println("Adress label " +flag3);
		Assert.assertTrue(flag3);
		
	}
	
	@Test(priority = 1)
	public void selectContactTest()
	{
		System.out.println("*** select contacts page **** "); 

		contactsPage.selectContact("fname2 lname2");
		//assert
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
