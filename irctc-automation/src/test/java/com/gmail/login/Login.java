package com.gmail.login;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.gmail.base.StartBrowser;
import com.gmail.constants.Locators;
import com.gmail.constants.Standard;

public class Login extends StartBrowser {
	public WebDriverWait wait;
	@Test (priority=1,groups = { "T1" })
	public void login() {
		//Enter userid in textbox
		WebElement ele = driver.findElement(By.xpath(Locators.USER_ID));
		ele.sendKeys(Standard.EMAIL_ID_VALUE);
		//Click on next button
		driver.findElement(By.xpath(Locators.NEXT_BUTTON)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Enter password in text box
		driver.findElement(By.xpath(Locators.PASS)).sendKeys(Standard.PASS_VALUE);
		//Add try catch block to handle stale element exception
		wait = new WebDriverWait(driver, 20);
		try {
		
			//Apply explicit wait so that element can be visible and clickable
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.PASSWORD_NEXT_BUTTON))));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.PASSWORD_NEXT_BUTTON)));
			//Click on Login button
			driver.findElement(By.xpath(Locators.PASSWORD_NEXT_BUTTON)).click();

		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
		}
	}

}
