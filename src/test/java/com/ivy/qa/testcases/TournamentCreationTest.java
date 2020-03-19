package com.ivy.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ivy.qa.base.TestBase;
import com.ivy.qa.pages.AdminToolsPage;
import com.ivy.qa.pages.BackOfficeHomePage;
import com.ivy.qa.pages.LoginPage;
import com.ivy.qa.pages.SetUpPage;
import com.ivy.qa.pages.TemplateCreationPage;

public class TournamentCreationTest extends TestBase {

	SetUpPage setUpPage;
	LoginPage loginPage;
	AdminToolsPage adminToolsPage;
	BackOfficeHomePage backOfficeHomePage;
	TemplateCreationPage templateCreationPage;
	
	public TournamentCreationTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		setUpPage= new SetUpPage();
		loginPage=new LoginPage();
		adminToolsPage = new AdminToolsPage();
		backOfficeHomePage = new BackOfficeHomePage();
		templateCreationPage = new TemplateCreationPage();
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
	public void clickOnMTCTAdmin() {
		adminToolsPage.clickOnMTCTAdmin();
	}
	@Test(priority=6)
	public void clickOnMTCTTemplates() {
		adminToolsPage.clickOnMTCTTemplates();
	}
	@Test(priority=7)
	public void clickOnCreateTemplate() {
		adminToolsPage.clickOnCreateTemplate();
	}
	@Test(priority=8)
	public void createTemplate() throws InterruptedException {
		templateCreationPage.selectLquidity();
		templateCreationPage.selectCurrencyType();
		templateCreationPage.selectClientTabVisibility();
		templateCreationPage.selectRealNameDisplay();
		templateCreationPage.selectReEntry();
		templateCreationPage.tournyName();
		templateCreationPage.BuyIn();
		templateCreationPage.selectGameType();
		templateCreationPage.selectReBuyAddOn();
		templateCreationPage.blindStructure();
		templateCreationPage.selectLateRegistration();
		templateCreationPage.selectDealMaking();
		templateCreationPage.selectMaxSeats();
		templateCreationPage.selectChips();
		templateCreationPage.selectPayout();
		templateCreationPage.saveTemplate();
		templateCreationPage.copyTemplateId();
		templateCreationPage.clickNext();
		templateCreationPage.clickNext();
		templateCreationPage.selectTemplateActiveDate();
		templateCreationPage.saveActiveTemplate();
		templateCreationPage.clickScheduleTentativelyButton();
		templateCreationPage.scheduleTentatively();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
