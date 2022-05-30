package com.crm.pom.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtilty;

public class CreateCampaignsPage {

	
	//initialization
	public CreateCampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(name="campaignname")
	private WebElement CampaignNameTextFeild;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement productimg;
	
	@FindBy(name="search_text")
	private WebElement SearchTextBox;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(name="search_text")
	private WebElement productSearchTextBox;
	
	@FindBy(name="search_text")
	private WebElement productSearch;
	
	@FindBy(name="selected_id")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@class=\"crmbutton small save\"]")
	private WebElement SelectProduct;
	


	
	//getter method
	public WebElement getCampaignNameTextFeild() {
		return CampaignNameTextFeild;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getSearchTextBox() {
		return SearchTextBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getProductSearchTextBox() {
		return productSearchTextBox;
	}

	public WebElement getProductSearch() {
		return productSearch;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getSelectProduct() {
		return SelectProduct;
	}


	public WebElement getProductimg() {
		return productimg;
	}
	//business logic
	/**
	 * this method used to perform typing action on Campaign Name TextFeild
	 * used to click on save button
	 * @param campaignname
	 */
	public void CreateCampaign(String campaignname) {
		CampaignNameTextFeild.sendKeys(campaignname);
		//saveButton.click();
	}
	public void savebutton() {
		saveButton.click();
	}
	public void productLookup() {
		productimg.click();
	}
	public void productName(WebDriver driver,String Title,String Title1,String productName) {		
		new WebDriverUtilty().switchToWindow(driver, Title);
		productSearchTextBox.sendKeys(productName);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		//checkbox.click();
		//productSearch.click();
	//	driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		new WebDriverUtilty().switchToWindow(driver, Title1);
	}

}
