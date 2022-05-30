package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtilty;

public class CreateOragnizationPage extends WebDriverUtilty {
	
	@FindBy (name="accountname")
	private WebElement OragnizationName;
	
	@FindBy (name="industry")
	private WebElement selectIndustry;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	public CreateOragnizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOragnizationName() {
		return OragnizationName;
	}

	public WebElement getSelectIndustry() {
		return selectIndustry;
	}
	WebDriverUtilty wlib=new WebDriverUtilty();
	//business logic
	public void createoragnization(String Orgname,String industry) {
		OragnizationName.sendKeys(Orgname);
		wlib.select(selectIndustry, industry);
			}
	public void oragnizationCreate(String oragnization) {
		OragnizationName.sendKeys(oragnization);
	}
	public void saveButton() {
			saveButton.click();

		}
}
