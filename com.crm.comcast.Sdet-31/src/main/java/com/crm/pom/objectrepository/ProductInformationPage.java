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
public class ProductInformationPage {
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//span[@class=\"lvtHeaderText\"]")
	private WebElement getInformationText;
	
	public WebElement getGetInformationText() {
		return getInformationText;
	}
	
	public String productInformationText() {
		return getInformationText.getText();
	}
}
