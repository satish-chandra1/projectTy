package com.crm.createcontact_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtilty;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createcontactwithoragnization_test {

	public static void main(String[] args) throws Throwable {
		
		
		//create object to libraries
		JavaUtility jlib=new JavaUtility();
		WebDriverUtilty wlib=new WebDriverUtilty();
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		
		//get random data
		int randomNum =jlib.getRandDomNumber();
		
		//read data from excel sheet
	
		
		String orgName = elib.getDataFromExcel("sheet1", 1, 1)+ randomNum;
		String contacts = elib.getDataFromExcel("sheet2", 1, 1)+randomNum;
		
		
	
		//read data from propety file

		String browser=flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("url");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		
	//launch the browser
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launched browser is "+ browser);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launched browser is "+ browser);
		}else {
			System.out.println("specify a valid browser");
		}
		
		wlib.WaitForPageToLoad(driver);
		driver.get(url);
		
		//step1--login to application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//step2-- navigate to organization
				driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		//step3--navigate to create organization
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//step4--create a new organization
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				
		//click on save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify
				WebElement header=driver.findElement(By.className("dvHeaderText"));
				wlib.waitForElementToBeClickAble(driver, header);
				
				
		//USE explicit wait to navigate to contacts
				WebDriverWait wait =new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.linkText("Contacts"))));
				
		//navigate to contacts
				 driver.findElement(By.linkText("Contacts")).click();
		//navigate to create contact
				 driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
				 driver.findElement(By.name("lastname")).sendKeys("contacts");
				 
		//click on organization img
		         driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		         

				 
		//to handle the popup
				 wlib.switchToWindow(driver, "Accounts");
				
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
			 wlib.switchToWindow(driver, "Contacts");
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//verify
			String value1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
			
			
			//logout
			
				wlib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")));
				driver.findElement(By.linkText("Sign Out")).click();
				driver.close();
			  
			  
		
		
	}

}
