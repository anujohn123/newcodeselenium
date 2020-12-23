package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericFunctionUtil {
WebDriver driver;

public  GenericFunctionUtil(WebDriver driver)
{
	this.driver = driver;
}

public WebElement getElement(By Locator)
{
	WebElement element = null;
	try{
	System.out.println("Locator is .."+Locator);
	element = driver.findElement(Locator);
	}
	catch(Exception e)
	{
	System.out.println("Exception Occured");	
		}
	return element;
	}
}
