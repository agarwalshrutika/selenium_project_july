package com.MytestNg;   //Assignment 1 (launch browser, read from properties and hard assertion)

import org.testng.annotations.Test;

import com.utility.MyLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class validate_website_launch extends MyLibrary {

	@Test
	public void ValidateTitle() {
		System.out.println("inside validate title");
		String titleOfGmoOnline = driver.getTitle();
		Assert.assertEquals( titleOfGmoOnline, objPro.getProperty("GmoOnlineTitle"));
	}

	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
		LaunchBrowserandGmoOnline();
	}



	@BeforeSuite
	public void readingPropertiesFromFile() {
		System.out.println("inside before suite");
		try {
			ReadProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
