package com.test1.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileEditPage extends PageBase{
	
	public FileEditPage (WebDriver driver)
	{
		super(driver);
	}
	
	public FileEditPage addAttachment(String filetitle, String documentpath, String filename) throws InterruptedException, AWTException
	{
		
		//find the Edit button and click
		driver.findElement(By.cssSelector("[ng-click='state.editFile()']")).click();
		//System.out.println("printing out filetitle, documentpath and filename " + filetitle + documentpath + filename);
		//find the add attachment link and click
		driver.findElement(By.cssSelector("span.btn-text")).click();
		
		Thread.sleep(2000);
		
		//find the file title field and enter title
		driver.findElement(By.xpath("//div[@id='add-dif-modal']/div[2]/div[2]/div[1]/div/input")).sendKeys(filetitle);
		Thread.sleep(2000);
		
		//attach the document - send the path and filename to the upload file button    (//div[@class='file-field clr']/div)
		driver.findElement(By.xpath("//div[@id='add-dif-modal']/div[2]/div[2]/div[2]/div/div/div[1]/input")).sendKeys(documentpath + filename);
		

		Thread.sleep(1000);
		
		//is the add attachment button enabled?  print out true or false
		System.out.println("is the add attachment button enabled? " + (driver.findElement
				(By.cssSelector("button.right.button.btn.green-btn")).isEnabled()) );
		
		Thread.sleep(1000);
		
		//click the add attachment button		
		//driver.findElement(By.cssSelector("button.right.button.btn.green-btn")).sendKeys(Keys.ENTER);
		//Thread.sleep(3000);
		
		//Robot Class to use keyboard functionality 
		Robot robotObj = new Robot();
		
		//press down Tab key then release two times
		robotObj.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robotObj.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robotObj.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robotObj.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		
		//press down Space key then release 
		robotObj.keyPress(KeyEvent.VK_SPACE);
		robotObj.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(1000);
		//press down Enter Key then release
		robotObj.keyPress(KeyEvent.VK_ENTER);
		robotObj.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		
		return new FileEditPage(driver);
	}
	
	public boolean isAddAttachmentSuccessful (String filetitle) throws InterruptedException
	{
		String expectedstr = filetitle;
		
		System.out.println("The available attached file is " + driver.findElement(By.xpath
				("//table[@class='right-pane-document-table striped']/tbody/tr/td")).getText());
		
		Thread.sleep(2000);
		
		boolean testresults;
		
		testresults = driver.findElement(By.xpath("//table[@class='right-pane-document-table striped']"
				+ "/tbody/tr/td")).getText().contains(expectedstr);
		
        Thread.sleep(2000);
		
		System.out.println(testresults);
		
		Thread.sleep(1000);
		
		return testresults;
	}
	
	
}
