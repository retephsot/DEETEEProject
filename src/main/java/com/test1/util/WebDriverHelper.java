package com.test1.util;

import java.awt.Toolkit;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

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
			//original setup for google chrome
			System.setProperty("webdriver.chrome.driver",
					"C:\\seleniumJar\\chromedriver_win32\\chromedriver.exe");
			
			//to enable download using chrome
//			System.setProperty("webdriver.chrome.driver", System.getProperty("C:\\seleniumJar\\chromedriver_win32")
//					+ System.getProperty("file.separator")
//					+ "BrowserDrivers"
//					+ System.getProperty("file.separator")
//					+ "chromedriver.exe");
//			String downloadFilepath = "C:\\testfolder\\SeleniumDownloads";
//
//			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//			chromePrefs.put("profile.default_content_settings.popups", 0);
//			chromePrefs.put("download.default_directory", downloadFilepath);
//			chromePrefs.put("pdfjs.disabled", true);
//
//			//Save Chrome Opions
//			ChromeOptions options = new ChromeOptions();
//			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
//			options.setExperimentalOption("prefs", chromePrefs);
//			options.addArguments("--test-type");
//
//
//			DesiredCapabilities cap = DesiredCapabilities.chrome();
//			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
//			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			cap.setCapability(ChromeOptions.CAPABILITY, options); //to enable download using chrome

			//original chrome setup
			driver = new ChromeDriver();
			
			//driver = new ChromeDriver(cap);
			
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
		
		//Set implicityWait time to 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enlarge the application screen to a custom size
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		int Width = (int) toolkit.getScreenSize().getWidth();
//		int Height = (int)toolkit.getScreenSize().getHeight();
//		driver.manage().window().setSize(new Dimension(1800,1600));
		
		//Set application screen to full screen
		driver.manage().window().maximize();
		
		return driver;

		
	}
	
	public static void quitDriver(WebDriver driver)
	{
		driver.quit();
	}
	
	
}