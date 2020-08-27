package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String mainPageHandle = driver.getWindowHandle();

		//First window tab
		WebElement newTabButton = driver.findElement(By.id("tabButton"));
		newTabButton.click();
		
		Set<String> windowsHandle1 = driver.getWindowHandles();
		for (String currentwindow1 : windowsHandle1) {
			driver.switchTo().window(currentwindow1);
		}
		
		WebElement newTabText1 = driver.findElement(By.id("sampleHeading"));
		System.out.println("First window text --> "+newTabText1.getText());
		driver.close();
		driver.switchTo().window(mainPageHandle);

		
		//Second window tab
		WebElement newWindowButton = driver.findElement(By.id("windowButton"));
		newWindowButton.click();
		
		Set<String> windowsHandle2 = driver.getWindowHandles();
		for (String currentwindow2 : windowsHandle2) {
			driver.switchTo().window(currentwindow2);
		}
		
		WebElement newTabText2 = driver.findElement(By.id("sampleHeading"));
		System.out.println("Second window text --> "+newTabText2.getText());
		driver.close();
		driver.switchTo().window(mainPageHandle);		
	
		//Third window tab
		WebElement newMessageWindowButton = driver.findElement(By.id("messageWindowButton"));
		newMessageWindowButton.click();

		Set<String> windowsHandle3 = driver.getWindowHandles();
		for (String currentwindow3 : windowsHandle3) {
			driver.switchTo().window(currentwindow3);
		}
		
//		WebElement newTabText3 = driver.findElement(By.xpath("/html/body"));
//		System.out.println("Third window text --> "+newTabText3.getText());
		driver.close();
		driver.switchTo().window(mainPageHandle);		
		
		WebElement logo=driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
		if (logo.isDisplayed()) {
			System.out.println(driver.getTitle());
		}
		driver.close();
	}
}
//Go to https://demoqa.com/browser-windows
//click on New Tab and print the text from new tab in the console
//click on New Window and print the text from new window in the console
//click on New Window Message and print the text from new window in the console
//Verify the title is displayed
//Print out the title of the main page
