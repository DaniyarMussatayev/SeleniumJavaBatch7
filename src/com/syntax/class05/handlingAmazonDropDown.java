package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class handlingAmazonDropDown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		WebElement categoriesDD = driver.findElement(By.id("searchDropdownBox"));
		Select select = new Select(categoriesDD);
		List<WebElement> options = select.getOptions();
		options.size();

		for(WebElement option : options) {
			String text = option.getText();
			System.out.println(text);
			
		}
		Thread.sleep(4000);
		select.selectByValue("search-alias=alexa-skills");
		
	}
}
