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
	  public void testSuccessfulNewAdminUserCreationDBcheck(String username, String password, String nusername, String status,
			String role, String client, String telenumber, String email, String npassword, String confirmpw, String path,
			String imgname) 
					  throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException 
	  {
		
		//The entry point LogInPage object below can now be removed because its added to TestBase can now inherit this
	    //LogInPage logInPage = new LogInPage(driver);
		  
		boolean testResult = loginpage.loginAsAdmin(username, password)
									  .ClickManageUsersLink()
									  .AddUser()
									  .CreateNewUser(nusername, status, role, client, telenumber, email, npassword, confirmpw, path, imgname)
									  .clickManageUsersPagelink()
									  .isCreateUserSuccessfulCheckDB(nusername, email);
	  
		 System.out.println(testResult);	
		 
		 Assert.assertTrue(testResult, "The account for " + nusername + " has not been successfully created." );
		 
	  }
	  
	
	 @Test (priority=2, dataProvider = "dataProvider")
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
	  
	 
	
	@Test (priority=3, dataProvider = "dataProvider")
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
	  
	  @Test (priority=4, dataProvider = "dataProvider")
	  public void testSuccessfulNewClientCreation(String username, String password, String clientname, String clientphone,
			String clientext, String clientaddress, String clientcity, String clientstate, String clientzip) 
					  throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException 
	  {
		

		  
		boolean testResult = loginpage.loginAsAdmin(username, password)
									  .ClickManageClientsLink()
									  .ClickAddClientButton()
									  .CreateNewClient(clientname, clientphone, clientext, clientaddress, clientcity, clientstate, clientzip)
									  .ClickMangeClientsButton()
									  .isCreateClientSuccessful(clientname, clientaddress);
	  
		 System.out.println(testResult);	
		 
		 Assert.assertTrue(testResult, "The client account for " + clientname + " has not been successfully created." );
		 
	  }
	
	  @Test (priority=5, dataProvider = "dataProvider")
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
	  
	  @Test (priority=6, dataProvider = "dataProvider")
	  public void testSuccessfulAdminAddAttachment(String client, String username, String password, String mp, String filetitle, 
			  String documentpath, String filename) throws InterruptedException, IOException, AWTException 
	  {
		
		  
		boolean testResult = loginpage.loginAsAdmin(username, password)
									  .SearchClient(client)
									  .clickMapParcelLink(mp)
									  .addAttachment(filetitle, documentpath, filename)
									  .isAddAttachmentSuccessful(filetitle); 
	  
		 System.out.println(testResult);	
		 
		 Assert.assertTrue(testResult, filetitle + " was not successfully attached for " + mp );
		 
	  }
	  
	  @Test (priority=7, dataProvider = "dataProvider")
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
	  

	  

	 @Test (priority=8, dataProvider = "dataProvider")
	  public void testSuccessfulNewUserCreationDBcheck(String username, String password, String nusername, String status,
			String role, String client, String telenumber, String email, String npassword, String confirmpw, String path,
			String imgname) 
					  throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException 
	  {
		
		//The entry point LogInPage object below can now be removed because its added to TestBase can now inherit this
	    //LogInPage logInPage = new LogInPage(driver);
		  
		boolean testResult = loginpage.loginAsAdmin(username, password)
									  .ClickManageUsersLink()
									  .AddUser()
									  .CreateNewUser(nusername, status, role, client, telenumber, email, npassword, confirmpw, path, imgname)
									  .clickManageUsersPagelink()
									  .isCreateUserSuccessfulCheckDB(nusername, email);
	  
		 System.out.println(testResult);	
		 
		 Assert.assertTrue(testResult, "The account for " + nusername + " has not been successfully created." );
		 
	  }
	  
	
	 @Test (priority=9, dataProvider = "dataProvider")
	  public void testSuccessfulNewUserCreate(String username, String password, String nusername, String status,
			String role, String client, String telenumber, String email, String npassword, String confirmpw, String path,
			String imgname) 
					  throws InterruptedException, IOException, AWTException 
	  {
		
		//The entry point LogInPage object below can now be removed because its added to TestBase can now inherit this
	    //LogInPage logInPage = new LogInPage(driver);
		  
		boolean testResult = loginpage.loginAsAdmin(username, password)
									  .ClickManageUsersLink()
									  .AddUser()
									  .CreateNewUser(nusername, status, role, client, telenumber, email, npassword, confirmpw, path, imgname)
									  .clickManageUsersPagelink()
									  .isCreateUserSuccessful(nusername);
	  
		 System.out.println(testResult);	
		 
		 Assert.assertTrue(testResult, "The account for " + nusername + " has not been successfully created." );
		 
	  }
	  

	
  @Test (priority=10, dataProvider = "dataProvider")
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
  

  @Test (priority=11, dataProvider = "dataProvider")
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
  

 
  
  
  
  

  
  
  @Test (priority=12, dataProvider = "dataProvider")
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
