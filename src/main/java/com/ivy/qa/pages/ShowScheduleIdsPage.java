package com.ivy.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ivy.qa.base.TestBase;
import com.ivy.qa.util.TestUtil;
import com.ivy.qa.util.Xls_Reader;

public class ShowScheduleIdsPage extends TestBase {

	public static Xls_Reader reader;
	WebDriverWait wait = new WebDriverWait(driver, 120);
	public static String templateId;
	TestUtil utilObject;
	
	// Page Objects
	@FindBy(id="templateID")
	WebElement templateIdTextBox;
	@FindBy(xpath="//input[@type='button']")
	WebElement searchButton;
	//Schedule id
	@FindBy(xpath="//table[@id='schIdList']//tbody//tr//td//div//a")
	WebElement scheduleId;
	@FindBy(xpath="//table[@id='schIdInstanceList']//tbody//tr//td[4]")
	List<WebElement> listOfInstanceIds;
	//Specify Template Properties Tab
	@FindBy(id="tabs1")
	WebElement specifyTemplatepropTab;
	//changeStatusButton
	@FindBy(id="changeStButton")
	WebElement changeStatusButton;
	@FindBy(id="uploadPlayersPopupId")
	WebElement registerUserButton;
	// Users List to Register Users
	@FindBy(id="usersList")
	WebElement enterUsersToRegister;
	@FindBy(id="brandMapOptions")
	WebElement selectBrand;
	@FindBy(id="applyButton")
	WebElement loadPlayersButton;
	@FindBy(id="cancelBtn")
	WebElement closeButton;
	
	@FindBy(xpath="//div[@id='registerUsersResultDiv']//form")
	WebElement registerUserSuccessMsg;
	
	// change status drop down
	@FindBy(id="changeStatus")
	WebElement selectStatusDropDown;
	
	
	
	
	public ShowScheduleIdsPage() {
		PageFactory.initElements(driver, this);
		utilObject = new TestUtil();
		reader = new Xls_Reader(
				"C:\\Users\\kkumar4\\Java_Selenium_WorkSpace\\MTCTCreation\\src\\main\\java\\com\\ivy\\qa\\testdata\\data.xlsx");
	}
	
	
	//Methods
	
	public void enterTemplateId() {
		templateIdTextBox.sendKeys(TemplateCreationPage.templateId);	
	}
	public void clickOnSearch() {
		searchButton.click();
	}
	public void clickOnScheduleId() {
		scheduleId.click();
	}
	public void clickOnMtctInstance() {
		for (int i = 0; i < listOfInstanceIds.size(); i++) {
		String mtctStatusText = listOfInstanceIds.get(i).getText();

		if (mtctStatusText.equalsIgnoreCase("Created")) {
			driver.findElement(
					By.xpath("//div[@id='schIdInstanceResultDiv']//tr[" + (i + 1) + " ]//td[2]//div[1]//a"))
					.click();
			break;
		}
	}
	}
	public void changeStatusOfTournament() throws InterruptedException {
		specifyTemplatepropTab.click();
		handleLocalAlerts();
		specifyTemplatepropTab.click();
		handleLocalAlerts();
		specifyTemplatepropTab.click();
		registerUserButton.click();
		enterUsersToRegister.sendKeys(reader.getCellData("data", 2, 36));
		Select brand=new Select(selectBrand);
		brand.selectByVisibleText(reader.getCellData("data", 2, 37));
		loadPlayersButton.click();
		wait.until(ExpectedConditions.visibilityOf(registerUserSuccessMsg));
		closeButton.click();
		Select changeStatusDropDown=new Select(selectStatusDropDown);
		changeStatusDropDown.selectByVisibleText("Load Tables");
		handleLocalAlerts();
		specifyTemplatepropTab.click();
		handleLocalAlerts();
	}
	public void handleLocalAlerts() throws InterruptedException {
		changeStatusButton.click();
		utilObject.handleAlertAccept();
		wait.until(ExpectedConditions.alertIsPresent());
		utilObject.handleAlertAccept();
	}
}
	
	

