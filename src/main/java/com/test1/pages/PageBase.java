package com.test1.pages;

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
	

}
