package com.syntax.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleStaticWebTables {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.syntaxtechs.com/selenium-practice/table-search-filter-demo.php");

		List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("Number of rows " + rowData.size());
		Iterator<WebElement> it = rowData.iterator();
		while(it.hasNext()) {
			WebElement row=it.next();
			String text=row.getText();
			System.out.println(text);
		}
		
		List<WebElement> colsData=driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("Number of rows " + colsData.size());
		for(WebElement col:colsData) {
			String colText=col.getText();
			System.out.println(colText);
			
		}


	}
}
