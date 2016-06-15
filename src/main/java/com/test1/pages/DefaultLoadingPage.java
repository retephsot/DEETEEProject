package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DefaultLoadingPage extends PageBase{
	
	public DefaultLoadingPage (WebDriver driver)
	{
		super(driver);
	}
	
	public LogInPage logOut() throws InterruptedException
	{
		// wait 2 seconds to show the movement
		Thread.sleep(2000);
		
		//find the Log Out button and click
		driver.findElement(By.cssSelector("a.log-out-link")).click();

		
		return new LogInPage(driver);
	}
	
	public boolean isLogInSuccessful (String username) throws InterruptedException
	{
		
		System.out.println("The page title includes " + driver.findElement(By.cssSelector("h1.page-title")).getText());
		
		Thread.sleep(1000);
		
		boolean testresults;
		
		testresults = driver.findElement(By.cssSelector("h1.page-title")).getText().contains(username);
		
        Thread.sleep(1000);
		
		System.out.println(testresults);
		
		Thread.sleep(1000);
		
		return testresults;
	}

}
