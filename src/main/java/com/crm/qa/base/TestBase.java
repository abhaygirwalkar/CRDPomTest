package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	//public OptionsManage optionsManager;
	
	public TestBase()
	{
		try
        {
           prop = new Properties();
           System.out.println( " File name ***  " +System.getProperty("user.dir"));
           String path = System.getProperty("user.dir") +"/src/main/java/com/crm/qa/config/mysettings.properties";
        		   //System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/mysettings.properties";
           System.out.println(" path :  "+path);

           FileInputStream propFile = new FileInputStream(path);
            prop.load(propFile);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found");
        }
        catch (IOException e)
        {
            System.out.println("IO");
        }

	}
	
	public static void intialization()
	{
		String browserName = prop.getProperty("browser");
		
		//String browserName = "chrome";
		
		if (System.getProperty("browser") == null) {
			System.out.println("**** browser name if *****  " +browserName);
			browserName = prop.getProperty("browser");
		} else {
			System.out.println("**** else browser name if *****  " +browserName);
			browserName = System.getProperty("browser");
		}
		
		
		if (browserName.equals("chrome")) {
			
			System.out.println(" browser name in if " +browserName);
			//System.setProperty("browser.chrome.driver", System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/chromedriver");
			//System.out.println(" browser name in after set property " +browserName);
			driver= WebDriverManager.chromedriver().create();
			//driver = new ChromeDriver();
		}
		
	//setup all default webdriver settings	
	driver.manage().window().maximize();
	System.out.println(" driver setup ");
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_IMPLICITWAIT,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("URL"));
	//driver.get("https://ui.freecrm.com/");
	
	System.out.println(" my URL "+prop.getProperty("URL"));
	
	}
	
	
	

}
