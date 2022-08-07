package com.MytestNg;    //Assignment 2 GMO Place Order and validate calculation

import org.testng.annotations.Test;

import com.utility.ConstantValues;
import com.utility.MyLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MyGmoOnlineTestNG extends MyLibrary {
	@Test(priority = 0)
	public void GmoTitleValidation() {
		System.out.println("inside GmoTitleValidation");
		String TitleofGmoOnline = driver.getTitle();
		Assert.assertEquals(TitleofGmoOnline, objPro.getProperty("GmoOnlineTitle"));
		System.out.println("TitleofGmoOnline :" + objPro.getProperty("GmoOnlineTitle"));
	}

	@Test(priority = 1, dependsOnMethods = { "GmoTitleValidation" })

	public void enterGmoOnlineandOrderProduct() {
		driver.findElement(By.name("bSubmit")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='QTY_TENTS']")).clear();
		driver.findElement(By.xpath("//input[@name='QTY_TENTS']")).sendKeys(ConstantValues.QuantityOfTent);
		driver.findElement(By.name("bSubmit")).click();
		String titleOfPlaceOrderPage = driver.getTitle();
		System.out.println("Title of place order page is:" + objPro.getProperty("titleOfPlaceOrderPage"));
		Assert.assertEquals(titleOfPlaceOrderPage, objPro.getProperty("titleOfPlaceOrderPage"));
	}
	
	@Test(priority = 2)
	public void validateGrandTotal() {

	String unitprice = driver.findElement(By.xpath("//tbody//tr[2]//td[4]")).getText().substring(2);
	System.out.println("unit price of person Dome Tent is :" + unitprice);
	Float TotalPriceInFloat = Float.parseFloat(unitprice) * Integer.parseInt(ConstantValues.QuantityOfTent);
	System.out.println("total price of person Dome Tent is :" + TotalPriceInFloat);
	Float ProductTotalinFloat = Float
			.parseFloat(driver.findElement(By.xpath("//tbody//tr[3]//td[3]")).getText().substring(2));
	
	Float SalesTaxInFloat = Float
			.parseFloat(driver.findElement(By.xpath("//tbody//tr[4]//td[2]")).getText().substring(2));
	Float ShippingAndHandling = Float
			.parseFloat(driver.findElement(By.xpath("//tbody//tr[5]//td[2]")).getText().substring(2));
	System.out.println ("ProductTotalinFloat ,SalesTaxInFloat, ShippingAndHandling :" + ProductTotalinFloat + SalesTaxInFloat + ShippingAndHandling);
	Float GrandTotalfromapplication = Float
			.parseFloat(driver.findElement(By.xpath("//tbody//tr[6]//td[2]//strong")).getText().substring(2));
	Float GrandTotalByCalculation = (ProductTotalinFloat + SalesTaxInFloat +  ShippingAndHandling );
	System.out.println ("GrandTotalByCalculation is :"+ GrandTotalByCalculation);
	Assert.assertEquals(GrandTotalfromapplication, GrandTotalByCalculation);
}

	@Test(priority = 3)
	public void validateProceedToOrder () {
		
	driver.findElement(By.xpath("//input[@name=\"bSubmit\"]")).click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String titleofBillingInformation = driver.getTitle();
	System.out.println("title of Billing Information page is :"+ titleofBillingInformation);
	Assert.assertEquals(titleofBillingInformation, objPro.getProperty("titleofBillingInformation"));
	}
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("inside before class");
		LaunchBrowserandGmoOnline();
}

	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside before method");
		try {
			ReadProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
	
	}
	

}
