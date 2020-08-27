package com.syntax.class09;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW {
	public static void main(String[] args) throws InterruptedException {
		// Go to aa.com/homePage.do
		// select depart date
		// select return date
		// select destination
		// click on search
		// quit the browser

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aa.com/homePage.do");

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement dAirport = driver.findElement(By.name("originAirport"));
		dAirport.sendKeys("LAX");
		WebElement aAirport = driver.findElement(By.name("destinationAirport"));
		aAirport.sendKeys("NYC");

		WebElement dCalendar = driver.findElement(By.id("aa-leavingOn"));
		dCalendar.click();
		
		WebElement dMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
		String defMonth = dMonth.getText();
		String expectedDepart = "October";
		while (!defMonth.equals(expectedDepart)) {
			WebElement next = driver.findElement(By.xpath("//a[@title='Next']"));
			next.click();
			WebElement dMonth1 = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
			defMonth = dMonth1.getText();
		}
		List<WebElement> dDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement returnDate : dDate) {
			if (returnDate.getText().equals("24")) {
				returnDate.click();
				break;
			}
		}

			WebElement aCalendar = driver.findElement(By.xpath("//label[@for='aa-returningFrom']"));
			aCalendar.click();

			WebElement aMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]"));
			String arrivaltMonth = aMonth.getText();
			String expectedArrive = "December";
			while (!arrivaltMonth.equals(expectedArrive)) {
				WebElement next = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
				next.click();
				WebElement aMonth1 = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]"));
				arrivaltMonth = aMonth1.getText();
			}
			List<WebElement> aDate = driver
					.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
			for (WebElement arrivalDate : aDate) {
				if (arrivalDate.getText().equals("31")) {
					arrivalDate.click();
					break;
				}
			}
			WebElement searchButton=driver.findElement(By.id("flightSearchForm.button.reSubmit"));
			searchButton.click();
			driver.quit();

		
	}
}
