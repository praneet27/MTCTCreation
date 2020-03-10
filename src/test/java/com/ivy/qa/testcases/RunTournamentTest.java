package com.ivy.qa.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ivy.qa.base.TestBase;
import com.ivy.qa.pages.AdminToolsPage;
import com.ivy.qa.pages.BackOfficeHomePage;
import com.ivy.qa.pages.LoginPage;
import com.ivy.qa.pages.SetUpPage;
import com.ivy.qa.pages.ShowScheduleIdsPage;

public class RunTournamentTest extends TestBase {
	SetUpPage setUpPage;
	LoginPage loginPage;
	AdminToolsPage adminToolsPage;
	BackOfficeHomePage backOfficeHomePage;
	ShowScheduleIdsPage showScheduleIdsPage;

	public RunTournamentTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		setUpPage = new SetUpPage();
		loginPage = new LoginPage();
		adminToolsPage = new AdminToolsPage();
		backOfficeHomePage = new BackOfficeHomePage();
		showScheduleIdsPage=new ShowScheduleIdsPage();
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
	public void showScheduleForCreatedTemplate() {
		adminToolsPage.clickOnMTCTAdmin();
		adminToolsPage.clickOnMtctInstancesScheduleIds();
		adminToolsPage.clickOnSchowSheduleIds();
		showScheduleIdsPage.enterTemplateId();
		showScheduleIdsPage.clickOnSearch();
		
	}
	@Test(priority=6)
	public void runTournament() throws InterruptedException {
		showScheduleIdsPage.clickOnScheduleId();
		showScheduleIdsPage.clickOnMtctInstance();
		showScheduleIdsPage.changeStatusOfTournament();
	}
	
	
	
	
	
	
	
	
}
