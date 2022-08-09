package com.Mypages;

import org.openqa.selenium.By;

public class Frame_page {
	
	public static By firstFrame_demoqa = By.xpath("//*[@id=\"frame1\"]");
	public static By TextFromFrame = By.xpath("//*[@id=\"sampleHeading\"]");
	public static By SecondFrame_demoqa = By.xpath("//*[@id=\"frame2\"]");
	
	public static By nested_outerFrame = By.id("frame1");
	public static By nested_Topic_box = By.tagName("input");
	
	 
}
