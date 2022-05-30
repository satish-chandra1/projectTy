package com.crm.practice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {
	@Test
	public void spice() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		  driver.findElement(By.xpath("//div[text()='one way']/following::div[@class=\"css-1dbjc4n r-zso239\"]/*[name()='svg']")).click();
		 
//		 WebElement ele = driver.findElement(By.xpath("//div[text()='one way']/following::div[@data-testid=\"to-testID-origin\"]"));
//		 WebDriverWait wait=new WebDriverWait(driver,20);
//		 wait.until(ExpectedConditions.elementToBeClickable(ele));
//		
//		 ele.sendKeys("Ajmer");
		WebElement ele = driver.findElement(By.xpath("//div[text()='From']"));
		ele.click();
		driver.findElement(By.xpath("//div[text()='Amritsar']")).click();
		
//		WebDriverWait wait=new WebDriverWait(driver,10);
		
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[text()='To']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Bagdogra']")).click();

		
		//driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[normalize-space(text())='April']/ancestor::div[@data-testid='undefined-month-April-2022']/descendant::div[text()='5']")).click();
		driver.findElement(By.xpath("//div[normalize-space(text())='May']/ancestor::div[@data-testid=\"undefined-month-May-2022\"]/descendant::div[text()='13']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class=\"css-1dbjc4n r-18u37iz r-1wtj0ep r-1lgpqti\"]/child::div[@class=\"css-1dbjc4n\"]")).click();
		
	}

}
