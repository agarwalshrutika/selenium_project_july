package com.Mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;

public class CharChar_Frame_Page {
	
	public static By OuterFrame1 = By.xpath("//iframe[@id='frame1']");
	public static By innerFrame = By.xpath("//iframe[@id='frame3']");
	public static By outerFrame2 = By.xpath("//iframe[@id='frame2']") ;
	public static By Check_box =By.xpath("//input[@type='checkbox']");
	public static By text_box =By.xpath("//input");
	public static By dropbox= By.xpath("//select[@id= 'animals']");
	
	}
