package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class elementCommands {

	public static String url = "http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		String title = driver.getTitle();
		WebElement ageRadionBtn = driver.findElement(By.xpath("//input[@value='0 - 5']"));
		boolean isEnabled = ageRadionBtn.isEnabled();
		boolean isDisplayed = ageRadionBtn.isDisplayed();
		System.out.println(isEnabled);
		System.out.println(isDisplayed);
		
		
		System.out.println("Before clicking "+ ageRadionBtn.isSelected());
		ageRadionBtn.click();
		System.out.println("After clicking " +ageRadionBtn.isSelected());

	}

}
