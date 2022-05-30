package com.crm.practice_test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Oragnization_consol_print_verify_test {
	
	public static void main(String[] args) throws Throwable   {
		Random r=new Random();
		int random=r.nextInt(1000);
		String oragnizationname= "donedone"+random;
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(oragnizationname);
		driver.findElement(By.xpath("//b[text()='Organization Information']/preceding::input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Organizations")).click();
		
		for(;;) { 
			try {
			driver.findElement(By.xpath("//table[@class='lvtBg']//tbody/tr[*]/td[3]/a[text()='"+oragnizationname+"']")).click();		
						 break;

			}catch(Exception e) {
				driver.findElement(By.xpath("//img[@src='themes/images/next.gif']")).click();
			}
			}
	
	driver.findElement(By.cssSelector("[title='Delete [Alt+D]']")).click();
	driver.switchTo().alert().accept();
	System.out.println("created product deleted successfully");

WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));


Actions action=new Actions(driver);
action.moveToElement(ele).perform();

driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
driver.close();
	
		}
		
			
		 
		}
	



