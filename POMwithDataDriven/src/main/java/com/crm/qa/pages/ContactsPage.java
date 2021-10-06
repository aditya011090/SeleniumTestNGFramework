package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
//this is contacts page
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(xpath = "//input[@value='52823645']")
	WebElement contactname;
	
	@FindBy(id = "first_name")
	WebElement firstname;
	
	@FindBy(id = "surname")
	WebElement lastname;
	
	@FindBy(name = "client_lookup")
	WebElement companyname;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement saveBttn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactslabel.isDisplayed();
	}
	
	public void clickOnContactName() {
		contactname.click();
	}
	
	public void createNewContact(String title,String ftname, String ltname, String company) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		companyname.sendKeys(company);
		saveBttn.click();
	}
}
