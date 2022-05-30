package com.crm.practice_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtilty;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOragnization_test {

	public static void main(String[] args) throws Throwable {
		JavaUtility jlib=new  JavaUtility();
		FileUtility flib= new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtilty wlib=new WebDriverUtilty();
		
		int randomNum=jlib.getRandDomNumber();
		
		String oragName=elib.getDataFromExcel("sheet1", 1, 0)+randomNum;
		
		String browser=flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("url");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is"+browser );	
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is "+ browser );
		}
		else {
			System.out.println("use valid browser");
		}
		
		wlib.WaitForPageToLoad(driver);//implictly wait implementation
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(oragName);
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		 String value=driver.findElement(By.className("dvHeaderText")).getText();
		 if(value.contains(oragName)) {
			 
			 System.out.println("testscript is pass:"+oragName);
		 }
		 else {
			 System.out.println("testscrip is fail:"+oragName);
		 }
		 
		 wlib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")));
		 
		 wlib.waitForElementToBeClickAble(driver, driver.findElement(By.linkText("Sign Out")));
		 driver.close();
		
		
		
	}

}
