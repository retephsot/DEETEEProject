package com.test1.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends PageBase{
	
	//private WebDriver driver;
	
	public LogInPage (WebDriver driver)
	{
		super(driver);
	}
	
	public DefaultLoadingPage login(String username, String password) throws InterruptedException
	{
		//Find email field and enter userID
		driver.findElement(By.id("UserName")).sendKeys(username);
		Thread.sleep(1000);
		
		// Find password field clear it and enter password
		driver.findElement(By.id("Password")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("Password")).sendKeys(password);
		Thread.sleep(1000);
	
		//Find Submit button and click on it
		driver.findElement(By.xpath("//*[@id='login-box']/div/div[2]/form/div/input")).click();
		
		return new DefaultLoadingPage(driver);
		
	}
	
	public FileManagerPage loginAsAdmin(String username, String password) throws InterruptedException, AWTException
	{
		
			
		//remove trailing zero from password		
		//password = password.replaceAll("\\.0*$", "");
		
		
		//Find email field and enter userID
		driver.findElement(By.id("UserName")).sendKeys(username);
		Thread.sleep(1000);
		
		// Find password field clear it and enter password
		driver.findElement(By.id("Password")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("Password")).sendKeys(password);
		Thread.sleep(1000);
	
		//Find Submit button and click on it
		driver.findElement(By.xpath("//*[@id='login-box']/div/div[2]/form/div/input")).click();
		Thread.sleep(2000);
		
		return new FileManagerPage(driver);
		
	}
	
	
	public boolean isLogOutSuccessful () throws InterruptedException
	{
		String expectedword = "Login";
		
		System.out.println("The page title includes: " + driver.findElement(By.cssSelector("h1.page-title")).getText());
		
		Thread.sleep(1000);
		
		boolean testresults;
		
		testresults = driver.findElement(By.cssSelector("h1.page-title")).getText().contains(expectedword);
		
        Thread.sleep(1000);
		
		System.out.println(testresults);
		
		Thread.sleep(1000);
		
		return testresults;
	}
	
	public ForgotPasswordPage SelectRequestPasswordReset() throws InterruptedException
	{
		//Find the Request a password reset token link and click
		driver.findElement(By.linkText("Request a password reset token.")).click();
		Thread.sleep(2000);
			
		return new ForgotPasswordPage(driver);
		
	}

}
