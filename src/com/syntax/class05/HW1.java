package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW1 {
	public static void main(String[] args) throws InterruptedException {
//		Go to facebook sign up page
//		Fill out the whole form
//		Click signup
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);
		
		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Gareth");
		
		WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.sendKeys("Smith");
		
		WebElement email=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		email.sendKeys("test@gmail.com");
		
		WebElement emailConfirm=driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		emailConfirm.sendKeys("test@gmail.com");
		
		WebElement password=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		password.sendKeys("test12345");
		
		WebElement mothDD = driver.findElement(By.xpath("//select[@id='month']"));
		Select selectMonth = new Select(mothDD);
		selectMonth.selectByIndex(1);
		
		WebElement daysDD = driver.findElement(By.xpath("//select[@id='day']"));
		Select selectDay = new Select(daysDD);
		selectDay.selectByIndex(1);
		
		WebElement yearDD = driver.findElement(By.xpath("//select[@id='year']"));
		Select selectYear = new Select(yearDD);
		selectYear.selectByValue("2015");
		
		Thread.sleep(1000);

		
		driver.findElement(By.xpath("//input[@id='u_1_5']")).click();
		driver.findElement(By.id("u_1_s")).click();
		
		Thread.sleep(2000);
		driver.quit();

		
		
		
		
		
		
		

	}

}
