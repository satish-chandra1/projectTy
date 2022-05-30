package com.crm.practice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_commandline {
	@Test
	public void commandline() {
		
		WebDriver driver=null;
		String browser=System.getProperty("browser");
		String url=System.getProperty("url");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		
		if(browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.contains("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("use valid browser");
		}
		
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.findElement(By.name("user_name")).sendKeys(username);
		System.out.println("user name by parameter");
		driver.findElement(By.name("user_password")).sendKeys(password);
		System.out.println("password by parameter");
		driver.findElement(By.id("submitButton")).click();
		driver.close();
		
		
		
	}

}
