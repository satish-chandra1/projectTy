package com.crm.practice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.pom.objectrepository.ContactInformationPage;
import com.crm.pom.objectrepository.ContactPage;
import com.crm.pom.objectrepository.CreateContactPage;
import com.crm.pom.objectrepository.CreateOragnizationPage;
import com.crm.pom.objectrepository.HomePage;
import com.crm.pom.objectrepository.LoginPage;
import com.crm.pom.objectrepository.OragnizationChildPopup;
import com.crm.pom.objectrepository.OragnizationInformationPage;
import com.crm.pom.objectrepository.OragnizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest {

	public static void main(String[] args) throws Throwable {
		FileUtility flib =new FileUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		
		String firstName=elib.getDataFromExcel("Sheet1", 8, 0);
		String lastName=elib.getDataFromExcel("Sheet1", 9, 0)+jlib.getRandDomNumber();

		String oragnizationname=elib.getDataFromExcel("Sheet1",6 , 0)+jlib.getRandDomNumber();
		String industryname=elib.getDataFromExcel("Sheet1", 7, 0) ;
		
		
		String browser=flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("url");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();		
		}
		else {
			System.out.println("use the valid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		 
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOragnizationLink();
		
		
		
		OragnizationPage oragnization =new OragnizationPage(driver);
		oragnization.CreateOragnization();
		
		CreateOragnizationPage create=new CreateOragnizationPage(driver);
		create.createoragnization(oragnizationname, industryname);
		
		
		
		OragnizationInformationPage information=new OragnizationInformationPage(driver);
		String actualoragnization=information.getoragnizationText();
		
		if(actualoragnization.contains(oragnizationname)) {
			System.out.println("oragnization name is created");
		}
		else {
			System.out.println("oragnization name is not created");
		}
		
		homepage.ClickOnContactsLink();
		
		ContactPage contact=new ContactPage(driver);
		contact.clickOnCreateContacts();
		
		CreateContactPage createcontact=new CreateContactPage(driver);
		createcontact.CreateContact(firstName);
		
		ContactInformationPage informatio=new ContactInformationPage(driver);
		String actualcontact=informatio.getContactsText();
		
		
		if(actualcontact.contains(firstName)) {
			System.out.println("contacts created");
		}
		else {
			System.out.println("contact not created");
		}
		
		OragnizationChildPopup popup=new OragnizationChildPopup(driver);
		popup.ChildBrowserPopup(driver,oragnizationname);
		
		
		
		homepage.logout(driver);
		
				}

}
