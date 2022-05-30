package com.crm.practice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class olympic_gold {
	@Test
	public void gold() {
		String gold="Mikael KINGSBURY";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		driver.findElement(By.xpath("//div[@class=\"ot-sdk-container\"]/descendant::button[text()='Yes, I am happy']")).click();
	 	

	 	driver.findElement(By.xpath("//span[text()='"+gold+"']")).click();
	 	
	 	WebElement ele = driver.findElement(By.xpath("//span[@class=\"medal-count -gold\"]"));
	 	System.out.println(ele.getText());
	 	driver.close();
	}

}
