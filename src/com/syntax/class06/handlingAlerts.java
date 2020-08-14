package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingAlerts {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Switchto");
		driver.manage().window().maximize();
		
		WebElement simpleAlertButton = driver.findElement(By.id("alert")); 
		simpleAlertButton.click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		// handling simple alert
		alert.accept();
		
		WebElement confirmationAlertButton = driver.findElement(By.id("confirm")); 
		confirmationAlertButton.click();
		Thread.sleep(5000);
//		Alert confirmAlert = driver.switchTo().alert();
//		confirmAlert.dismiss();
		String confirmAlertText=alert.getText();
		System.out.println(confirmAlertText);
		// handling confirmation alert
		alert.dismiss();
		
		WebElement promptAlertButton =driver.findElement(By.id("prompt"));
		promptAlertButton.click();
		Thread.sleep(2000);
		
		alert.sendKeys("Syntax");
		Thread.sleep(5000);
		alert.accept();

		

		
		

		
		
	}

}
