package hancocksStore

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

import internal.GlobalVariable

public class createAccount {

	@Keyword
	def redirectsToCreateNewAccountPage() {

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl(GlobalVariable.Staging_url)

		WebUI.mouseOver(findTestObject('Login_Page/MouseOver_SignInButton'))

		WebUI.click(findTestObject('CreateAccount_Page/Link_CreateanAccount'))

		if (GlobalVariable.Create_account_text == WebUI.getText(findTestObject('CreateAccount_Page/Text_CreateNewCustomerAccount'))) {
			assert true
		}
		else {
			assert false
		}
	}


	@Keyword
	def registerFromLoginPage() {

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl(GlobalVariable.Staging_url)

		WebUI.mouseOver(findTestObject('Login_Page/MouseOver_SignInButton'))

		WebUI.click(findTestObject('Login_Page/Link_SignIn'))

		WebUI.click(findTestObject('CreateAccount_Page/Button_CreateAnAccount'))

		if (GlobalVariable.Create_account_text == WebUI.getText(findTestObject('CreateAccount_Page/Text_CreateNewCustomerAccount'))) {
			assert true
		}
		else {
			assert false
		}
	}
}
