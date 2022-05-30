package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Satish
 *
 */
public class ContactPage {
	//initialization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//declaration
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createcontactImg;
	
	//getter method
	public WebElement getCreatecontactImg() {
		return createcontactImg;
	}
	//business logic
	/**
	 *this method  used to click on create contact lookup icon 
	 */
	public void clickOnCreateContacts() {
		createcontactImg.click();
	}
}
