package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import utils.PageActions
import internal.GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.safari.SafariDriver
import com.kms.katalon.core.util.KeywordUtil

public class OpenBrowsers {

	/**
	 * Opens the specified browser.
	 * @param browserName The browser name (chrome, firefox, edge, safari, etc.)
	 */
	@Keyword
	def openBrowser(String browserType) {
		WebDriver driver = null
		try {
			// Set up WebDriver paths based on the browser choice
			if (browserType == "Chrome") {
				System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe")
				driver = new ChromeDriver()
				KeywordUtil.logInfo("Chrome browser opened successfully.")
			} else if (browserType == "Edge") {
				System.setProperty("webdriver.edge.driver", "C:/path/to/msedgedriver.exe")
				driver = new EdgeDriver()
				KeywordUtil.logInfo("Edge browser opened successfully.")
			} else if (browserType == "Safari") {
				// SafariDriver does not require setting system property if the driver is installed
				driver = new SafariDriver()
				KeywordUtil.logInfo("Safari browser opened successfully.")
			} else if (browserType == "Firefox") {
				System.setProperty("webdriver.gecko.driver", "C:/path/to/geckodriver.exe")
				driver = new FirefoxDriver()
				KeywordUtil.logInfo("Firefox browser opened successfully.")
			} else {
				KeywordUtil.markFailed("Unsupported browser: " + browserType)
				return null
			}

			// Open a sample URL to confirm the browser opens
			driver.get("http://192.168.151.33:3000/login")

			// Return the driver for further use if necessary
			return driver
		} catch (Exception e) {
			KeywordUtil.markFailed("Failed to open browser: " + e.message)
			return null
		}
	}
}
