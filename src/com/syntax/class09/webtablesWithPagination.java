package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webtablesWithPagination {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://syntaxtechs.com/selenium-practice/table-pagination-demo.php");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr"));

		WebElement next = driver.findElement(By.xpath("//a[@class='next_link']"));

		boolean flag = true;
		while (flag) {// since flag is true, go inside the for each loop
			for (WebElement row : rows) {// going inside the for loop
				String rowText = row.getText();// get the text
				if (rowText.contains("Archy J")) {// if my text does not contain such text
					flag = false;// while loop is false
					System.out.println(rowText);// break the for each loop
					break;
				} // go outside the for loop
			}
			next.click();// click next page
			// go inside the while loop to find your text, if your text contains the text
			// your looking , while will be true
		}
		driver.quit();
	}
}
