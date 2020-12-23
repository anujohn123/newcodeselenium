package com.qa.hubspot.basepage;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.hubspot.pages.loginPage;

public class baseTest {
	
		public  basePage basePage;
		public  Properties prop ;
		public  WebDriver driver;
		public  loginPage LoginPage;
			
			@BeforeTest
			public void setup() throws IOException, InterruptedException
			{
				basePage = new basePage();
				prop = basePage.init_properties();
				driver = basePage.init_browserName(prop);
				
				LoginPage = new  loginPage(driver);
			}
			
			@AfterTest
			public void teardown()
			{
				driver.quit();
			}
			

}
