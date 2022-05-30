package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	//initialization
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreatecampaignImg;
	
	
 //gettermethod
	public WebElement getCreatecampaignImg() {
		return CreatecampaignImg;
	}
	
	//business logic
	/**
	 * this method used to click on create campaign
	 */
	public void CreateCampaign() {
		CreatecampaignImg.click();
	}

}
