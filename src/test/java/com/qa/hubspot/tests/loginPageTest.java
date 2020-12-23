package com.qa.hubspot.tests;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import  com.qa.hubspot.basepage.basePage;
import com.qa.hubspot.basepage.baseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.pages.loginPage;;


public class loginPageTest extends baseTest {
	
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
	

}
