package com.crm.practice_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class createcontactwithoragnization_test {

	public static void main(String[] args) throws Throwable {
		Random r = new Random();
		int randomNum = r.nextInt(1000);
		//read data from excel sheet
		FileInputStream fls= new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fls);
		Sheet sheet=wb.getSheet("sheet1");
		
		String orgName = sheet.getRow(1).getCell(0).getStringCellValue()+"_"+randomNum;
		String contacts = sheet.getRow(1).getCell(0).getStringCellValue()+"_"+randomNum;
		
		
	
		//read data from propety file
		FileInputStream fis = new FileInputStream("./src\\main\\resources\\commandata\\credentials.properties");
		Properties pro_obj = new Properties();
		pro_obj.load(fis);
		 String browser = pro_obj.getProperty("browser");
		String url = pro_obj.getProperty("url");
		String username = pro_obj.getProperty("username");
		String password = pro_obj.getProperty("password");
		
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
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		// navigate to oragnization
				driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		//navigate to create oragnization
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//create a new oragnization
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				
		//click on save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify
				String header=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				if(header.contains(orgName))
				{
					System.out.println("is verified :pass");
				}
				else {
					System.out.println("not verified");
				}
				
				
		//USE explicit wait to navigate to contacts
				WebDriverWait wait =new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.linkText("Contacts"))));
				
		//navigate to contacts
				 driver.findElement(By.linkText("Contacts")).click();
		//navigate to create contact
				 driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
				 driver.findElement(By.name("lastname")).sendKeys("contacts");
				 
		//click on organization img
				 driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				 
		//to handle the popup
				 Set<String> set = driver.getWindowHandles();
				 
				 Iterator<String> it=set.iterator();
				 while(it.hasNext())
				 {
					 String window_id=it.next();
					 driver.switchTo().window(window_id);
					 if(driver.getTitle().contains("Accounts"))
					 {
						 break;
					 }
				 }
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
			 Set<String> set1 = driver.getWindowHandles();
			 
			 Iterator<String> it1=set.iterator();
			 while(it1.hasNext())
			 {
				 String window_id=it1.next();
				 driver.switchTo().window(window_id);
				 if(driver.getTitle().contains("Contacts"))
				 {
					 break;
				 }
			 }
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//verify
			String value1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
			if(header.contains(contacts))
			{
				System.out.println("is verified :pass");
			}
			else {
				System.out.println("not verified");
			}
			
			//logout
			  driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
				WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				Actions a =new Actions(driver);
				a.moveToElement(ele).perform();
				Thread.sleep(5000);
			  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			  Thread.sleep(5000);
			  driver.close();
			  
	}

}
