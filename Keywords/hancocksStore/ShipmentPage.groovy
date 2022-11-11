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

public class ShipmentPage {

	@Keyword
	def addShippmentAddress() {

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_increase_QuantityCartPage'))
		int getSubTotalAmount = WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_SubTotalPriceViewTrolley')).substring(1, 3).toInteger()
		if( getSubTotalAmount< GlobalVariable.MinimumOrderAmount) {
			WebUI.clearText(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'))
			WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'), GlobalVariable.ProductQuantityAtCartPage)
			WebUI.click(findTestObject('Object Repository/Cart_Page/Link_UpdateTrolleyPage'))

			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_proceedToCheckout'))
		}
		else {
			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_proceedToCheckout'))
		}
		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_add_shipping_address'))
		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/Textbox_StreetAddress'), GlobalVariable.AddNew_Address_Street_Address)
		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_city_ShipmentPage'), GlobalVariable.AddNew_Address_town)
		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_postcode_ShippmentPage'), GlobalVariable.AddNew_Address_zip)
		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/Textbox_PhoneNumber_shipmentPage'), GlobalVariable.Add_New_Addres_PhoneNumber)
		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_deliverHere_shippmentPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Shipment_Page/Text_Customer_details_Page')) == true : "assert passed."

		WebUI.back()
	}
	@Keyword
	def editTrolleyFromCheckoutShipmentPage() {

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_increase_QuantityCartPage'))
		int getSubTotalAmount = WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_SubTotalPriceViewTrolley')).substring(1, 3).toInteger()
		if( getSubTotalAmount< GlobalVariable.MinimumOrderAmount) {
			WebUI.clearText(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'))
			WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'), GlobalVariable.ProductQuantityAtCartPage)
			WebUI.click(findTestObject('Object Repository/Cart_Page/Link_UpdateTrolleyPage'))
			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_proceedToCheckout'))
			WebUI.click(findTestObject('Object Repository/Shipment_Page/Link_EditTrolley_ShipmmentPage'))
		}
	}

	@Keyword
	def selectDeliveryOptionShipmentPage() {

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_increase_QuantityCartPage'))
		int getSubTotalAmount = WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_SubTotalPriceViewTrolley')).substring(1, 3).toInteger()
		if( getSubTotalAmount< GlobalVariable.MinimumOrderAmount) {
			WebUI.clearText(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'))
			WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'), GlobalVariable.ProductQuantityAtCartPage)
			WebUI.click(findTestObject('Object Repository/Cart_Page/Link_UpdateTrolleyPage'))
		}
		else {
			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_proceedToCheckout'))
		}

		WebUI.click(findTestObject('Object Repository/Shipment_Page/Radio_DeliveryOptions_shipmentPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Shipment_Page/Radio_DeliveryOption_Text_ShipmentPage'))

		WebUI.back()
		
		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Remove_AllitemsFromTrolleyPage'))
		
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_Ok_Popup_RemoveItemsFromCart'))
	}

	@Keyword
	def removeItemFromTrolley() {
		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Remove_AllitemsFromTrolleyPage'))
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_Ok_Popup_RemoveItemsFromCart'))
	}

	@Keyword
	def redirectToPaymentPageFromCheckoutShipping() {

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_increase_QuantityCartPage'))
		int getSubTotalAmount = WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_SubTotalPriceViewTrolley')).substring(1, 3).toInteger()
		if( getSubTotalAmount< GlobalVariable.MinimumOrderAmount) {
			WebUI.clearText(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'))
			WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'), GlobalVariable.ProductQuantityAtCartPage)
			WebUI.click(findTestObject('Object Repository/Cart_Page/Link_UpdateTrolleyPage'))
		}
		else {
			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_proceedToCheckout'))
		}

		WebUI.click(findTestObject('Object Repository/Shipment_Page/Radio_DeliveryOptions_shipmentPage'))

		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_Next_ShippmentPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Shipment_Page/Text_PaymentMethodPage')) == true : "Assert passed."

		WebUI.back()

		WebUI.back()
	}
}
