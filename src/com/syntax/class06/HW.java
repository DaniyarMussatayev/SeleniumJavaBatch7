package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	public static void main(String[] args) throws InterruptedException {
		// click on each button and handle the alert accordingly

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html");

		WebElement simple = driver.findElement(By.xpath("//button[@class = 'btn btn-default']"));
		simple.click();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		
		WebElement confirm =driver.findElement(By.xpath("//button[@onclick = 'myConfirmFunction()']"));
		confirm.click();
		Thread.sleep(1000);
		alert.accept();
		
		
		WebElement prompt = driver.findElement(By.xpath("//button[@onclick = 'myPromptFunction()']"));
		prompt.click();
		Thread.sleep(1000);
		alert.sendKeys("Syntax");
		Thread.sleep(1000);
		alert.accept();

		
		
				
				

	}

}
