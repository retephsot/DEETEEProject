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
import org.openqa.selenium.firefox.FirefoxProfile;
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
					
			//To change download option and save to different path
			
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			
			String downloadPath = "C:\\testfolder\\SeleniumDownloads";
			
			firefoxProfile.setPreference("browser.download.folderList", 2);
			firefoxProfile.setPreference("browser.download.dir", downloadPath);
			firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
			firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
			firefoxProfile.setPreference("browser.download.manager.focusWhenStarting", false);  
			firefoxProfile.setPreference("browser.download.useDownloadDir", true);
			firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			firefoxProfile.setPreference("browser.download.manager.closeWhenDone", true);
			firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
			firefoxProfile.setPreference("browser.download.manager.useWindow", false);
			firefoxProfile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			firefoxProfile.setPreference("pdfjs.disabled", true);

			driver = new FirefoxDriver(firefoxProfile);
			
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			//original setup for google chrome
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\seleniumJar\\chromedriver_win32\\chromedriver.exe");
			
			//to change download option and save to a different path
			System.setProperty("webdriver.chrome.driver",
		"C:\\seleniumJar\\chromedriver_win32\\chromedriver.exe");
		
			String downloadFilepath = "C:\\testfolder\\SeleniumDownloads";

			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			chromePrefs.put("pdfjs.disabled", true);

			//Save Chrome Options
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");


			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options); //to change chrome options

			//original chrome setup
			//driver = new ChromeDriver();
			
			driver = new ChromeDriver(cap);
			
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
