package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskFrame {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/bootstrap-iframe.html");
		
		driver.switchTo().frame("FrameOne");
		WebElement logo=driver.findElement(By.xpath("//img[@id='hide']"));
		boolean logoIsDisplayed=logo.isDisplayed();
		System.out.println(logoIsDisplayed);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("FrameTwo");
		WebElement button=driver.findElement(By.xpath("//a[@class='enroll-btn']"));
		boolean buttomIsEnabled=button.isEnabled();
		System.out.println(buttomIsEnabled);
	}

}
