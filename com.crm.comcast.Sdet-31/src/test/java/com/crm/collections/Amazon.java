package com.crm.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	//div[@id="anonCarousel1"]/descendant::span[@class='a-price-whole']
	@Test
	public void amazon() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		driver.findElement(By.xpath("//a[text()=' Electronics ']")).click();
		List<WebElement> price = driver.findElements(By.xpath("//div[@id=\"anonCarousel1\"]/descendant::span[@class='a-price-whole']"));
		for(WebElement wb:price) {	
			String s=wb.getText();
			System.out.println(s);
			
		}
		driver.close();
		
	}
}
