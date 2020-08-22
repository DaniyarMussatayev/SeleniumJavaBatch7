package com.syntax.class08;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		
		WebElement timingAlertButton=driver.findElement(By.id("timingAlert"));
		timingAlertButton.click();
		
		WebDriverWait wait =new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert= driver.switchTo().alert();
		
		alert.accept();
		
		
	}

}
