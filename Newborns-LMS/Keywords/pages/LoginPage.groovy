package pages

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
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable as App
import utils.PageActions
import utils.Support

public class LoginPage {
	/**
	 * Verify the Login page is displayed
	 */
	@Keyword
	static void verifyLoginPageHeaderIsCorrect(String expectedHeader) {
		try {
			String actualHeader = PageActions.getText(findTestObject('Object Repository/LoginPage/txtLogin'))
			PageActions.verifyExpectedResult(actualHeader, expectedHeader)
		} catch (Exception e) {
			KeywordUtil.markWarning("Page header verification failed: " + e.getMessage())
		}
	}


	/**
	 * Verify the Email label is displayed
	 */
	@Keyword
	static void verifyEmailLablelIsCorrect(String expectedLabel) {
		try {
			String actualHeader = PageActions.getText(findTestObject('Object Repository/LoginPage/lblEmail'))
			PageActions.verifyExpectedResult(actualHeader, expectedLabel)
		} catch (Exception e) {
			KeywordUtil.markWarning("Page header verification failed: " + e.getMessage())
		}
	}


	/**
	 * Verify the Password label is displayed
	 */
	@Keyword
	static void verifyPasswordlLablelIsCorrect(String expectedLabel) {
		try {
			String actualHeader = PageActions.getText(findTestObject('Object Repository/LoginPage/lblPassword'))
			PageActions.verifyExpectedResult(actualHeader, expectedLabel)
		} catch (Exception e) {
			KeywordUtil.markWarning("Page header verification failed: " + e.getMessage())
		}
	}


	/**
	 * Input the Password to Login Page
	 */
	@Keyword
	static void inputValidPassword() {
		String password=Support.decrypt(App.Password,App.KeyPassword)
		PageActions.setText(findTestObject('Object Repository/LoginPage/txtPassword'), password)
	}


	/**
	 * Input the Email to Login Page
	 */
	@Keyword
	static void inputEmail(String email) {
		PageActions.setText(findTestObject('Object Repository/LoginPage/txtEmail'),email)
	}

	/**
	 * Input the Password to Login Page
	 */
	@Keyword
	static void inputInValidPassword(String password) {
		PageActions.setText(findTestObject('Object Repository/LoginPage/txtPassword'), password)
	}

	/**
	 * Input the Password to Login Page
	 */
	@Keyword
	static void aler(String password) {
		PageActions.setText(findTestObject('Object Repository/LoginPage/txtPassword'), password)
	}
}
