package com.qa.hubspot.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.loginPage;
import com.qa.hubspot.pages.homePage;

import com.qa.hubspot.basepage.basePage;
import com.qa.hubspot.basepage.constants;

public class homePageTest {
	basePage basePage;
	WebDriver driver;
	loginPage loginPage;
	homePage homePage;
	Properties prop;
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		basePage = new basePage();
		prop = basePage.init_properties();
		driver =basePage.init_browserName(prop);
		loginPage = new loginPage(driver);
		Thread.sleep(3000);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
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
		String header = homePage.getHomePageHeader();
		System.out.println(header);
		//Assert.assertEquals(header, constants.Home_Page_headertitle, "Home page header is not correct");
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}