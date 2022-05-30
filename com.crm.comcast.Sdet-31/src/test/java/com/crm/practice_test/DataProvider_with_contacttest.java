package com.crm.practice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_with_contacttest {
	
	@Test(dataProvider="getcontactdata")
	public void contactdata(String Lastname,String contact) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(Lastname);
		driver.findElement(By.id("mobile")).sendKeys(contact);
		driver.findElement(By.xpath("//b[text()='Contact Information']/preceding::input[@title=\"Save [Alt+S]\"]")).click();
		WebElement ele=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		
		Actions a =new Actions(driver);
		a.moveToElement(ele).click().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	@DataProvider
	public Object[][] getcontactdata(){
		Object[][] objarray=new Object[5][2];
		objarray[0][0]="krishna";
		objarray[0][1]="1234567";
		
		objarray[1][0]="ram";
		objarray[1][1]="543234543";
		
		objarray[2][0]="nandy";
		objarray[2][1]="54323454";
		
		objarray[3][0]="sam";
		objarray[3][1]="65456765";
		
		objarray[4][0]="alexa";
		objarray[4][1]="76556754";
		return objarray;
		
		
	}
}
