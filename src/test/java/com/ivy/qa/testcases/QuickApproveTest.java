package com.ivy.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ivy.qa.base.TestBase;
import com.ivy.qa.pages.AdminToolsPage;
import com.ivy.qa.pages.ApprovalQueue;
import com.ivy.qa.pages.BackOfficeHomePage;
import com.ivy.qa.pages.LoginPage;
import com.ivy.qa.pages.SetUpPage;

public class QuickApproveTest extends TestBase {
	
	SetUpPage setUpPage;
	LoginPage loginPage;
	AdminToolsPage adminToolsPage;
	BackOfficeHomePage backOfficeHomePage;
	ApprovalQueue approvalQueue;
	
	public QuickApproveTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		setUpPage= new SetUpPage();
		loginPage=new LoginPage();
		adminToolsPage = new AdminToolsPage();
		backOfficeHomePage = new BackOfficeHomePage();	
		approvalQueue=new ApprovalQueue();
	}
	
	@Test(priority=1)
	public void GoToBackOfficePage() {
		setUpPage.BOReal();
	}
	@Test(priority=2)
	public void Login() {
		loginPage.Login();
	}
	@Test(priority=3)
	public void clickOnAdminTools() {
		backOfficeHomePage.ClickOnAdminTools();
	}
	@Test(priority=4)
	public void clickOnGameConfig() {
		adminToolsPage.clickOnGameConfig();
	}
	@Test(priority=5)
	public void clickOnApprovalQueue() {
		adminToolsPage.clickOnApproval();
		adminToolsPage.clickOnApprovalQueue();
	}
	@Test(priority=6)
	public void approveTemplate() throws InterruptedException {
		approvalQueue.approveTemplate();
		approvalQueue.clickQuickApprove();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
