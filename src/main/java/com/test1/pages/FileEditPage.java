package com.test1.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FileEditPage extends PageBase{
	
	public FileEditPage (WebDriver driver)
	{
		super(driver);
	}
	
	public FileEditPage addAttachment(String filetitle, String documentpath, String filename) throws InterruptedException, AWTException
	{
		
		//find the Edit button and click
		driver.findElement(By.cssSelector("[ng-click='state.editFile()']")).click();
		Thread.sleep(3000);
		
		//System.out.println("printing out filetitle, documentpath and filename " + filetitle + documentpath + filename);
		//find the add attachment link and click
		driver.findElement(By.cssSelector("[ng-click='state.addAttachment()']")).click();
		
		Thread.sleep(2000);
		
		//find the file title field and enter title
		driver.findElement(By.xpath("//div[@class='modal-content-area']/form/div/div/input")).sendKeys(filetitle);
		Thread.sleep(2000);
		
		//attach the document - send the path and filename to the upload file button    (//div[@class='file-field clr']/div)
		driver.findElement(By.cssSelector("[ng-model='ctrl.model.file']")).sendKeys(documentpath + filename);
		

		Thread.sleep(2000);
		
		//is the add attachment button enabled?  print out true or false
		System.out.println("is the add attachment button enabled? " + (driver.findElement
				(By.cssSelector("[ng-click='ctrl.confirmModal()']")).isEnabled()) );
		
		Thread.sleep(1000);
		
		//click the add attachment button	
//		driver.findElement(By.cssSelector("[ng-click='ctrl.confirmModal()']")).click();
//		Thread.sleep(4000);
	
		
		//click and hold the add attachment button
//		Actions action = new Actions(driver);
//	    action.clickAndHold(driver.findElement(By.cssSelector("[ng-click='ctrl.confirmModal()']"))).build().perform();
//	    Thread.sleep(2000);
//	    	    	    
//	    //to release the button press
//	    action.moveToElement(driver.findElement(By.cssSelector("[ng-click='ctrl.confirmModal()']"))).release();
//	    Thread.sleep(3000);
	    
	    //mouse hover over then click
		
		// to hover the mouse pointer over the Add Attachment link
		WebElement ele = driver.findElement(By.cssSelector("[ng-click='ctrl.confirmModal()']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		
		Thread.sleep(2000);
		
		//click on the add attachment link
		action.moveToElement(ele).click().perform();
		
		// after hovering the mouse pointer click on the Add Attachment button
	    //driver.findElement(By.cssSelector("[ng-click='ctrl.confirmModal()']")).click();
							

	    Thread.sleep(3000);
	    
//		WebElement element = driver.findElement(By.xpath("//div[@class='modal-content-area']/div[2]/div[3]/button"));
//		element.click();
//		Thread.sleep(3000);
		
		
//		driver.findElement(By.cssSelector("button.right.button.btn.green-btn")).click();
//		Thread.sleep(3000);
//		
		
		//Robot Class to use keyboard functionality *************
//		Robot robotObj = new Robot();
//		
//		//press down Tab key then release two times
//		robotObj.keyPress(KeyEvent.VK_TAB);
//		robotObj.keyRelease(KeyEvent.VK_TAB);
//		Thread.sleep(2000);
//		robotObj.keyPress(KeyEvent.VK_TAB);
//		robotObj.keyRelease(KeyEvent.VK_TAB);
//		Thread.sleep(2000);
//		robotObj.keyPress(KeyEvent.VK_TAB);
//		robotObj.keyRelease(KeyEvent.VK_TAB);
//		Thread.sleep(2000);
//
//		//press down Space key then release 
//		robotObj.keyPress(KeyEvent.VK_SPACE);
//		Thread.sleep(3000);
//		
//		robotObj.keyRelease(KeyEvent.VK_SPACE);
//
//		Thread.sleep(3000);
	    
		driver.navigate().refresh();
		Thread.sleep(4000);
		
		
		return new FileEditPage(driver);
	}
	
	public boolean isAddAttachmentSuccessful (String filetitle) throws InterruptedException
	{
		
		//DTS QA File Page Documents table 
		WebTable table = new WebTable(driver.findElement(By.xpath("//div[@class='app-right-pane "
				+ "ng-scope']/div/table")));
						
		Thread.sleep(2000);
		
		//Print out all webtable values
		System.out.println("");
		System.out.println("==== getTextDisplayedInAllRows ====");
		String[][] tableText = table.getTextDisplayedInAllRows();
		for(String[] row:tableText)
		{
			for(String cell:row)
			{
				System.out.print(cell+"   ");
			}
			System.out.println("");
		}
		
		Thread.sleep(4000);
				
		System.out.println("The row element for the attachment name is: " + table.getRowElement(filetitle).getText());
		
		Thread.sleep(2000);
		
		String retrieveVal = table.getRowElement(filetitle).getText();
		
		
		Thread.sleep(2000);
		
		boolean testresults;
		
		testresults = retrieveVal.contains(filetitle);
		
        Thread.sleep(2000);
		
		System.out.println(testresults);
		
		Thread.sleep(1000);
		
		return testresults;
	}
	
	
}
