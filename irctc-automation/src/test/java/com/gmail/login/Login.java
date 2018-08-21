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
import com.gmail.constants.Standard;
import com.relevantcodes.extentreports.LogStatus;

public class Login extends StartBrowser {

	@Test(priority = 1, groups = { "T1" })
	public void login() {
		// logger = report.startTest("login");
		// Enter userid in textbox
		WebElement ele = driver.findElement(By.xpath(Locators.USER_ID));
		ele.sendKeys(Standard.EMAIL_ID_VALUE);
		logger.log(LogStatus.INFO, "Email id entered.");
		// Click on next button
		driver.findElement(By.xpath(Locators.NEXT_BUTTON)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Enter password in text box
		driver.findElement(By.xpath(Locators.PASS)).sendKeys(Standard.PASS_VALUE);
		logger.log(LogStatus.INFO, "Password entered.");
		// Add try catch block to handle stale element exception
		wait = new WebDriverWait(driver, 20);
		try {
			// Apply explicit wait so that element can be visible and clickable
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.PASSWORD_NEXT_BUTTON))));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.PASSWORD_NEXT_BUTTON)));
			// Click on Login button
			driver.findElement(By.xpath(Locators.PASSWORD_NEXT_BUTTON)).click();
			// Reporting
			logger.log(LogStatus.INFO, "Clicked on password next button");
			String actual = "https://accounts.google.com/signin/v2/sl/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward";
			Assert.assertEquals(actual, driver.getCurrentUrl());
			logger.log(LogStatus.PASS, "Login successful");
			report.endTest(logger);
			report.flush();
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			logger.log(LogStatus.FAIL, "Login Test Case Failed");
			// report.endTest(logger);
			// report.flush();
		}
	}

}
