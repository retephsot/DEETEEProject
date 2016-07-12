package com.test1.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SettingsPage extends PageBase{
	
	public SettingsPage (WebDriver driver)
	{
		super(driver);
	}
	
	public SettingsPage AddBatches(String day1, String day2, String day3, String day4, String day5, String day6,
			String day7, String day8, String day9, String day10, String day11,
			String day12) throws InterruptedException, AWTException
	{	
		String dayinput = "";
		//find the Add Batches button and click
		driver.findElement(By.xpath("//i[@class='fa fa-plus-circle']")).click();
		Thread.sleep(1000);
		
		
		//populate each month field
		for(int i=1; i<13; i++)
		{
			
			System.out.println("This is loop " + i);
			//click on the month field
			driver.findElement(By.cssSelector("[placeholder='Month " + i + " Sale Date']")).click();
			Thread.sleep(2000);
			
			
			//print out the window count after clicking on the month field
//			System.out.println("Window count after clicking on month sale date  : " + driver.getWindowHandles().size());
//			
//			Iterator<String> whs = driver.getWindowHandles().iterator();
//			
//			String mainWin = whs.next();
//			String detailViewWin = whs.next();
//			
//			driver.switchTo().window(detailViewWin);
			//to select the month
			for(int j=0; j<i; j++)
			{
				if(j>0)
				{
										
					Thread.sleep(2000);
					
					//click on today link to get focus on the calendar pop-up
					driver.findElement(By.xpath("//div[@class='picker picker--opened picker--focused']"
							+ "/div/div/div/div/div[3]/button")).click();
					
					//to get focus on the calendar popup
					//driver.findElement(By.xpath("//div[@class='picker picker--opened picker--focused']"
					//		+ "/div/div/div/div/div[2]/div")).click();
					
					
					
					Thread.sleep(3000);
					//to click on the next month arrow button
					driver.findElement(By.xpath("//div[@class='picker picker--opened "
							+ "picker--focused']/div/div/div/div/div[2]/div/div[4]")).click();
				}
				Thread.sleep(3000);
			}
			
			//to select the day
			if (i == 1)
			{
				dayinput = day1;
			}
			if (i == 2)
			{
				dayinput = day2;
			}
			if (i == 3)
			{
				dayinput = day3;
			}
			if (i == 4)
			{
				dayinput = day4;
			}
			if (i == 5)
			{
				dayinput = day5;
			}
			if (i == 6)
			{
				dayinput = day6;
			}
			if (i == 7)
			{
				dayinput = day7;
			}
			if (i == 8)
			{
				dayinput = day8;
			}
			if (i == 9)
			{
				dayinput = day9;
			}
			if (i == 10)
			{
				dayinput = day10;
			}
			if (i == 11)
			{
				dayinput = day11;
			}
			if (i == 12)
			{
				dayinput = day12;
			}
			driver.findElement(By.xpath("//div[contains(@class, 'picker__day picker__day--infocus') and "
					+ "text() ='" + dayinput + "']")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div[contains(@class, 'picker__day picker__day--infocus') and "
					+ "text() ='" + dayinput + "']")).click();
			Thread.sleep(3000);
			
			//to get focus on the calendar popup
//			driver.findElement(By.xpath("//div[@class='picker picker--opened picker--focused']"
//					+ "/div/div/div/div/div[3]")).click();
			
			Thread.sleep(2000);
			
			//find the close link and click
			driver.findElement(By.xpath("//div[@class='picker picker--opened picker--focused']"
					+ "/div/div/div/div/div[3]/button[3]")).click();
			
			Thread.sleep(3000);
			
		}
		
		return new SettingsPage(driver);
	}
	
	
	public boolean isAddSaleDateSuccessful () throws InterruptedException
	{
		String expectedstr = "Sale Date";
		
		
		Thread.sleep(1000);
		
		boolean testresults;
		
		testresults = driver.findElement(By.cssSelector("[ui-grid-one-bind-id-grid='col.uid + '-header-text'']"))
				.getText().contains(expectedstr);
		
        Thread.sleep(1000);
		
		System.out.println(testresults);
		
		Thread.sleep(1000);
		
		return testresults;
	}
	
	
	

}
