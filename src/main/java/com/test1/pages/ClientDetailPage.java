package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientDetailPage extends PageBase{
	
	public ClientDetailPage (WebDriver driver)
	{
		super(driver);
	}

	public boolean isImportFileSuccessful (String mapparcelnumber1, String mapparcelnumber2) throws InterruptedException
	{
		String actualstrings = "";
		
		actualstrings = driver.findElement(By.cssSelector("[ng-style='colContainer.getViewportStyle()']")).getText();
		Thread.sleep(1000);
		System.out.println("The available imported file information includes " + actualstrings);
		
		Thread.sleep(4000);
		
		boolean testresults = false;
		
		if(actualstrings.contains(mapparcelnumber1) && actualstrings.contains(mapparcelnumber2))
		{
			testresults = true;
		}
				
        Thread.sleep(1000);
		
		System.out.println("The test results is :" + testresults);
		
		return testresults;
	}
	
}
