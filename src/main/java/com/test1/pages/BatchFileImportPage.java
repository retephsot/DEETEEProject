package com.test1.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BatchFileImportPage extends PageBase{
	
	public BatchFileImportPage (WebDriver driver)
	{
		super(driver);
	}

	

	public FileProcessViewPage ImportFilesIntoBatch(String client, String batchdate,
			String path, String filename) throws InterruptedException, AWTException
	{
				
		//find the Import Files into Batch button and click
		driver.findElement(By.cssSelector("[ng-click='state.startImport()']")).click();
		Thread.sleep(2000);
		
		//Find the client field and enter client name
		driver.findElement(By.xpath("//div[@class='input-field typeahead-container clr']/input")).sendKeys(client);	
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[ng-click='ctrl.setSearch(result)']")).click();
		Thread.sleep(1000);
		//pick batch and select from drop down
		driver.findElement(By.cssSelector("[data-activates='drop-import']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText(batchdate)).click();
		
		Thread.sleep(2000);
		//sendkeys the path and import file to the upload file button
		driver.findElement(By.cssSelector("[ng-model='ctrl.model.file']")).sendKeys(path + filename);
		
		Thread.sleep(1000);
		
		
		// to hover the mouse pointer over the Start Import button
		WebElement ele = driver.findElement(By.cssSelector("[ng-click='ctrl.confirmModal()']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		
		//find the Start Import button and click
		driver.findElement(By.cssSelector("button.right.button.btn.green-btn")).click();
		
		
		//to open dev tools in chrome
//				Robot robotObj = new Robot();
//				robotObj.keyPress(KeyEvent.VK_F12);
//				Thread.sleep(1000);
//				robotObj.keyRelease(KeyEvent.VK_F12);
//				Thread.sleep(15000);
				
		
		return new FileProcessViewPage(driver);
	}

}
