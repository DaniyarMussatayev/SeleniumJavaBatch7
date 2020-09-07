package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.Utils.BaseClassHW;

public class LoginPageHW extends BaseClassHW {
	@FindBy(id="txtUsername")
	public WebElement userNametextBox;
	
	@FindBy(xpath = "//input[@id = 'txtPassword']")
	public WebElement passwordTextBox;
	
	@FindBy(css = "input#btnLogin")
	public WebElement loginBtn;
	
	@FindBy(id = "spanMessage")
	public WebElement errMessage;
	
	public LoginPageHW() {
		PageFactory.initElements(driver, this);
	}
	

}
