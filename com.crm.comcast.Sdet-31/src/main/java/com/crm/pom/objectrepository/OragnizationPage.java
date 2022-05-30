package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OragnizationPage {
	//initialization
	public OragnizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreateOragnizationImg;
	
	
	//getter method
	public WebElement getCreateOragnizationImg() {
		return CreateOragnizationImg;
	}
	//business logic
	/**
	 * this method used to click on create oragnization look up icon
	 */
	public void CreateOragnization() {
		CreateOragnizationImg.click();
	}
}
