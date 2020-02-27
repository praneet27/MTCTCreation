package com.ivy.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NormalTournamentCreationTest {

	public static String playerArray[];
	public static Properties prop;
	

	public static void main(String[] args) throws InterruptedException, IOException {

		
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("window-size=1400,800");
//		options.addArguments("headless");
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\kkumar4\\Java_Selenium_WorkSpace\\WorkLocation\\src\\input.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kkumar4\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Selecting environment
		
		if (prop.getProperty("SETUP").trim().equalsIgnoreCase("relb"))
				 {
			driver.get("http://10.1.52.194/RELB_PG/releaseb_Setup_Details.html");
			driver.findElement(
					By.linkText("http://releaseb-backoffice-real.ivycomptech.co.in/home.action/"))
					.click();
		} else if (prop.getProperty("SETUP").trim().equalsIgnoreCase("staging")) {
			driver.get("http://staging-su.e7new.com/LIVELIKE_PG/e7new.com_Setup_Details.html");
			driver.findElement(
					By.linkText("https://backoffice.partygaming.com.e7new.com/home.action/")).click();
		}

		// Login credentials

		driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("guest");
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("123123");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		//driver.manage().window().maximize();

		// Click on Admin Tools

		driver.findElement(By.className("nav-icon-ADT")).click();

		// Click on Game Config web link and creating a MTCT Template

		WebDriverWait w = new WebDriverWait(driver, 40);
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[contains(text(),'Game Config')]"),
				"Game Config"));
		driver.findElement(By.xpath("//a[contains(text(),'Game Config')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'MTCT Admin')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'MTCT Templates')]")).click();
		driver.findElement(By.cssSelector("a[onclick*=Create_Template]")).click();
		w.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//h1[contains(text(),'MTCT Template Creation')]"), "MTCT Template Creation"));
		// Create MTCT Template

		if (prop.getProperty("LIQUIDITY").trim().equalsIgnoreCase("COM")) {
			driver.findElement(By.id("1_brndsGrpIdChk_create")).click();
		} else if (prop.getProperty("LIQUIDITY").trim().equalsIgnoreCase("IT")) {
			driver.findElement(By.id("2_brndsGrpIdChk_create")).click();
		} else if (prop.getProperty("LIQUIDITY").trim().equalsIgnoreCase("FR")) {
			driver.findElement(By.id("6_brndsGrpIdChk_create")).click();
		} else if((prop.getProperty("LIQUIDITY").trim().equalsIgnoreCase("FR"))) {
			driver.findElement(By.id("5_brndsGrpIdChk_create")).click();
		}

		WebElement currTypeXpath = driver.findElement(By.id("gameCurrency"));
		WebElement mtctTypeXpath = driver.findElement(By.id("shootOutType"));
		WebElement buyInEntryXpath = driver.findElement(By.id("buyinEntry"));

		Select currType = new Select(currTypeXpath);
		if(prop.getProperty("LIQUIDITY").trim().equalsIgnoreCase("COM"))
		{
		currType.selectByValue(prop.getProperty("CURRENCY"));
		}
		
		driver.findElement(By.id("440000_chk")).click();
		driver.findElement(By.id("450000_chk")).click();
		
		

		// RealName Display

		if (prop.getProperty("REAL_NAME_DISPLAY").equalsIgnoreCase("YES")) {
			driver.findElement(By.id("enableRealNameTable")).click();
			driver.switchTo().alert().accept();
		}

		// Bounty support
		
		if (prop.getProperty("BOUNTY").trim().equalsIgnoreCase("YES")) {
		//	driver.findElement(By.id("bountyConfigured2")).click();
			
			Select mtctType= new Select(mtctTypeXpath);
			mtctType.selectByIndex(1);
			
			Select bounty = new Select(driver.findElement(By.id("bountyType")));
			if (prop.getProperty("BOUNTY_TYPE").trim().equalsIgnoreCase("Regular")) {
				driver.findElement(By.id("bountyFee")).sendKeys(prop.getProperty("BOUNTY_FEE"));
			} else {
				bounty.selectByIndex(1);
				driver.findElement(By.id("bountyFee")).sendKeys(prop.getProperty("BOUNTY_FEE"));
				driver.findElement(By.id("bountyTopUp")).sendKeys(prop.getProperty("PROG_BOUNTY_PERCENT"));
			}
		}

		// Re-ENTRY

		if (prop.getProperty("ENRTY_TYPE").trim().equalsIgnoreCase("YES")) {
			driver.findElement(By.id("entryTypeReentry")).click();
			WebElement reEntryXpath = driver.findElement(By.id("noOfEntriesAllowed"));
			Select reEntries = new Select(reEntryXpath);
			reEntries.selectByIndex(Integer.parseInt(prop.getProperty("RE_ENTRIES_ALLOWED")));
		}

		Select controller = new Select(driver.findElement(By.id("mcontroller")));
		controller.selectByIndex(1);
		driver.findElement(By.id("en_US")).sendKeys(prop.getProperty("TOURNEY_NAME"));
		driver.findElement(By.xpath("//input[@onclick='copyTrnNameToOneClick();']")).click();

		// Select Buyin Value

		Select buyInEntry = new Select(buyInEntryXpath);
		buyInEntry.selectByVisibleText("Custom Value");

		driver.findElement(By.id("custumisedBuyIn")).sendKeys(prop.getProperty("BUYIN"));
		driver.findElement(By.id("mtctEnteredFee")).sendKeys(prop.getProperty("BUYIN_FEE"));

		// Rebuy and Addon

		if (prop.getProperty("REBUY").trim().equalsIgnoreCase("YES")) {
			driver.findElement(By.id("rebuyAndAddOn2")).click();
		} else if (prop.getProperty("REBUY_ADDON").trim().equalsIgnoreCase("YES")) {
			driver.findElement(By.id("rebuyAndAddOn2")).click();
		}

		// Selecting Blind Structure

		driver.findElement(By.xpath("//div[@id='blindId_chosen']//a[@class='chosen-single']")).click();
		WebElement blindStructureXpath = driver
				.findElement(By.xpath("//div[@id='blindId_chosen']//input[@class='inputClass']"));

//		WebDriverWait w = new WebDriverWait(driver, 10);
//		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='blindId_chosen']//input[@class='inputClass']")));
//		Thread.sleep(4000L);
		blindStructureXpath.sendKeys(prop.getProperty("BLIND_STRUCTURE"));
		blindStructureXpath.sendKeys(Keys.ENTER);

		// Late Registration

		Select lateReg = new Select(driver.findElement(By.id("lateRegLevel")));
		List<WebElement> lateRegValue = lateReg.getOptions();
		Set<String> actualLateReg = new HashSet<String>();

		for (WebElement webElement : lateRegValue) {
			actualLateReg.add(webElement.getText());
		}
		if (actualLateReg.contains(prop.getProperty("LATE_REG"))) {
			lateReg.selectByVisibleText(prop.getProperty("LATE_REG"));
		}

		// Deal making

		WebElement dealMakingXpath = driver.findElement(By.id("dealMaking"));
		Select dealMaking = new Select(dealMakingXpath);

		if (prop.getProperty("DEAL_MAKING").equalsIgnoreCase("YES")) {
			dealMaking.selectByIndex(2);
		} else {
			dealMaking.selectByIndex(1);
		}

		// Max Seats at table

		WebElement maxSeatsXpath = driver.findElement(By.id("maxSeats"));
		Select maxSeats = new Select(maxSeatsXpath);

		Select maxSeatsDropDown = new Select(driver.findElement(By.id("maxSeats")));
		List<WebElement> maxSeats2 = maxSeatsDropDown.getOptions();
		Set<String> originalMaxSeatDropDown = new HashSet<String>();

		for (WebElement webElement : maxSeats2) {
			originalMaxSeatDropDown.add(webElement.getText());

		}

		if (originalMaxSeatDropDown.contains(prop.getProperty("MAX_SEATER").trim())) {

			maxSeats.selectByVisibleText(prop.getProperty("MAX_SEATER"));

		}

		// Minimum Chips

		driver.findElement(By.id("minChips")).click();
		driver.findElement(By.id("minChips")).sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
		driver.findElement(By.id("minChips")).sendKeys(prop.getProperty("MIN_CHIPS"));

		Thread.sleep(5000L);

		driver.findElement(By.xpath("//span[contains(text(),'---Select Default Payout---')]")).click();
		WebElement payoutXpath = driver.findElement(By.xpath("//span[contains(text(),'---Select Default Payout---')]"));
		payoutXpath.click();
		WebElement payoutXpath1 = driver
				.findElement(By.xpath("//div[@id='templatePrizeStructure_chosen']//input[@class='inputClass']"));
		payoutXpath1.sendKeys(prop.getProperty("PAYOUT_STRUCT"));
		Thread.sleep(4000L);
		payoutXpath1.sendKeys(Keys.ENTER);
		Thread.sleep(2000L);

		WebElement saveButton = driver.findElement(By.id("createMtctBasicTemplateSave"));
		saveButton.click();
		
		if(prop.getProperty("LIQUIDITY").equalsIgnoreCase("com"))
		{
		int buyIn = Integer.parseInt(prop.getProperty("BUYIN"));
		double buyInFee = Double.parseDouble(prop.getProperty("BUYIN_FEE"));
		if (buyInFee <= (buyIn * 5 / 100)) {
			Alert feeAlert = driver.switchTo().alert();
			while (feeAlert != null) {

				feeAlert.accept();

				Thread.sleep(2000L);

				try {
					feeAlert = driver.switchTo().alert();

				} catch (Exception e) {

					feeAlert = null;

					break;
				}
			}
		}
		}

		// Copying template id
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("successMsg")));
		String tempId = driver.findElement(By.className("successMsg")).getText();
		String tempSplitId[] = tempId.split(":");
		String templateId = tempSplitId[1].trim();
		System.out.println("Template Id : " + templateId);

		WebElement nextButton = driver.findElement(By.id("createMtctBasicTemplateNext"));
		nextButton.click();
		nextButton.click();

		// Select Template Active Date
		// Calender

		String date = "20";
		String month = "Feb";
		String year = "2025";

		driver.findElement(By.id("tmdate")).click();

		Select selectYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		selectYear.selectByValue(year);

		Select selectMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		selectMonth.selectByVisibleText(month);

		List<WebElement> dateXpath = driver.findElements(By.cssSelector("[class=\"ui-state-default\"]"));
		int dateXpathSize = dateXpath.size();

		for (int i = 0; i < dateXpathSize; i++) {
			String dateText = dateXpath.get(i).getText();

			if (dateText.equals(date)) {
				dateXpath.get(i).click();

			}
		}

		driver.findElement(By.id("SpecfyOccurSave")).click();

		Alert alert = driver.switchTo().alert();

		while (alert != null) {
			alert.accept();

			try {
				alert = driver.switchTo().alert();
			} catch (Exception e) {
				alert = null;
				break;
			}
		}

		Thread.sleep(2000L);

		driver.findElement(By.id("scheduleBtn")).click();
		Thread.sleep(2000L);

		// Schedule Date

		String date1 = prop.getProperty("SCHEDULE_DATE").trim();
		String datearray[] = date1.split("-");
		String scheduledate = datearray[0];
		String schedulemonth = datearray[1];
		String scheduleyear = datearray[2];

//		String scheduledate = "2";
//		String schedulemonth = "Mar";
//		String scheduleyear = "2020";

		driver.findElement(By.id("scheduleStDate")).click();

		Select ScheduleYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		ScheduleYear.selectByValue(scheduleyear);

		Select ScheduleMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		ScheduleMonth.selectByVisibleText(schedulemonth);

		List<WebElement> scheduleDateXpath = driver.findElements(By.cssSelector("[class=\"ui-state-default\"]"));
		int scheduleDateXpathSize = scheduleDateXpath.size();

		for (int i = 0; i < scheduleDateXpathSize; i++) {
			String scheduleDateText = scheduleDateXpath.get(i).getText();

			if (scheduleDateText.equals(scheduledate)) {

				try {

					Thread.sleep(5000L);
					scheduleDateXpath.get(i).click();

					break;

				} catch (Throwable e) {
					break;
				}

			}
		}

		Thread.sleep(5000L);
		driver.findElement(By.id("schedule_bt")).click();
		// alert.dismiss();
		Thread.sleep(2000L);
		driver.findElement(By.id("noRadioBtn")).click();
		driver.findElement(By.id("schTrny_bt")).click();

		// Approve Template

		Thread.sleep(3000L);
		driver.findElement(By.xpath("//span[@id='rGame_Configapproval_queue']//a[contains(text(),'Approval')]"))
				.click();

		// QuickApprove of Template created above

		QuickApproveTest.quickApprove(templateId, driver);
		

		// Run Tournament for the template created above

		String players = prop.getProperty("UPLOAD_PLAYERS");
		playerArray = players.split(",");

		RunTournamentTest.runTournament(templateId, driver, playerArray);
	}

}
