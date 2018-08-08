package com.gmail.login;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
	public WebDriverWait wait;

	@Test(priority = 1, groups = { "T1" })
	public void login() {
		logger = report.startTest("login");
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
			String actual = "hasgdhgdhas";
			Assert.assertEquals(actual, driver.getCurrentUrl());
			// Assert.assertTrue(false);

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			logger.log(LogStatus.FAIL, "login Test Case failed");
			report.endTest(logger);
			report.flush();
		}
	}

	/*
	 * @AfterMethod(groups={"T1"}) public void getResult(ITestResult result)
	 * throws Exception { // using ITestResult.FAILURE is equals to
	 * result.getStatus then it enter // into if condition if
	 * (ITestResult.FAILURE == result.getStatus()) { logger.log(LogStatus.FAIL,
	 * "Test Case Failed is " + result.getName()); logger.log(LogStatus.FAIL,
	 * "Test Case Failed is " + result.getThrowable()); // To capture screenshot
	 * path and store the path of the screenshot // in the string
	 * "screenshotPath" // We do pass the path captured by this method in to the
	 * extent // reports using "logger.addScreenCapture" method. String
	 * screenshotPath = Utility.getScreenshot(driver, result.getName()); // To
	 * add it in the extent report logger.log(LogStatus.FAIL,
	 * logger.addScreenCapture(screenshotPath)); } else if (result.getStatus()
	 * == ITestResult.SKIP) { logger.log(LogStatus.SKIP, "Test Case Skipped is "
	 * + result.getName()); } report.endTest(logger); report.flush(); }
	 */
}
