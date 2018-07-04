package com.gmail.mail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.gmail.login.Login;
import com.irctc.constants.Locators;
import com.irctc.constants.Standard;


public class SendMail extends Login {

	@Test(priority = 2, groups = { "T1" })
	public void composeMailBtnClick() {
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.COMPOSE_BTN))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.COMPOSE_BTN)));
		driver.findElement(By.xpath(Locators.COMPOSE_BTN)).click();
	}

	@Test(priority = 3, groups = { "T1" })
	public void composeToFrom() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath(Locators.RECIPIENTS_EMAIL));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(Standard.RECIPIENTS_EMAIL_ID);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.SUBJECTS))));
		driver.findElement(By.xpath(Locators.SUBJECTS)).sendKeys(Standard.SUBJECTS_NAME);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.BODY))));
		driver.findElement(By.xpath(Locators.BODY)).sendKeys(Standard.BODY_TEXT);
	}

	@Test(priority = 4, groups = { "T1" })
	public void composeMailAttachment() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.ATTACHMENT_LINK))));
		driver.findElement(By.xpath(Locators.ATTACHMENT_LINK)).click();
		// Code of AUTOIT tool for attaching file.
		Runtime.getRuntime()
				.exec("D:\\T2link\\AutoItLibrary-1.1.post1\\3rdPartyTools\\AutoIt\\New folder\\uploadfile.exe");
		Thread.sleep(1000);
	}

	@Test(priority = 5, groups = { "T1" })
	public void sendMail() {
		driver.findElement(By.xpath(Locators.SEND_BTN)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.SENT_MSG))));
		WebElement msg=driver.findElement(By.xpath(Locators.SENT_MSG));
		String actualMessage=msg.getText();
		Assert.assertEquals(actualMessage,Standard.EXPECTED_MSG);
	}

}
