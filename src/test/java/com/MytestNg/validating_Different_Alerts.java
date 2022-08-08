//Assignment 3	Handling Alerts	"Automate different types of Alerts :
//1.switch to the alert(s)
//2.Ger Text out of alert using getText() and validate it.
//3.Use accept() , dismiss() and sendKeys(String) methods/functions when ever they are necessary"	"https://tutorialshut.com/demo-website-for-selenium-automation-practice/
//https://chercher.tech/practice/practice-pop-ups-selenium-webdriver ---- using this url 
//https://demoqa.com/alerts
//https://demoqa.com/modal-dialogs
//https://nxtgenaiacademy.com/alertandpopup/






package com.MytestNg;

import org.testng.annotations.Test;
import com.utility.ConstantValues;
import com.utility.MyLibrary;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class validating_Different_Alerts extends MyLibrary {

	@Test(priority=1)
	public void AlertUrlValidation() {
		System.out.println("inside validating alert url");
		driver.navigate().to(objPro.getProperty("AlertUrl"));
		// driver.get(objPro.getProperty("AlertUrl"));
		driver.manage().timeouts().pageLoadTimeout(ConstantValues.pageLoadTimeOut, TimeUnit.SECONDS);
		String AlertPageTitle = driver.getTitle();
		Assert.assertEquals(AlertPageTitle, objPro.getProperty("AlertPageTitle"));
	}
	@Test(priority=2)
	public void ValidatingAlert() {
		System.out.println("I am inside alert");
		driver.findElement(By.xpath("//input[@name='alert']")).click();
		ExplicitWaitForAlert();
		Alert NormalAlert = driver.switchTo().alert();
		String AlertText = NormalAlert.getText();
		System.out.println("AlertText is:"+ AlertText);
		Assert.assertEquals(AlertText, objPro.getProperty("NormalAlertText"));
		NormalAlert.accept();
	}
	@Test (priority=3)
	
	public void ConfirmBoxAccept(){
		System.out.println("I am inside ConfirmBox accept");
		driver.findElement(By.xpath("//input[@name='confirmation']")).click();
		ExplicitWaitForAlert();
		Alert ConfirmAlert = driver.switchTo().alert();
		String ConfirmAlertText = ConfirmAlert.getText();
		Assert.assertEquals(ConfirmAlertText, objPro.getProperty("ConfirmAlertTextfromProperties"));
		ConfirmAlert.accept();
			}
	
	@Test (priority=4)
		public void ConfirmBoxDecline(){
			System.out.println("I am inside ConfirmBox dismiss");
			driver.findElement(By.xpath("//input[@name='confirmation']")).click();
			ExplicitWaitForAlert();
			Alert ConfirmAlert = driver.switchTo().alert();
			String ConfirmAlertText = ConfirmAlert.getText();
			Assert.assertEquals(ConfirmAlertText, objPro.getProperty("ConfirmAlertTextfromProperties"));
			ConfirmAlert.dismiss();
				}
	
	
	@Test (priority=5)
	public void PromptAlert() throws Exception {
		System.out.println("I am inside prompt");
		driver.findElement(By.xpath("//input[@value ='Prompt']")).click();
		ExplicitWaitForAlert();
		Alert prompt= driver.switchTo().alert();
		Thread.sleep(20);
		String PromptText = prompt.getText();
		prompt.sendKeys(objPro.getProperty("promptAlertEnterText"));
		prompt.accept();
		System.out.println("PromptText:"+ PromptText);
		Assert.assertEquals(PromptText, objPro.getProperty("PromptTextFromProperties"));	
	}
	
	@Test(priority=6)
	public void DoubleClickMeAlert() throws Exception {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("double-click"))).doubleClick().build().perform();
		Alert doubleClick = driver.switchTo().alert();
		Thread.sleep(45);
		String doubleClickMessage = doubleClick.getText();
		Assert.assertEquals(doubleClickMessage, objPro.getProperty("doubleClickMessageFromFile"));
		doubleClick.accept();
		driver.close();
		
	}
	
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		LaunchBrowserandGmoOnline();
	}

	@AfterTest
	public void afterTest() {

		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		try {
			ReadProperties();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
