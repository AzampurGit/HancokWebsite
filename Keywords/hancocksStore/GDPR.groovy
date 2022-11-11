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

public class GDPR {

	@Keyword
	def redirectToGDPRPage() {
		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/GDPR/Link_gdpr'))
		
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/GDPR/Text_GDPR_Page')) == true : "Assert passed."
		
		
			}
	@Keyword
	def selectEraseAccountOptionGDpr() {
		WebUI.callTestCase(findTestCase('Test Cases/GDPR/TC_42(Verify_User_redirects_To_GDPR_Page)'),  [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/GDPR/Radio_button_erase_account_option'))
	
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/GDPR/Text_EraseAcount_Radio')) == true : "Assert passed."
		}

}
