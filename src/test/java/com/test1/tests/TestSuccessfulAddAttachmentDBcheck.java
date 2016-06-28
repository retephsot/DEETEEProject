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
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestSuccessfulAddAttachmentDBcheck extends TestBase

{

  @Test (dataProvider = "dataProvider")
  public void testSuccessfulAddAttachmentDBcheck(String client, String username, String password, String mp, String filetitle, 
		  String documentpath, String filename) throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException 
  {
	
	  
	boolean testResult = loginpage.loginAsAdmin(username, password)
								  .SearchClient(client)
								  .clickMapParcelLink(mp)
								  .addAttachment(filetitle, documentpath, filename)
								  .isAddAttachmentSuccessfulCheckDB(filetitle, filename); 
  
	 System.out.println(testResult);	
	 
	 Assert.assertTrue(testResult, filetitle + " was not successfully attached for " + mp );
	 
  }
  


}
