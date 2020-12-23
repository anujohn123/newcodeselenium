package com.qa.hubspot.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.loginPage;
import com.qa.hubspot.pages.homePage;

import com.qa.hubspot.basepage.basePage;
import com.qa.hubspot.basepage.baseTest;
import com.qa.hubspot.basepage.constants;

public class homePageTest extends baseTest{
	homePage homePage;
	
	
@BeforeClass
public void homeSetup()
{
		homePage = LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
}
	@Test
	public void verifyHomePageusername() throws InterruptedException
	{
		Thread.sleep(8000);
		String title = homePage.getHomepageusername();
		System.out.println(title);
		Assert.assertEquals(title, constants.username, "Home page username is not correct");
	}
	@Test
	public void verifyheaderTitle() throws InterruptedException
	
	{
		Thread.sleep(3000);
		 homePage.getHomePageHeader();
		
		//Assert.assertEquals(header, constants.Home_Page_headertitle, "Home page header is not correct");
	}
	
	@Test
	public void gotocontact() throws InterruptedException
	
	{
		Thread.sleep(3000);
		 homePage.gotocontacts();
		 Thread.sleep(3000);
	
	}
	
	
}