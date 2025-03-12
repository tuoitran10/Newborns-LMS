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
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

import internal.GlobalVariable

public class Support {

	/**
	 * Support decrypt password
	 * @param testObject - TestObject of the element to click
	 */
	@Keyword
	static String decrypt(String encryptedPasswordBase64, String keyBase64) {
		try {
			// Decode the AES key from Base64
			byte[] decodedKey = Base64.getDecoder().decode(keyBase64)
			SecretKeySpec secretKeySpec = new SecretKeySpec(decodedKey, "AES")

			// Initialize AES Cipher for decryption
			Cipher cipher = Cipher.getInstance("AES")
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)

			// Decode and decrypt the password
			byte[] encryptedPassword = Base64.getDecoder().decode(encryptedPasswordBase64)
			byte[] decryptedPassword = cipher.doFinal(encryptedPassword)

			return new String(decryptedPassword, "UTF-8")
		} catch (Exception e) {
			println("Error during decryption: " + e.getMessage())
			return null
		}
	}
}
