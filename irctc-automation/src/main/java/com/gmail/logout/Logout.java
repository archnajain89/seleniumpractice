package com.gmail.logout;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.gmail.mail.SendMail;
import com.irctc.constants.Locators;

public class Logout extends SendMail{
	@Test(priority=6,groups={"T1"})
	public void logout() {
		//Click on drop down for sign out
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.LOGOUT_LINK))));
		driver.findElement(By.xpath(Locators.LOGOUT_LINK)).click();
		//Click on sign out button
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.SIGNOUT_BTN))));
		driver.findElement(By.xpath(Locators.SIGNOUT_BTN)).click();
	}

}
