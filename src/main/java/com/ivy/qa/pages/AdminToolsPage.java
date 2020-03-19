package com.ivy.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ivy.qa.base.TestBase;

public class AdminToolsPage extends TestBase{

	public WebDriverWait wait;
	
	@FindBy(xpath="//a[contains(text(),'Game Config')]")
	WebElement gameConfig;
	
	@FindBy(xpath="//a[contains(text(),'MTCT Admin')]")
	WebElement mTCTAdmin;
	
	@FindBy(xpath="//a[contains(text(),'MTCT Templates')]")
	WebElement mTCT_Template;
	
	@FindBy(css="a[onclick*=Create_Template]")
	WebElement createTemplate;
	
	// Approval
	
	@FindBy(xpath="//a[contains(text(),'Approval')]")
	WebElement approval;
	
	@FindBy(xpath="//a[contains(text(),'Approve/Reject')]")
	WebElement approvalQueue;
	
	//Schedule
	@FindBy(xpath="//a[contains(text(),'MTCT Instances/Schedule IDs')]")
	WebElement mTCT_Instances_schedule;
	@FindBy(id="rGame_ConfigMTCT_Adminmtct_instancesshow_schedule_id")
	WebElement showScheduleId;
	
	// Initializing the Page Objects 
	
	public AdminToolsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public void clickOnGameConfig() {
		gameConfig.click();
	}
	
	public void clickOnMTCTAdmin() {
		mTCTAdmin.click();
	}
	
	public void clickOnMTCTTemplates() {
		mTCT_Template.click();
	}
	
	public void clickOnCreateTemplate() {
		createTemplate.click();
		
	}
	
	public void clickOnApproval() {
		approval.click();
	}
	
	public void clickOnApprovalQueue() {
		approvalQueue.click();
	}
	
	public void clickOnMtctInstancesScheduleIds() {
		mTCT_Instances_schedule.click();
	}
	
	public void clickOnSchowSheduleIds() {
		showScheduleId.click();
	}
	
}
