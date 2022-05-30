package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author satish
 *
 */
public class CampaignInformationPage {
	//initialization
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//declaration
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement HeaderText;


	
	//getter method
	public WebElement getHeaderText() {
		return HeaderText;
	}
	//business logic
	/**
	 * this method used to verify text of campaign
	 * @return
	 */
	public String getCampaignText() {
		return HeaderText.getText();
		
	}
}