package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewUserPage extends PageBase{
	
	public AddNewUserPage (WebDriver driver)
	{
		super(driver);
	}
	
	public AddNewUserPage CreateNewUser(String nusername, String status, String role, String client, 
			String telenumber, String email, String npassword, String confirmpw,
			String path, String imgname) throws InterruptedException
	{
		
		//find name field and enter name
		driver.findElement(By.cssSelector("[ng-model='state.model.name']")).sendKeys(nusername);
		
		//select user status
		String choice ="";
		
		if (status.equals("Active"))
		{
			choice = "//div[@class='input-field']/div/ul/li[2]/span";
		}
		if (status.equals("Inactive"))
		{
			choice ="//div[@class='input-field']/div/ul/li[3]/span";
		}
				
		driver.findElement(By.xpath("//div[@class='col three-fourths']/div/div[2]/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(choice)).click();
		
		Thread.sleep(1000);
		
		//select role
		String choice2 ="";
		if (role.equals("Admin"))
		{
			choice2 ="//div[@class='col third']/div/div/ul/li[2]/span";
		}
		if (role.equals("Paralegal"))
		{
			choice2 = "//div[@class='col third']/div/div/ul/li[3]/span";
		}
		if (role.equals("Data Entry"))
		{
			choice2 = "//div[@class='col third']/div/div/ul/li[4]/span";
		}
		if (role.equals("Client"))
		{
			choice2 = "//div[@class='col third']/div/div/ul/li[5]/span";
		}
		driver.findElement(By.xpath("//div[@class='col third']/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(choice2)).click();
		Thread.sleep(1000);
		
		//enter client value for client field
		if (role.equals("Client"))
		{
			driver.findElement(By.cssSelector("[ng-change='ctrl.autoSearch()'][ng-readonly='ctrl.islocked']")).sendKeys(client);
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[ng-click='ctrl.setSearch(result)']")).click();
		}
		
		//fill out rest of the fields
		driver.findElement(By.cssSelector("[ng-model='state.model.phoneNumber']")).sendKeys(telenumber);
		Thread.sleep(1000);
		
		//enter email
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		Thread.sleep(1000);
		//enter password
		driver.findElement(By.cssSelector("[ng-model='state.model.password']")).sendKeys(npassword);
		Thread.sleep(1000);
		//enter confirm password
		driver.findElement(By.cssSelector("[ng-model='state.model.confirmPassword']")).sendKeys(confirmpw);
		Thread.sleep(1000);
		
		//upload profile image  css=input.ng-pristine.ng-valid.ng-empty.ng-touched
		// or can user //div[@class='col fourth user-profile-container']/div[2]/div/input
		driver.findElement(By.name("newImg")).sendKeys(path+imgname);
		
		Thread.sleep(2000);
		
		//click save changes button
		driver.findElement(By.cssSelector("[ng-click='state.validateUser()']")).click();
		Thread.sleep(2000);		
		
		return new AddNewUserPage(driver);
	}
	
	public ManageUsersPage clickManageUsersPagelink() throws InterruptedException
	{
		
		//find the Add User button and click
		driver.findElement(By.cssSelector("[ui-sref='user-manager']")).click();
		
		
		return new ManageUsersPage(driver);
	}
	

}
