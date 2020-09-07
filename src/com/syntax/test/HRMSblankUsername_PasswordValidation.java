package com.syntax.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.syntax.Utils.BaseClassHW;
import com.syntax.pages.LoginPageHW;

public class HRMSblankUsername_PasswordValidation {
	@Test
	public void TC3() {
		BaseClassHW.setUp();
		LoginPageHW login = new LoginPageHW();
		login.userNametextBox.sendKeys("Test");
		login.passwordTextBox.sendKeys("test");
		login.loginBtn.click();
		
		SoftAssert sAssert=new SoftAssert();
		String expectedMessage="Invalid credentials";
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
