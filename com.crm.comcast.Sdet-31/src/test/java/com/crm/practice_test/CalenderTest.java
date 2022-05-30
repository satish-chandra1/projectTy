package com.crm.practice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderTest {

	public static void main(String[] args) {
		String monthandyear="May 2022";
		String date="25";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions a=new Actions(driver);
		a.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.className("langCardClose")).click();
		driver.findElement(By.xpath("//span[text()=\"DEPARTURE\"]")).click();
		String path="//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='"+date+"']";
		for(;;) {
			
		try {
			driver.findElement(By.xpath(path)).click();

			break;
		
				
		}catch(Exception e){
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
			}
	}
}
