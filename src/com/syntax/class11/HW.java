package com.syntax.class11;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Index");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		String mainPageHandle = driver.getWindowHandle();

		// Deleting the last Employee from table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		for (int i = 0; i <= rows.size(); i++) {
			if (i == 6) {
				WebElement deleteButton = driver.findElement(
						By.xpath("//table[@class='table']/tbody/tr[" + i + "]/td/button/following-sibling::button[2]"));
				deleteButton.click();
				WebElement acceptDeleteButton = driver.findElement(By.xpath("//input[@value='Delete']"));
				acceptDeleteButton.click();
				break;
			}
		}

		// AjaxCall
		WebElement ajaxCallButton = driver.findElement(By.xpath("//a[@href='/Students/Contact']"));
		ajaxCallButton.click();
		WebElement linkAjaxButton = driver.findElement(By.xpath("//a[@data-ajax='true']"));
		linkAjaxButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ContactUs']")));
		String ajaxText = driver.findElement(By.xpath("//div[@class='ContactUs']")).getText();
		System.out.println(ajaxText);
		driver.navigate().back();

		// Form
		WebElement formButton = driver.findElement(By.xpath("//a[@href='/Students/Form']"));
		formButton.click();
		WebElement firstName = driver.findElement(By.id("firstname"));
		firstName.sendKeys("Greg");
		WebElement lastName = driver.findElement(By.id("lastname"));
		lastName.sendKeys("Nat");

		List<WebElement> radionButton = driver.findElements(By.xpath("//label[@class='radio-inline']"));
		for (WebElement radioButtonOption : radionButton) {
			String radioButtonText = radioButtonOption.getText();
			if (radioButtonText.equals("Married")) {
				radioButtonOption.click();
				break;
			}
		}

		List<WebElement> hobbyButton = driver.findElements(By.xpath("//label[@class='checkbox-inline']"));
		for (WebElement hobbyButtonOption : hobbyButton) {
			hobbyButtonOption.click();
		}

		WebElement countryListDropDown = driver.findElement(By.id("sel1"));
		countryListDropDown.click();
		Select select = new Select(countryListDropDown);
		select.selectByVisibleText("Bahamas");

		// Calendar
		WebElement birthCalendar = driver.findElement(By.xpath("//input[@class='form-control hasDatepicker']"));
		birthCalendar.click();

		WebElement selectMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[1]"));
		selectMonth.click();
		Select selectM = new Select(selectMonth);
		selectM.selectByIndex(11);
		WebElement selectYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[2]"));
		selectYear.click();
		Select selectY = new Select(selectYear);
		selectY.selectByValue("2019");
		List<WebElement> dataPickRows = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		Iterator<WebElement> it = dataPickRows.iterator();
		while (it.hasNext()) {
			WebElement row = it.next();
			String day = row.getText();
			if (day.equals("25")) {
				row.click();
				break;
			}
		}

		WebElement phoneNumber = driver.findElement(By.id("phonenumber"));
		phoneNumber.sendKeys("123456789");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("syntax");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("syntax@gmail.com");
		WebElement aboutYourself = driver.findElement(By.xpath("//textarea[@class='form-control test']"));
		aboutYourself.sendKeys("Hello! I am a student at Syntax technology");
		WebElement password = driver.findElement(By.id("pwd"));
		password.sendKeys("qwerty123456789");
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-default ']"));
		submitButton.click();

		// Controls
		WebElement controlButton = driver.findElement(By.linkText("Controls"));
		controlButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']")));
		WebElement draggable = driver
				.findElement(By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		// Actions actions=new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();

		// double click
//		WebElement doubleClickButton=driver.findElement(By.xpath("//button[@ondblclick='myDblClickFunction()']"));
//		action.doubleClick(doubleClickButton);

		driver.switchTo().frame("iframe_a");
		WebElement enterName = driver
				.findElement(By.xpath("//label[text()='Enter your name:']/following-sibling::input"));
		enterName.sendKeys("Alan");
		driver.switchTo().defaultContent();

		WebElement videoOnCButton = driver.findElement(By.xpath("//a[text()='Click here to watch videos on C#']"));
		videoOnCButton.click();
		Set<String> allWindowsHandles = driver.getWindowHandles();
		for (String currentWindow : allWindowsHandles) {
			driver.switchTo().window(currentWindow);
		}
		String titleChild = driver.getTitle();
		System.out.println("Child window is " + titleChild); // fix it!!!
		driver.close();
		driver.switchTo().window(mainPageHandle);
		String titleMain = driver.getTitle();
		System.out.println("Main window is " + titleMain);

		// Widgets
		WebElement widgetButton = driver.findElement(By.xpath("//a[text()='Widgets']"));
		widgetButton.click();
		WebElement chooseFileButton = driver.findElement(By.id("image_file"));
		chooseFileButton.sendKeys("C:\\Users\\User\\Desktop\\1.jpg");
		WebElement uploadButton = driver.findElement(By.xpath("//input[@value='Upload']"));
		uploadButton.click();
		WebElement uploadResult = driver.findElement(By.xpath("//div[@class='ContactUs']/p"));
		String uploadText = uploadResult.getText();
		System.out.println(uploadText);

		// Actions
		WebElement actionButton = driver.findElement(By.xpath("//a[text()='Actions']"));
		actionButton.click();

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row']/button[1]")));
//		WebElement clickButton=driver.findElement(By.xpath("//div[@class='row']/button[1]"));
//		action.click(clickButton).perform();
//
//		//wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert=driver.switchTo().alert();
//		System.out.println(alert.getText());
//		alert.accept();
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row']/button[2]")));
//		WebElement doubleClickButton=driver.findElement(By.xpath("//div[@class='row']/button[1]"));
//		action.doubleClick(doubleClickButton);
//		
//		//wait.until(ExpectedConditions.alertIsPresent());
//		alert=driver.switchTo().alert();
//		System.out.println(alert.getText());
//		alert.accept();

		WebElement drag = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));
		action.dragAndDrop(drag, drop).perform();

		List<WebElement> numbers = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));
		for (WebElement currNum : numbers) {
			action.clickAndHold(numbers.get(0)).perform();
			String nameValue = currNum.getAttribute("name");
			if (nameValue.equals("twelve")) {
				action.clickAndHold(currNum).release().build().perform();
			}
		}

		// SwitchTo

		WebElement switchToButton = driver.findElement(By.xpath("//a[text()='Switch to']"));
		action.click(switchToButton).perform();

		WebElement alertButton = driver.findElement(By.xpath("//button[@id='alert']"));
		alertButton.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement alertText = driver.findElement(By.xpath("//div[@id='demo']"));
		System.out.println(alertText.getText());

		WebElement confirmAlertButton = driver.findElement(By.xpath("//button[@id='confirm']"));
		confirmAlertButton.click();
		alert.accept();
		System.out.println(alertText.getText());

		WebElement promtAlertButton = driver.findElement(By.xpath("//button[@id='prompt']"));
		promtAlertButton.click();
		alert.sendKeys("Syntax");
		alert.accept();
		System.out.println(alertText.getText());

		WebElement launchModalButton = driver.findElement(By.xpath("//button[@data-target='#myModal']"));
		launchModalButton.click();

		WebElement launchModalText = driver.findElement(By.xpath("//div[@class='modal-body']"));
//		String launchModalTextResult=launchModalText.getText();
//		System.out.println(launchModalTextResult);
		WebElement launchModalOk = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		launchModalOk.click();

		driver.switchTo().frame("iframe_a");
		WebElement textFrame = driver.findElement(By.id("name"));
		textFrame.sendKeys("This is Frame text");
		driver.switchTo().defaultContent();

		WebElement newTabLink = driver.findElement(By.xpath("//a[@target='_blank']"));
		newTabLink.click();
		allWindowsHandles = driver.getWindowHandles();
		for (String currentWindowTab : allWindowsHandles) {
			driver.switchTo().window(currentWindowTab);
		}
		System.out.println("New window title: " + driver.getTitle());
		driver.close();
		driver.switchTo().window(mainPageHandle);

		// Select
		WebElement selectButton = driver.findElement(By.xpath("//a[text()='Select']"));
		selectButton.click();

		WebElement dropDown = driver.findElement(By.id("countriesSingle"));
		dropDown.click();
		Select selectDD = new Select(dropDown);
		selectDD.selectByIndex(1);
		

		WebElement multipleSelect = driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
		Select selectMult=new Select(multipleSelect);
		System.out.println("Multiply is selected: "+selectMult.isMultiple());
		List<WebElement> option=selectMult.getOptions();
		
		
		for (WebElement currentOption : option) {
			String getValue=currentOption.getAttribute("value");
			if(getValue.equals("usa") || getValue.equals("england")) {
				currentOption.click();
			}
		}
		WebElement multipleSelectResult = driver.findElement(By.id("result"));
		System.out.println("You selected: "+ multipleSelectResult.getText());

		WebElement dropD=driver.findElement(By.id("dropdownMenu1"));
		dropD.click();
		List<WebElement> listDD=driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
		for (WebElement currentListDD : listDD) {
			String value=currentListDD.getText();
			if(value.equals("England")) {
				currentListDD.click();
			}
		}
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File fileSource=ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(fileSource, new File("screenshots/HW11/finaly_did_it.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
		driver.quit();
		
	}
}
