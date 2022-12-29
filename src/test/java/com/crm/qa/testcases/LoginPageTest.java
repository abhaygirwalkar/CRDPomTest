package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		boolean flag1,flag2;
		System.out.println("*** login page **** "); 
		String titleString = loginPage.validateLoginPage();
		System.out.println("Title string " +titleString);
		Assert.assertEquals(titleString, "Cogmento CRM");
		flag1 = loginPage.validateForgotPasswordLink();
		System.out.println(" validate forgot password link " +flag1);

		flag2 =loginPage.validateSignUpLink();
		System.out.println(" validate Sign up link " +flag2);
		
	}	
	
	@Test(priority = 2)
	public void loginUserTest()
	{
		System.out.println("*** login user  **** "); 

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
}
