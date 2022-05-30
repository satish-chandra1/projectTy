package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInformationPage {
	//initialization
	public PurchaseOrderInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//declaration
	@FindBy(id="dtlview_Status")
	private WebElement VerifyStatusText;
	
	@FindBy(id="dtlview_Status")
	private WebElement verifycreated;
	
	public WebElement getVerifycreated() {
		return verifycreated;
	}

	public WebElement getVerifyStatusText() {
		return VerifyStatusText;
	}
	//business logic
	/**
	 * this method used to verify Approved status
	 * @return
	 */
	public String verifyStatus() {
		return VerifyStatusText.getText();
		
	}
	/**
	 * this method used to verify created status
	 * @return
	 */
	public String verifycreated() {
		return verifycreated.getText();
	}

}
