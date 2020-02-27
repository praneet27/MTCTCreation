package com.ivy.qa.testcases;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunTournamentTest {

	//players
	static String selectBrand="";
	public static void runTournament(String templateId, WebDriver driver,String playerArray[]) throws InterruptedException
	{
		
		driver.findElement(By.xpath("//a[contains(text(),'MTCT Instances/Schedule IDs')]")).click();
		driver.findElement(By.id("rGame_ConfigMTCT_Adminmtct_instancesshow_schedule_id")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("templateID")));

		driver.findElement(By.id("templateID")).sendKeys(templateId);

		driver.findElement(By.xpath("//input[@type='button']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='schIdList']//tbody//tr//td//div//a")));
		driver.findElement(By.xpath("//table[@id='schIdList']//tbody//tr//td//div//a")).click();
	// 	Thread.sleep(5000L);

		Thread.sleep(5000L);
	//	wait.until(ExpectedConditions.elementToBeClickable(By.id("delId12032020000000")));

		List<WebElement> mtctStatusXpath = driver
				.findElements(By.xpath("//table[@id='schIdInstanceList']//tbody//tr//td[4]"));

		for (int i = 0; i < mtctStatusXpath.size(); i++) {
			String mtctStatusText = mtctStatusXpath.get(i).getText();

			if (mtctStatusText.equalsIgnoreCase("Created")) {
				driver.findElement(
						By.xpath("//div[@id='schIdInstanceResultDiv']//tr[" + (i + 1) + " ]//td[2]//div[1]//a"))
						.click();
				break;
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabs1")));
		//Thread.sleep(2000L);
		driver.findElement(By.id("tabs1")).click();
		//Thread.sleep(5000L);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("changeStButton")));
		driver.findElement(By.id("changeStButton")).click();
		Alert changeStatusAlert = driver.switchTo().alert();

		while (changeStatusAlert != null) {

			changeStatusAlert.accept();
			Thread.sleep(2000L);

			try {
				changeStatusAlert = driver.switchTo().alert();

			} catch (Exception e) {

				changeStatusAlert = null;
				break;
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabs1")));
		driver.findElement(By.xpath("//a[@id='tabs1']")).click();
		//Thread.sleep(3000L);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("changeStButton")));
		driver.findElement(By.id("changeStButton")).click();

		Alert changeStatusAlert1 = driver.switchTo().alert();

		while (changeStatusAlert1 != null) {
			changeStatusAlert1.accept();
			Thread.sleep(2000L);

			try {
				changeStatusAlert1 = driver.switchTo().alert();
				
			} catch (Exception e) {
				
				changeStatusAlert1 = null;
				
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabs1")));
		//Thread.sleep(2000L);
		driver.findElement(By.id("tabs1")).click();
		//Thread.sleep(2000L);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("changeStButton")));
		driver.findElement(By.id("uploadPlayersPopupId")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("usersList")));
		WebElement uploadPlayers = driver.findElement(By.id("usersList"));

	//	String clientPrefix = "pp_";
				
		String[] players =  NormalTournamentCreationTest.playerArray;
		//
		String prefix=playerArray[0];
		String[] prefix1= prefix.split("_");
		String brandPrefix = prefix1[0];
		
		if(brandPrefix.equalsIgnoreCase("pp"))
		{
		 selectBrand= "PARTYPOKER";

		for (int i = 0; i < players.length; i++) 
		{
			uploadPlayers.sendKeys(players[i] + ",");
			uploadPlayers.sendKeys(Keys.ENTER);
		}
		}
		
		else if(brandPrefix.equalsIgnoreCase("bz"))
		{
			 selectBrand= "BWINCOM";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
		}
		}
		
		else if(brandPrefix.equalsIgnoreCase("pr")) {
			 selectBrand= "PREMIUM";

			for (int i = 0; i < players.length; i++) {
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			
		}
		}
		else if(brandPrefix.equalsIgnoreCase("dk")) {
			 selectBrand= "PARTYDK";

			for (int i = 0; i < players.length; i++) {
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
		}
		}
		else if(brandPrefix.equalsIgnoreCase("sb")) {
			 selectBrand= "SBCOM";

			for (int i = 0; i < players.length; i++) {
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
		}
		}
		else if(brandPrefix.equalsIgnoreCase("sh"))
		{
			 selectBrand= "BWINSH";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}
		else if(brandPrefix.equalsIgnoreCase("be")) {
			 selectBrand= "BWINBE";

			for (int i = 0; i < players.length; i++) {
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
		}
		}
		else if(brandPrefix.equalsIgnoreCase("br"))
		{
			 selectBrand= "BWINGR";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}	
		else if(brandPrefix.equalsIgnoreCase("cp"))
		{
			 selectBrand= "PPCZECH";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
		}
		}
		else if(brandPrefix.equalsIgnoreCase("sb")) {
			 selectBrand= "SBGREECE";

			for (int i = 0; i < players.length; i++) {
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
		}
		}
		else if(brandPrefix.equalsIgnoreCase("cr")) {
			 selectBrand= "CRYSTALBET";

			for (int i = 0; i < players.length; i++) {
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			
		}
		}
		else if(brandPrefix.equalsIgnoreCase("cl")) {
			 selectBrand= "CORAL";

			for (int i = 0; i < players.length; i++) {
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
		}
		}
		else if(brandPrefix.equalsIgnoreCase("vb")) {
			 selectBrand= "VISTABET";

			for (int i = 0; i < players.length; i++) {
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
		}
		}
		else if(brandPrefix.equalsIgnoreCase("ps"))
		{
			 selectBrand= "PARTYSE";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}
		else if(brandPrefix.equalsIgnoreCase("sb"))
		{
			 selectBrand= "SBCOM";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}	
		else if(brandPrefix.equalsIgnoreCase("fr"))
		{
			 selectBrand= "PARTTFR";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}	
		else if(brandPrefix.equalsIgnoreCase("bf"))
		{
			 selectBrand= "BWINFR";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}	
		else if(brandPrefix.equalsIgnoreCase("BE"))
		{
			 selectBrand= "BWINES";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}	
		else if(brandPrefix.equalsIgnoreCase("pe"))
		{
			 selectBrand= "PARTES";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}	
		else if(brandPrefix.equalsIgnoreCase("gd"))
		{
			 selectBrand= "GIOCOD";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}	
		else if(brandPrefix.equalsIgnoreCase("bi"))
		{
			 selectBrand= "BWINIT";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}	
		else if(brandPrefix.equalsIgnoreCase("pi"))
		{
			 selectBrand= "PARTYIT";

			for (int i = 0; i < players.length; i++) 
			{
				uploadPlayers.sendKeys(players[i] + ",");
				uploadPlayers.sendKeys(Keys.ENTER);
			}
		}	
		
		WebElement brandsXpath= driver.findElement(By.id("brandMapOptions"));
		Select brands= new Select(brandsXpath);
		brands.selectByVisibleText(selectBrand);

		driver.findElement(By.id("applyButton")).click();
		wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='registerUsersResultDiv']//form//div[2]//span"), "Uploaded Players and MTCT loaded to all servers and clients."));
		
		driver.findElement(By.id("cancelBtn")).click();
		WebElement statusXpath= driver.findElement(By.id("changeStatus"));
		Select status= new Select(statusXpath);
		status.selectByIndex(1);
		driver.findElement(By.id("changeStButton")).click();
		//Thread.sleep(5000L);
		

		Alert changeStatusAlert2 = driver.switchTo().alert();

		while (changeStatusAlert2 != null) {
			
			changeStatusAlert2.accept();
			
			Thread.sleep(10000L);	
			

			try {
				changeStatusAlert2 = driver.switchTo().alert();
				
			} catch (Exception e) {
				
				changeStatusAlert2 = null;
				
				break;
			}
		}
		
		//Thread.sleep(7000L);
		driver.findElement(By.id("tabs1")).click();
		//Thread.sleep(2000L);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("changeStButton")));
		driver.findElement(By.id("changeStButton")).click();
		
		Alert changeStatusAlert3 = driver.switchTo().alert();
		while (changeStatusAlert3 != null) {
			changeStatusAlert3.accept();
			
			Thread.sleep(2000L);

			try {
				changeStatusAlert3 = driver.switchTo().alert();
				
			} catch (Exception e) {
				
				changeStatusAlert3 = null;
				
				break;
			}
		}

	}

}
