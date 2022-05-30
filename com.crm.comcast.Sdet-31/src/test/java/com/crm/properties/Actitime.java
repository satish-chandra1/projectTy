package com.crm.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actitime {

	@Test
	public void act() throws Throwable {
		WebDriver driver = null;
		FileInputStream fis=new FileInputStream("./src\\main\\resources\\commandata\\actitime.properties");
		Properties p=new Properties();
		p.load(fis);
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		String url=p.getProperty("url");
		String browser=p.getProperty("browser");
		
		
		
		if(browser.contains(browser)) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		driver.close();
		
		
		
	}
}
