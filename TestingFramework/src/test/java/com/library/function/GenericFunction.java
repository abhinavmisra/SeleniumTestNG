package com.library.function;

	import java.awt.Rectangle;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.image.BufferedImage;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.text.DateFormat;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
	import java.util.Random;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import org.w3c.dom.*;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.Node;
	import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;
	import org.xml.sax.SAXParseException;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLCollection;
import com.sun.jna.platform.unix.X11.Screen;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

	// TODO: Auto-generated Javadoc
	/**
	 * The Class Steps_Data_Driven.
	 */
	public class GenericFunction {

		// wait techniques

		/** The Constant Result. */
		private static final String Result = null;

		/** The query. */
		public static String query = null;

		/** The query 1. */
		public static String query1 = null;

		/** The connection. */
		public static Connection connection = null;

		/** The Constant CHAR_LIST. */
		private static final String CHAR_LIST = "abcStringghijklmnopqrstuvwxyzABCStringGHIJKLMNOPQRSTUVWXYZ";

		/** The Constant RANDOM_STRING_LENGTH. */
		private static final int RANDOM_STRING_LENGTH = 9;

		/** WorkBook declaration to read data from excel */
		static Workbook objWorkbook = null;

		/** WorkSheet declaration to read data from excel */
		static Sheet objSheet = null;

		static Map<String, String> objNewMap = new HashMap<String, String>();

		/** HashMap to store the data from an excel sheet */
		static Map<String, Map<String, String>> objMap1 = new HashMap<String, Map<String, String>>();

		/**
		 * Wait for element.
		 *
		 * @param by
		 *            the by
		 * @return the web element
		 */
		public WebElement waitForElement(By by) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			return element;
		}

		/**
		 * Wait for element.
		 *
		 * @param by
		 *            the by
		 * @param timeout
		 *            the timeout
		 * @return the web element
		 */
		public WebElement waitForElement(By by, int timeout) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, timeout);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			return element;
		}

		/**
		 * Wait for element staleness of.
		 *
		 * @param elem
		 *            the elem
		 */
		public void waitForElementStalenessOf(WebElement elem) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			wait.until(ExpectedConditions.stalenessOf(elem));
		}

		/**
		 * Wait for text present in element.
		 *
		 * @param by
		 *            the by
		 * @param text
		 *            the text
		 */
		public void waitForTextPresentInElement(By by, String text) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
		}

		/**
		 * Wait for visible element.
		 *
		 * @param by
		 *            the by
		 * @return the web element
		 */
		public WebElement waitForVisibleElement(By by) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			Actions action = new Actions(DriverClass.driver);
			action.moveToElement(waitForElement(by)).perform();
			return element;
		}

		/**
		 * Wait for IN visibility of element.
		 *
		 * @param by
		 *            the by
		 * @return true, if successful
		 */
		public boolean waitForINVisibilityOfElement(By by) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		}

		/**
		 * Wait for IN visibility of element.
		 *
		 * @param by
		 *            the by
		 * @param timout
		 *            the timout
		 * @return true, if successful
		 */
		public boolean waitForINVisibilityOfElement(By by, int timout) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, timout);
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		}

		/**
		 * Wait for element to exist.
		 *
		 * @param by
		 *            the by
		 * @return the web element
		 */
		public WebElement waitForElementToExist(By by) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return element;
		}

		/**
		 * Check for element to exist.
		 *
		 * @param by
		 *            the by
		 * @return the boolean
		 */
		public Boolean checkForElementToExist(By by) {
			return DriverClass.driver.findElements(by).size() != 0;
		}

		/**
		 * Wait for element to be selected.
		 *
		 * @param by
		 *            the by
		 * @return true, if successful
		 */
		public boolean waitForElementToBeSelected(By by) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			return wait.until(ExpectedConditions.elementToBeSelected(by));
		}

		/**
		 * Wait for element to disappear.
		 *
		 * @param by
		 *            the by
		 * @return the list
		 */
		public List<WebElement> waitForElementToDisappear(By by) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			return wait.until(ExpectedConditions.numberOfElementsToBeLessThan(by, 1));

		}

		/**
		 * Wait for element to disappear.
		 *
		 * @param by
		 *            the by
		 * @param timeout
		 *            the timeout
		 * @return the list
		 */
		public List<WebElement> waitForElementToDisappear(By by, int timeout) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, timeout);
			return wait.until(ExpectedConditions.numberOfElementsToBeLessThan(by, 1));

		}

		/**
		 * Wait for number of windows to be.
		 *
		 * @param nrOfWindowsOpened
		 *            the nr of windows opened
		 * @return the boolean
		 */
		public Boolean waitForNumberOfWindowsToBe(int nrOfWindowsOpened) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			return wait.until(ExpectedConditions.numberOfWindowsToBe(nrOfWindowsOpened));
		}

		/**
		 * Wait for page load.
		 */
		public void waitForPageLoad() {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 30);
			wait.until(pageToBeLoaded(DriverClass.driver));
		}

		/**
		 * Wait for url to contain.
		 *
		 * @param textToBeCOntained
		 *            the text to be C ontained
		 */
		public void waitForUrlToContain(String textToBeCOntained) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 30);
			wait.until(ExpectedConditions.urlContains(textToBeCOntained));
		}

		/**
		 * Wait for page title to contain.
		 *
		 * @param textToBeCOntained
		 *            the text to be C ontained
		 */
		public void waitForPageTitleToContain(String textToBeCOntained) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 30);
			wait.until(ExpectedConditions.titleContains(textToBeCOntained));
		}

		/**
		 * Page to be loaded.
		 *
		 * @param drv
		 *            the drv
		 * @return the expected condition
		 */
		public static ExpectedCondition<Boolean> pageToBeLoaded(WebDriver drv) {
			return new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver drv) {
					return ((JavascriptExecutor) drv).executeScript("return document.readyState").equals("complete");
				}
			};
		}

		/**
		 * Wait for user to get added.
		 *
		 * @param temp
		 *            the temp
		 * @param xPath
		 *            the x path
		 * @throws Exception
		 *             the exception
		 */
		public void waitForUserToGetAdded(String temp, By xPath) throws Exception {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 10);
			int j = 1;
			while (true) {
				DriverClass.driver.navigate().refresh();

				try {
					wait.until(ExpectedConditions.alertIsPresent());
					Alert alert = DriverClass.driver.switchTo().alert();
					alert.accept();

				} catch (Exception e) {
					System.out.println(e.toString());
				}
				try {

					Thread.sleep(5000);
					WebElement userWebTableSize = DriverClass.driver.findElement(xPath);
					List<WebElement> rowNum = userWebTableSize.findElements(By.tagName("tr"));

					String strActualName = rowNum.get(0).getText();

					if (!strActualName.equalsIgnoreCase(temp)) {
						System.out.println("rownum value is " + strActualName);
						break;
					} else {
						j++;
						if (j == 30) {
							throw new Exception("User/profile did not get provisioned in time");
						}
					}
				} catch (Exception e) {
					throw new Exception("User/profile did not get provisioned in time");
				}

			}

		}

		// Navigation Steps

		/**
		 * Navigate to.
		 *
		 * @param link
		 *            the link
		 */
		// Step to navigate to specified URL
		public void navigate_to(String link) {
			//DriverClass.setupScenario.write(DriverClass.browserName + " " + DriverClass.browserVersion);
			DriverClass.driver.navigate().to(link);
		}

		/**
		 * Navigate forward.
		 */
		// Step to navigate forward
		public void navigate_forward() {
			DriverClass.driver.navigate().forward();
		}

		/**
		 * Navigate back.
		 */
		// Step to navigate backward
		public void navigate_back() {
			DriverClass.driver.navigate().back();
		}

		/**
		 * Switch to frame.
		 *
		 * @param frameName
		 *            the frame name
		 */
		// Step to switch to a frame by frame name
		public void switch_to_frame(String frameName) {
			DriverClass.driver.switchTo().frame(frameName);
		}

		/**
		 * Switch to frame by locator.
		 *
		 * @param frame
		 *            the frame
		 */
		public void switch_to_frame_by_locator(WebElement frame) {
			DriverClass.driver.switchTo().frame(frame);
		}

		public void waitSeconds(int socondsToWaitFor) throws InterruptedException {
			long start = System.currentTimeMillis();
			long end = start + socondsToWaitFor * 1000; // seconds * 1000 ms/sec
			while (System.currentTimeMillis() < end) {
			}
		}

		/**
		 * Select frame by xpath.
		 *
		 * @param by
		 *            the by
		 */
		public void selectFrameByXpath(By by) {
			WebElement frame = DriverClass.driver.findElement(by);
			waitForElementToExist(by);
			DriverClass.driver.switchTo().frame(frame);
		}

		/**
		 * Switch to Stringault frame.
		 */
		// Step to switch to Stringault frame
		public void switch_to_Stringault_frame() {
			DriverClass.driver.switchTo().defaultContent();
		}

		/**
		 * Switch to new window.
		 *
		 * @return the string
		 */
		// Step to new window
		public String switch_to_new_window() {
			String parentWindow = DriverClass.driver.getWindowHandle();
			waitForNumberOfWindowsToBe(2);
			// Get all the window handles in a set
			Set<String> handles = DriverClass.driver.getWindowHandles();
			for (String winHandle : handles) {
				if (!winHandle.equals(parentWindow)) {
					DriverClass.driver.switchTo().window(winHandle);
					DriverClass.driver.manage().window().maximize();
				}
			}
			return parentWindow;
		}

		/**
		 * Clear I E cache data.
		 *
		 * @throws Exception
		 *             the exception
		 */
		// Clear IE cache , history, cooskies

		public void clear_IE_cacheData() throws Exception {
			excCommand("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
		}

		
		public void close_IE_browser() throws Exception {
			try {
				DriverClass.driver.close();
			} catch (WebDriverException wde) {
				System.err.println(wde.getMessage());
			}
			try {
				DriverClass.driver.quit();
			} catch (WebDriverException wde) {
				System.err.println(wde.getMessage());
			}
			try {
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
				Thread.sleep(3000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		public void start_ChromeDriver_Browser() throws Exception {
			System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver_win32/chromedriver.exe");
			DriverClass.driver = new ChromeDriver();
			DriverClass.driver.manage().window().maximize();
		}

		public void I_wait_number_of_seconds(int seconds) throws Exception {
			Thread.sleep(seconds * 1000);
		}

		/**
		 * Exc process.
		 *
		 * @param commandToExecute
		 *            the command to execute
		 * @throws Exception
		 *             the exception
		 */
		public void excProcess(String commandToExecute) throws Exception {
			try {
				Process rt = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", "/wait", commandToExecute });
				System.out.println("Waiting for process " + commandToExecute);
				rt.waitFor();
				System.out.println("Process :" + commandToExecute + " is DONE.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Exc command.
		 *
		 * @param commandToExecute
		 *            the command to execute
		 * @throws Exception
		 *             the exception
		 */
		public void excCommand(String commandToExecute) throws Exception {
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec(new String[] { "cmd.exe", "/c", commandToExecute });
				System.out.println("Command :" + commandToExecute + " is Executed.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Run command.
		 *
		 * @param BatchFilePath
		 *            the batch file path
		 * @throws InterruptedException
		 *             the interrupted exception
		 */
		public void runCommand(String BatchFilePath) throws InterruptedException {
			String FinalFilePath = System.getProperty("user.home") + "\\Desktop\\" + BatchFilePath;
			try {
				Process p = Runtime.getRuntime().exec("cmd /c start /wait " + FinalFilePath);
				Thread.sleep(10000);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/**
		 * Switch to previous window.
		 *
		 * @param windowToSwitchAt
		 *            the window to switch at
		 */
		public void switch_to_previous_window(String windowToSwitchAt) {
			DriverClass.driver.switchTo().window(windowToSwitchAt);
		}

		/**
		 * Gets the text.
		 *
		 * @param xpath
		 *            the xpath
		 * @return the text
		 */
		// Method to get the text from a label
		public String getText(String xpath) {
			String text = DriverClass.driver.findElement(By.xpath(xpath)).getText();
			return text;
		}

		/**
		 * Refresh page.
		 */
		// steps to refresh page
		public void refresh_page() {
			DriverClass.driver.navigate().refresh();
		}

		/**
		 * Close current window.
		 */
		public void close_current_window() {
			DriverClass.driver.close();
		}

		/**
		 * I wait for text to be dispplayed.
		 *
		 * @param text
		 *            the text
		 * @param tagName
		 *            the tag name
		 */
		// wait for Text steps
		public void i_wait_for_text_toBeDispplayed(String text, String tagName) {
			waitForTextPresentInElement(By.tagName(tagName), text);
		}

		public void i_wait_for_text_to_be_present_on_page(String text) {
			waitForElementToExist(By.xpath(String.format("//*[contains(text(),'" + text + "')]")));
		}

		// Input steps

		/**
		 * Type value into input field having xpath.
		 *
		 * @param text
		 *            the text
		 * @param xpath
		 *            the xpath
		 * @throws Exception
		 *             the exception
		 */
		// enter text into input field steps
		public void typeValueIntoInputFieldHavingXpath(String text, String xpath) throws Exception {
			waitForElement(By.xpath(xpath)).sendKeys(text);
		}

		/**
		 * Click on button having xpath.
		 *
		 * @param xpath
		 *            the xpath
		 * @throws Exception
		 *             the exception
		 */
		public void clickOnButtonHavingXpath(String xpath) throws Exception {
			waitForElement(By.xpath(xpath)).click();
		}

		/**
		 * Select on combo having xpath.
		 *
		 * @param text
		 *            the text
		 * @param xpath
		 *            the xpath
		 * @throws Exception
		 *             the exception
		 */
		public void selectOnComboHavingXpath(String text, String xpath) throws Exception {
			WebElement element = waitForElement(By.xpath(xpath));
			Select selectBox = new Select(element);
			selectBox.selectByVisibleText(text);
		}

		/**
		 * I save screenshot on disk with name.
		 *
		 * @param screenshotName
		 *            the screenshot name
		 * @throws Exception
		 *             the exception
		 */

		/*public void I_save_screenshot_on_Disk_with_name(String screenshotName) throws Exception {
			TakeAScreenshot(DriverClass.setupScenario.getName(), screenshotName, DriverClass.browserName);
		}*/

		/**
		 * Take A screenshot.
		 *
		 * @param testName
		 *            the test name
		 * @param screenshotName
		 *            the screenshot name
		 * @param browserName
		 *            the browser name
		 * @throws IOException
		 *             Signals that an I/O exception has occurred.
		 */
		private void TakeAScreenshot(String testName, String screenshotName, String browserName) throws IOException {
			File scrFile = ((TakesScreenshot) DriverClass.driver).getScreenshotAs(OutputType.FILE);
			testName = testName.replaceAll("[^\\p{L}\\p{Z}]", "");
			File folders = new File(System.getProperty("user.dir").toString() + "\\target\\Screenshots\\" + testName);
			if (!folders.exists()) {
				if (folders.mkdirs()) {
					System.out.println("Multiple Screenshots directories are created!");
				} else {
					System.out.println("Failed to create multiple Screenshots directories!");
				}
			}
			String DestFileName = System.getProperty("user.dir").toString() + "\\target\\Screenshots\\" + testName + "\\"
					+ screenshotName + "_" + browserName + ".png";
			FileUtils.copyFile(scrFile, new File(DestFileName));

		}

		/**
		 * Take A screenshot with taskbar/timestamp.
		 *
		 * @param valueTakeScreenshot
		 *            Yes/No/Enable/Disable
		 * @param ScenarioName
		 *            the scenario name
		 * @throws Exception
		 *             Signals that an I/O exception has occurred.
		 */
		public void TakeAScreenshotWithTime(String valueTakeScreenshot, String ScenarioName) throws Exception {
			if (valueTakeScreenshot.equalsIgnoreCase("Yes") | valueTakeScreenshot.equalsIgnoreCase("Enable")) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmssa");
				Calendar now = Calendar.getInstance();
				Robot robot = new Robot();
				BufferedImage screenShot = robot
						.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				File folders = new File(
						System.getProperty("user.dir").toString() + "\\target\\Screenshots\\" + ScenarioName);
				if (!folders.exists()) {
					if (folders.mkdirs()) {
						System.out.println("Multiple Screenshots directories are created!");
					} else {
						System.out.println("Failed to create multiple Screenshots directories!");
					}
				}
				String DestFileName = System.getProperty("user.dir").toString() + "\\target\\Screenshots\\" + ScenarioName
						+ "\\" + formatter.format(now.getTime()) + "_" + ".jpeg";
				ImageIO.write(screenShot, "JPG", new File(DestFileName));
				System.out.println(formatter.format(now.getTime()));
			}
		}

		/**
		 * Clear The Screenshot Directory.
		 *
		 * @param ScenarioName
		 *            the scenario name
		 * @throws Exception
		 *             Signals that an I/O exception has occurred.
		 */
		public void CleartheDirectory(String ScenarioName) throws Exception {
			File folders = new File(System.getProperty("user.dir").toString() + "\\target\\Screenshots\\" + ScenarioName);
			if (!folders.exists()) {
				if (folders.mkdirs()) {
					System.out.println("Multiple Screenshots directories are created!");
				} else {
					System.out.println("Failed to create multiple Screenshots directories!");
				}
			}
			FileUtils.cleanDirectory(folders);
		}

		/**
		 * Select by label.
		 *
		 * @param dataText
		 *            the data text
		 * @param by
		 *            the by
		 */
		public void selectByLabel(String dataText, By by) {
			WebElement elem = waitForElement(by);
			Select selElement = new Select(elem);
			selElement.selectByVisibleText(dataText);
		}

		/**
		 * Select by index.
		 *
		 * @param index
		 *            the index
		 * @param by
		 *            the by
		 */
		public void selectByIndex(int index, By by) {
			WebElement elem = waitForElement(by);
			Select selElement = new Select(elem);
			selElement.selectByIndex(index);
		}

		/**
		 * De-select all selected.
		 *
		 * @param by
		 *            the by
		 */
		public void deselectAll(By by) {
			WebElement elem = waitForElement(by);
			Select selElement = new Select(elem);
			selElement.deselectAll();
		}

		/**
		 * Double click.
		 *
		 * @param by
		 *            the by
		 */
		// mouse / keyboard actions
		public void doubleClick(By by) {
			Actions action = new Actions(DriverClass.driver);
			action.doubleClick(waitForElement(by)).perform();
		}

		public void doubleClickAction(By by) {
			Actions action = new Actions(DriverClass.driver);
			action.moveToElement(waitForElement(by)).doubleClick().build().perform();
		}

		/**
		 * Mouse hover.
		 *
		 * @param by
		 *            the by
		 */
		public void mouseHover(By by) {
			Actions action = new Actions(DriverClass.driver);
			action.moveToElement(waitForElement(by)).perform();
		}

		/**
		 * Right click.
		 *
		 * @param by
		 *            the by
		 */
		public void RightClick(By by) {
			WebElement label = waitForElement(by);
			Actions clicker = new Actions(DriverClass.driver);
			clicker.contextClick(label).perform();
		}

		/**
		 * Alert accept.
		 */
		public void AlertAccept() {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = DriverClass.driver.switchTo().alert();
				alert.accept();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		/**
		 * Alert accept.
		 *
		 * @param textToCheck
		 *            the text to check
		 */
		public void AlertAcceptHasText(String textToCheck) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = DriverClass.driver.switchTo().alert();
				Assert.assertTrue(alert.getText().contains(textToCheck));
				alert.accept();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		/**
		 * Alert dismiss.
		 */
		public void AlertDismiss() {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = DriverClass.driver.switchTo().alert();
				alert.dismiss();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		/**
		 * Alert dismiss.
		 *
		 * @param textToCheck
		 *            the text to check
		 */
		public void AlertDismissHasText(String textToCheck) {
			WebDriverWait wait = new WebDriverWait(DriverClass.driver, 20);
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = DriverClass.driver.switchTo().alert();
				Assert.assertTrue(alert.getText().contains(textToCheck));
				alert.dismiss();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		/**
		 * Execute javascript scrool into view.
		 *
		 * @param by
		 *            the by
		 */
		// javascript executor
		public void executeJavascriptScroolIntoView(By by) {
			WebElement element = waitForVisibleElement(by);
			((JavascriptExecutor) DriverClass.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}

		/**
		 * Execute javascript to click on element.
		 *
		 * @param element
		 *            the element
		 */
		public void executeJavascriptToClickOnElement(WebElement element) {
			((JavascriptExecutor) DriverClass.driver).executeScript("arguments[0].click();", element);
		}

		/**
		 * Execute javascript to sent keys to element.
		 *
		 * @param element
		 *            the element
		 * @param longstring
		 *            the longstring
		 */
		public void executeJavascriptToSentKeysToElement(WebElement element, String longstring) {
			((JavascriptExecutor) DriverClass.driver)
					.executeScript("arguments[0].setAttribute('value', '" + longstring + "');", element, longstring);
		}

		/**
		 * Execute javascript to un hide element.
		 *
		 * @param element
		 *            the element
		 */
		public void executeJavascriptToUnHideElement(WebElement element) {
			((JavascriptExecutor) DriverClass.driver).executeScript("arguments[0].setAttribute('type', 'text');",
					element);
		}

/*		*//**
		 * Sikuli click on image.
		 *
		 * @param imagePath
		 *            , receives 2 images for running on Multiple Machines
		 * @param imagePath2
		 *            , if first image doesn't match the second image is clicked,
		 *//*
		public void sikuliClickOnImage(String imagePath, String imagePath2) {
			Screen s = new Screen();
			try {
				s.wait(imagePath2, 20);
				s.click(imagePath2, 0);
			} catch (FindFailed e) {
				e.printStackTrace();
				try {
					s.wait(imagePath, 10);
					s.click(imagePath, 0);
				} catch (FindFailed e1) {
					e1.printStackTrace();
					try {
						// here you can set the Image Matching Accuracy
						Pattern pattern = new Pattern(imagePath2).similar(0.8f);
						s.wait(imagePath, 10);
						s.click(pattern);
					} catch (FindFailed e2) {
						e2.printStackTrace();
					}
				}
			}
		}

		*//**
		 * Sikuli click action.
		 *
		 * @param arg
		 *            the arg
		 * @param strings
		 *            the strings
		 *//*
		public void sikuliClickAction(String arg, String... strings) {

			for (String imagePath : strings) {
				Screen s = new Screen();
				try {
					s.wait(imagePath, 20);
					s.click(imagePath, 0);
					break;
				} catch (FindFailed e) {
					e.printStackTrace();
					try {
						Pattern pattern = new Pattern(imagePath).similar(0.8f);
						s.wait(imagePath, 10);
						s.click(pattern);
						break;
					} catch (FindFailed e2) {
						e2.printStackTrace();
					}
				}
			}

		}*/

		// Database Connection method for MSSQL Server and to execute the query
		public static void getDBConnection(String dbURL, String username, String password, String passedQuery) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(dbURL, username, password);
				System.out.println("Database is connected..");
				Statement sta = connection.createStatement();
				query = passedQuery + " '%" + "" + "%'";
				System.out.println("The query to be executed is " + query);
				ResultSet output = sta.executeQuery(query);
				while (output.next()) {
					System.out.println("Updated fist name in FBA is " + output.getNString("FirstName"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					System.out.println("Connection is closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		/**
		 * Verify text.
		 *
		 * @param text
		 *            the text
		 * @return the boolean
		 * @throws Exception
		 *             the exception
		 */
		public Boolean VerifyText(String text) throws Exception {
			Boolean res = DriverClass.driver.getPageSource().contains(text);
			if (res.equals(true)) {
				System.out.println("The text " + text + " is present on the page");
				return true;
			} else {
				/*
				 * System.out.println("The text " + text +
				 * " is not present on the page"); return false;
				 */
				throw new Exception(text + " text doesn't exist on the page");
			}

		}

		/**
		 * Verify text not present.
		 *
		 * @param text
		 *            the text
		 * @return the boolean
		 * @throws Exception
		 *             the exception
		 */
		public Boolean VerifyTextNotPresent(String text) throws Exception {
			Boolean textNotPresent = DriverClass.driver.getPageSource().contains(text);
			if (textNotPresent.equals(false)) {
				System.out.println("The text " + text + " is not present on the page");
				return true;
			} else {
				throw new Exception(text + " Text exist on the page");
			}
		}

		/**
		 * Checks if is text present.
		 *
		 * @param text
		 *            the text
		 * @return the boolean
		 */
		public Boolean IsTextPresent(String text) {
			Boolean textPresent = DriverClass.driver.getPageSource().contains(text);
			if (textPresent.equals(true)) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * Select a checkbox.
		 *
		 * @param by
		 *            the Locator
		 * 
		 */
		public void check(By by) {
			boolean state = waitForElement(by).isSelected();
			System.out.println("Value of State is " + state);
			if (state == false) {
				waitForElement(by).click();
			}
		}

		/**
		 * Verify an element is selected.
		 *
		 * @param by
		 *            the Locator
		 * @return true, if is selected
		 * @throws Exception
		 *             the exception
		 */
		public boolean isSelected(By by) throws Exception {
			boolean state = waitForElementToExist(by).isSelected();
			if (state == true) {
				System.out.println("The element is selected");
				return true;
			} else {
				return false;
			}
		}

		/**
		 * De-select a checkbox.
		 *
		 * @param by
		 *            the Locator
		 * 
		 */
		public void Uncheck(By by) {
			boolean state = waitForElement(by).isSelected();
			if (state == true) {
				waitForElement(by).click();
			}
		}

		/**
		 * Generate random string.
		 *
		 * @return the string
		 */
		// This method is to randomly generate a name
		public String generateRandomString() {

			StringBuffer randStr = new StringBuffer();
			for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
				int number = getRandomNumber();
				char ch = CHAR_LIST.charAt(number);
				randStr.append(ch);
			}
			return randStr.toString();
		}

		/**
		 * This method generates random numbers.
		 *
		 * @return int
		 */
		private int getRandomNumber() {
			int randomInt = 0;
			Random randomGenerator = new Random();
			randomInt = randomGenerator.nextInt(CHAR_LIST.length());
			if (randomInt - 1 == -1) {
				return randomInt;
			} else {
				return randomInt - 1;
			}
		}

		// This method is to append time stamp to a string and return the value

		/**
		 * Generate string timestamp.
		 *
		 * @param name
		 *            the name
		 * @return the string
		 */
		public static String generate_string_timestamp(String name) {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("ddHHmmss");
			String newDate = dateFormat.format(date);
			String generatedString = name + newDate;
			return generatedString;
		}

		/**
		 * Study start date.
		 *
		 * @return the string
		 */
		public String StudyStartDate() {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
			String currentDate = dateFormat.format(date);
			return currentDate;
		}

		/**
		 * Substract days from date in string format. This method is Striclty
		 * Depending on the DateFormat
		 *
		 * @param startDateString
		 *            the start date string
		 * @param daysToSubstract
		 *            the days to substract
		 * @param pattern
		 *            the pattern
		 * @return the string
		 */
		public String substractDaysFromDateInStringFormat(String startDateString, int daysToSubstract, String pattern) {
			Date startDate = new Date();
			String newDateString = null;
			DateFormat df = new SimpleDateFormat(pattern);
			try {
				startDate = df.parse(startDateString);
				Calendar cal = Calendar.getInstance();
				cal.setTime(startDate);
				cal.add(Calendar.DATE, daysToSubstract);
				newDateString = df.format(cal.getTime());
				System.out.println(newDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return newDateString;
		}

		/**
		 * Delete file.
		 *
		 * @param path
		 *            the path
		 */
		// This method is to delete the file from the folder
		public void deleteFile(String path) {

			File file = new File(path);
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isFile() && f.exists()) {
					f.delete();
					System.out.println("successfully deleted");
				} else {
					System.out.println("cant delete a file due to open or is a directory or due to an error");
				}
			}
		}

		/**
		 * Checks if is element present.
		 *
		 * @param by
		 *            the by
		 * @return true, if is element present
		 */
		public boolean isElementPresent(By by) {
			try {
				waitForElementToExist(by);
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		/**
		 * Verify if element is present.
		 *
		 * @param by
		 *            the by
		 * @throws Exception
		 *             the exception
		 */
		public void verifyElementPresent(By by) throws Exception {
			try {
				if (waitForElement(by, 10) != null) {
					System.out.println("Element " + by + " present on the page");
				}
			} catch (Exception e) {
				throw new Exception("Element " + by + " doesn't exist on the page");
			}
		}

		/**
		 * Verify if element is not present.
		 *
		 * @param by
		 *            the by
		 * @throws Exception
		 *             the exception
		 */
		public void verifyElementNotPresent(By by) throws Exception {
			try {
				if (waitForElement(by) != null) {
					throw new Exception("Element " + by + " doesn't exist on the page");
				}
			} catch (Exception e) {
				System.out.println("Element " + by + " is not present on the page");
			}
		}

		/**
		 * Verify state of element.
		 *
		 * @param by
		 *            the by
		 * @param state
		 *            the state
		 * @return true, if successful
		 * @throws Exception
		 *             the exception
		 */
		public boolean verifyStateOfElement(By by, String state) throws Exception {
			if (state.equalsIgnoreCase("Enabled")) {
				boolean res = DriverClass.driver.findElement(by).isEnabled();
				if (res == true) {
					return true;
				} else {
					throw new Exception("Element is not enabled");
				}
			} else if (state.equalsIgnoreCase("Disabled")) {
				boolean res = DriverClass.driver.findElement(by).isEnabled();
				if (res == false) {
					return true;
				} else {
					throw new Exception("Element is not disabled");
				}
			}
			return false;
		}

		/**
		 * Upload file.
		 *
		 * @param by
		 *            the by
		 * @param fileLocation
		 *            the file location
		 */
		public void UploadFile(By by, String fileLocation) {
			// String filePath = System.getProperty("user.dir").toString() +
			// "\\Upload\\sample PDF1.pdf";
			String filePath = System.getProperty("user.dir").toString() + fileLocation;
			DriverClass.driver.findElement(by).sendKeys(filePath);
		}

		/**
		 * Drag and Drop.
		 *
		 * @param fromElement
		 *            the from element
		 * @param toElement
		 *            the to element
		 */

		public void DragAndDrop(By fromElement, By toElement) {
			WebElement source = waitForElement(fromElement);
			WebElement target = waitForElement(toElement);
			Actions builder = new Actions(DriverClass.driver);
			Action dragAndDrop = builder.clickAndHold(source).moveToElement(waitForElement(toElement))
					.release(waitForElement(toElement)).build();
			dragAndDrop.perform();
		}

		// Split the text

		/**
		 * Gets the password new.
		 *
		 * @param MailText
		 *            the mail text
		 * @return the password new
		 */
		public String getPasswordNew(String MailText) {
			final String[] splitStringArray = MailText.split("\\- Your temporary password is ");
			String a = splitStringArray[0];
			String b = splitStringArray[1];

			final String[] splitStringArray1 = b.split("Thank you");
			String c = splitStringArray1[0];
			String d = splitStringArray1[1];
			c = c.trim();
			return c;
		}

		/**
		 * Gets the username new.
		 *
		 * @param MailText
		 *            the mail text
		 * 
		 * @param URL
		 *            the URL text
		 * 
		 * @return the username new
		 */

		public String getUserName(String MailText, String URL) {
			final String[] splitStringArray = MailText.split("To login to the Portal, please go to " + URL + ".");
			String a = splitStringArray[0];
			String b = splitStringArray[1];

			final String[] splitStringArray1 = b.split("- Your password will be sent in a separate notification.");
			String c = splitStringArray1[0];
			String d = splitStringArray1[1];
			c = c.trim();
			return c;
		}

		/**
		 * Gets the epoch time new.
		 *
		 * @return the epoch time to search in gmail
		 * @throws ParseException
		 *             the parse exception
		 */

		public String generateEpochTime() throws ParseException {
			DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm zzz");
			Calendar cal = Calendar.getInstance();
			String yearMonthString = dateFormat.format(cal.getTime());
			String str = yearMonthString;
			SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy HH:mm zzz");
			Date date = df.parse(str);
			long epoch = (date.getTime()) / 1000;
			String finalEpoch = Objects.toString(epoch, null);
			return finalEpoch;
		}

		/**
		 * Read the data from an excel sheet.
		 *
		 * @param strDataSheetPath
		 *            the path of document in system
		 * 
		 * @param strSheetName
		 *            the sheet name of the excel
		 * @return the key pair value
		 */

		public static Map<String, Map<String, String>> readTestData(String strDataSheetPath, String strSheetName) {
			try {
				String filePath = System.getProperty("user.dir").toString() + strDataSheetPath;
				System.out.println("The filepath is " + filePath);
				File objpath = new File(filePath);
				FileInputStream fis = new FileInputStream(objpath);
				String strFilePath = objpath.toString();

				if (strFilePath.toLowerCase().endsWith(".xlsx")) {
					objWorkbook = new XSSFWorkbook(fis);
				} else if (strFilePath.toLowerCase().endsWith(".xls")) {
					objWorkbook = new HSSFWorkbook(fis);
				}

				objSheet = objWorkbook.getSheet(strSheetName);

				int intRowCount = objSheet.getLastRowNum();

				System.out.println("RowCount is " + intRowCount);

				Row objFirstRow = objSheet.getRow(0);

				int intColCount = objFirstRow.getLastCellNum();

				for (int intRowCounter = 1; intRowCounter <= intRowCount; intRowCounter++) {
					Row objRow = objSheet.getRow(intRowCounter);
					Map<String, String> objMap = new HashMap<String, String>();
					for (int intColCounter = 1; intColCounter <= intColCount; intColCounter++) {
						Cell objCellColName = objFirstRow.getCell(intColCounter - 1);

						String strKey = gFunc_ReadCellValue(objCellColName);

						Cell objCellColValue = objRow.getCell(intColCounter - 1);

						String strValue = gFunc_ReadCellValue(objCellColValue);

						if (strValue != null && strValue.length() != 0) {
							objMap.put(strKey, strValue);
						}
					}
					objMap1.put("Row" + intRowCounter, objMap);
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return objMap1;
		}

		public static String gFunc_ReadCellValue(Cell cell) {
			String strResult = "";
			try {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BLANK:
					strResult = "";
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					strResult = String.valueOf(cell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_ERROR:
					strResult = String.valueOf(cell.getErrorCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					strResult = String.valueOf(cell.getNumericCellValue());
					if (strResult.endsWith(".0")) {
						strResult = strResult.replace(".0", "");
					}
					break;
				case Cell.CELL_TYPE_STRING:
					strResult = cell.getStringCellValue();
					break;
				default:
					strResult = "";
				}
			} catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("The cell is blank");
			}
			return strResult;
		}

		/**
		 * Verify that the strings are in sorted order (Ascending/Descending)
		 * 
		 * @param sortOrder
		 *            The sorting order as "ASC" for ascending order and "DESC" for
		 *            descending order
		 * 
		 * @param text1
		 *            The first text or string
		 * 
		 * @param text2
		 *            The second text or string
		 * 
		 * @param text3
		 *            The third text or string
		 * 
		 * @return the boolean value as true or false
		 */

		public boolean verifySorting(String sortOrder, String text1, String text2, String text3) throws Exception {
			String[] listActual = { text1, text2, text3 };
			int size = listActual.length;
			String[] listExpected = new String[3];
			for (int i = 0; i < size; i++) {
				listExpected[i] = listActual[i];
			}
			if (sortOrder.equalsIgnoreCase("DESC") || sortOrder.equalsIgnoreCase("DESCENDING")) {
				Arrays.sort(listExpected, Collections.reverseOrder());
			} else if (sortOrder.equalsIgnoreCase("ASC") || sortOrder.equalsIgnoreCase("ASCENDING")) {
				Arrays.sort(listExpected);
			} else {
				throw new Exception("Please specify a valid Expected Sort Order");
			}
			System.out.println("Expected " + sortOrder + " order of Values =  " + listExpected[0] + ", " + listExpected[1]
					+ ", " + listExpected[2]);
			boolean flag = Arrays.equals(listActual, listExpected);
			System.out.println("The Result of Actual Sort vs Expected " + sortOrder + " Sort ===================  " + flag);
			return flag;
		}
		
	// This method is to read an xml file and return the correlation id
		 
		public static String xmlToExcel(String filepath, String nodelist) throws ParserConfigurationException, SAXException, IOException{
		  
			File inputFile = new File(filepath);
			DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder(); 
			Document doc = (Document) dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			String rootElement =  doc.getDocumentElement().getNodeName(); 
			NodeList nList = doc.getElementsByTagName(nodelist); 
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = (Node) nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) { 
					Element eElement = (Element) nNode; 
					String corrID = ((Node) eElement .getElementsByTagName("CorrelationId").item(0)) .getTextContent();
					return corrID;
		  }
		  
			}
			return null;
		}
		  
		  
		  
		  // This method is to generate an xml file and run the 
		public static void generatexmlFile(String xmlfilename, String rootnodeElement, String Lname, String Fname, String UsrStatus,
		  String SysRoles, String mailID, String domain, String country, String xmlFilePath) throws TransformerException, ParserConfigurationException{
		  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
		  Document doc = dBuilder.newDocument();
		  
		  // root element
		  Element rootElement = doc.createElement(rootnodeElement);
		  doc.appendChild(rootElement);
		  
		  // Institution element as xml attribute 
		  Element Institution = doc.createElement("Institution");
		  Institution.appendChild(doc.createTextNode("AGSInst"));
		  rootElement.appendChild(Institution);
		  
		  // Last Name element as xml attribute 
		  Element LastName = doc.createElement("LastName");
		  LastName.appendChild(doc.createTextNode(Lname));
		  rootElement.appendChild(LastName);
		  
		  // First Name element as xml attribute 
		  Element FirstName = doc.createElement("FirstName");
		  FirstName.appendChild(doc.createTextNode(Fname));
		  rootElement.appendChild(FirstName);
		  
		  // User Status element as xml attribute 
		  Element UserStatus = doc.createElement("UserStatus");
		  UserStatus.appendChild(doc.createTextNode(UsrStatus));
		  rootElement.appendChild(UserStatus);
		  
		  //System Role element as xml attribute 
		  Element SystemRole = doc.createElement("SystemRoles");
		  SystemRole.appendChild(doc.createTextNode(SysRoles));
		  rootElement.appendChild(SystemRole);
		  
		  //Email element as xml attribute 
		  Element Email = doc.createElement("Email");
		  Email.appendChild(doc.createTextNode(mailID+"+"+Lname+"."+Fname+"@"+domain)); 
		  rootElement.appendChild(Email);
		  
		  //Country element as xml attribute 
		  Element Country = doc.createElement("Country");
		  Country.appendChild(doc.createTextNode(country));
		  rootElement.appendChild(Country);
		  
		  // write the content into xml file 
		  TransformerFactory transformerFactory = TransformerFactory.newInstance(); 
		  Transformer transformer =  transformerFactory.newTransformer(); 
		  DOMSource source = new DOMSource(doc); 
		  StreamResult result = new StreamResult(new File(xmlFilePath+"\\"+xmlfilename+".txt")); 
		  transformer.transform(source, result); 
		  }
}
