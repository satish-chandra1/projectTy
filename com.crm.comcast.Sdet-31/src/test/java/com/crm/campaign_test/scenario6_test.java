package com.crm.campaign_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scenario6_test {

	public static void main(String[] args) throws Throwable {
		FileInputStream fil= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fil);
		Sheet sheet = wb.getSheet("Sheet4");
		int rowCount= sheet.getLastRowNum();
		int columnCount= sheet.getRow(0).getLastCellNum();
		
		System.out.println("Total number of rows"+rowCount);
		System.out.println("Total number of columns"+columnCount);
		
		for(int i=0;i<=rowCount;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(j);
				String data=cell.getStringCellValue();
				System.out.print(data+"  ");
			}
			System.out.println();
		}
		String campaign=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println("Campaign selected is "+campaign);
		
		
		FileInputStream fis = new FileInputStream("./src\\main\\resources\\commandata\\credentials.properties");
		Properties pro_obj= new Properties();
		pro_obj.load(fis);
		String browser = pro_obj.getProperty("browser");
		String url = pro_obj.getProperty("url");
		String username = pro_obj.getProperty("username");
		String password = pro_obj.getProperty("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Enter valid browser");
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaign);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
			driver.switchTo().window(b);
		}
		driver.findElement(By.linkText("ss")).click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.close();
	}

}
