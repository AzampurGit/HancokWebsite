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

public class EmailSubscription {

	@Keyword
	def redirectToEmailSubscriptionPage() {
		

		WebUI.click(findTestObject('Object Repository/Email_Subscription/Link_Email_subscription'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Email_Subscription/Text_Email_Subscription_Text')) == true : "Assert ppassed."
	}

	@Keyword
	def checkEmailSubCheckbox() {

		WebUI.callTestCase(findTestCase('Test Cases/EmailSubscription/TC_51(Verify_User_redirects_To_EMailSubsription_Page)'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Email_Subscription/Checkbox_General_subscription'))
		WebUI.click(findTestObject('Object Repository/Email_Subscription/Checkbox_General_subscription'))
	}

	@Keyword
	def subscribeEmail() {

		WebUI.callTestCase(findTestCase('Test Cases/EmailSubscription/TC_51(Verify_User_redirects_To_EMailSubsription_Page)'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Email_Subscription/Checkbox_General_subscription'))
		WebUI.click(findTestObject('Object Repository/Email_Subscription/Button_Save_EmailSub'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Email_Subscription/Text_Email_SubscribedSuccesfully')) == true : "Assert passed."

		WebUI.click(findTestObject('Object Repository/Email_Subscription/Link_Email_subscription'))
		WebUI.click(findTestObject('Object Repository/Email_Subscription/Checkbox_General_subscription'))
		WebUI.click(findTestObject('Object Repository/Email_Subscription/Button_Save_EmailSub'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Email_Subscription/Sucess_Msg_RemoveSubscription')) == true : "Assert passed."
	}
}
