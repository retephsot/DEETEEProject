package com.test1.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileProcessViewPage extends PageBase{
	
	public FileProcessViewPage (WebDriver driver)
	{
		super(driver);
	}

	public ClientDetailPage ClickSaveImportButton() throws InterruptedException, AWTException
	{
		
		String results = "";
		
		results = driver.findElement(By.xpath("//span[@class='ng-binding']")).getText();
		
		if (results.equals("0 Errors"))
		{
			System.out.println("The file has been successfully imported without any errors.");
			Thread.sleep(2000);
			
			//find the Save Import Button and click
			driver.findElement(By.cssSelector("[ng-click='state.processImport()']")).click();
			Thread.sleep(4000);
		}
		if (!results.equals("0 Errors"))
		{
		System.out.println("The file has not been successfully imported and has errors.");
		Thread.sleep(2000);
		
		//find the Cancel Import Button and click
		driver.findElement(By.cssSelector("[ui-sref='file-import']")).click();
		Thread.sleep(2000);
		}
		
		return new ClientDetailPage(driver);
	}
	
}


