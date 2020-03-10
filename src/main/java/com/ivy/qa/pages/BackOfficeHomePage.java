package com.ivy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ivy.qa.base.TestBase;

public class BackOfficeHomePage extends TestBase {

	@FindBy(className="nav-icon-ADT")
	WebElement adminTools;
	
	
	
	
	// Initializing the Page Objects 
	
	public BackOfficeHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public AdminToolsPage ClickOnAdminTools() {
		adminTools.click();
		return new AdminToolsPage();
	}
}
