package com.test1.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

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
	
	public DefaultLoadingPage DownloadIssuesList() throws InterruptedException, AWTException
	{
				
		//find the Download Issues List button and click
		driver.findElement(By.xpath("//div[@class='main-content-area']/div[1]/div[3]/a")).click();
		Thread.sleep(4000);
		
		//to handle windows based controls
//		Robot robotObj = new Robot();
//		
//		robotObj.keyPress(KeyEvent.VK_DOWN);
//		
//		Thread.sleep(2000);
//		
//		robotObj.keyPress(KeyEvent.VK_ENTER);
//		
//		Thread.sleep(2000);
		
		
		
		
		return new DefaultLoadingPage(driver);
	}
	
	
	public boolean isFileDownLoadSuccessful (String downloadPath, String filename) throws InterruptedException
	{
		
		boolean testresults = false;
		
		
		File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(filename))
	            return testresults=true;
	            }

		
		return testresults;
	}
	
	

}
