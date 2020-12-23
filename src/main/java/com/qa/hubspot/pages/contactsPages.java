package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;

import com.qa.hubspot.basepage.basePage;
import com.qa.hubspot.util.ExcelUTil;
import com.qa.hubspot.util.GenericFunctionUtil;

public class contactsPages extends basePage {
	WebDriver driver;
	public GenericFunctionUtil GenericFunctionUtil;
	Actions actions;
	
	
    By firstName = By.xpath("//div/input[@name ='first_name']");
    By middleName = By.xpath("//div/input[@name ='middle_name']");
    By lastname = By.xpath("//div/input[@name ='last_name']");
    By company = By.xpath("//div/div[@name ='company']/input");
    By tag = By.xpath("//label/div[@role = 'combobox']/input");
    By department = By.xpath("//div/input[@name ='department']");
    By description = By.xpath("//div/textarea[@name ='description']");
    By save = By.xpath("//div/button[contains(text(),'Save')]");
	 
	 public contactsPages(WebDriver driver) {
		 
		 this.driver = driver;
		 GenericFunctionUtil = new GenericFunctionUtil(this.driver);
		 
			 
	 }
	 
	 
	 public void  createnewcontact(String firstname,String middlename,String lastName,String Company,String admin,String depat,String descrp) throws InterruptedException
	 {
		 driver.findElement(firstName).sendKeys(firstname);
		 String title = driver.findElement(firstName).getText();
		 System.out.println(title);
		 driver.findElement(middleName).sendKeys(middlename);
		
		 driver.findElement(lastname).sendKeys(lastName);
		 
		 driver.findElement(company).sendKeys(Company);
		 
		 driver.findElement(tag).sendKeys(admin);
		
		 driver.findElement(department).sendKeys(depat);
		
		 driver.findElement(description).sendKeys(descrp);
		
		 driver.findElement(save).click();
		Thread.sleep(5000);
		 
	 }
	
	
	

}
