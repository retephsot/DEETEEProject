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

public class TestSuccessfulNavigationToResetPasswordPage extends TestBase

{

		//commented out dataProvider as no data is required to execute this test
  @Test //(dataProvider = "dataProvider")
  public void testSuccessfulNavigationToResetPasswordPage() 
				  throws InterruptedException, IOException 
  {
	
	  
	boolean testResult = loginpage.SelectRequestPasswordReset()
								  .isNavigateToForgotPasswordPageSuccessful(); 
  
	 System.out.println(testResult);	
	 
	 Assert.assertTrue(testResult, "Navigation to the Reset Password Page is not successful.");
	 
  }
  


}
