package com.library.function;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverClass {
	public static WebDriver driver;
	public static String browserName;
	public static String browserVersion;
	public static String screenshots;

	
	public void setupScenario(){
		String paramBrowser = System.getProperty("browser");
		if(paramBrowser.equalsIgnoreCase("InternetExplorer")){
		File file = new File("C:/Program Files/IEDriverServer_Win32_3.0.0/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		// setting a clean session with clean cache
		caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		browserName = caps.getBrowserName().toString();
		browserVersion = caps.getVersion().toString();
		// starting new clean IE
		driver = new InternetExplorerDriver(caps);
		}else if(paramBrowser.equalsIgnoreCase("firefox")){
		// starting new clean Firefox
		File file = new File("C:/Program Files/geckodriver-v0.11.1-win64/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());		
		driver = new FirefoxDriver();
		}
		driver.manage().window().maximize(); 
}
	public void closeScenario(){
		driver.quit();
	}
}