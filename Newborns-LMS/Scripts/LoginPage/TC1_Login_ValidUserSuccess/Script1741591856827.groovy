import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as App
import org.openqa.selenium.Keys as Keys
import utils.PageActions
import pages.LoginPage
import com.kms.katalon.core.util.KeywordUtil
import pages.DashboardPage


/**
 * Description:
 * This test case verifies that the user can login success with valid user
 */

/**
 * Precondition:
 * User should naviagte to Newborns page.
 * User input valid email and valid password
 
 */

'Step 1'
'Navigate to the Newborns'
PageActions.NavigateURL(App.NewbornUAT)
'Expected Result:'
'The Login Page is displayed'
LoginPage.verifyLoginPageHeaderIsCorrect("Login")
'The label Email is displayed'
LoginPage.verifyEmailLablelIsCorrect("Email")
'The label Password is displayed'
LoginPage.verifyPasswordlLablelIsCorrect("Password")

'Step 2'
'Input Valid Email and Password'
PageActions.setText(findTestObject('Object Repository/LoginPage/txtEmail'),App.Email)
PageActions.setText(findTestObject('Object Repository/LoginPage/txtPassword'),App.Password)

'Step 3'
'Click to Login Button'
PageActions.click(findTestObject('Object Repository/LoginPage/btnLogin'))
'Expected Result:'
DashboardPage.verifyDashboardPresent()




