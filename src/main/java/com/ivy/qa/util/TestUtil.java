package com.ivy.qa.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ivy.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICT_WAIT = 10;
	
	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	Xls_Reader reader= new Xls_Reader("C:\\Users\\kkumar4\\Java_Selenium_WorkSpace\\MTCTCreation\\src\\main\\java\\com\\ivy\\qa\\testdata\\data.xlsx");
	
	public void handleAlertAccept(){
		 while(isAlertPresent()){
		  Alert alert = driver.switchTo().alert();
		  System.out.println(alert.getText());
		  alert.accept();
		 }
		}
	public void handleAlertDismiss(){
		 while(isAlertPresent()){
		  Alert alert = driver.switchTo().alert();
		  System.out.println(alert.getText());
		  alert.dismiss();
		 }
		}
	public boolean isAlertPresent(){
		 try{
		  driver.switchTo().alert();
		  return true;
		 }catch(NoAlertPresentException ex){
		  return false;
		 }
		}
	
	
}
