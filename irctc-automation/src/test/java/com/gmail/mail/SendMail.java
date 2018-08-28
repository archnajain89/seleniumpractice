package com.gmail.mail;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.gmail.base.StartBrowser;
import com.gmail.constants.Locators;
import com.gmail.constants.Standard;
import com.relevantcodes.extentreports.LogStatus;

public class SendMail extends StartBrowser {

	@Test(priority = 1, groups = { "T2" })
	public void composeMailBtnClick() {

		try {
			// logger = report.startTest("send Mail");
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.COMPOSE_BTN))));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.COMPOSE_BTN)));
			driver.findElement(By.xpath(Locators.COMPOSE_BTN)).click();
			logger1.log(LogStatus.PASS, "Compose Button clicked");
		} catch (Exception e) {
			System.out.println(e);
			logger1.log(LogStatus.FAIL, "Compose button not clicked");
		}
	}

	@Test(priority = 2, groups = { "T2" })
	public void composeToFrom() {
		try {

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement ele = driver.findElement(By.xpath(Locators.RECIPIENTS_EMAIL));
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.sendKeys(Standard.RECIPIENTS_EMAIL_ID);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.SUBJECTS))));
			driver.findElement(By.xpath(Locators.SUBJECTS)).sendKeys(Standard.SUBJECTS_NAME);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.BODY))));
			driver.findElement(By.xpath(Locators.BODY)).sendKeys(Standard.BODY_TEXT);
			logger1.log(LogStatus.PASS, "Mail data entered in ComposeToFrom");
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
			logger1.log(LogStatus.FAIL, "Mail data not entered successfully.");
		}
	}

	@Test(priority = 3, groups = { "T2" })
	public void composeMailAttachment() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.ATTACHMENT_LINK))));
		driver.findElement(By.xpath(Locators.ATTACHMENT_LINK)).click();
		// Code of AUTOIT tool for attaching file.
		Runtime.getRuntime().exec("C:\\Users\\arrchnnajaiin\\Downloads\\uploadfile.exe");
		Thread.sleep(5000);
		logger1.log(LogStatus.PASS, "Attachment completed");
	}

	@Test(priority = 4, groups = { "T2" })
	public void sendMail() throws InterruptedException, IOException {
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.xpath(Locators.SEND_BTN)).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.SENT_MSG))));
		Thread.sleep(3000);
		WebElement msg = driver.findElement(By.xpath(Locators.SENT_MSG));
		// String actualMessage = "Sending..";
		String actualMessage = msg.getText();
		// System.out.println(actualMessage);
		try {
			/*
			 * JavascriptExecutor jse = (JavascriptExecutor)driver; WebElement
			 * element = driver.findElement(By.xpath(Locators.SENT_MSG));
			 * jse.executeScript("return arguments[0].text", element);
			 */
			Assert.assertEquals(actualMessage, Standard.EXPECTED_MSG);
			// System.out.println("Actual message and expected message is
			// equal");
			logger1.log(LogStatus.PASS, "Mail Sent.");
			// report.endTest(logger);
			// report.flush();
		} catch (AssertionError e) {
			// Take screenshot if Assertion fails.
			String filename = "failed";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hhmmss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destfilename = System.getProperty("user.dir") + "\\Screenshot\\" + filename + "_"
					+ dateFormat.format(date) + ".png";
			File f2 = new File(destfilename);
			System.out.println(f2);
			FileUtils.copyFile(f1, f2);
			logger1.log(LogStatus.FAIL, "Mail not sent. Screenshot attached.");

		}

	}

}