package com.crm.pom.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtilty;
/**
 * 
 * @author satish
 *
 */
public class CreatePurchaseOrderPage extends WebDriverUtilty{

	//initialiazation
		public CreatePurchaseOrderPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
	//declaration
	@FindBy (name="subject")
	private WebElement SubjectTextBox;
	
	
	@FindBy(xpath="//input[@name=\"vendor_name\"]/following-sibling::img[@title='Select']")
	private WebElement VendorNameImg;
	
	@FindBy(name="postatus")
	private WebElement Selectstatus;
	
	@FindBy(name="bill_street")
	private WebElement BillingTextBox;
	
	@FindBy(name="ship_street")
	private WebElement ShippingTextBox;
	
	@FindBy(xpath="//img[@title=\"Products\"]")
	private WebElement ProductsImg;
	
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
	
	
	
	@FindBy(xpath="//img[@title=\"Products\"]")
	private WebElement productimg;
	
	@FindBy(id="qty1")
	private WebElement qtyTextBox;
	
	@FindBy(xpath="//input[@value=\"Add Product\"]")
	private WebElement AddProduct;
	
	@FindBy(xpath="//b[text()='Purchase Order Information']//preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
//getters method
	public WebElement getSubjectTextBox() {
		return SubjectTextBox;
	}

	public WebElement getVendorNameImg() {
		return VendorNameImg;
	}

	public WebElement getSelectstatus() {
		return Selectstatus;
	}

	public WebElement getBillingTextBox() {
		return BillingTextBox;
	}

	public WebElement getShippingTextBox() {
		return ShippingTextBox;
	}

	public WebElement getProductsImg() {
		return ProductsImg;
	}
	
	public WebElement getSearchpopup() {
		return SearchTextBox;
	}
	
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public WebElement getPopupproductSearch() {
		return productSearchTextBox;
	}
	public WebElement getProductpopupSeacrh() {
		return productSearch;
	}
	
	public WebElement getProductSearch() {
		return productSearch;
	}
	public WebElement getCheckbox() {
		return checkbox;
	}
	
	public WebElement getQtyTextBox() {
		return qtyTextBox;
	}
	

	public WebElement getAddProduct() {
		return AddProduct;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	//business logic
	/**
	 * this method is used to provide the data in SubjectTextBox
	 * @param subjectName
	 * 
	 */
	
	public void subject(String subjectName ) {
		SubjectTextBox.sendKeys(subjectName);
		
	}
	/**
	 * this method is used to click on lookup icon
	 */
	public void vendorlookUp() {
		VendorNameImg.click();
	}
	/**
	 * this method is used to click on product lookup icon
	 */
	
	public void productIcon() {
		ProductsImg.click();
	}
	/**
	 *this method is used to handle vendorLookup icon with help of switchto method 
	 * @param driver
	 * @param title
	 * @param title2
	 * @param vendorName
	 */
	public void vendorName(WebDriver driver,String title,String title2,String vendorName) {
		new WebDriverUtilty().switchToWindow(driver, title);
		SearchTextBox.sendKeys(vendorName);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		new WebDriverUtilty().switchToWindow(driver, title2);
		
	}
	/**
	 *this method is used to handle status  dropdown  with status parameter
	 * @param status
	 */
	public void selectDrop(String status) {
		new WebDriverUtilty().select(Selectstatus, status);		
	}
	/**
	 * this method used to handle status dropdown with status created parameter 
	 * @param StatusCreated
	 */
	public void StatusDrop(String StatusCreated) {
		new WebDriverUtilty().select(Selectstatus, StatusCreated);
	}
	/**
	 * this method used to handle  BillingTextBox
	 * @param billingAddress
	 */
	public void billingAddress(String billingAddress) {
		BillingTextBox.sendKeys(billingAddress);
	}
	/**
	 *this method used to handle ShippingTextBox
	 * @param shippingAddress
	 */
	
	public void shippingAddress(String shippingAddress) {
		ShippingTextBox.sendKeys(shippingAddress);
	}
	/**
	 * this method used to handle product name  with switchto method
	 * @param driver
	 * @param Title
	 * @param Title1
	 * @param productName
	 */
	public void productName(WebDriver driver,String Title,String Title1,String productName) {
		new WebDriverUtilty().switchToWindow(driver, Title);
		productSearchTextBox.sendKeys(productName);
		productSearch.click();
		checkbox.click();
		productSearch.click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		new WebDriverUtilty().switchToWindow(driver, Title1);
	}
	/**
	 *this method used to handle qtyTextBox
	 * @param quantity
	 */
	public void quantity (String quantity) {
		qtyTextBox.sendKeys(quantity);
	}
	/**
	 *this method used to create add product 
	 */
	public void addProduct() {
		AddProduct.click();
	}
	/**
	 * this method used to click on save button
	 */
	public void saveButton() {
		saveButton.click();
	}
	
	
	
	
	
	
	
	
}
