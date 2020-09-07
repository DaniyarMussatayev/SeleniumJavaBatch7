package com.syntax.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.syntax.Utils.BaseClassHW;
import com.syntax.pages.LoginPageHW;

public class HRMSblankPasswordValidation  {
	@Test
	public void TC1() {
		BaseClassHW.setUp();
		LoginPageHW login = new LoginPageHW();
		login.userNametextBox.sendKeys("Admin");
		login.loginBtn.click();
		
		SoftAssert sAssert=new SoftAssert();
		String expectedMessage="Password cannot be empty";
		String actualMessage=login.errMessage.getText();
		sAssert.assertEquals(actualMessage, expectedMessage);
		
		TakesScreenshot ts=(TakesScreenshot) BaseClassHW.driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("screenshots/HRMS/HRMSblankPasswordValidation.jpeg"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		sAssert.assertAll();
		BaseClassHW.tearDown();
		
	}

}
//TC 1: HRMS blank password validation
//Navigate to “http://166.62.36.207/humanresources/symfony/web/index”
//Enter valid username and leave password field empty
//Click on login button
//Verify error message with text “Password cannot be empty” is displayed