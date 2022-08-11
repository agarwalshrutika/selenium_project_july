//Assignment 5:  Frames ( https://chercher.tech/practice/frames-example-selenium-webdriver)
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

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Mypages.CharChar_Frame_Page;
import com.Mypages.Frame_page;
import com.utility.ConstantValues;
import com.utility.MyLibrary;

public class Validating_CharChar_Frame extends MyLibrary {

	@Test(priority=0)
	public static void UrlLoadedSuccessfully() {
		System.out.println("inside validate url");
		driver.get(objPro.getProperty("CharChar_FrameUrl1"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ConstantValues.pageLoadTimeOut, TimeUnit.SECONDS);
		String CharCharUrlText = driver.getTitle();
		System.out.println("UrlText:" + CharCharUrlText);
		Assert.assertEquals(CharCharUrlText, objPro.getProperty("Frame_CharChar_title"));
	}
@Test (priority=1)
	public static void Validating_NestedFrame() {
		System.out.println("inside Nested_frame");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		WebElement objOuterFrame1 = driver.findElement(CharChar_Frame_Page.OuterFrame1);
		driver.switchTo().frame(objOuterFrame1);										//switch to 1st frame
		
		WebElement TextBox = driver.findElement(CharChar_Frame_Page.text_box);	//textBox
		//driver.switchTo().frame(TextBox);										//switch to textbox
		TextBox.sendKeys(objPro.getProperty("CharChar_Text"));
		
		WebElement insideFrame = driver.findElement(CharChar_Frame_Page.innerFrame);
		driver.switchTo().frame(insideFrame);										//switch to inside frame
		//driver.findElement(CharChar_Frame_Page.Check_box);
		//driver.findElement(By.xpath("//input[@type='checkbox']")).click(); 
		driver.findElement(CharChar_Frame_Page.Check_box).click(); 	//click checkbox
		driver.switchTo().defaultContent();
		
		WebElement ObjOuterFrame2 = driver.findElement(CharChar_Frame_Page.outerFrame2);
		driver.switchTo().frame(ObjOuterFrame2);
		driver.findElement(CharChar_Frame_Page.dropbox).click();		//Click on dropbox 
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("insite beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("insite afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("insite beforeTest");
		LaunchBrowserandGmoOnline();
	}

	@AfterTest
	public void afterTest() {

		System.out.println("insite afterTest");
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
		System.out.println("insite afterSuite");
	}

}
