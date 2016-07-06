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

public class TestSuccessfulImportFileToClient extends TestBase

{

  @Test (dataProvider = "dataProvider")
  public void testSuccessfulImportFileToClient(String username, String password, String clientname, String batchdate, String path, 
		  String filename, String mapparcelnumber1, String mapparcelnumber2) throws InterruptedException, IOException, AWTException 
  {
	
	  
	boolean testResult = loginpage.loginAsAdmin(username, password)
								  .ClickImportFilesLink()
								  .ImportFilesIntoBatch(clientname, batchdate, path, filename)
								  .ClickSaveImportButton()
								  .isImportFileSuccessful(mapparcelnumber1, mapparcelnumber2);
  
	 System.out.println(testResult);	
	 
	 Assert.assertTrue(testResult, filename + " has not been successfully uploaded for " + clientname );
	 
  }
  


}
