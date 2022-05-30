package com.crm.practice_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtilty;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOragnizationwithIndustry_test {

	public static void main(String[] args) throws Throwable {
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib= new ExcelUtility();
		FileUtility flib=new FileUtility();
		WebDriverUtilty wlib=new WebDriverUtilty();
		
		int randomNum=jlib.getRandDomNumber();
		
		String oragname=elib.getDataFromExcel("sheet1", 2, 0)+randomNum;
		String industry=elib.getDataFromExcel("sheet1", 2, 1);
		
		String browser=flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("url");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is"+browser);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is"+browser);
		}
		else {
			System.out.println("use valid browser");
		}
		
		wlib.WaitForPageToLoad(driver);
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(oragname);
		WebElement element=driver.findElement(By.name("industry"));
		wlib.select(element, industry);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		String value=driver.findElement(By.id("mouseArea_Industry")).getText();
		if(value.contains(industry)) {
			System.out.println("testscrip is pass");
		}else {
			System.out.println("testscript is fail");
		}
		 wlib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")));
			wlib.waitForElementToBeClickAble(driver, driver.findElement(By.linkText("Sign Out")));
			driver.close();
		
	}

}
