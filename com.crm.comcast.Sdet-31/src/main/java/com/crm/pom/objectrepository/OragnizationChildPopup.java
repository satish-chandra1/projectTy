package com.crm.pom.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtilty;

public class OragnizationChildPopup {

	//initializaton
	public OragnizationChildPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
		@FindBy(name="search_text")
		private WebElement SearchTextBox;
		
		@FindBy(name="search")
		private WebElement searchButton;
	
	

		//getter method
		public WebElement getSearchTextBox() {
			return SearchTextBox;
		}

		public WebElement getSearchButton() {
			return searchButton;
		}
		
		
		//business logic
		/**
		 *  this method used to handle oragnization name pop up
		 * @param driver
		 * @param oragname
		 */
		public void ChildBrowserPopup(WebDriver driver,String oragname) {
			WebDriverUtilty wlib=new WebDriverUtilty();
		wlib.switchToWindow(driver, "Accounts");
		SearchTextBox.sendKeys(oragname);
		searchButton.click();
		driver.findElement(By.linkText(oragname)).click();
		}
		
}
