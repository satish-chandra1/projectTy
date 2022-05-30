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
public class ContactInformationPage {
	//initialization
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    //declaration
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement headerText;
	
	//getter method
	public WebElement getHeaderText() {
		return headerText;
	}
	//business logic
	/**
	 *this method used to get the text of contacts 
	 * @return
	 */
	public String getContactsText() {
		return headerText.getText();
	}
}
