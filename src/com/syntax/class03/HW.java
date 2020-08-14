package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/index.html");
		driver.findElement(By.xpath("//a[@id = 'btn_basic_example']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id = 'btn_inter_example']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()= 'Input Form with Validations']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[name*='last']")).sendKeys("Smith");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Smith@gmail.com");
		driver.findElement(By.cssSelector("input[name^='ph']")).sendKeys("(845)-555-1212");
		driver.findElement(By.cssSelector("input[placeholder^='Ad']")).sendKeys("665 5th Ave");
		driver.findElement(By.cssSelector("input[placeholder$='ty']")).sendKeys("New York city");
		driver.findElement(By.cssSelector("input[name='zip']")).sendKeys("10022");
		driver.findElement(By.cssSelector("input[name='website']")).sendKeys("https://syntaxtechs.com/");
		driver.findElement(By.cssSelector("textarea[name='comment']")).sendKeys("Batch7 project");
		driver.findElement(By.cssSelector("button[class='btn btn-default']")).click();
	
	}

}

//Go to http://166.62.36.207/syntaxpractice/index.html
//Click on start practicing button
//Click on proceed next button
//Click on “Input form validations”
//Fill out the form and click on send -- skip - dropdown for state and radio button

