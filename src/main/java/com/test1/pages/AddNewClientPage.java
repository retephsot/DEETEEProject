package com.test1.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewClientPage extends PageBase{
	
	public AddNewClientPage (WebDriver driver)
	{
		super(driver);
	}
	
	public AddNewClientPage CreateNewClient(String clientname, String clientphone, String clientext, 
			String clientaddress, String clientcity, String clientstate, 
			String clientzip) throws InterruptedException, AWTException
	{
				
		//find the name field and enter name - fill out the form
		driver.findElement(By.cssSelector("[ng-model='state.model.name']")).sendKeys(clientname);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[ng-model='state.model.phone']")).sendKeys(clientphone);	
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[ng-model='state.model.phoneExt']")).sendKeys(clientext);	
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[ng-model='state.model.address']")).sendKeys(clientaddress);	
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[ng-model='state.model.city']")).sendKeys(clientcity);	
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[ng-model='state.model.state']")).sendKeys(clientstate);	
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[ng-model='state.model.zip']")).sendKeys(clientzip);	
		Thread.sleep(1000);
		
		//find the save changes button and click
		driver.findElement(By.cssSelector("[ng-click='state.validateClient()']")).click();	
	
		return new AddNewClientPage(driver);
	}
	
	public ManageClientsPage ClickMangeClientsButton() throws InterruptedException
	{
				
		//find the Add Client Button and click
		driver.findElement(By.cssSelector("[ui-sref='client-manager']")).click();
		Thread.sleep(2000);
			
		return new ManageClientsPage(driver);
	}
	
	

}
