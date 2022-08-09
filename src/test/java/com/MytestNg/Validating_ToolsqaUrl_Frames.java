//Assignment 5: 
//Handling frames	: "Automate Web Elements present inside frames"
//1. Identify the frames present in given website using Frame number 
//or ID/Name or Frame Web Element
//2.Swith to Individual Frames and automate the Web Elements present 
//inside frames
//3. Come out of the Frame  
// https://chercher.tech/practice/frames-example-selenium-webdriver
//https://demoqa.com/frames
//https://demoqa.com/nestedframes
//https://www.hyrtutorials.com/p/frames-practice.html

package com.MytestNg;

import org.testng.annotations.Test;

import com.Mypages.Frame_page;
import com.utility.ConstantValues;

import com.utility.MyLibrary;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class Validating_ToolsqaUrl_Frames extends MyLibrary{

	@Test (priority=0)
  public void validateUrlLoadedSuccessfully() {
	    System.out.println("inside validate url");
	  driver.get(objPro.getProperty("FrameUrl_Toolsqa"));
	  driver.manage().window().maximize();
	  String UrlText = driver.getTitle();
	  System.out.println("UrlText:"+ UrlText);
	  Assert.assertEquals(UrlText, objPro.getProperty("Frame_ToolsQA_title"));
  }
	
	@Test (priority=1)
public void validating_FirstFrame() {
	System.out.println("inside first frame");
	WebElement frameElement = driver.findElement(Frame_page.firstFrame_demoqa);		
	driver.switchTo().frame(frameElement);
	String FirstFrameText = driver.findElement(Frame_page.TextFromFrame).getText();
	System.out.println("FirstFrameText is :"+ FirstFrameText);
	Assert.assertEquals(FirstFrameText, objPro.getProperty("FirstFrameTextfromProperties"));
	driver.switchTo().defaultContent();
}

	@Test (priority=2)
	public void validating_SecondFrame() {
		System.out.println("inside second frame");
		WebElement SecondFrame = driver.findElement(Frame_page.SecondFrame_demoqa);
		driver.switchTo().frame(SecondFrame);
		String SecondFrameText = driver.findElement(Frame_page.TextFromFrame) .getText();
		System.out.println("SecondFrameText is :"+ SecondFrameText);
		Assert.assertEquals(SecondFrameText, objPro.getProperty("SecondFrameTextfromProperties"));
		driver.switchTo().defaultContent();
	}
  @AfterMethod
  public void afterMethod() {
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

}
