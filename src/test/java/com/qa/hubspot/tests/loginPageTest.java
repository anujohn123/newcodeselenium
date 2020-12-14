package com.qa.hubspot.tests;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import  com.qa.hubspot.basepage.basePage;
import com.qa.hubspot.pages.loginPage;;

public class loginPageTest {
basePage basePage;
Properties prop ;
WebDriver driver;
loginPage LoginPage;
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		basePage = new basePage();
		prop = basePage.init_properties();
		driver = basePage.init_browserName(prop);
		
		LoginPage = new  loginPage(driver);
	}
	
	@Test(priority = 1)
	public void gettitle()
	{
		String title =LoginPage.pagetitle();
		System.out.println(title);
		Assert.assertEquals(title,"Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void checksignuplink()
	{
	//	Assert.assertTrue(LoginPage.checksignuplink());
	}
	
	@Test(priority = 3)
	public void loginpagetest() throws InterruptedException
	{
		LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(4000);
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}
