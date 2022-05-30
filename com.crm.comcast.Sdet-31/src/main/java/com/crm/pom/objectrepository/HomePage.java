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
public class HomePage extends WebDriverUtilty{
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy (linkText="Organizations")
	private WebElement OragnizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/menuDnArrow.gif\"]")
	private WebElement MoreImg;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement selectCampaign;
	
	@FindBy(name="Purchase Order")
	private WebElement selectPurchaseOrder;
	
	
	@FindBy(name="Vendors")
	private WebElement vendors;
	

	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	 private WebElement signoutImg; 
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;
	

	//getter method
	
	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getOragnizationLink() {
		return OragnizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}
	
	public void ClickOnContactsLink() {
		contactsLink.click();
	}

	public WebElement getProductLink() {
		return productLink;
	}
	
	public WebElement getSelectCampaign() {
		return selectCampaign;
	}


	public WebElement getSelectPurchaseOrder() {
		return selectPurchaseOrder;
	}
	
	public WebElement getVendors() {
		return vendors;
	}


	public WebElement getMoreImg() {
		return MoreImg;
	}
	public WebElement getSignout() {
		return signout;
	}
	
	 //business logic
	/**
	 * this method used to click on oragnization
	 */
	public void clickOnOragnizationLink() {
		OragnizationLink.click();
	}
	/**
	 * this method used to perform mouseover on more lookup icon
	 * @param driver
	 */
	public void mouseOverOnMoreImg(WebDriver driver) {
		mouseOverOnElement(driver, MoreImg);
		selectCampaign.click();
		
	}
	public void camapignlink() {
		selectCampaign.click();
	}
	/**
	 *this method used to perform mouseover on purchase order look up icon 
	 * @param driver
	 */
	public void ClickonPurchaseorder(WebDriver driver) {
		
		mouseOverOnElement(driver, MoreImg);
		selectPurchaseOrder.click();
	}
	
	
	
	
	
	 public void clickOnproduct(){
		 productLink.click();
	 }
	 
	
	
	public void clickOnContacts(WebDriver driver) {
		WebDriverUtilty wlib=new WebDriverUtilty();
		wlib.waitForElementToBeClickAble(driver, contactsLink);
		
	}
	
	public void mouseonVendors(WebDriver driver) {
		mouseOverOnElement(driver, MoreImg);
		vendors.click();
	}
	
	public void clickContacts() {
		contactsLink.click();
	}
	

	public void signoutlookup() {
		signoutImg.click();
	}
	
	public void logout(WebDriver driver) {
		mouseOverOnElement(driver,signoutImg);
		signout.click();
		}
	
		
	}
	

