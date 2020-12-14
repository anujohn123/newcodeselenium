package com.qa.hubspot.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basePage {

	
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_browserName(Properties prop)
	
	{
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equals("chrome")){
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(BrowserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if(BrowserName.equals("safari"))
		{
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}}
		else
		{
			System.out.println("Browsername" +BrowserName+ "is not found");
		}
	
	//	driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url"));
		return driver;
}
	
	public Properties init_properties() throws IOException
	{
		 prop = new Properties();
		 try {
			FileInputStream FIS = new FileInputStream("C:\\Users\\anujo\\OneDrive\\Desktop\\All framework\\Basic_selenium_2020\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
		prop.load(FIS);
		 } catch (FileNotFoundException e) {
			System.out.println("ISssues to intialize config file");
			e.printStackTrace();
		}
		return prop;		
	}	 
		 
		 
		 
		 
		 
	
}