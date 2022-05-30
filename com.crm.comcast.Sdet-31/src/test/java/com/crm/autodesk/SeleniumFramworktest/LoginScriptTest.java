package com.crm.autodesk.SeleniumFramworktest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginScriptTest {

	public static void main(String[] args) {
		//WebDriver driver=new ChromeDriver();
		int uniqueNum=(int)(Math.random()*100000);
		String name="inception"+uniqueNum;
		
		ChromeOptions option=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.name("button")).click();
		
		String header=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(header.contains(name)) {
			System.out.println("is verified :pass");
		}
		else
		{
			System.out.println("is verified :fail");
		}
		
		WebElement wb=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(wb).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}

}
