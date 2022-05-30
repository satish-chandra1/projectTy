package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtilty;
/**
 * 
 * 
 * @author satish
 *
 */
public class PurchaseOrderPage extends WebDriverUtilty {
	//declaration
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createPurchaseImg;
	//initialization
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatePurchaseImg() {
		return createPurchaseImg;
	}
	
	
	//business logic  utilization
	/**
	 * this method used to click on purchase lookup icon
	 * @param driver
	 */
	public void clickOnLookUp(WebDriver driver) {
		createPurchaseImg.click();
	}
}
