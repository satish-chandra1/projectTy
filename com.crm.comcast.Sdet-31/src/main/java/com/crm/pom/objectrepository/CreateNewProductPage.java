package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	//declaration
		@FindBy(name="productname")
		private WebElement prodName;
		
		@FindBy(xpath="//b[text()='Product Information']/preceding::input[@title='Save [Alt+S]']")
		private WebElement saveButton;
		
		//initialization
		public CreateNewProductPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

		
		public WebElement getProdName() {
			return prodName;
		}
		
		
		//business logic
		public void createProducts(String productName) {
			prodName.sendKeys(productName);
			
		}
		public void saveButton() {
			saveButton.click();
		}

}
