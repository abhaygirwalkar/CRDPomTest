package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black'][1]")
	WebElement contactLabel;
	
	@FindBy(xpath = "//th[normalize-space()='Name']")
	WebElement contactNamelabel;
	
	@FindBy(xpath = "//th[normalize-space()='Name']")
	WebElement contactAddresslabel;
	
	@FindBy(xpath = "//div[@title='Select All']//input[@type='checkbox']")
	WebElement contactCheckBoxtList;
	
	@FindBy(xpath ="//th[normalize-space()='Email']")
	WebElement emailList;
	

	//initialize factory

	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	} 
	
	
	public boolean verifyContactsLabel()
	{
		return contactLabel.isDisplayed();
	}

	public boolean verifyContactsNameLabel()
	{
		return contactNamelabel.isDisplayed();
	}
	
	public boolean verifyContactsAddressLabel()
	{
		return contactAddresslabel.isDisplayed();
	}
	
	public void selectContact(String flName)
	{
		Actions mouseover = new Actions(driver);
		
		mouseover.moveToElement(emailList).build().perform();;
		
		driver.findElement(By.xpath("//a[normalize-space()='"+flName+"']")).click();

	
	}
	
}
