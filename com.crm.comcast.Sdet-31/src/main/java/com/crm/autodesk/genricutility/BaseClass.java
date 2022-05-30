package com.crm.autodesk.genricutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.pom.objectrepository.HomePage;
import com.crm.pom.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver= null;
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib= new JavaUtility();
	public WebDriverUtilty wlib= new WebDriverUtilty();
	public static WebDriver sDriver;
	//public HomePage homepage=new HomePage(driver);

	@BeforeSuite(groups= {"IntegrationTest","SmokeTest","FunctionalTest"})
	public void bs() {
		System.out.println("database connection");
	}
	@BeforeTest(groups= {"IntegrationTest","SmokeTest","FunctionalTest"})
	public void bt() {
		System.out.println("execute script in parallel mode");
	}
	//@Parameters("browser")  //bc(String browser)
	@BeforeClass(groups= {"IntegrationTest","SmokeTest","FunctionalTest"})
	public void bc() throws Throwable {
		String browser=flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("url");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			throw new Exception("browser is not compatible");
		}
		driver.get(url);
		driver.manage().window().maximize();
		wlib.WaitForPageToLoad(driver);
		sDriver=driver;
	//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
	}
	@BeforeMethod(groups= {"IntegrationTest","SmokeTest","FunctionalTest"})
	public void bm() throws Throwable {
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
	}
	
	@AfterMethod(groups= {"IntegrationTest","SmokeTest","FunctionalTest"})
	public void am() {
		 HomePage homepage=new HomePage(driver);
		homepage.logout(driver);
		
	}
	@AfterClass(groups= {"IntegrationTest","SmokeTest","FunctionalTest"})
		public void ac() {
			driver.quit();
		}
	
	@AfterTest(groups= {"IntegrationTest","SmokeTest","FunctionalTest"})
	public void at() {
		System.out.println("close the parallel browser ");
	}
	@AfterSuite(groups= {"IntegrationTest","SmokeTest","FunctionalTest"})
	public void as() {
		System.out.println("close the database and all connections");
	}
}
