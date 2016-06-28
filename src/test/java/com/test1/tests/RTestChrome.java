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

public class RTestChrome extends TestBase

{

	 @Test (dataProvider = "dataProvider")
	  public void testSuccessfulNewUserCreationDBcheck(String username, String password, String nusername, String status,
			String role, String telenumber, String email, String npassword, String confirmpw, String path,
			String imgname) 
					  throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException 
	  {
		
		//The entry point LogInPage object below can now be removed because its added to TestBase can now inherit this
	    //LogInPage logInPage = new LogInPage(driver);
		  
		boolean testResult = loginpage.loginAsAdmin(username, password)
									  .ClickManageUsersLink()
									  .AddUser()
									  .CreateNewUser(nusername, status, role, telenumber, email, npassword, confirmpw, path, imgname)
									  .clickManageUsersPagelink()
									  .isCreateUserSuccessfulCheckDB(nusername, email);
	  
		 System.out.println(testResult);	
		 
		 Assert.assertTrue(testResult, "The account for " + nusername + " has not been successfully created." );
		 
	  }
	  
	
	
  @Test (priority=2, dataProvider = "dataProvider")
  public void testSuccessfulLogIn(String username, String password) 
				  throws InterruptedException, IOException 
  {
	
	//The entry point LogInPage object below can now be removed because its added to TestBase can now inherit this
    //LogInPage logInPage = new LogInPage(driver);
	  
	boolean testResult = loginpage.login(username, password)
								  .isLogInSuccessful(); 
  
	 System.out.println(testResult);	
	 
	 Assert.assertTrue(testResult, "Login is not successful for username " + username );
	 
  }
  

  @Test (priority=3, dataProvider = "dataProvider")
  public void testSuccessfulLogOut(String username, String password) 
				  throws InterruptedException, IOException 
  {
	
	//The entry point LogInPage object below can now be removed because its added to TestBase can now inherit this
    //LogInPage logInPage = new LogInPage(driver);
	  
	boolean testResult = loginpage.login(username, password)
								  .logOut()
								  .isLogOutSuccessful(); 
  
	 System.out.println(testResult);	
	 
	 Assert.assertTrue(testResult, username + " has not been successfully logged out.");
	 
  }
  

  @Test (priority=4, dataProvider = "dataProvider") //this is for client users ***
  public void testSuccessfulIssuesFileDownLoad(String username, String password, String downloadPath, 
		  String filename) throws InterruptedException, IOException, AWTException 
  {
	
	  
	boolean testResult = loginpage.login(username, password)
								  .DownloadIssuesList()
								  .isFileDownLoadSuccessful(downloadPath, filename); 
  
	 System.out.println(testResult);	
	 
	 Assert.assertTrue(testResult, "The Issues File download was not successful for " + username );
	 
  }
  
//  @Test (priority=4, dataProvider = "dataProvider")
//  public void testSuccessfulSumSheetDownLoadFiref(String username, String password, String mp, String downloadPath, 
//		  String filename) throws InterruptedException, IOException, AWTException 
//  {
//	
//	  
//	boolean testResult = loginpage.login(username, password)
//								  .SelectfileInputMP(mp)
//								  .clickActionLink()
//								  .DownloadTestAttachmentFirefox()
//								  .isFileDownLoadSuccessful(downloadPath, filename); 
//  
//	 System.out.println(testResult);	
//	 
//	 Assert.assertTrue(testResult, "The Summary Sheet download was not successful for " + mp );
//	 
//  }
//  




}
