package com.irctc.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.irctc.base.StartBrowser;
import com.irctc.constants.Locators;
import com.irctc.constants.Standard;

public class Login extends StartBrowser {

	@Test
	public void login() {
		//Enter userid in textbox
		WebElement ele = driver.findElement(By.xpath(Locators.USER_ID));
		ele.sendKeys(Standard.EMAIL_ID_VALUE);
		//Click on next button
		driver.findElement(By.xpath(Locators.NEXT_BUTTON)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Enter password in text box
		driver.findElement(By.xpath(Locators.PASS)).sendKeys(Standard.PASS_VALUE);
		//Click on Login button
		driver.findElement(By.xpath(Locators.PASSWORD_NEXT_BUTTON)).click();
		

	}

}
