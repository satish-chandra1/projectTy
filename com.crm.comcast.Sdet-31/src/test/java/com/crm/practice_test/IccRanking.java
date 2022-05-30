package com.crm.practice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccRanking {
	@Test
	public void table() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		
		
//		WebElement thead1=driver.findElement(By.xpath("//div[@class=\"global-navigation\"]"));
//		System.out.println(thead1.getText());
		
		//tbody head
//		WebElement thead = driver.findElement(By.xpath("//tr[@class=\"table-head\"]"));
//		System.out.println(thead.getText());
		
		// identify the webelements of 2nd row and 3rd coloum
//		WebElement thead1=driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[2]/td[5]"));
//		System.out.println(thead1.getText());
		
		//identify the elements of the all rows and all coloums
		WebElement ele=driver.findElement(By.xpath("//table[@class=\"table\"]/tbody/tr[*]/td"));
		System.out.println(ele.getText());
		
		//identify the webelement of last row last coloum
		WebElement ele1=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[last()]/td[last()]"));
		System.out.println(ele1.getText());
	}

}
