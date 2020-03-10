package com.ivy.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ivy.qa.base.TestBase;
import com.ivy.qa.util.TestUtil;
import com.ivy.qa.util.Xls_Reader;

public class ApprovalQueue extends TestBase {

	public static Xls_Reader dataReader;
	String approvalTemplateId;
	TestUtil utilObject;

	// Page Objects
	// staging approval queue
	@FindBy(xpath = "//table[@id='approvalQueueList']//tbody[1]//tr/td[6]/div[1]")
	List<WebElement> staging_approvalIds;

	// relB approval Queue
	@FindBy(xpath = "//table[@id='approvalQueueList']//tbody[1]//tr/td[6]/div[1]")
	List<WebElement> relB_approvalIds;

	// Quick Approve button
	@FindBy(xpath = "//input[@value='Quick Approve']")
	WebElement quickApproveButton;

	// Initializing Page Object

	public ApprovalQueue() {
		PageFactory.initElements(driver, this);
		utilObject = new TestUtil();
		dataReader = new Xls_Reader(
				"C:\\Users\\kkumar4\\Java_Selenium_WorkSpace\\MTCTCreation\\src\\main\\java\\com\\ivy\\qa\\testdata\\data.xlsx");
	}

	// Actions

	public void approveTemplate() throws InterruptedException {
		Thread.sleep(2000L);
		if (dataReader.getCellData("Data", 2, 3).equalsIgnoreCase("staging")) {
			int approvalIdssize = staging_approvalIds.size();

			for (int i = 0; i < approvalIdssize; i++) {
				approvalTemplateId = staging_approvalIds.get(i).getText();

				if (approvalTemplateId.equals(TemplateCreationPage.templateId)) {
					int j = i + 1;
					driver.findElement(
							By.xpath("//table[@id='approvalQueueList']//tbody//tr[" + j + "]/td[11]//div[1]//input[1]"))
							.click();
					break;

				}
			}

		} else {

			int approvalIdssize = relB_approvalIds.size();

			for (int i = 0; i < approvalIdssize; i++) {
				String approvalTemplateId = relB_approvalIds.get(i).getText();

				if (approvalTemplateId.equals(TemplateCreationPage.templateId)) {
					// Thread.sleep(2000L);
					int j = i + 1;
					driver.findElement(
							By.xpath("//table[@id='approvalQueueList']//tbody//tr[" + j + "]/td[10]//div[1]//input[1]"))
							.click();
					break;

				}
			}
		}
	}

	public void clickQuickApprove() {
		if(quickApproveButton.isEnabled()) {
		quickApproveButton.click();
		utilObject.handleAlertAccept();
		}

	}
}
