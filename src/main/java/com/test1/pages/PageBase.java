package com.test1.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase 
{
	//change to protected so it can be inherited by other class
    //private WebDriver driver;
	protected WebDriver driver;
	
	public PageBase (WebDriver driver)
	{
		this.driver = driver;
	}
	

	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isFileDownLoadSuccessful (String downloadPath, String filename) throws InterruptedException
	{
		
		boolean testresults = false;
		
		
		File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	    //System.out.println("The value of dir_contents.length is " + dir_contents.length);
	    
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	    	    	
	    	//System.out.println("The value of i is " + i);
	    	
	        if (dir_contents[i].getName().equals(filename))
	            return testresults=true;
	            }

		
		return testresults;
	}
	
	
	

}
