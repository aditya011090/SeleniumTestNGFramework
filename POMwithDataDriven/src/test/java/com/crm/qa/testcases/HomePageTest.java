package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage ContactsPage;
	DealsPage DealsPage;
	TasksPage TasksPage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homepageTitleTest() {
		String homepagetitle = homepage.validateHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority =2)
	public void verifyLoginNameOfUserTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifyLoginUserName());	
	}
	
	@Test(priority =3)
	public void verifyContactslinksTest() {
		testUtil.switchToFrame();
		ContactsPage = homepage.clickOnContactslink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
