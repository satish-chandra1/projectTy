package com.crm.createcontact_test;

import java.io.FileInputStream;
import java.util.Properties;
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
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scenario4_test {

	public static void main(String[] args) throws Throwable {
		FileInputStream fls =new FileInputStream(".//src\\main\\resources\\commandata\\credentials.properties");
		Properties p =new Properties();
		p.load(fls);
		String browser=p.getProperty("browser");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		 System.out.println(browser);
		 System.out.println(url);
		 System.out.println(username);
		 System.out.println(password);
		 
		 
		 
		 FileInputStream fil=new FileInputStream("./src\\test\\resources\\testdata.xlsx");
		  Workbook wb = WorkbookFactory.create(fil);
		  Sheet sheet=wb.getSheet("Sheet2");
		  int rowcount=sheet.getLastRowNum();
		  int coloumcount=sheet.getRow(0).getLastCellNum();
		  
		  System.out.println("total count of row"+rowcount);
		  System.out.println("total count of coloum"+coloumcount);
		  
		  for(int i=0;i<=rowcount;i++) {
			
			for(int j=0;j<coloumcount;j++) {
				Row row=sheet.getRow(i);
				Cell cell=row.getCell(j);
				String data=cell.getStringCellValue();
				System.out.print(data+"   ");
			}
			System.out.println();	
		  }
		  String firstname=sheet.getRow(1).getCell(0).getStringCellValue();
		  System.out.println(firstname);
		  String lastname=sheet.getRow(1).getCell(1).getStringCellValue();
		  System.out.println(lastname);
 WebDriver driver=null;
		  
		  if(browser.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
			  System.out.println("launched browser is "+browser);
		  }
		  else if(browser.equalsIgnoreCase("firefox")) {
			  WebDriverManager.firefoxdriver().setup();
			  System.out.println("launched browser is "+browser);
		  }
		  else {
			  System.out.println("use the valid browser");
		  }
		  
		  
		 
			// Thread.sleep(5000);
			  driver.manage().window().maximize();
			  driver.get(url);
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
			  driver.findElement(By.name("user_name")).sendKeys(username);
			  driver.findElement(By.name("user_password")).sendKeys(password);
			  driver.findElement(By.id("submitButton")).click();
			  
			  
			  driver.findElement(By.linkText("Contacts")).click();
			  //driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
			 
			  driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
			  driver.findElement(By.name("firstname")).sendKeys(firstname);
			  driver.findElement(By.name("lastname")).sendKeys(lastname);
				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
			  String parent=driver.getWindowHandle();
			  System.out.println(parent);
			  
			 Set<String> child = driver.getWindowHandles();
					 System.out.println(child);
			 for(String b:child)
			 {
				 driver.switchTo().window(b);
				
			 }
			 driver.findElement(By.linkText("inception12")).click();
				driver.switchTo().window(parent);	  
			  
			  
				WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				Actions a =new Actions(driver);
				a.moveToElement(ele).perform();
				Thread.sleep(5000);
			  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			  driver.quit();
			 
	}

}
