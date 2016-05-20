package com.test1.util;

import java.awt.Toolkit;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverHelper 
{
	public static WebDriver createDriver(String browser)
	{
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\seleniumJar\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",
					"C:\\seleniumJar\\IEDriverServer_Win32_2.52.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			throw new InvalidParameterException(browser + "- is not a valid web browser for web driver.");
		}
		
		//Set implicityWait time to 40 seconds
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Enlarge the application screen
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int Width = (int) toolkit.getScreenSize().getWidth();
		int Height = (int)toolkit.getScreenSize().getHeight();
		driver.manage().window().setSize(new Dimension(1800,1600));
		
		return driver;
		
		//add any new driver methods here
		
	}
	
	public static void quitDriver(WebDriver driver)
	{
		driver.quit();
	}
	
	
}
