package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.basePage;

public class homePage extends basePage{
	private WebDriver driver;
	
	 By username = By.xpath("//div/span[@class ='user-display']");
	 By header = By.xpath("//div[@id='top-header-menu']");
	 
	   By contact = By.xpath("//div/a/span[contains(text(),'Contacts')]//following::button/i");
	    By contactstext = By.xpath("//div/a/span[contains(text(),'Home')]");
	 
	 public homePage(WebDriver driver) {
		 
		 this.driver = driver;
		 
		 
		 
	 }

	 public String getHomepageusername()
	 {
		 return driver.findElement(username).getText();
	 }
	 
	 public void getHomePageHeader() throws InterruptedException
	 {
		  driver.findElement(header).getText();
		  Thread.sleep(5000);
		 
	 }
	 
	 public contactsPages gotocontacts() throws InterruptedException
	 {
		 driver.findElement(contactstext).click();
		 Thread.sleep(1000);
		 driver.findElement(contact).click();
		 return new contactsPages(driver);
	 }
	 
}
