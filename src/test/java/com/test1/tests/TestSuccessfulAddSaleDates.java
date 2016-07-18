package com.test1.tests;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.test1.pages.LogInPage;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestSuccessfulAddSaleDates extends TestBase

{

  @Test (dataProvider = "dataProvider")
  public void testSuccessfulAddSaleDates(String username, String password, String day1, String day2, 
		  String day3, String day4, String day5, String day6, String day7, String day8, String day9,
		  String day10, String day11, String day12) throws InterruptedException, IOException, AWTException 
  {
	
	  
	boolean testResult = loginpage.loginAsAdmin(username, password)
								  .clickSettingsLink()
								  .AddBatches(day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12)
								  .isAddSaleDateSuccessful(day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12);
  
	 System.out.println(testResult);	
	 
	 Assert.assertTrue(testResult, "The sale dates have not been successfully added." );
	 		
	 
  }
  


}
