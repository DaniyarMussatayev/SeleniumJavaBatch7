package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html");
		List<WebElement> allRadioButtonsOption = driver.findElements(By.xpath("//input[@name='optradio']"));

		for (WebElement radioButtonsOption : allRadioButtonsOption) {
			if (radioButtonsOption.isEnabled()) {
				String checkRadioButton = radioButtonsOption.getAttribute("Value");
				if (checkRadioButton.equals("Male")) {
					radioButtonsOption.click();
					Thread.sleep(1000);
					break;
				}
			}
		}
		driver.findElement(By.xpath("//button[text()='Get Checked value']")).click();
		Thread.sleep(1000);

		List<WebElement> allSexGroupRadioButtonsOption = driver.findElements(By.xpath("//input[@name='gender']"));

		for (WebElement groupSexRadioButtonsOption : allSexGroupRadioButtonsOption) {
			if (groupSexRadioButtonsOption.isEnabled()) {
				String checkRadioButton = groupSexRadioButtonsOption.getAttribute("Value");
				if (checkRadioButton.equals("Male")) {
					groupSexRadioButtonsOption.click();
					Thread.sleep(1000);
					break;
				}
			}
		}

		List<WebElement> allAgeGroupRadioButtonsOption = driver.findElements(By.xpath("//input[@name='ageGroup']"));

		for (WebElement groupAgeRadioButtonsOption : allAgeGroupRadioButtonsOption) {
			if (groupAgeRadioButtonsOption.isEnabled()) {
				String checkRadioButton = groupAgeRadioButtonsOption.getAttribute("Value");
				if (checkRadioButton.equals("15 - 50")) {
					groupAgeRadioButtonsOption.click();
					Thread.sleep(1000);
					break;
				}
			}
		}
		
		driver.findElement(By.xpath("//button[text()='Get values']")).click();
		
//		driver.findElement(By.xpath("//button[text()='Get Checked value']")).click();

//		WebElement radioBtn2 =driver.findElement(By.xpath("(//input[@value='Male'])[2]"));
//		radioBtn2.click();
//		driver.findElement(By.xpath("//button[@id='buttoncheck']")).
//		
	}

}

//Go to http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html
//Select any radiobutton and the age group ---> use List and loop
//Click on get values
//Verify the text in the page -- do not hardcode the values and compare
