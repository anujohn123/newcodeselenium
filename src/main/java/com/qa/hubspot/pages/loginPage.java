package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.basePage;
import com.qa.hubspot.util.GenericFunctionUtil;

public class loginPage extends basePage{
	
	WebDriver driver;
	public GenericFunctionUtil GenericFunctionUtil;
	By emailID = By.name("email");
	By pwd = By.name("password");
	By loginBtn = By.xpath("//a/span[contains(text(),'Log In')]");
	By singupLink = By.linkText("Sign u");
	By loginCRM = By.xpath("//div/div[contains(text(),'Login')]");
	
	
public  loginPage(WebDriver driver)
{
	this.driver = driver;
	GenericFunctionUtil = new GenericFunctionUtil(this.driver);
	}

//Page actions
public String pagetitle()

{
	return driver.getTitle();
	}


public boolean checksignuplink()
{
	return driver.findElement(singupLink).isDisplayed();
	
}

public  homePage doLogin(String username,String Password)

{
	//driver.findElement(loginCRM).click();
	driver.findElement(emailID).sendKeys(username);
	driver.findElement(pwd).sendKeys(Password);
	driver.findElement(loginCRM).click();
	
	return new homePage(driver);
	}


}
