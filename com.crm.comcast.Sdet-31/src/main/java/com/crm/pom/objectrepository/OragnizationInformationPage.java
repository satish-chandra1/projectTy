package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtilty;
/**
 * 
 * @author Satish
 *
 */
public class OragnizationInformationPage {
	//initialization
	public OragnizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement headerText;
	
	
	//getter method
	public WebElement getHeaderText() {
		return headerText;
	}
	//business libraries
	/**
	 * this method used to get text from oragnization
	 * @return
	 */
	public String getoragnizationText() {
		 return headerText.getText();
	}
		
			}
	


