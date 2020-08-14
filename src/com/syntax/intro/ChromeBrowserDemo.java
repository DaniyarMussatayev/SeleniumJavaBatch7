package com.syntax.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ChromeBrowserDemo {

	public static void main(String[] args) throws InterruptedException {

		// 1. set a system property
		// use this path for Win
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\eclipse-workspace\\SeleniumJavaBatch7\\drivers\\chromedriver.exe");

		// 2. create an object of webdriver type
		WebDriver driver = new ChromeDriver();

		// 3. navigate to Syntax application
		driver.get("https://amazon.com");

		WebElement account = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

		Actions action = new Actions(driver);
		action.moveToElement(account).perform();

		// hover the mouse over Menu
		WebElement element = driver.findElement(By.xpath("//div[@id='nav-flyout-ya-newCust']"));

		// validate the menu is opened up
		if (element.getText().contains("Start")) {
			System.out.println("Menu displayed");
		} else {
			System.out.println("Menu did NOT display");
		}
		// How to right-click on a element
		action.contextClick(element).perform();

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		// Search for Movies
		action.moveToElement(searchBox).click().sendKeys("Movies").perform();

		searchBox.submit();



	}

}
