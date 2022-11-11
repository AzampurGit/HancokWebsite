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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://staging.hancocks.co.uk/')

WebUI.click(findTestObject('Page_Hancocks Cash  Carry  Wholesale Sweets_61042e/a_Sign In'))

WebUI.setText(findTestObject('Page_Customer Login/input_Email_loginusername'), 'hancocksautouser@yopmail.com')

WebUI.setEncryptedText(findTestObject('Page_Customer Login/input_Password_loginpassword'), 'cvW8qx4B2o3J/qo+fRAOjg==')

WebUI.click(findTestObject('Page_Customer Login/input_Password_loginaccept_gdpr'))

WebUI.click(findTestObject('Page_Customer Login/span_Sign In'))

WebUI.setText(findTestObject('Page_Customer Login/input_Email_loginusername'), 'hancockautouser@yopmail.com')

WebUI.setEncryptedText(findTestObject('Page_Customer Login/input_Password_loginpassword'), 'cvW8qx4B2o3J/qo+fRAOjg==')

WebUI.click(findTestObject('Page_Customer Login/input_Password_loginaccept_gdpr'))

WebUI.click(findTestObject('Page_Customer Login/span_Sign In'))

WebUI.click(findTestObject('Page_/a_Stored Payment Methods'))

WebUI.click(findTestObject('Page_Stored Payment Methods/button_Add a card'))

WebUI.setText(findTestObject('Page_Stored Payment Methods/input_concat(id(, , checkout-frames-card-number, , ))_cardnumber'), '4242 4242 4242 4242')

WebUI.setText(findTestObject('Page_Stored Payment Methods/input_concat(id(, , checkout-frames-expiry-_05a08f'), '02/23')

WebUI.setText(findTestObject('Page_Stored Payment Methods/input_concat(id(, , checkout-frames-expiry-_376991'), '100')

WebUI.click(findTestObject('Page_Stored Payment Methods/button_Save the card'))

WebUI.setText(findTestObject('Page_Stored Payment Methods/input_concat(id(, , checkout-frames-expiry-_376991'), '100')

