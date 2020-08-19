package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleWindows {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");

		String mainPageHanle = driver.getWindowHandle();

		System.out.println(mainPageHanle);

		WebElement helpLink = driver.findElement(By.linkText("Справка"));
		helpLink.click();

		Set<String> allWindowsHandles = driver.getWindowHandles();
		System.out.println(allWindowsHandles.size());

		Iterator<String> it = allWindowsHandles.iterator();
		mainPageHanle = it.next();
		String childHandle = it.next();
		System.out.println(childHandle);
		Thread.sleep(3000);
		driver.switchTo().window(mainPageHanle);
		
		driver.close();
		

	}

}
