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

public class TestSuccessfulDLSumSheetFirefox extends TestBase

{

  @Test (dataProvider = "dataProvider")
  public void testSuccessfulSumSheetDownLoadFiref(String username, String password, String mp, String downloadPath, 
		  String filename) throws InterruptedException, IOException, AWTException 
  {
	
	  
	boolean testResult = loginpage.login(username, password)
								  .SelectfileInputMP(mp)
								  .clickActionLink()
								  .DownloadTestAttachmentFirefox()
								  .isFileDownLoadSuccessful(downloadPath, filename); 
  
	 System.out.println(testResult);	
	 
	 Assert.assertTrue(testResult, "The Summary Sheet download was not successful for " + mp );
	 
  }
  


}
