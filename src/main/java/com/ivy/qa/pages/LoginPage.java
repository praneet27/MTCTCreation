package com.ivy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ivy.qa.base.TestBase;

public class LoginPage extends TestBase {
	

	//Page Factory or Object Repository
	@FindBy(name="j_username")
	WebElement username;
	
	@FindBy(name="j_password")
	WebElement password;
	
	@FindBy(name="submit")
	WebElement login;
	
	
	// Initializing the Page Objects 
	public LoginPage() {
		PageFactory.initElements(driver, this);
			}
		
			
	// Actions 
	
	public BackOfficeHomePage Login() {
		
		username.sendKeys(prop.getProperty("usernmane"));
		password.sendKeys(prop.getProperty("password"));
		login.click();
		return new BackOfficeHomePage();
		
	}
	
	
}
