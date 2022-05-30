package com.crm.practice_test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tommorow_date_test {
	@Test
	public void tomDate() {
		LocalDateTime dateAndTime=LocalDateTime.now().plusDays(1);
		String month=dateAndTime.getMonth().toString();
		int date=dateAndTime.getDayOfMonth();
		int year =dateAndTime.getYear();
		String actualMonth=month.substring(0, 1)+month.substring(1).toLowerCase();
		String monthAndYear=actualMonth+" "+year;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Actions a= new Actions(driver);
		a.moveByOffset(0, 0).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		
		driver.close();

	}

}
