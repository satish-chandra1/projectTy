package com.crm.practice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtilty;
import com.crm.pom.objectrepository.CampaignInformationPage;
import com.crm.pom.objectrepository.CampaignsPage;
import com.crm.pom.objectrepository.CreateCampaignsPage;
import com.crm.pom.objectrepository.HomePage;
import com.crm.pom.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest {

	public static void main(String[] args) throws Throwable {
		WebDriverUtilty wlib=new WebDriverUtilty();
		JavaUtility jlib=new JavaUtility();
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		
		String campaignName=elib.getDataFromExcel("Sheet1", 1, 0)+jlib.getRandDomNumber();
		
		String browser =flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("url");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		
		
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("open a valid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get(url);
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		HomePage homepage=new HomePage(driver);
		homepage.mouseOverOnMoreImg(driver);
		
		CampaignsPage campaign =new CampaignsPage(driver);
		campaign.CreateCampaign();
		
		CreateCampaignsPage createcampaign=new CreateCampaignsPage(driver);
		createcampaign.CreateCampaign(campaignName);
		createcampaign.savebutton();
		
		CampaignInformationPage information= new CampaignInformationPage(driver);
		String actualresult=information.getCampaignText();
		if(actualresult.contains(actualresult)) {
			System.out.println("campaign created successfully");
		}
		else {
			System.out.println("campaign not created");
		}
		homepage.logout(driver);
		driver.quit();
	}

}
