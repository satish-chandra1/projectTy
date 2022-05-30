package com.crm.pom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Satish
 *
 */
public class LoginPage {
	//declaration
	@FindBy(name="user_name")
	private WebElement userNameTextfeild;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfelid;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;

	
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		

		}


	public WebElement getUserNameTextfeild() {
		return userNameTextfeild;
	}


	public WebElement getPasswordTextfelid() {
		return passwordTextfelid;
	}


	public WebElement getLoginbutton() {
		return loginbutton;
	}
		
	//business logic
	/**
	 * this method used to fill user Name Textfeild and password Textfelid
	 * @param username
	 * @param password
	 */
	public void login(String username,String password) {
		userNameTextfeild.sendKeys("admin");
		passwordTextfelid.sendKeys("root");
		loginbutton.click();
		
	}

}
