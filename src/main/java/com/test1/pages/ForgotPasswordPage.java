package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends PageBase{
	
	public ForgotPasswordPage (WebDriver driver)
	{
		super(driver);
	}
	
	public boolean isNavigateToForgotPasswordPageSuccessful () throws InterruptedException
	{
		String expectedstr = "Request a password";
		
		System.out.println("The page title includes: " + driver.findElement(By.cssSelector("h4")).getText());
		
		Thread.sleep(1000);
		//to get the top page title
		//driver.getTitle();
		System.out.println("The title on top of the page is " + (driver.getTitle()));
		
		Thread.sleep(1000);
		
		boolean testresults;
		
		testresults = driver.findElement(By.cssSelector("h4")).getText().contains(expectedstr);
		
        Thread.sleep(1000);
		
		System.out.println(testresults);
		
		Thread.sleep(1000);
		
		return testresults;
	}

}
