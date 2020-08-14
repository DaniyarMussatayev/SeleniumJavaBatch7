package com.syntax.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW2 {
	public static void main(String[] args) {
//		Go to ebay.com
//		get all the categories and print them in the console
//		select Computers/Tables & Networking
//		click on search
//		verify the header
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");

		WebElement allCategories = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		Select select=new Select(allCategories);
		List<WebElement> option=select.getOptions();
		Iterator<WebElement> it=option.iterator();
		while(it.hasNext()) {
			WebElement options=it.next();
			String optionText=options.getText();
			System.out.println(optionText);
		}
		System.out.println("---------------");
		//select Computers/Tables & Networking
		select.selectByValue("58058");
		//click on search
		driver.findElement(By.id("gh-btn")).click();
		
		String expectedText="Компьютеры, планшеты и сетевого оборудования";
		WebElement actualTextWebElement=driver.findElement(By.xpath("//span[@class='b-pageheader__text']"));
		String actualText=actualTextWebElement.getText();
		
		if(expectedText.equals(actualText)) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
		
		
	}

}
