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

public class PostivieFlow {

	@Keyword
	def generateOrderWithoutLogin()
	{
		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/Textbox_EmailAddress_shipmentPage'), GlobalVariable.EmailWithoutLoginUserShipmentPage)
		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_FirstName_shipmmentPage'), GlobalVariable.FirstName)
		WebUI.sendKeys(findTestObject('Object Repository/EditAccountInformation_Page/TextField_LastName'), GlobalVariable.LastName)
		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_StreetAddress_ShippingPage'), GlobalVariable.AddNew_Address_Street_Address)
		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_city_ShipmentPage'), GlobalVariable.AddNew_Address_town)
		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_postcode_ShippmentPage'), GlobalVariable.AddNew_Address_zip)
		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/Textbox_PhoneNumber_shipmentPage'), GlobalVariable.Add_New_Addres_PhoneNumber)
		
		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_Next_ShippmentPage'))
		
		WebUI.click(findTestObject('Object Repository/Payment_Page/Radio_CashOnDelivery_PaymentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Checkbox_TermsAndCondition_PaymentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Button_PlaceOrder_CheckoutShipmentPage'))
		
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Payment_Page/Text_SucessPageOfOrder')) == true
	}
	
	@Keyword
	def generateOrderWithLogin()
	{
	
		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_Next_ShippmentPage'))
		
		WebUI.click(findTestObject('Object Repository/Payment_Page/Radio_CashOnDelivery_PaymentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Checkbox_TermsAndCondition_PaymentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Button_PlaceOrder_CheckoutShipmentPage'))
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Payment_Page/Text_SucessPageOfOrder')) == true : "Assert passed."
	}
	}

