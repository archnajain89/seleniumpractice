package com.gmail.login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.xpath.operations.Equals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	public WebDriver driver;
	/*
	 * //Switching from parent to child and child to parent window
	 * 
	 * @Test(priority=1) public void startDriver() throws InterruptedException {
	 * System.setProperty("web.chrome.driver", "./Driver/chromedriver.exe");
	 * driver = new ChromeDriver();
	 * driver.get("https://business.twitter.com/en/solutions.html");
	 * driver.findElement(By.xpath("//span[contains(text(),'Start a Campaign')]"
	 * )).click(); String currentwindow= driver.getWindowHandle();
	 * ArrayList<String> list= new ArrayList<String>(driver.getWindowHandles());
	 * int size=list.size(); 
	 * System.out.println(size);
	 * driver.manage().window().maximize();
	 * driver.switchTo().window(list.get(1)); 
	 * Thread.sleep(1000);
	 * //driver.switchTo().window(list.get(0));
	 * driver.switchTo().window(currentwindow);
	 * 
	 * }
	 * 
	 * //To handle alert by clicking on cancel button
	 * 
	 * @Test(priority=2) public void alertHandle() throws InterruptedException {
	 * System.setProperty("web.chrome.driver", "./Driver/chromedriver.exe");
	 * driver = new ChromeDriver();
	 * driver.get("http://demo.guru99.com/test/delete_customer.php");
	 * driver.findElement(By.xpath("//input[@value='Submit']")).click();
	 * driver.manage().window().maximize(); Thread.sleep(1000);
	 * driver.switchTo().alert().dismiss(); }
	 * 
	 * 
	 * // To handle multiple check boxes
	 * 
	 * @Test(priority=3) public void selectCheckboxes() throws
	 * InterruptedException { System.setProperty("web.chrome.driver",
	 * "./Driver/chromedriver.exe"); driver = new ChromeDriver();
	 * driver.get("http://toolsqa.com/automation-practice-form/");
	 * List<WebElement> list= new
	 * ArrayList<WebElement>(driver.findElements(By.xpath(
	 * "//input[@name='profession']"))); 
	 * Thread.sleep(1000); //select first
	 * check box for(int i=0;i<1;i++) { 
	 * list.get(i).click(); }
	 * 
	 * //To select multiple check boxes for(WebElement ele: list) {
	 * if(ele.isSelected()==false) { ele.click(); } }
	 * 
	 * }
	 */

	// To select & check value from dropdown
	/*
	 * @Test(priority = 4) public void selectDropdown() throws
	 * InterruptedException { 
	 * System.setProperty("web.chrome.driver","./Driver/chromedriver.exe"); driver = new ChromeDriver();
	 * driver.get("http://toolsqa.com/automation-practice-form/"); 
	 * Select select = new Select(driver.findElement(By.xpath("//select[@id='continents']")));
	 * // check and select dropdown options 
	 * driver.manage().window().maximize();
	 * List<WebElement> list = select.getOptions(); 
	 * for (WebElement ele : list) {
	 * String selectedtext = select.getFirstSelectedOption().getText(); 
	 * if (selectedtext.equalsIgnoreCase("abcd")) { 
	 * System.out.println("Valid exists"); } 
	 * else System.out.println("Not exist in lists"); }
	 * //select all dropdown options driver.manage().window().maximize();
	 * List<WebElement> list= select.getOptions(); for(WebElement ele:list) {
	 * Thread.sleep(500); ele.click(); } 
	 * select.selectByVisibleText("Australia"); 
	 * String selectedtext=select.getFirstSelectedOption().getText();
	 * if(selectedtext.equalsIgnoreCase("Australia")) { System.out.println(
	 * "Valid selection"); } else System.out.println("Not a valid selection" );
	 * }
	 */
	// verify the title of the page
	@Test(priority = 5)
	public void assertTitle() throws InterruptedException {
		System.setProperty("web.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		String actual = driver.getTitle();
		System.out.println(actual);
		assertEquals(actual, "Demo Form for practicing Selenium Automation");
		
	}

}
