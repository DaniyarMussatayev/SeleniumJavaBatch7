package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWDeltaDoWhile {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.delta.com/");
		driver.manage().window().maximize();

		WebElement calendar = driver.findElement(By.id("input_departureDate_1"));
		calendar.click();
		WebElement dMonth = driver.findElement(By.className("dl-datepicker-month-0"));// locating departure month
		String actualDepMothn = dMonth.getText();
		String expectedDepMoth = "December";
		if (!actualDepMothn.equals(expectedDepMoth)) {
			do {

				WebElement next = driver.findElement(By.xpath("//span[text() = 'Next']"));

				next.click();

			} while (!driver.findElement(By.className("dl-datepicker-month-0")).getText().equals(expectedDepMoth));
		}

		List<WebElement> departDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-0']/tr/td"));
		for (WebElement departDate : departDates) {
			if (departDate.getText().equals("11")) {
				departDate.click();
				break;
			}
		}
		WebElement rMonth = driver.findElement(By.className("dl-datepicker-month-1"));
		String actualReturnMonth = rMonth.getText();
		String expectedReturnMonth = "April";
		if (!actualReturnMonth.equals(expectedReturnMonth)) {

			do {
				WebElement next = driver.findElement(By.xpath("//span[text() = 'Next']"));
				next.click();

			} while (!driver.findElement(By.className("dl-datepicker-month-1")).getText().equals(expectedReturnMonth));
		}
		List<WebElement> returnDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-1']/tr/td"));
		for (WebElement returnDate : returnDates) {
			if (returnDate.getText().equals("20")) {
				returnDate.click();
				break;
			}
		}
		WebElement done = driver.findElement(By.className("donebutton"));
		done.click();

	}

}
