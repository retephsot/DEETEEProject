package com.test1.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageClientsPage extends PageBase{
	
	public ManageClientsPage (WebDriver driver)
	{
		super(driver);
	}

	public AddNewClientPage ClickAddClientButton() throws InterruptedException, AWTException
	{
				
		//find the Add Client Button and click
		driver.findElement(By.cssSelector("[ui-sref='client']")).click();
		Thread.sleep(2000);
			
		return new AddNewClientPage(driver);
	}
	
	
	public boolean isCreateClientSuccessful (String clientname, String clientaddress) throws InterruptedException
	{
		
		boolean testresults = false;
		
		//to print out all text values in the ui-grid-canvas 
		//System.out.println("all texts avail are: " + driver.findElement(By.cssSelector("[ng-style='colContainer.getViewportStyle()']")).getText());
		String compare1 = driver.findElement(By.cssSelector("[ng-style='colContainer.getViewportStyle()']")).getText();
		if(compare1.contains(clientname) && compare1.contains(clientaddress))
		{
			testresults = true;
		}
			
        Thread.sleep(3000);
		
		System.out.println(testresults);
				
		return testresults;
	}
	
}
