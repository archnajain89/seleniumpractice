package com.gmail.base;

import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.gmail.constants.Standard;

public class StartBrowser {
	public  ResourceBundle rb;
	public  WebDriver driver;

	@BeforeSuite (alwaysRun=true)
	public void getDriver()
	{
		rb=ResourceBundle.getBundle(Standard.CONFIG_PROPERTY_FILENAME);
		if (Standard.CHROME_BROWSER.equals(rb.getString(Standard.BROWSER)))
		{
			System.setProperty(Standard.CHROME_DRIVER, Standard.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			
		}
		//return driver;
	}

	@BeforeTest (alwaysRun=true)
	public void openBrowser() {
		driver.get(rb.getString(Standard.URL));
		driver.manage().window().maximize();
	}
	
//	@AfterSuite(alwaysRun=true)
//	public void closeBrowser()
//	{
//		driver.close();
//	}

}