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

public class Stored_Payment_Methods {

	@Keyword
	def redirectToStoredPaymentPage() {

		WebUI.callTestCase(findTestCase('Test Cases/Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('StoredPaymentMethods/Link_stored_payment_methods'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/StoredPaymentMethods/Text_StorePaymentMethodPage')) == true : "Assert passed."
	}

	@Keyword
	def clickonAddCardButton() {

		WebUI.callTestCase(findTestCase('Test Cases/Stored_Payment_Methods/TC_34(Verify_User_RedirectTo_StorePaymentMethod_Page)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('StoredPaymentMethods/Button_Add_Card'))
	}

	@Keyword
	def addNewCard() {
		WebUI.callTestCase(findTestCase('Test Cases/Stored_Payment_Methods/TC_36(Verify_User_RedirectsTo_AddCardPageFrom_StoredPaymentSection)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(5)

		//WebUI.setText(findTestObject('//input_concat(id(, , checkout-frames-card-number, , ))_cardnumber'), '1253')
		WebUI.sendKeys(findTestObject('Object Repository/StoredPaymentMethods/TextField_Card_Number'), '4242 4242 4242 4242')
		//WebUI.sendKeys(findTestObject('Object Repository/StoredPaymentMethods/TextField_Card_Number'), '125')
		//WebUI.switchToFrame(findTestObject('Object Repository/StoredPaymentMethods/TextField_Card_Number'), 0)

	}

	@Keyword
	def redirectTodeleteCardPopUp() {
		WebUI.callTestCase(findTestCase('Test Cases/Stored_Payment_Methods/TC_36(Verify_User_RedirectsTo_AddCardPageFrom_StoredPaymentSection)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/StoredPaymentMethods/Link_delete_card'))
		
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/StoredPaymentMethods/Button_Cancel_DeleteCardPopup')) == true
		
		WebUI.click(findTestObject('Object Repository/StoredPaymentMethods/Button_Cancel_DeleteCardPopup'))
	}

	@Keyword
	def deleteCardFromPopUp() {
		WebUI.callTestCase(findTestCase('Test Cases/Stored_Payment_Methods/TC_39(Verify_User_RediectedTo_DeleteCardPopu_AfterClickingOnDeleteCard_link)'), [:],FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(5)
		WebUI.click(findTestObject('Object Repository/StoredPaymentMethods/Button_delete_card_popup'))
		WebUI.click(findTestObject('Object Repository/StoredPaymentMethods/Button_Delete_card_StoredPaymentPage'))
	
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/StoredPaymentMethods/Text_card_delete_sucessMessage_StoredPayment')) == true
		
		}
		
	@Keyword
	def cancelDeletePopupOption() {
		WebUI.callTestCase(findTestCase('Test Cases/Stored_Payment_Methods/TC_39(Verify_User_RediectedTo_DeleteCardPopu_AfterClickingOnDeleteCard_link)'), [:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/StoredPaymentMethods/Button_Cancel_delete_popup'))
	}
}
