package com.test1.tests;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.test1.pages.LogInPage;
import org.testng.annotations.BeforeMethod;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestSuccessfulLogIn extends TestBase

{

  @Test (dataProvider = "dataProvider")
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
  
 

  //AfterMethod is not inherited from TestBase class
//  @AfterMethod
//  public void afterMethod() 
//  {
//	  driver.close();
//  }

}
