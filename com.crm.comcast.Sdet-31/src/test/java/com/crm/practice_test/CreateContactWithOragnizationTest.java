package com.crm.practice_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtilty;
import com.crm.pom.objectrepository.ContactPage;
import com.crm.pom.objectrepository.CreateContactPage;
import com.crm.pom.objectrepository.CreateOragnizationPage;
import com.crm.pom.objectrepository.HomePage;
import com.crm.pom.objectrepository.LoginPage;
import com.crm.pom.objectrepository.OragnizationInformationPage;
import com.crm.pom.objectrepository.OragnizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOragnizationTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib= new ExcelUtility();
		FileUtility flib=new FileUtility();
		WebDriverUtilty wlib=new WebDriverUtilty();
	
		String lastname=elib.getDataFromExcel("Sheet2", 1, 1)+jlib.getRandDomNumber();
		String oragnization=elib.getDataFromExcel("Sheet2", 6, 1)+jlib.getRandDomNumber();
		
		
		String browser=flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("url");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		 
		
		
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
		driver.manage().window().maximize();
		driver.get(url);
	
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.login(username, password);
		
		HomePage homepage =new HomePage(driver);
		homepage.clickOnOragnizationLink();
		 
		OragnizationPage oragnizatio=new OragnizationPage(driver);
		oragnizatio.CreateOragnization();
		
		CreateOragnizationPage create=new CreateOragnizationPage(driver);
		create.oragnizationCreate(oragnization);
		
		create.saveButton();
		
		OragnizationInformationPage  getinformation=new OragnizationInformationPage(driver);
		if(getinformation.getoragnizationText().contains(oragnization)) {
			System.out.println("oragnization is verified");
		}
		else{
			System.out.println("oragnization is not verified");
		}
		
		homepage.clickContacts();
		
		ContactPage contact=new ContactPage(driver);
		contact.clickOnCreateContacts();
		
		CreateContactPage createpage=new CreateContactPage(driver);
		createpage.CreateContact(lastname);
		createpage.oragnizationlookup();
		createpage.oragnizationNamePopup(driver, "testsoftware", "Accounts", oragnization);
		createpage.saveButton();
		

	}

}
