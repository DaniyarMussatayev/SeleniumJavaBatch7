package com.syntax.class10;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HW {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://artoftesting.com/samplesiteforselenium");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// getting sample text
		WebElement sampleText = driver.findElement(By.id("idOfDiv"));
		System.out.println(sampleText.getText());

		// clicking on link
		WebElement link = driver.findElement(By.linkText("This is a link"));
		link.click();

		// handling window
		String mainPageHandling = driver.getWindowHandle();
		Set<String> allPagesHandnling = driver.getWindowHandles();
		for (String currentPage : allPagesHandnling) {
			String titleChildPage = driver.switchTo().window(currentPage).getTitle();
			System.out.println(titleChildPage);
		}
		driver.close();
		String titleMainPage = driver.switchTo().window(mainPageHandling).getTitle();
		System.out.println(titleMainPage);

		// TextBox
		WebElement textBox = driver.findElement(By.id("fname"));
		textBox.sendKeys("My Home Work!");
		System.out.println(textBox.getText());

		// Click Button
		WebElement clickButton = driver.findElement(By.id("idOfButton"));
		clickButton.click();

		// Double Click Button
		WebElement doubleClickButton = driver.findElement(By.id("dblClkBtn"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleClickButton).perform();
		// Accepting Alert
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		// Radio button
		List<WebElement> allSexRadioButton = driver.findElements(By.name("gender"));
		for (WebElement optionRadioButton : allSexRadioButton) {
			String cheackRadioButton = optionRadioButton.getAttribute("value");
			if (cheackRadioButton.equals("male")) {
				optionRadioButton.click();
				break;
			}
		}

		// Check Box
		List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement enableCheckBox : checkBox) {
			if (enableCheckBox.isEnabled()) {
				String val = enableCheckBox.getAttribute("Value");
				if(val.equals("Automation")) {
					enableCheckBox.click();
					break;
				}
			}
		}
		
		//Drop Down
		WebElement dd=driver.findElement(By.id("testingDropdown"));
		Select select=new Select(dd);
		select.selectByIndex(1);
		
		//Generate Alert Box
		WebElement alertBox=driver.findElement(By.xpath("//button[text()='Generate Alert Box']"));
		alertBox.click();
		Alert alertB=driver.switchTo().alert();
		System.out.println(alertB.getText());
		alertB.accept();
		
		//Generate Confirm Box
		WebElement confirmBox=driver.findElement(By.xpath("//button[text()='Generate Confirm Box']"));
		confirmBox.click();
		Alert alertConfirm=driver.switchTo().alert();
		System.out.println(alertConfirm.getText());
		alertConfirm.accept();
		WebElement confirmText=driver.findElement(By.id("demo"));
		System.out.println(confirmText.getText());
		Thread.sleep(3000);
		
		//Drag and Drop
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 600)");
		WebElement drag=driver.findElement(By.xpath("//img[@class=' lazyloaded']"));
		WebElement drop=driver.findElement(By.xpath("//div[@ondrop='if (!window.__cfRLUnblockHandlers) return false; drop(event)']"));
		Actions a=new Actions(driver);
		a.clickAndHold(drag).moveToElement(drop).release().build().perform();


	}

}
