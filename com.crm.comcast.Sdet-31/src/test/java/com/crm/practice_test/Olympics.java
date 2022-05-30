package com.crm.practice_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympics {
	@Test
	public void medals() throws InterruptedException {
		String athletename="Dorothea";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		driver.findElement(By.xpath("//div[@class=\"ot-sdk-container\"]/descendant::button[text()='Yes, I am happy']")).click();
	 	driver.findElement(By.xpath("//section[@class=\"b2p-nav__extended\"]/descendant::span[text()='Athletes']")).click();
	 	
	 	driver.findElement(By.xpath("//section[@class=\"pvp-modal\"]/descendant::button[@class=\"button-no-styles icon-close-button pvp-modal__close\"]")).click();
		driver.findElement(By.xpath("//span[text()='"+athletename+"']")).click();
		WebElement medals1 = driver.findElement(By.xpath("//li[@class=\"detail__item text-small detail__item--medals\"]"));
		System.out.println(medals1.getText());
	}

}
