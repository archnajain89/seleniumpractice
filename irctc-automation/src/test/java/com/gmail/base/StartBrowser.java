package com.gmail.base;

import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.gmail.constants.Standard;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class StartBrowser {
	public  ResourceBundle rb;
	public  WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite (alwaysRun=true)
	public void getDriver()
	{
		report=new ExtentReports(".\\Reports\\ExtentReport.html");
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
		logger =report.startTest("openBrowser");
		driver.get(rb.getString(Standard.URL));
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO,"Url is opened and window is maximized.");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case openBrowser Passed");
		report.endTest(logger);
		report.flush();
	}
	
//	@AfterSuite(alwaysRun=true)
//	public void closeBrowser()
//	{
//		driver.close();
//	}

}
