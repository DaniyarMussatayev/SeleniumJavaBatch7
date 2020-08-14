package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinksFromEbay {
	public static String url = "http://www.ebay.com/";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		List<WebElement> allLink= driver.findElements(By.tagName("a"));
		System.out.println(allLink.size());
		for (WebElement link:allLink) {
			String linkText = link.getText();
			String fullLink =link.getAttribute("href");
			if(!(linkText.isEmpty())) {
				System.out.println(linkText+ "    "+fullLink);

			}
			
		}

	}

}
