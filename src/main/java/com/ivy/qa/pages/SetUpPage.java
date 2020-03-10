package com.ivy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ivy.qa.base.TestBase;
import com.ivy.qa.util.*;

public class SetUpPage extends TestBase {

	//Page Factory or Object Repository
	
	@FindBy(linkText="http://releaseb-backoffice-real.ivycomptech.co.in/home.action/")
	WebElement relB_BO_Real;
	
	@FindBy(linkText="https://backoffice.partygaming.com.e7new.com/home.action/")
	WebElement staging_BO_Real;
	
	@FindBy(linkText="http://trunkia-backoffice-real.ivycomptech.co.in/home.action/")
	WebElement trunIA_BO_Real;
	
	@FindBy(linkText="http://trunkib-backoffice-real.ivycomptech.co.in/home.action/")
	WebElement trunIB_BO_Real;
	
	
	
	// Initializing the Page Objects 
		public SetUpPage() {
			PageFactory.initElements(driver, this);
		}
	
		
	// Actions 
		
	public void BOReal() {
		Xls_Reader reader= new Xls_Reader("C:\\Users\\kkumar4\\Java_Selenium_WorkSpace\\MTCTCreation\\src\\main\\java\\com\\ivy\\qa\\testdata\\data.xlsx");
		if(reader.getCellData("data", 2 , 3).equals("relB")){
			driver.get("http://10.1.52.194/RELB_PG/releaseb_Setup_Details.html");
			relB_BO_Real.click();
		}else if(reader.getCellData("data", 2 , 3).equals("staging")) {
			driver.get("http://staging-su.e7new.com/LIVELIKE_PG/e7new.com_Setup_Details.html");
			staging_BO_Real.click();
		}else if(reader.getCellData("data", 2 , 3).equals("trunkIA")) {
			driver.get("http://tr-su.ivycomptech.co.in/tr_Setup_Details.html");
			trunIA_BO_Real.click();
		}else if(reader.getCellData("data", 2 , 3).equals("trunkIB")) {
			driver.get("http://10.1.152.23/TRUNKIB_PG/trunkib_Setup_Details.html");
			trunIB_BO_Real.click();
		}
		
		
		
		
	}
		
		
		
}
