package com.gmail.login;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.gmail.base.StartBrowser;
import com.gmail.constants.Locators;
import com.gmail.utility.ExcelUtils;
import com.relevantcodes.extentreports.LogStatus;

public class LoginExcel extends StartBrowser{
	@Test(priority = 1, groups = { "T2" })
	public void login1() throws Exception {
		
		// Enter userid in textbox from excel file
		String Username=ExcelUtils.getCelldata(1,1);
		WebElement ele = driver.findElement(By.xpath(Locators.USER_ID));
		ele.sendKeys(Username);
		logger1.log(LogStatus.INFO, "Email id entered.");
		
		// Click on next button
		driver.findElement(By.xpath(Locators.NEXT_BUTTON)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Enter password in text box from excel file
		String Password=ExcelUtils.getCelldata(1,2);
		driver.findElement(By.xpath(Locators.PASS)).sendKeys(Password);
		logger1.log(LogStatus.INFO, "Password entered.");
		
		// Add try catch block to handle stale element exception
		wait = new WebDriverWait(driver, 20);
		// Apply explicit wait so that element can be visible and clickable
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.PASSWORD_NEXT_BUTTON))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.PASSWORD_NEXT_BUTTON)));
		// Click on Login button
		driver.findElement(By.xpath(Locators.PASSWORD_NEXT_BUTTON)).click();
		// Reporting
		logger1.log(LogStatus.INFO, "Clicked on password next button");
		String actual = "https://accounts.google.com/signin/v2/sl/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward";
	
		Assert.assertEquals(actual, driver.getCurrentUrl());
		logger1.log(LogStatus.PASS, "Login successful");
	}

}
