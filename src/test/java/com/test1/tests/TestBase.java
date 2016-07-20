package com.test1.tests;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
//import com.test1.pages.DefaultLandingPage;
//input the correct "entry point class" below in this case "DefaultLandingPage"
import com.test1.pages.LogInPage;
import com.test1.util.DataDrivenHelper;
import com.test1.util.SendMail;
import com.test1.util.WebDriverHelper;

public class TestBase 
{
	
	
	protected WebDriver driver;
	//need to make the entry point a member variable below like this... enter the correct entry point below
	protected LogInPage loginpage;
	//need to make Properties testConfig member variable below like this
	protected Properties testConfig;
	public String baseUrl;
	
	
	
	
	@BeforeSuite()
	public void beforSuite() throws FileNotFoundException, IOException
	{
		testConfig = new Properties();
		testConfig.load(new FileInputStream("TestConfig.properties"));
	}
	
	@BeforeMethod
	  public void beforeMethod() 
	  {
		//the below 4 lines were copied from the JavaProperties file - need to make Properties testConfig Member variable
		//Properties testConfig = new Properties();
		//testConfig.load(new FileInputStream("TestConfig.properties"));
		
		//System.out.println(testConfig.getProperty("browser"));
		
		//System.out.println(testConfig.getProperty("baseUrl"));
		
		//the below 3 are handled by the WebDriverHelper
		
//		//To launch on google Chrome
//		System.setProperty("webdriver.chrome.driver",
//		"C:\\seleniumJar\\chromedriver_win32\\chromedriver.exe");
		
		//	change the below since we are getting web choice from WebDriverHelper		
		//driver = new ChromeDriver();  //testConfig.getProperty("browser")
		
		driver = WebDriverHelper.createDriver(testConfig.getProperty("browser"));  
		
		// the below baseUrl value is coming from the Java PropertiesFile
		baseUrl = testConfig.getProperty("baseUrl");

		
		driver.get(baseUrl);
		
		//adding the entry point for all test LogInPage logInPage = new LogInPage(driver) so this can be inherited
		//1 LogInPage logInPage = new LogInPage(driver);
		//2 now LogInPage can be removed below because this has been added as protected above
		//enter the correct entry point name below
		loginpage = new LogInPage(driver);
				
	  }
	
	 @DataProvider()
	  public Object[][] dataProvider(Method method)
	  {

		 DataDrivenHelper ddh = new DataDrivenHelper(testConfig.getProperty("mastertestdatafile"));
			
		Object[][] testData = ddh.getTestCaseDataSets(testConfig.getProperty("testdatasheet"), method.getName());
		
		return testData;
		
	  }
	 
	 
	
	 @AfterMethod
	  public void afterMethod() throws InterruptedException 
	  {
		 //since we are inheriting from WebDriverHelper to close or tear down we need the below
		 WebDriverHelper.quitDriver(driver);
		 
		 Thread.sleep(2000);

		 
	  }
	 
	 @AfterSuite
	 public void afterSuite() throws Exception
	 {
		 
		//Send emailable report email after test suite has been ran
		SendMail.execute("emailable-report.html");
	 }
	 
	
}
