package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.baseTest;
import com.qa.hubspot.basepage.constants;
import com.qa.hubspot.pages.homePage;
import com.qa.hubspot.util.ExcelUTil;
import com.qa.hubspot.pages.contactsPages;

public class contactsPageTest extends baseTest{

	homePage homePage;
	contactsPages contactsPages;
	contactsPageTest contactsPageTest;
	
	
	@BeforeClass
	public void homeSetup() throws InterruptedException
	{
			homePage = LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			contactsPages = homePage.gotocontacts();
	}
	
	@DataProvider
	 public Object[][]  createnewcontacttestdata() throws InterruptedException
	 {
		Object data[][]= ExcelUTil.getTestData("Contacts");
		return data;
	 }
		@Test(dataProvider ="createnewcontacttestdata" )
		public void createnewcontact(String firstname,String middleName,String	LastName, String company,String	tag,String department, String description
) throws InterruptedException
		{
			
			contactsPages.createnewcontact(firstname,middleName,LastName,company,tag,department,description);
			Thread.sleep(5000);
			 homePage.gotocontacts();
		}
		

}
