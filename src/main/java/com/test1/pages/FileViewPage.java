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
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//ul[@id='client-file-modal-file-list']/li[2]/div")));
		
		Thread.sleep(3000);
		
		// MIDDLE WHEEL CLICK
        //robotObj.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        //robotObj.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		
		//to mouse scroll all the way down
		//robotObj.mouseWheel(-100);
		
		//find the Test Attachment link and click
		driver.findElement(By.xpath("//ul[@id='client-file-modal-file-list']/li[2]/a")).click();
		
		Thread.sleep(3000);
		
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
			
		return new FileViewPage(driver);
	}
	
	public FileViewPage DownloadTestAttachment() throws InterruptedException, AWTException
	{
		
		//To scroll down until Test Attachment is visible
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//ul[@id='client-file-modal-file-list']/li[2]/div")));
		
		Thread.sleep(3000);
		
		//to handle windows based controls
		//Robot robotObj = new Robot();
		
		//to mouse scroll all the way down
		//robotObj.mouseWheel(-100);
		
		//find the Test Attachment link and click
		driver.findElement(By.xpath("//ul[@id='client-file-modal-file-list']/li[2]/a")).click();
				
		Thread.sleep(2000);
			
		return new FileViewPage(driver);
	}
	
	
	public boolean isFileDownLoadSuccessful (String downloadPath, String filename) throws InterruptedException
	{
		
		boolean testresults = false;
		
		
		File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	    System.out.println("The value of dir_contents.length is " + dir_contents.length);
	    	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	    		    	
	    	//System.out.println("The value of i is " + i);
	    	
	        if (dir_contents[i].getName().equals(filename))
	            return testresults=true;
	            }

		
		return testresults;
	}

}
