package com.syntax.class08;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement checkBoxButton = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkBoxButton.click();
		
		WebElement removeButtom = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
		removeButtom.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		
		WebElement removeGetText = driver.findElement(By.xpath("//p[@id='message']"));
		System.out.println(removeGetText.getText());

		
		WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
		enableButton.click();
		
		WebElement enableText = driver.findElement(By.xpath("//p[@id='message']"));
		System.out.println(enableText.getText());
		
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		
		WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
		textBox.sendKeys("Syntax");
		
		WebElement disbaleButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
		disbaleButton.click();
		
		System.out.println("Text box is displayd "+textBox.isDisplayed());
		
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

		WebElement disabledText = driver.findElement(By.xpath("//p[@id='message']"));
		System.out.println(disabledText.getText());
	}

}
//go to https://the-internet.herokuapp.com/dynamic_controls
//click on checkbox and click on remove
//verify the text
//click on enable verify the textbox is enabled
//enter text and click disable
//verify the textbox is disabled
