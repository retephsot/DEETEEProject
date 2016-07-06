package com.test1.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileViewPage extends PageBase{
	
	public FileViewPage (WebDriver driver)
	{
		super(driver);
	}
	
	public FileViewPage DownloadTestAttachmentFirefox() throws InterruptedException, AWTException
	{
		
		//To scroll down until Test Attachment is visible
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath
				("//table[@class='modal-data-table']/tbody/tr/td[2]/a/span")));
		
		Thread.sleep(3000);
		
		// MIDDLE WHEEL CLICK
        //robotObj.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        //robotObj.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		
		//to mouse scroll all the way down
		//robotObj.mouseWheel(-100);
		
		//find the Download Attachment link and click
		driver.findElement(By.cssSelector("a.file-link.truncate")).click();
		
		Thread.sleep(3000);
		
		//to handle windows based controls
//		Robot robotObj = new Robot();
//			
//		robotObj.keyPress(KeyEvent.VK_DOWN);
//		robotObj.keyRelease(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
//		
//		robotObj.keyPress(KeyEvent.VK_ENTER);
//		robotObj.keyRelease(KeyEvent.VK_ENTER);
//		
//		Thread.sleep(2000);
			
		return new FileViewPage(driver);
	}
	
	public FileViewPage DownloadTestAttachment() throws InterruptedException, AWTException
	{
		
		//To scroll down until Test Attachment is visible
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath
		("//table[@class='modal-data-table']/tbody/tr/td[2]/a/span")));
		
		Thread.sleep(3000);
		
		//to handle windows based controls
		//Robot robotObj = new Robot();
		
		//to mouse scroll all the way down
		//robotObj.mouseWheel(-100);
		
		//find the Download Attachment link and click
		driver.findElement(By.cssSelector("a.file-link.truncate")).click();
				
		Thread.sleep(2000);
			
		return new FileViewPage(driver);
	}
	
	
	public boolean isFileDownLoadSuccessful (String downloadPath, String filename) throws InterruptedException
	{
		
		boolean testresults = false;
		
		
		File dir = new File(downloadPath);
	    File[] dircontents = dir.listFiles();
	    System.out.println("The value of dircontents.length is " + dircontents.length);
	    	  	    
	    for (int i = 0; i < dircontents.length; i++) {
	    		    	
	    	//System.out.println("The value of i is " + i);
	    	
	        if (dircontents[i].getName().equals(filename))
	            return testresults=true;
	            }

		
		return testresults;
	}

}
