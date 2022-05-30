package com.crm.practice_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtilty;
import com.crm.pom.objectrepository.CreateNewProductPage;
import com.crm.pom.objectrepository.HomePage;
import com.crm.pom.objectrepository.LoginPage;
import com.crm.pom.objectrepository.ProductInformationPage;
import com.crm.pom.objectrepository.Productpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtilty wlib=new WebDriverUtilty();
		
		String productname=elib.getDataFromExcel("Sheet2", 5, 1)+jlib.getRandDomNumber();
		
		String browser=flib.getPropertyKeyValue("browser");
		String url= flib.getPropertyKeyValue("url");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		
		WebDriver driver=null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is"+browser);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is"+browser);
		}
		
		wlib.WaitForPageToLoad(driver);
		driver.get(url);
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.login(username, password);
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnproduct();
		
		Productpage productpage=new Productpage(driver);
		productpage.clickOnAddIcon();
		
		CreateNewProductPage newproduct=new CreateNewProductPage(driver);
		newproduct.createProducts(productname);
		newproduct.saveButton();
		
	
		ProductInformationPage pagetext=new ProductInformationPage(driver);
		if(pagetext.productInformationText().contains(productname)) {
			System.out.println("verification success");
		}
		else {
			System.out.println("verification not successfull");
		}
		homepage.logout(driver);
		driver.close();
		
	}

}
