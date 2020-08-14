package com.syntax.class04;

import java.awt.SystemColor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2 {

//	    HRMS Application Negative Login:
//		Open chrome browser
//		Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//		Enter valid username
//		Leave password field empty
//		Verify error message with text “Password cannot be empty” is displayed.

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name= 'txtUsername']")).sendKeys("Admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type= 'submit']")).click();
		
		WebElement errorMessage = driver.findElement(By.cssSelector("span#spanMessage"));
		String error=errorMessage.getText();
		if(error.equals("Password cannot be empty")) {
			System.out.println("Error message is displayed");
		}else {
			System.out.println("Correct credential");
		}

	}
}
