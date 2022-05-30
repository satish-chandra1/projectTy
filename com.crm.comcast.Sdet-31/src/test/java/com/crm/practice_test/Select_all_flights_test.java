package com.crm.practice_test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Select_all_flights_test {

	public static void main(String[] args) {
		
	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Actions a= new Actions(driver);
		a.moveByOffset(0, 0).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();	
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//p[text()='Pune, India']")).click();
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//p[text()='Bangkok, Thailand']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String path="//div[text()='March 2022']/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()='15']";
		
		driver.findElement(By.xpath(path)).click();
		
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		 List<WebElement> listofFlights=driver.findElements(By.xpath("//span[@class=\"boldFont blackText airlineName\"]"));
		 
		 for(WebElement i:listofFlights) {
			 String filghtName=i.getText();
			 System.out.println("flight name is"+filghtName);
		 }
		 driver.close();
	}

}
