package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	DealPage dealPage;
	
	@FindBy(xpath = "(//div[@class='header item'])[1]")
	WebElement headerIcon;
	
	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//div[contains(text(),'Contacts activity stream')]")
	WebElement contactActivity;
	
	@FindBy(xpath = "//div[contains(text(),'Deals Summary')]")
	WebElement dealSummary;
	
	@FindBy(xpath ="//div[@class='header'][normalize-space()='Deals']")
	WebElement deals;
	
	@FindBy(xpath ="//span[normalize-space()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[5]/button[1]/i[1]")
	WebElement dealtNewLink;
	
	@FindBy(xpath = "///span[normalize-space()='Call Queue']")
	WebElement callQueue;
	
	@FindBy(xpath = "//span[normalize-space()='Upcoming calls']")
	WebElement upcomingCall;
	
	@FindBy(xpath = "//div[contains(text(),'Twitter')]")
	WebElement twitter;
	
	
	@FindBy(xpath = "//span[normalize-space()='Contacts']")
	WebElement contactLink;
	
	@FindBy(xpath = "//div[@id='main-nav']//div[5]//button[1]//i[1]")
	WebElement contactNewLink;
	
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	

	public boolean verifyHomePageHeaderIcon()
	{
		return headerIcon.isDisplayed();
	}
	public boolean verifyHomePageContActivity()
	{
		return contactActivity.isDisplayed();
		
	}
	public boolean verifyHomePageDeals()
	{
		return dealSummary.isDisplayed();
		
	}
	public boolean verifyHomePageTwitter()
	{
		return twitter.isDisplayed();
		/*;
		callQueue.isDisplayed();
		userNameLabel.isDisplayed();*/
	}
	
	public DealPage mouseOverOnDeals()
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(dealsLink).build().perform();
		dealsLink.click();
		return new DealPage();
	}
	public ContactsPage mouseOverOnContact()
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(contactLink).build().perform();
		contactLink.click();
		return new ContactsPage();
	}
	
	public void clickOnnewContact()
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(contactLink).build().perform();
		contactNewLink.click();
		
	}
	

	public void clickOnnewDeal()
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(dealtNewLink).build().perform();
		dealtNewLink.click();
		
	}
	
	public boolean verifyUserName() 
	{
		return userNameLabel.isDisplayed();
	}
	
}
