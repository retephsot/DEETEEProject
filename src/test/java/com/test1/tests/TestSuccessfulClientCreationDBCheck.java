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

public class TestSuccessfulClientCreationDBCheck extends TestBase

{

  @Test (dataProvider = "dataProvider")
  public void testSuccessfulNewClientCreationDBcheck(String username, String password, String clientname, String clientphone,
		String clientext, String clientaddress, String clientcity, String clientstate, String clientzip) 
				  throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException 
  {
	

	  
	boolean testResult = loginpage.loginAsAdmin(username, password)
								  .ClickManageClientsLink()
								  .ClickAddClientButton()
								  .CreateNewClient(clientname, clientphone, clientext, clientaddress, clientcity, clientstate, clientzip)
								  .isCreateClientSuccessfulCheckDB(clientname, clientaddress);
  
	 System.out.println(testResult);	
	 
	 Assert.assertTrue(testResult, "The client account for " + clientname + " has not been successfully created." );
	 
  }
  
 

}
