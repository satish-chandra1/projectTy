package com.crm.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Espn {
	@Test
	public void links() throws InterruptedException {
		String name = "K.S. Williamson";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.espncricinfo.com/rankings/content/page/211270.html?ex_cid=ipl2022:google_cpc:search:dsa_feed:msn&gclid=EAIaIQobChMIieyFhJv_9wIVWyUrCh2nUQoTEAAYASAAEgLBz_D_BwE");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement ele1 = driver.findElement(By.xpath("//iframe[@src=\"https://feed.cricket-rankings.com/feed/test/batting/\"]"));
		driver.switchTo().frame(ele1);
		WebElement ele = driver.findElement(By.xpath("//a[@href=\"http://www.relianceiccrankings.com/ranking/test/batting/\"]/preceding::td[contains(.,'"+name+"')]/following::span[@class=\"menuteamblack\"][2]"));
		System.out.println(ele.getText());
		driver.close();
	}
}