package com.gmail.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.gmail.base.StartBrowser;
import com.gmail.constants.Locators;
import com.relevantcodes.extentreports.LogStatus;

public class DeleteSentMail extends StartBrowser {

	@Test(priority=5,groups={"T2"})
	public void deleteSentMail() throws InterruptedException {
		try{	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.SENT_BTN)));
		driver.findElement(By.xpath(Locators.SENT_BTN)).click();
		logger.log(LogStatus.PASS, "Sent link clicked.");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.SELECT_ALL_SENTMAILS)));
		WebElement Select_Mails = driver.findElement(By.xpath(Locators.SELECT_ALL_SENTMAILS));
		//Select all sent mails 
		Select_Mails.click();
		// If check box is not selected that means no mail present in sent mail
		//problem in line of code: 26 , it should be isSelected instead of isDisplayed.
		boolean value=Select_Mails.isDisplayed();
		System.out.println(value);
		if (value == false) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.NO_MAILS)));
			WebElement No_mails = driver.findElement(By.xpath(Locators.NO_MAILS));
			String actual_message = No_mails.getText();
			String expected_message = "No sent messages! ";
			Assert.assertEquals(actual_message, expected_message);
			logger.log(LogStatus.PASS,"No mails present in Sent Mail.");			
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.DELETE_SENT_MAILS)));
			driver.findElement(By.xpath(Locators.DELETE_SENT_MAILS)).click();
			Thread.sleep(3000);
			logger.log(LogStatus.PASS,"All sent mails are deleted.");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.DELETE_SENT_MSG)));
			WebElement Delete_msg = driver.findElement(By.xpath(Locators.DELETE_SENT_MSG));
			String actual_message = Delete_msg.getText();
			String expected_message = "Conversation moved to Trash.";
			Assert.assertEquals(actual_message, expected_message);
		}
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
