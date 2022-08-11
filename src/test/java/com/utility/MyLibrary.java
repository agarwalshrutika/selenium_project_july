package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyLibrary {
	public static Properties objPro;
	public static WebDriver driver;

	public static void ReadProperties() throws IOException {
		System.out.println("file path is :" + System.getProperty("user.dir"));
		File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//configuration.properties");
		FileInputStream ObjIS = new FileInputStream(objFile);
		objPro = new Properties();
		objPro.load(ObjIS);

	}

	public static void LaunchBrowserandGmoOnline() {

		String browserfrompropertiesfile = objPro.getProperty("browser");
		switch (browserfrompropertiesfile) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}

	 public static void ExplicitWaitForAlert() {
		 WebDriverWait wait = new WebDriverWait(driver, ConstantValues.ExplicitWait);
		//  WebDriverWait wait = new WebDriverWait(driver,ConstantValues.ExplicitWait);
		  wait.until(ExpectedConditions.alertIsPresent());
	 }
}