package com.syntax.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Recap {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://facebook.com");
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("Facebook - Log In or Sign Up")){
			System.out.println("The title is Correct");
		}else {
			System.out.println("The title is WRONG");
			
		}
		
	}

}
