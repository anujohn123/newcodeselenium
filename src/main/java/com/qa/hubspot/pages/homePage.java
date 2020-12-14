package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.basePage;

public class homePage extends basePage{
	private WebDriver driver;
	
	 By username = By.xpath("//div/span[@class ='user-display']");
	 By header = By.xpath("//div[@id='top-header-menu']");
	 
	 public homePage(WebDriver driver) {
		 
		 this.driver = driver;
		 
		 
		 
	 }

	 public String getHomepageusername()
	 {
		 return driver.findElement(username).getText();
	 }
	 
	 public String getHomePageHeader()
	 {
		 return driver.findElement(header).getText();
	 }
	 
}
