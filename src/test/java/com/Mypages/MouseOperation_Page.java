package com.Mypages;

import org.openqa.selenium.By;

public class MouseOperation_Page {
	public static By rightClick = By.xpath("//span[text()='right click me']");
	public static By rightClick_Delete =  By.xpath("//span[text()='Delete']");
	public static By rightClick_Paste =  By.xpath("//span[text()='Paste']");
	public static By rightClick_copy =  By.xpath("//span[text()='Copy']");
	public static By Frame = By.xpath("//iframe");
	public static By Double_click = By.xpath("//span[text()='Double click the block']/preceding-sibling::div");
	public static By DoubleClick_ToolsQA = By.xpath("//*[@id='doubleClickBtn']");
	public static By DoubleClick_ToolsQA_message = By.xpath("//*[@id='doubleClickMessage']");
	public static By RightClick_ToolsQA = By.xpath("//*[@id='rightClickBtn']");
	public static By RightClick_ToolsQA_message = By.xpath("//*[@id='rightClickMessage']");
	public static By Click_ToolsQA = By.xpath("//*[@id='STqoL']"); 
	public static By Click_ToolsQA_message = By.xpath("//*[@id='dynamicClickMessage']");
}