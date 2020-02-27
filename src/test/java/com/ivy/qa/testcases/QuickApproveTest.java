package com.ivy.qa.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickApproveTest {
	
	static WebDriverWait wait;
	static String approvalTemplateId;
	

	public static void quickApprove(String templateId, WebDriver driver) throws InterruptedException, IOException {
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Approve/Reject')]")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//h1[contains(text(),'Approval Queue')]"), "Approval Queue"));
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
					"C:\\Users\\kkumar4\\Java_Selenium_WorkSpace\\WorkLocation\\src\\input.properties");
		prop.load(fis);
		Thread.sleep(2000L);
		
		if (prop.getProperty("SETUP").trim().equalsIgnoreCase("staging")) {

			List<WebElement> approvalIds = driver.findElements(By.xpath("//table[@id='approvalQueueList']//tbody[1]//tr/td[6]/div[1]"));
			int approvalIdssize = approvalIds.size();

			for (int i = 0; i < approvalIdssize; i++) {
				approvalTemplateId = approvalIds.get(i).getText();

				if (approvalTemplateId.equals(templateId)) {
					// Thread.sleep(2000L);
					int j = i + 1;
					driver.findElement(
							By.xpath("//table[@id='approvalQueueList']//tbody//tr[" + j + "]/td[11]//div[1]//input[1]"))
							.click();
					break;

				}
			}

		} else {
			List<WebElement> approvalIds = driver
					.findElements(By.xpath("//table[@id='approvalQueueList']//tbody[1]//tr/td[6]/div[1]"));

			int approvalIdssize = approvalIds.size();

			for (int i = 0; i < approvalIdssize; i++) {
				String approvalTemplateId = approvalIds.get(i).getText();

				if (approvalTemplateId.equals(templateId)) {
					 Thread.sleep(2000L);
					int j = i + 1;
					driver.findElement(
							By.xpath("//table[@id='approvalQueueList']//tbody//tr[" + j + "]/td[10]//div[1]//input[1]")).click();
					break;

				}
			}
		}

		WebElement quickApproveButton = driver.findElement(By.xpath("//input[@value='Quick Approve']"));
		if (quickApproveButton.isEnabled()) {
			quickApproveButton.click();
			Alert a = driver.switchTo().alert();
			a.accept();
		}

	}

}
