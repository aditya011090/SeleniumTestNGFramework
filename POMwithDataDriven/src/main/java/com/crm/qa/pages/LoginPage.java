package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {

	//PageFactory or Object repository
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	
	
	  @FindBy(xpath = "//input[@value='Login']") 
	  WebElement loginBtn;
	 
	 
	
	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	WebElement signUplink;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement logoCrm;
	
	//Initializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMlogo() {
		return logoCrm.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		Thread.sleep(300);
		
		loginBtn.click();
		return new HomePage();
		
		//comment
	}
}
