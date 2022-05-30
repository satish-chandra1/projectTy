package com.crm.oragnization_test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class create_oragnization_test {

	public static void main(String[] args) throws Throwable {
		FileInputStream fls= new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fls);
		Sheet sheet=wb.getSheet("sheet1");
		int rowcount= sheet.getLastRowNum();
		int coloumcount=sheet.getRow(0).getLastCellNum();
		
		System.out.println("total count of row"+rowcount);
		System.out.println("total count of coloum"+coloumcount);
		
		for(int i=0;i<=rowcount;i++)
		{
			for(int j=0;j<coloumcount;j++) {
				Row row= sheet.getRow(i);
				Cell cell=row.getCell(j);
				String data=cell.getStringCellValue();
				System.out.print(data+"   ");
			}
			System.out.println();
		}
		String orgName = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println("organization name is "+orgName);
		
		FileInputStream fis = new FileInputStream("./src\\main\\resources\\commandata\\credentials.properties");
		Properties pro_obj = new Properties();
		pro_obj.load(fis);
		 String browser = pro_obj.getProperty("browser");
		String url = pro_obj.getProperty("url");
		String username = pro_obj.getProperty("username");
		String password = pro_obj.getProperty("password");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		//run time polymorphism
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
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		//click on organization link
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		//click on "+" image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//enter orgname
		Random r = new Random();
		int randomNum = r.nextInt(1000);
		orgName = orgName + randomNum;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		//click on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		
	}

}
