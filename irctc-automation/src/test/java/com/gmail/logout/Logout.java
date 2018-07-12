package com.gmail.logout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.gmail.constants.Locators;
import com.gmail.login.Login;
import com.gmail.mail.SendMail;
import com.gmail.login.Login;

public class Logout {
	
//	public static Login l;
//		
//	@Test(priority=1,groups={"T2"})
//	public void logout() {
//		l= new Login();
//		//Click on drop down for sign out
//		//l.wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.LOGOUT_LINK))));
//		//l.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		l.driver.findElement(By.xpath(Locators.LOGOUT_LINK)).click();
//		//Click on sign out button
//		l.wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Locators.SIGNOUT_BTN))));
//		l.driver.findElement(By.xpath(Locators.SIGNOUT_BTN)).click();
//	}

}
