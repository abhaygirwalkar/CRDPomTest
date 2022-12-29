package com.crm.qa.pages;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

import io.netty.handler.timeout.TimeoutException;


public class DealPage extends TestBase {
	
	@FindBy(xpath ="//input[@name='title']")
	WebElement dealTitle;
	
	@FindBy(xpath ="//span[text()='Tanu abhay']//parent::div[@role='option']//parent::div[@class='menu transition']//parent::div[@class='ui fluid multiple selection dropdown']")
	WebElement dealAssignedTo;
	
	@FindBy(xpath="//div[@class='ui active visible fluid multiple selection dropdown']")
	WebElement dealassign;
	
	@FindBy(xpath ="//div[contains(@class,'react-datepicker-wrapper')]")
	WebElement dealDate;
	
	@FindBy(xpath ="//div[@class='react-datepicker__current-month']")
	WebElement dealdate1;
	
	@FindBy(xpath ="//input[@name='amount']")
	WebElement dealAmount;
	
	@FindBy(xpath ="//button[@class='ui linkedin button']")
	WebElement dealSave;
	
	
	@FindBy(xpath ="//div[@name='company']//input[@type='text']")
	WebElement dealCompany;
	
	@FindBy(xpath="//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[@class='ui fluid container ']/div[@class='ui fluid container main-content']/form[@class='ui form segment custom-form-container']/div[1]/div[1]/div[1]/div[1]")
	WebElement dealStatus;
	
	
	@FindBy(xpath ="//span[text()='Qualify']//parent::div[@class='item']//parent::div[@class='menu transition']//parent::div[@role='listbox']//parent::div[@class='ui field']")
	WebElement dealStatusSelect;
	
	@FindBy(xpath ="//div[contains(@class,'visible menu transition')]//div[1]")
	WebElement dealStage;
	
	
	public DealPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewDeal(String title, int amount) 
	{
		
		
		Random ran = new Random();
		Actions mouseover = new Actions(driver);
		System.out.println("create new deal 1");
		mouseover.moveToElement(dealCompany).build().perform();;
		
		int rand_int1 = ran.nextInt(1000);
		title =title+Integer.toString(rand_int1);
		System.out.println("get title "+title);
		dealTitle.sendKeys(title);
		
		dealAssignedTo.click();
		dealassign.sendKeys("Tanu abhay");
		
        dealDate.click();
       
		
        String monthYear = dealdate1.getText();
       
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("react-datepicker__month-container")));
        
		System.out.println("monthYear " +monthYear);//December 2022
		
		String month = monthYear.split(" ")[0].trim();
		String year = monthYear.split(" ")[1].trim();
		
		System.out.println("Month  " +month);
		System.out.println("Year  " +year);
		while(!(month.equals("January") && year.equals("2023")))
		{
			
			System.out.println("---- in while loop ----");
			driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
			monthYear =dealdate1.getText();
			
			System.out.println("while loop monthYear " +monthYear);//December 2022
			
			 month = monthYear.split(" ")[0].trim();
			 year = monthYear.split(" ")[1].trim();
			
		}
		
		driver.findElement(By.xpath("//div[text()='25']")).click();
		dealAmount.sendKeys(String.valueOf(amount));
		
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ui linkedin button']"))).click();

		System.out.println(" save deal");
	}
	

}
