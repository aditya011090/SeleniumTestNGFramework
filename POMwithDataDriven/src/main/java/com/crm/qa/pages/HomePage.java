package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'User: group automation')]")
	WebElement loginusername;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath = "//a[normalize-space()='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement newContactslink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasklink;
	
	
	//Initializing Page Objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyLoginUserName() {
			return loginusername.isDisplayed();
		}
		
		public String validateHomePageTitle() {
			return driver.getTitle();
		}
		
		public DealsPage clickOnDealslink() {
			
			dealslink.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasklink() {
			tasklink.click();
			return new TasksPage();
		}
		
		
		public ContactsPage clickOnContactslink() {
			contactslink.click();
			return new ContactsPage();
		}
		
		public void clickOnNewContactsLinks() {
			Actions action = new Actions(driver);
			action.moveToElement(contactslink).build().perform();
			newContactslink.click();
		}
		
}
