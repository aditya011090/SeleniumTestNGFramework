package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage ContactsPage;
	DealsPage DealsPage;
	TasksPage TasksPage;
	TestUtil testUtil;

	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		ContactsPage = new ContactsPage();
		homepage = new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		// testUtil.switchToFrame();
		testUtil.switchToFrame();
		ContactsPage = homepage.clickOnContactslink();
		Assert.assertTrue(ContactsPage.verifyContactsLabel(), "Contacts label is not present");
	}

	@DataProvider
	public Object[][] getCRMTestData()  {
	Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}


	@Test(priority = 2, dataProvider="getCRMTestData" )
	public void validateCreateNewContact(String title,String firstname, String lastname, String company) {
		
		testUtil.switchToFrame();
		
		homepage.clickOnNewContactsLinks();
		ContactsPage.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
