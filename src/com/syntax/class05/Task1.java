package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task1 {
	public static void main(String[] args) throws InterruptedException {
//		Go to “https://www.facebook.com”
//			Verify:
//			month dd has 12 month options
//			day dd has 31 day options
//			year dd has 115 year options
//			Select your date of birth	
//			Quit browser
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

		Thread.sleep(2000);
		WebElement mothDD = driver.findElement(By.xpath("//select[@id='month']"));

		Select selectMonth = new Select(mothDD);

		List<WebElement> optionMonth = selectMonth.getOptions();
		int size = optionMonth.size() - 1;
		System.out.println(size);

		WebElement daysDD = driver.findElement(By.xpath("//select[@id='day']"));

		Select selectDay = new Select(daysDD);
		List<WebElement> optionDay = selectDay.getOptions();
		int sizeDay = optionDay.size()-1;
		System.out.println(sizeDay);
		
		WebElement yearDD = driver.findElement(By.xpath("//select[@id='year']"));

		Select selectYear = new Select(yearDD);
		List<WebElement> optionYear = selectYear.getOptions();
		int sizeYear = optionYear.size()-1;
		System.out.println(sizeYear);

	}

}
