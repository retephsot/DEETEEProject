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
	
	public boolean isLogInSuccessful () throws InterruptedException
	{
		//to retreive the page title
		//driver.getTitle();
		
		System.out.println("The page title includes " + driver.getTitle());
		
		String expected = "Log in";
		String actual = driver.getTitle();
		
		boolean testresults = false;
		
		if (actual.equals(expected))
		{
			testresults = false;
		}
		if (!actual.equals(expected))
		{
			testresults = true;
		}
				
        Thread.sleep(1000);
		
		System.out.println(testresults);
		
		Thread.sleep(1000);
		
		return testresults;
	}
	
	//this method is no longer needed ** IssuesList no longer exists
	public DefaultLoadingPage DownloadIssuesList() throws InterruptedException, AWTException
	{
				
		//find the Download Issues List button and click
		driver.findElement(By.xpath("//div[@class='main-content-area']/div[1]/div[3]/a")).click();
		Thread.sleep(4000);
		
		//to handle windows based controls enable when using Firefox browser
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
	
	
	//this method is no longer needed ** IssuesList no longer exists
	public DefaultLoadingPage DownloadIssuesListFirefox() throws InterruptedException, AWTException
	{
				
		//find the Download Issues List button and click
		driver.findElement(By.xpath("//div[@class='main-content-area']/div[1]/div[3]/a")).click();
		Thread.sleep(4000);
		
		//to handle windows based controls enable when using Firefox browser
		Robot robotObj = new Robot();
		
		//to press down key and then release
		robotObj.keyPress(KeyEvent.VK_DOWN);
		robotObj.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		
		//to press Enter key then release
		robotObj.keyPress(KeyEvent.VK_ENTER);
		robotObj.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);		
		
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
	
	public DefaultLoadingPage SelectfileInputMP(String mp) throws InterruptedException, AWTException
	{
				
		//find the MP Search field and enter MP
		driver.findElement(By.id("main-search")).sendKeys(mp);
		Thread.sleep(3000);
						
		return new DefaultLoadingPage(driver);
	}
	
	
	public FileViewPage clickActionLink() throws InterruptedException
	{
		
		//find the Action button and click
		driver.findElement(By.cssSelector("span.fa.fa-file-text")).click();

		
		return new FileViewPage(driver);
	}
	

}
