package com.syntax.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	
	/**
	 * this method navigates to hrms website
	 * @return <--driver
	 * @author Syntax
	 */

	
	public static WebDriver setUp() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/pim/addEmployee");

		return driver;
	}

	/**
	 * this method will quit the browser
	 * 
	 */
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
