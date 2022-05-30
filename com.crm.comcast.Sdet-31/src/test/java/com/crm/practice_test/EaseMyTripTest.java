package com.crm.practice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EaseMyTripTest {

	public static void main(String[] args) {
		String monthAndyear = "March 2022";
		String date = "14";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get("https://www.cleartrip.com");
		driver.findElement(By.xpath("//*[name()='svg' and @ class=\"t-all ml-2\"]")).click();
		//String path="//div[text()='March 2022']/ancestor::div[@class="DayPicker-Month"]/descendant::div[@aria-label="Sun Mar 13 2022"]";
		//String path="//div[@class=\"flex-1 ta-left\"]/ancestor::div[@class=\"DayPicker-wrapper\"]/descendant::div[@aria-label=\"Fri Mar 11 2022\"]";
//String path="//div[text()='"+monthAndyear+"']/ancestor::div[@class=\"DayPicker-Month\"]/descendant::div[@aria-label='"+date+"']";
		
//driver.findElement(By.xpath(path)).click();



//		for(;;) {
//			try {
//				driver.findElement(By.xpath(path));
//			}
//			catch(Exception e)
//			{
//				driver.findElement(By.xpath("//*[name() ='svg' and @data-testid=\"rightArrow\"]")).click();
//			}
//		}
		

	}

}
