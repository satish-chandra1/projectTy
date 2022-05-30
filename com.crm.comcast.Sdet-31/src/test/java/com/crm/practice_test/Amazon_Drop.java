package com.crm.practice_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Drop {

	@Test
	public void drop() throws Throwable  {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
	//	 List<WebElement> list = driver.findElements(By.xpath("//option[@selected=\"selected\"]/following::option"));
		List<WebElement> list = driver.findElements(By.xpath("//option[@value=\"search-alias=aps\"]"));
		for(WebElement b:list) {
			System.out.println(b.getText());
			
			
			}
	
		
		
		
	}
//	FileInputStream fis=new FileInputStream("./src\\test\\resources\\testdata1.xlsx");
//	Workbook wb = WorkbookFactory.create(fis);
//	Sheet sh = wb.getSheet("Sheet3");
//	Row row = sh.createRow(1);
//	 row.createCell(1).setCellValue("data");
//	FileOutputStream fos=new FileOutputStream("./src\\test\\resources\\testdata1.xlsx");
//	wb.write();


}
