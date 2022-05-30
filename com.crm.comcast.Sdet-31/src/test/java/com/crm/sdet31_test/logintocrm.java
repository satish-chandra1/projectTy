package com.crm.sdet31_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logintocrm {

	public static void main(String[] args) throws Throwable {
		
		//login to vtiger
		//WebDriverManager.chromedriver().setup();
		
		FileInputStream fis=new FileInputStream (".\\src\\main\\resources\\commandata\\credentials.properties");
		Properties pro_object=new Properties();
		pro_object.load(fis);
		String browser=pro_object.getProperty("browser");
		String url=pro_object.getProperty("url");
		String username=pro_object.getProperty("username");
		String password=pro_object.getProperty("password");
		
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		//run time polymorphism
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is"+browser);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is"+browser);
		}
		else {
			System.out.println("specify the valid browser");
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
