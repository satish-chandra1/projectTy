package com.crm.newpractice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginBYParametertest {

	@Parameters({"browser","url","username","password"})
	@Test
	public  void vtiger(String browser,String url,String username,String password) {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();	
		}else {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		
		driver.get(url);
		
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		
		driver.findElement(By.name("user_password")).sendKeys(password);
		
		driver.findElement(By.id("submitButton")).click();
		
	}
}
