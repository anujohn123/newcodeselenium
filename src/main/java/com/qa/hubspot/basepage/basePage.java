package com.qa.hubspot.basepage;

import java.io.File;
import java.io.FileInputStream;
import com.qa.hubspot.util.GenericFunctionUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class basePage {

	
	WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> t1Driver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver()
	{
		return t1Driver.get();
	}
	
	public WebDriver init_browserName(Properties prop)
	
	{
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equals("chrome")){
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			t1Driver.set(new ChromeDriver());
		}
		if(BrowserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			t1Driver.set(new FirefoxDriver());
		}
		if(BrowserName.equals("safari"))
		{
			WebDriverManager.getInstance(SafariDriver.class).setup();
			t1Driver.set(new SafariDriver());
			//driver = new SafariDriver();
		}}
		else
		{
			System.out.println("Browsername" +BrowserName+ "is not found");
		}
	
	//	driver.manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
}
	
	public Properties init_properties() throws IOException
	{
		 prop = new Properties();
		 String Env = null;
		 String path = null;
		 try {
			 Env = System.getProperty("env");
			 if(Env == null)
			 {
				 path = "C:\\\\Users\\\\anujo\\\\OneDrive\\\\Desktop\\\\All framework\\\\Basic_selenium_2020\\\\src\\\\main\\\\java\\\\com\\\\qa\\\\hubspot\\\\config\\\\config.properties";
			 }else {
				 {switch(Env) {
				 case "qa": 
					 path = "C:\\Users\\anujo\\OneDrive\\Desktop\\All framework\\Basic_selenium_2020\\src\\main\\java\\com\\qa\\hubspot\\config\\qa.config.properties";
					 break;
				 case "stg": 
					 path = "C:\\Users\\anujo\\OneDrive\\Desktop\\All framework\\Basic_selenium_2020\\src\\main\\java\\com\\qa\\hubspot\\config\\stg.config.propeties";
					 break;
					 default:
						 System.out.println("Please provide correct env");
						 break;
				 }
					 }
			 }
			FileInputStream FIS = new FileInputStream(path);
		prop.load(FIS);
		 } catch (FileNotFoundException e) {
			System.out.println("ISssues to intialize config file");
			e.printStackTrace();
		}
		return prop;		
	}	 
		 
		 /*
		  * Screenshot 
		  */
		 public String getScreenshot() 
		 {
			File src =((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		 String path =System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis() + ".png";
		 File destination = new File(path);
		 try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 return path;
		 }
		 
		 
	
}