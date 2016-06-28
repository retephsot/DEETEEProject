package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageUsersPage extends PageBase{
	
	public ManageUsersPage (WebDriver driver)
	{
		super(driver);
	}
	
	
	public AddNewUserPage AddUser() throws InterruptedException
	{
		
		//find the Add User button and click
		driver.findElement(By.cssSelector("[ ui-sref='user']")).click();
		Thread.sleep(2000);
		
		
		return new AddNewUserPage(driver);
	}
	
	public boolean isCreateUserSuccessful (String nusername) throws InterruptedException
	{
		
		boolean testresults;
		
		testresults = driver.findElement(By.linkText(nusername)).isDisplayed();
		
        Thread.sleep(3000);
		
		System.out.println(testresults);
		
		Thread.sleep(1000);
		
		return testresults;
	}
	

}
