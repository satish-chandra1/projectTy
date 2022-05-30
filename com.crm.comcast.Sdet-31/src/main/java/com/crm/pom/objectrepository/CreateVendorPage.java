package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Satish
 */
public class CreateVendorPage {
	//Declaration
	@FindBy(name="vendorname")
	private WebElement vendorName;
	
	@FindBy(xpath="//b[text()='Vendor Information:']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	

	//initialization
	public CreateVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	//business logic
	public void createVendor(String data) {
		vendorName.sendKeys(data);
		saveButton.click();
	}
}