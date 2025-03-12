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
import static org.junit.Assert.assertEquals
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

public class PageActions {
	/**
	 * Click on an element on the page
	 * @param testObject - TestObject of the element to click
	 */
	@Keyword
	static void click(TestObject testObject) {
		if (WebUI.verifyElementPresent(testObject, 10, FailureHandling.OPTIONAL)) {
			WebUI.waitForElementClickable(testObject, 10)
			WebUI.click(testObject)
			KeywordUtil.logInfo("Clicked on element: " + testObject.getObjectId())
		} else {
			KeywordUtil.markWarning("Element not found: " + testObject.getObjectId())
		}
	}

	/**
	 * Enter text into an input field
	 * @param testObject - TestObject of the input field
	 * @param text - Text to enter
	 */
	@Keyword
	static void setText(TestObject testObject, String text) {
		WebUI.waitForElementVisible(testObject, 10)
		WebUI.setText(testObject, text)
	}

	/**
	 * Retrieve text from an element
	 * @param testObject - TestObject of the element
	 * @return String - Retrieved text
	 */
	@Keyword
	static String getText(TestObject testObject) {
		WebUI.waitForElementVisible(testObject, 10)
		return WebUI.getText(testObject)
	}


	/**
	 * Clear text from an input field
	 * @param testObject - TestObject of the input field
	 */
	@Keyword
	static void clearText(TestObject testObject) {
		WebUI.waitForElementVisible(testObject, 10)
		WebUI.clearText(testObject)
	}

	/**
	 * Check if an element is visible on the page
	 * @param testObject - TestObject of the element
	 * @return boolean - true if the element is visible, false otherwise
	 */
	@Keyword
	static boolean isElementVisible(TestObject testObject) {
		return WebUI.waitForElementVisible(testObject, 10)
	}

	/**
	 * Retrieve the value of an attribute from an element
	 * @param testObject - TestObject of the element
	 * @param attributeName - Name of the attribute to retrieve
	 * @return String - Value of the attribute
	 */
	@Keyword
	static String getAttributeValue(TestObject testObject, String attributeName) {
		WebUI.waitForElementVisible(testObject, 10)
		return WebUI.getAttribute(testObject, attributeName)
	}


	/**
	 * Send keyboard keys to an element
	 * @param testObject - TestObject of the element
	 * @param keys - Keys to send
	 */
	@Keyword
	static void sendKeys(TestObject testObject, String keys) {
		WebUI.waitForElementVisible(testObject, 10)
		WebUI.sendKeys(testObject, keys)
	}


	/**
	 * Verify if the expected result matches the actual result
	 * @param actual - Actual value
	 * @param expected - Expected value
	 */
	@Keyword
	static void verifyExpectedResult(String actual, String expected) {
		if (actual != expected) {
			KeywordUtil.markFailed("❌ Verification failed: Expected = '${expected}', but got = '${actual}'")
		} else {
			KeywordUtil.logInfo("✅ Verification passed: Expected = '${expected}', Actual = '${actual}'")
		}
		//assertEquals("Expected result does not match actual result", expected, actual)
	}


	/**
	 * Navigate to URL
	 * @param url - link URL to navigate
	 */
	@Keyword
	static void NavigateURL(String url) {
		try {
			WebUI.openBrowser('')
			WebUI.navigateToUrl(url)
			KeywordUtil.logInfo("✅ Successfully opened browser and navigated to: ${url}")
		} catch (Exception e) {
			KeywordUtil.markFailed("❌ Failed to open browser: " + e.getMessage())
		}
	}

	/**
	 *  Click Using JS
	 * @param testObject - testObject need to click
	 */
	@Keyword
	static void clickUsingJS(TestObject testObject) {
		try {
			WebElement element = WebUI.findWebElement(testObject)
			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
			js.executeScript("arguments[0].click();", element)
			KeywordUtil.logInfo("✅ Successfully clicked using JavaScript on: ${testObject.getObjectId()}")
		} catch (Exception e) {
			KeywordUtil.markWarning("⚠️ Failed to click using JavaScript: " + e.getMessage())
		}
	}
}


