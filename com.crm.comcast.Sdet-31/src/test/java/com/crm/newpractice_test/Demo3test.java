package com.crm.newpractice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo3test {

	@Test
	public void login() {
		WebDriver driver=null;
		
		
		
		
		
		String browser=System.getProperty("browser");
		String url= System.getProperty("url");
		String username=System.getProperty("username");

		String password=System.getProperty("password");
		
		
		

		if(browser.equals("chrome")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("please specify your browser");
		
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		
		driver.get(url);
		
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		
		driver.findElement(By.name("user_password")).sendKeys(password);
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.close();
		
		
	}
}
