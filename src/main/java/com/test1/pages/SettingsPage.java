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
			int role =0;
			int column = 0;
			
			System.out.println("This is loop " + i);
			//click on the month field
			driver.findElement(By.cssSelector("[placeholder='Month " + i + " Sale Date']")).click();
			Thread.sleep(1000);
			
			//to select the month
			for(int j=i-1; j<i; j++)
			{
				
				if (j >= 0 && j <=1)
				{
					role = 1;
				}
				if (j >= 2 && j <=3)
				{
					role =2;
				}
				if (j >=4 && j <=5)
				{
					role =3;
				}
				if (j >= 6 && j <= 7 )
				{
					role = 4;
				}
				if (j >= 8 && j <= 9)
				{
					role =5;
				}
				if (j >=10 && j <=11)
				{
					role =6;
				}
				if ((j==0) ||(j%2 == 0))
				{
					column = 1;
				}
				if ((j==1) || (j%2 !=0))
				{
					column =2;
				}

				if(j>0)
				{
					
					for(int k =1; k < i; k++)
					{
					String rolestr = Integer.toString(role);	
					String columnstr = Integer.toString(column);
					Thread.sleep(1000);
					
			
					//to click on the next month arrow button
					//print out the xpath being used
//					System.out.println("The xpath being used is " + "//form[@ng-submit='ctrl.confirmModal()']"
//							+ "/div[" + rolestr + "]/div[" + columnstr + "]/div/div/div/div/div/div/"
//									+ "div[2]/div/div[4]");
					
					driver.findElement(By.xpath("//form[@ng-submit='ctrl.confirmModal()']"
							+ "/div[" + rolestr + "]/div[" + columnstr + "]/div/div/div/div/div/div/"
									+ "div[2]/div/div[4]")).click();
					}
					
				}
				Thread.sleep(1000);
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
			
//			driver.findElement(By.xpath("//div[contains(@class, 'picker__day picker__day--infocus') and "
//					+ "text() ='" + dayinput + "']")).click();
			
			
			Thread.sleep(1000);
			
			if (i >= 1 && i <=2)
			{
				role = 1;
			}
			if (i >= 3 && i <=4)
			{
				role =2;
			}
			if (i >=5 && i <=6)
			{
				role =3;
			}
			if (i >= 7 && i <= 8 )
			{
				role = 4;
			}
			if (i >= 9 && i <= 10)
			{
				role =5;
			}
			if (i >=11 && i <=12)
			{
				role =6;
			}
			if (i==1 ||i%2 != 0)
			{
				column = 1;
			}
			if (i==2 || i%2 ==0)
			{
				column =2;
			}
			
			Thread.sleep(1000);

			String rolestr = Integer.toString(role);	
			String columnstr = Integer.toString(column);
			
			//print out the xpath used for find the day
//			System.out.println("the xpath being used is " + "//form[@ng-submit='ctrl.confirmModal()']"
//					+ "/div[" + rolestr + "]/div[" + columnstr + "]"
//							+ "/div/div/div/div/div/div/div[2]/table");
			
			//using webtable to find day value
			WebTable table = new WebTable(driver.findElement(By.xpath("//form[@ng-submit='ctrl.confirmModal()']"
					+ "/div[" + rolestr + "]/div[" + columnstr + "]"
							+ "/div/div/div/div/div/div/div[2]/table")));
			
			Thread.sleep(2000);
			
			table.clickCellElement(dayinput);
			
			//System.out.println("The day value has been selected.");
			
			Thread.sleep(2000);
			
			//print the xpath being used to click the close button
//			System.out.println("the xpath being used to find the close button is " + "//form[@ng-submit='ctrl.confirmModal()']"
//					+ "/div[" + rolestr + "]/div[" + columnstr + "]/div/div/div/div/div/div/div[3]/button[3]");
			
			//find the close link and click
			driver.findElement(By.xpath("//form[@ng-submit='ctrl.confirmModal()']"
					+ "/div[" + rolestr + "]/div[" + columnstr + "]/div/div/div/div/div/div/div[3]/button[3]")).click();
			
			Thread.sleep(2000);
			
		}
		
		//click the "Add Sale Dates" button
		driver.findElement(By.xpath("//button[contains(@class, 'right button btn green-btn') "
				+ "and text() = 'Add Sale Dates']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("The Add Sale Dates button has been clicked");
		
		Thread.sleep(1000);
		
		driver.navigate().refresh();
		
		Thread.sleep(6000);
		
		return new SettingsPage(driver);
	}
	
	
	public boolean isAddSaleDateSuccessful (String day1, String day2, String day3, String day4, String day5, String day6,
			String day7, String day8, String day9, String day10, String day11,
			String day12) throws InterruptedException
	{
		
		String actualstr = "";
		String dayinput = "";
		
		boolean testresults = true;
		
		
		
		System.out.println("print out the value of the Global Batches table " + 
				driver.findElement(By.xpath("//div[@class='ui-grid-contents-wrapper']/div/div[2]"))
		.getText());
		
		Thread.sleep(4000);
		
		actualstr = driver.findElement(By.xpath("//div[@class='ui-grid-contents-wrapper']/div/div[2]"))
				.getText();
		
	
        Thread.sleep(1000);
        
        for(int i = 1; i < 13; i++)
        {
        
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
    		
        testresults = actualstr.contains(dayinput);
		
		System.out.println(testresults);
		
		if(testresults == false)
		{
			testresults = false;
			break;
		}
		
        }
		
		Thread.sleep(1000);
		
		return testresults;
	}
	
	
	
	

}
