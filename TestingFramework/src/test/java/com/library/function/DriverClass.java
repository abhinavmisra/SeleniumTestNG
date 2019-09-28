package com.library.function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;


public class DriverClass {
	public static WebDriver driver;
	public static String browserName;
	public static String browserVersion;
	public static String screenshots;

	
	public void setupScenario(){
		String paramBrowser = System.getProperty("browser");
		if(paramBrowser.equalsIgnoreCase("firefox")){
		// starting new clean Firefox
		File file = new File("D:\\selenium driver\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());		
		driver = new FirefoxDriver();
		}
		else if(paramBrowser.equalsIgnoreCase("chrome")) {
			String exePath = "D:\\selenium driver\\chromedriver_win32\\chromedriver.exe";
			 System.setProperty("webdriver.chrome.driver", exePath);
			 driver = new ChromeDriver();
		}
		driver.manage().window().maximize(); 
}
	public void closeScenario(){
		driver.quit();
	}
}