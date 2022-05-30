package com.crm.purchaseordertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.pom.objectrepository.CreateNewProductPage;
import com.crm.pom.objectrepository.CreatePurchaseOrderPage;
import com.crm.pom.objectrepository.CreateVendorPage;
import com.crm.pom.objectrepository.HomePage;
import com.crm.pom.objectrepository.LoginPage;
import com.crm.pom.objectrepository.Productpage;
import com.crm.pom.objectrepository.PurchaseOrderInformationPage;
import com.crm.pom.objectrepository.PurchaseOrderPage;
import com.crm.pom.objectrepository.VendorPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PurchaseOrderTest {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		
		String subjectName=elib.getDataFromExcel("Sheet2", 0, 1)+jlib.getRandDomNumber();
		String vendorName=elib.getDataFromExcel("Sheet2", 1, 1)+jlib.getRandDomNumber();
		String status=elib.getDataFromExcel("Sheet2", 2, 1);
		String billingAddress=elib.getDataFromExcel("Sheet2", 3, 1);
		String shippingAddress=elib.getDataFromExcel("Sheet2", 4, 1);
		String productName=elib.getDataFromExcel("Sheet2", 6, 1);
		String quantity=elib.getDataFromExcel("Sheet2", 7, 1);
		
	
		String browser=flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("url");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}	
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("launch valid browser");
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get(url);
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username ,password );
		
		HomePage homepage=new HomePage(driver);
		homepage.mouseonVendors(driver);
		
		VendorPage page=new  VendorPage(driver);
		page.clickOnVendorlookup();
		
		CreateVendorPage vendorcreate=new CreateVendorPage(driver);
		vendorcreate.createVendor(vendorName);
		homepage.clickOnproduct();
		
		Productpage addpage=new Productpage(driver);
		addpage.clickOnAddIcon();
		
		CreateNewProductPage newproduct=new CreateNewProductPage(driver);
		newproduct.createProducts(productName);
		
		homepage.ClickonPurchaseorder(driver);
		
		
		
		
		PurchaseOrderPage order=new PurchaseOrderPage(driver);
		order.clickOnLookUp(driver);
		
		
		
		CreatePurchaseOrderPage create=new CreatePurchaseOrderPage(driver) ;
		create.subject(subjectName);
		create.vendorlookUp();
		create.vendorName(driver, "Vendors", "PurchaseOrder", vendorName);
		create.selectDrop(status);
		create.billingAddress(billingAddress);
		create.shippingAddress(shippingAddress);
	
		create.productIcon();
		create.productName(driver, "testsoftware", "action", productName);
		create.quantity(quantity);
		create.saveButton();
		
		PurchaseOrderInformationPage verify=new PurchaseOrderInformationPage(driver);
		if(verify.verifyStatus().equals(status)) {
			System.out.println("status is inserted successfully");
		}
		else {
			System.out.println("status is not inserted");
		}
		
		homepage.logout(driver);
		
		driver.close();
		
	}

}
