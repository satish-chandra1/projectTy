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
public class VendorPage {
	//initialization
	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement vendorLookup;
	
	//getter method
	public WebElement getVendorLookup() {
		return vendorLookup;
	}
	//business logic
	/**
	 * this method used to click on vendor look up icon
	 */
	public void clickOnVendorlookup() {
		vendorLookup.click();
	}
}
