package com.ivy.qa.pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ivy.qa.base.TestBase;
import com.ivy.qa.util.TestUtil;
import com.ivy.qa.util.Xls_Reader;

public class TemplateCreationPage extends TestBase {

	public static Xls_Reader reader;
	public WebDriverWait wait;
	public static String templateId;
	TestUtil utilObject;
	// Liquidity
	@FindBy(id = "1_brndsGrpIdChk_create")
	WebElement dot_COM_Liquidity;
	@FindBy(id = "2_brndsGrpIdChk_create")
	WebElement dot_IT_Lquidity;
	@FindBy(id = "6_brndsGrpIdChk_create")
	WebElement dot_EU_Liquidity;
	@FindBy(id = "5_brndsGrpIdChk_create")
	WebElement dot_NJ_Lquidity;
	// Currency
	@FindBy(id = "gameCurrency")
	WebElement currencyType;
	// MTCT Type
	@FindBy(id = "shootOutType")
	WebElement mTCT_Type_DropDown;
	@FindBy(id = "bountyConfigured2")
	WebElement selectBounty;
	// Select Bounty Type
	@FindBy(id = "bountyType")
	WebElement bountyTypeDropDown;
	// Buy-in
	@FindBy(id = "buyinEntry")
	WebElement buyIn_Entry;
	// Client tab Visibility
	@FindBy(id = "440000_chk")
	WebElement freeRoll;
	@FindBy(id = "450000_chk")
	WebElement restricted;
	// Real Name Check
	@FindBy(id = "enableRealNameTable")
	WebElement enableRealNameDisplay;
	// Controller
	@FindBy(id = "mcontroller")
	WebElement mTCT_controller;
	// Re-Enrty
	@FindBy(id = "entryTypeReentry")
	WebElement reEntry;
	@FindBy(id = "noOfEntriesAllowed")
	WebElement no_Of_ReEntries;
	// TournyName
	@FindBy(id = "en_US")
	WebElement tournyName;
	// OneClick Tourney
	@FindBy(xpath = "//input[@onclick='copyTrnNameToOneClick();']")
	WebElement oneClicktournyName;
	// BuyIn dropdown
	@FindBy(id = "buyinEntry")
	WebElement mTCT_buyIn_dropDown;
	// Custom Buyin
	@FindBy(id = "custumisedBuyIn")
	WebElement buyInValue;
	// MTCT Fee
	@FindBy(id = "mtctEnteredFee")
	WebElement mTCT_Fee;
	// Game Type
	@FindBy(id = "gameType")
	WebElement gameTypeDropDown;
	// Limit Type
	@FindBy(id = "limitType")
	WebElement limitTypeDropDown;
	// ReBuy Addon
	@FindBy(id = "rebuyAndAddOn2")
	WebElement onlyRebuy;
	@FindBy(id = "rebuyAndAddOn3")
	WebElement rebuyAddon;
	@FindBy(id = "rebuyStackType")
	WebElement rebuyStackType;
	// Blind Structure
	@FindBy(xpath = "//div[@id='blindId_chosen']//a[@class='chosen-single']")
	WebElement blindStructDropDown;
	@FindBy(xpath = "//div[@id='blindId_chosen']//input[@class='inputClass']")
	WebElement blindStructure;
	// Late Registration
	@FindBy(id = "lateRegType")
	WebElement lateRegTypeDropDown;
	@FindBy(id = "lateRegLevel")
	WebElement lateRegDropDown;
	// Deal Making
	@FindBy(id = "dealMaking")
	WebElement dealMakingDropDown;
	@FindBy(id = "maxSeats")
	WebElement maxSeatsDropDown;
	// minimum chips
	@FindBy(id = "minChips")
	WebElement minChips;
	// Select Pay out
	@FindBy(xpath = "//span[contains(text(),'---Select Default Payout---')]")
	WebElement enterPayoutClick;
	@FindBy(xpath = "//div[@id='templatePrizeStructure_chosen']//a[@class='chosen-single']//div//b")
	WebElement dropDownArrow;
	@FindBy(xpath = "//div[@id='templatePrizeStructure_chosen']//input[@class='inputClass']")
	WebElement enterPayoutStruct;
	// Save button
	@FindBy(id = "createMtctBasicTemplateSave")
	WebElement saveButton;
	// Copy Template Id text
	@FindBy(className = "successMsg")
	WebElement templateIdText;
	// Next button
	@FindBy(id = "createMtctBasicTemplateNext")
	WebElement nextButton;
	// Select Active Template Date
	@FindBy(id = "tmdate")
	WebElement activateTemplateCalender;
	@FindBy(className = "ui-datepicker-year")
	WebElement selectActivateTemplateYearDropDown;
	@FindBy(className = "ui-datepicker-month")
	WebElement selectActivateTemplateMonthDropDown;
	@FindBy(css = "[class=\"ui-state-default\"]")
	List<WebElement> selectActivateTemplateDate;
	// Save button at specify occurrence & schedule
	@FindBy(id = "SpecfyOccurSave")
	WebElement saveTemplateButton;
	// Schedule Button
	@FindBy(id = "scheduleBtn")
	WebElement scheduleTentativelyButton;
	@FindBy(id = "scheduleStDate")
	WebElement ScheduleDateCalender;
	@FindBy(id = "schedule_bt")
	WebElement scheduleButton;
	@FindBy(id = "noRadioBtn")
	WebElement noEndDateRadioButton;
	@FindBy(id = "schTrny_bt")
	WebElement scheduleTentativeButton;

	// Initializing the Page Objects

	public TemplateCreationPage() {
		PageFactory.initElements(driver, this);
		utilObject = new TestUtil();
	}

	// Actions
	public void selectLquidity() {
		reader = new Xls_Reader(
				"C:\\Users\\kkumar4\\Java_Selenium_WorkSpace\\MTCTCreation\\src\\main\\java\\com\\ivy\\qa\\testdata\\data.xlsx");
		if (reader.getCellData("Data", 2, 8).equals("COM")) {
			System.out.println(reader.getCellData("Data", 2, 8));
			dot_COM_Liquidity.click();
		} else if (reader.getCellData("Data", 2, 8).equals("IT")) {
			dot_IT_Lquidity.click();
		} else if(reader.getCellData("Data", 2, 8).equals("EU")) {
			dot_EU_Liquidity.click();
		} 

	}

	public void selectCurrencyType() {
		Select currType = new Select(currencyType);
		currType.selectByVisibleText(reader.getCellData("Data", 2, 9));
	}

	public void selectClientTabVisibility() {
		freeRoll.click();
		restricted.click();
	}

	public void selectRealNameDisplay() {
		if (reader.getCellData("data", 2, 10).equals("YES")) {
			enableRealNameDisplay.click();
			utilObject.handleAlertAccept();
		}
	}

	public void selectController() {
		Select controller = new Select(mTCT_controller);
		String controllerText = reader.getCellData("data", 2, 15);
		controller.deselectByVisibleText(controllerText);
	}

	public void selectReEntry() {
		if (reader.getCellData("data", 2, 13).equals("RE-ENTRY")) {
			reEntry.click();
			Select reEntry = new Select(no_Of_ReEntries);
			int no_of_Entries = Integer.parseInt(reader.getCellData("data", 2, 14));
			reEntry.selectByIndex(no_of_Entries);
		}

	}

	public void selectMTCT() {
		Select mtctType = new Select(mTCT_Type_DropDown);
		if (reader.getCellData("data", 2, 11).equals("BOUNTY")) {
			selectBounty(mtctType);
		}
	}

	public void tournyName() {
		tournyName.sendKeys(reader.getCellData("data", 2, 16));
		oneClicktournyName.click();
	}

	public void BuyIn() {
		Select buyInEntry = new Select(mTCT_buyIn_dropDown);
		buyInEntry.selectByVisibleText("Custom Value");
		buyInValue.sendKeys(reader.getCellData("data", 2, 17));
		mTCT_Fee.sendKeys(reader.getCellData("data", 2, 18));
	}

	public void selectGameType() {
		Select gameType = new Select(gameTypeDropDown);
		gameType.selectByVisibleText(reader.getCellData("data", 2, 19));
		Select limitType = new Select(limitTypeDropDown);
		limitType.selectByVisibleText(reader.getCellData("data", 2, 20));
	}

	public void selectReBuyAddOn() {
		Select allowRebuy = new Select(rebuyStackType);
		if (reader.getCellData("data", 2, 21).equals("Only_Rebuy_Support")) {
			onlyRebuy.click();
			allowRebuy.selectByVisibleText(reader.getCellData("data", 2, 22));
		} else if (reader.getCellData("data", 2, 21).equals("Rebuy_Addon Support")) {
			rebuyAddon.click();
			allowRebuy.selectByVisibleText(reader.getCellData("data", 2, 22));
		}
	}

	public void blindStructure() throws InterruptedException {
		blindStructDropDown.click();
		blindStructure.sendKeys(reader.getCellData("data", 2, 23));
		blindStructure.sendKeys(Keys.ENTER);
	}

	public void selectLateRegistration() {
		Select lateRegType = new Select(lateRegTypeDropDown);
		Select lateReg = new Select(lateRegDropDown);
		if (reader.getCellData("data", 2, 3).equals("relB")) {
			if (reader.getCellData("data", 2, 24).equals("Disabled")) {
				lateRegType.selectByVisibleText("Disabled");
			} else if (reader.getCellData("data", 2, 23).equals("LevelBased")) {
				lateRegType.selectByVisibleText("Level Based");
				lateReg.selectByVisibleText(reader.getCellData("data", 2, 25));
			}
		} else if (reader.getCellData("data", 2, 3).equals("staging")) {
			if (reader.getCellData("data", 2, 24).equals("Disabled")) {
				lateRegType.selectByVisibleText("Disabled");
			} else if (reader.getCellData("data", 2, 23).equals("LevelBased")) {
				lateRegType.selectByVisibleText("Enabled");
				lateReg.selectByVisibleText(reader.getCellData("data", 2, 25));
			}
		}
	}

	public void selectDealMaking() {
		Select dealMaking = new Select(dealMakingDropDown);
		dealMaking.selectByVisibleText(reader.getCellData("data", 2, 26));
	}

	public void selectMaxSeats() {
		Select maxSeats = new Select(maxSeatsDropDown);
		maxSeats.selectByValue(reader.getCellData("data", 2, 27));
	}

	public void selectChips() {
		minChips.click();
		minChips.sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
		minChips.sendKeys(reader.getCellData("data", 2, 28));
	}

	public void selectPayout() throws InterruptedException {
		Thread.sleep(7000L);
		enterPayoutClick.click();
		enterPayoutClick.click();
		enterPayoutStruct.click();
		enterPayoutStruct.sendKeys(reader.getCellData("data", 2, 29));
		Thread.sleep(5000L);
		enterPayoutStruct.sendKeys(Keys.ENTER);
		Thread.sleep(3000L);
		}
	

	public void saveTemplate() {
		saveButton.click();
		handleBuyInAlert();
	}

	public void copyTemplateId() {
		String templateIdMessage = templateIdText.getText();
		String tempSplitId[] = templateIdMessage.split(":");
		templateId = tempSplitId[1].trim();
		System.out.println("Template Id : " + templateId);
	}

	public void clickNext() {
		nextButton.click();
	}

	public void selectTemplateActiveDate() {

		activateTemplateCalender.click();

		String activeDate = reader.getCellData("data", 2, 32);
		String ActiveDateArr[] = activeDate.split("/");
		String schedulemonth = ActiveDateArr[0];
		String scheduledate = ActiveDateArr[1];
		String scheduleyear = ActiveDateArr[2];
		System.out.println(schedulemonth + "/" + scheduledate + "/" + scheduleyear);
		selectDate(scheduledate, schedulemonth, scheduleyear);

	}

	public void saveActiveTemplate() throws InterruptedException {
		saveTemplateButton.click();
		utilObject.handleAlertAccept();
		Thread.sleep(2000L);
		
	}

	public void clickScheduleTentativelyButton() {
		scheduleTentativelyButton.click();
	}

	public void scheduleTentatively() throws InterruptedException {
		ScheduleDateCalender.click();

		String activeDate = reader.getCellData("data", 2, 33);
		String ActiveDateArr[] = activeDate.split("/");
		String schedulemonth = ActiveDateArr[0];
		String scheduledate = ActiveDateArr[1];
		String scheduleyear = ActiveDateArr[2];
		System.out.println(schedulemonth + "/" + scheduledate + "/" + scheduleyear);
		selectDate(scheduledate, schedulemonth, scheduleyear);
		scheduleButton.click();
		utilObject.handleAlertDismiss();
		Thread.sleep(2000L);
		noEndDateRadioButton.click();
		scheduleTentativeButton.click();
	}

	public void handleBuyInAlert() {
		if (reader.getCellData("data", 2, 8).equals("COM")) {
			int buyIn = Integer.parseInt(reader.getCellData("data", 2, 17));
			double buyInFee = Double.parseDouble(reader.getCellData("data", 2, 18));
			if (buyInFee <= (buyIn * 5 / 100)) {
				utilObject.handleAlertAccept();
			}

		}
	}

	public void selectBounty(Select mtctType) {
		Select bountyType = new Select(bountyTypeDropDown);
		if (reader.getCellData("data", 2, 3).equalsIgnoreCase("relB")) {
			selectBounty.click();
		} else if (reader.getCellData("data", 2, 3).equalsIgnoreCase("staging")) {
			mtctType.selectByVisibleText("Is a Bounty");
		}
		if (reader.getCellData("data", 2, 12).equalsIgnoreCase("REGULAR")) {
			bountyType.selectByVisibleText("Regular");
		} else if (reader.getCellData("data", 2, 12).equalsIgnoreCase("PROGRESSIVE")) {
			bountyType.selectByVisibleText("Progressive");
		}

	}

	public void selectDate(String date, String month, String year) {
		Select selectActivateTemplateYear = new Select(selectActivateTemplateYearDropDown);
		selectActivateTemplateYear.selectByValue(20 + year);

		Select selectActivateTemplateMonth = new Select(selectActivateTemplateMonthDropDown);
		selectActivateTemplateMonth.selectByIndex(Integer.parseInt(month) - 1);

		int dateXpathSize = selectActivateTemplateDate.size();

		for (int i = 0; i < dateXpathSize; i++) {
			String dateText = selectActivateTemplateDate.get(i).getText();

			if (dateText.equals(date)) {
				selectActivateTemplateDate.get(i).click();

			}
		}
	}
}
