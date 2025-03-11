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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

// The password you want to encrypt
String password = "Kms@2023"

// Generate a random 16-byte key for AES encryption (AES-128)
KeyGenerator keyGenerator = KeyGenerator.getInstance("AES")
keyGenerator.init(128)  // AES-128 encryption
SecretKey secretKey = keyGenerator.generateKey()

// Encrypt the password using the secret key
Cipher cipher = Cipher.getInstance("AES")
cipher.init(Cipher.ENCRYPT_MODE, secretKey)

// Encrypt the password
byte[] encryptedPassword = cipher.doFinal(password.getBytes("UTF-8"))

// Encode the encrypted password in Base64 for easier storage
String encryptedPasswordBase64 = Base64.getEncoder().encodeToString(encryptedPassword)

// Output the encrypted password (Base64 encoded)
println("Encrypted Password (Base64): " + encryptedPasswordBase64)

// Output the generated key (Base64 encoded) for later use (for decryption)
String keyBase64 = Base64.getEncoder().encodeToString(secretKey.getEncoded())
println("Encryption Key (Base64): " + keyBase64)