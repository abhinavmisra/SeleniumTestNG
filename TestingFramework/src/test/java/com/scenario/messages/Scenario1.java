package com.scenario.messages;

import com.library.function.DriverClass;
import com.library.function.GenericFunction;
import com.objectLocators.part1.Locators1;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Scenario1 {		
	
	    DriverClass refDriver = new DriverClass();
	    GenericFunction Webdriver = new GenericFunction();
		@Test				
		public void testEasy() {
			Webdriver.navigate_to("http://www.orbitz.com");
			Webdriver.waitForElementToExist(Locators1.FlyingFrom);
			Webdriver.waitForElement(Locators1.FlyingFrom).sendKeys("Hyderabad");
		}
		@BeforeTest
		public void beforeTest() {	
			refDriver.setupScenario();
		}		
		@AfterTest
		public void afterTest() {
			refDriver.closeScenario();			
		}		
}	

