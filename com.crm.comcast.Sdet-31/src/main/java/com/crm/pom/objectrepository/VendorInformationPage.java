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
public class VendorInformationPage {
	//initialization
	public VendorInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	//declaration
	@FindBy(xpath="//span[@class=\"lvtHeaderText\"]")
	private WebElement text;
	
	
	//getter method
	public WebElement getText() {
		return text;
	}
	
	//business logic
	/**
	 * this method used to get text of vendor
	 * @return
	 */
	public String getVendorText() {
	return text.getText(); 
}
}
