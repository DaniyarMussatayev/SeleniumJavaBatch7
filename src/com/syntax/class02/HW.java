package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
		driver.findElement(By.id("customer.firstName")).sendKeys("Donald1");
		driver.findElement(By.name("customer.lastName")).sendKeys("Trump");
		driver.findElement(By.id("customer.address.street")).sendKeys("White House, DC Washington");
		driver.findElement(By.name("customer.address.city")).sendKeys("DC Washington");
		driver.findElement(By.id("customer.address.state")).sendKeys("Columbia District");
		driver.findElement(By.name("customer.address.zipCode")).sendKeys("20020");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("123456789");
		driver.findElement(By.name("customer.ssn")).sendKeys("078-05-1128 ");
		driver.findElement(By.id("customer.username")).sendKeys("Zhadra");
		driver.findElement(By.name("customer.password")).sendKeys("trumpampam1");
		driver.findElement(By.id("repeatedPassword")).sendKeys("trumpampam1");
//		driver.findElement(By.cssSelector("input[value$='Register']")).click();
		driver.findElement(By.className("button")).click();
		
		
	}

}
