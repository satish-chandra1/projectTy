package com.crm.pom.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtilty;

public class CreateContactPage extends  WebDriverUtilty{
	
	//initialization
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this );
	}
	//declaration
	@FindBy(name="lastname")
	private WebElement LastNameTextFeild;
		
	@FindBy(xpath="//input[@name=\"account_name\"]/following-sibling::img[@title='Select']")
	private WebElement oragnizationaNameImg;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(id="search_txt")
	private WebElement searchTextbox;
	
	@FindBy(name="search")
	private WebElement SearchButton;

	//getter method
	public WebElement getLastNameTextFeild() {
		return LastNameTextFeild;
	}
	public WebElement getSearchTextbox() {
		return searchTextbox;
	}


	public WebElement getSearchButton() {
		return SearchButton;
	}

	

	public WebElement getSaveButton() {
		return saveButton;
	}


	public WebElement getOragnizationaNameImg() {
		return oragnizationaNameImg;
	}


	//business logic
	/**
	 * this method used to enter lastname in Last Name TextFeild
	 * @param lastname
	 */
	public void CreateContact(String lastname) {
		
		LastNameTextFeild.sendKeys(lastname);
		
		
	}
	public void oragnizationlookup() {
		oragnizationaNameImg.click();
	}
	
	public void oragnizationNamePopup(WebDriver driver,String title,String title2,String oragnization) {
		new WebDriverUtilty().switchToWindow(driver, title);
		searchTextbox.sendKeys(oragnization);
		SearchButton.click();
		driver.findElement(By.xpath("//a[text()='"+oragnization+"']")).click();
		new WebDriverUtilty().switchToWindow(driver, title2);		
	 }
	public void saveButton() {
		saveButton.click();
	}
			
}
