package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
 // page factory 
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	
	WebElement password;
	
	@FindBy(xpath = "(//div[@class='ui fluid large blue submit button'])[1]")
	
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	WebElement signUpbtn;
	
	@FindBy(xpath = "(//a[normalize-space()='Forgot your password?'])[1]")
	WebElement forgotPassword;
	
	public LoginPage()

	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPage()
	{
		return driver.getTitle();
		
	}
	
	public boolean validateForgotPasswordLink()
	{
		return forgotPassword.isDisplayed();
	}
	
	public boolean validateSignUpLink()
	{
		return signUpbtn.isDisplayed();
	}
	
	public HomePage login(String em, String pwd)
	{
		email.sendKeys(em);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
}
