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

public class PaymentPage {


	@Keyword
	def selectPaymentMethodFromCheckoutPaymentPage() {

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

			WebUI.click(findTestObject('Object Repository/Shipment_Page/Radio_DeliveryOptions_shipmentPage'))
			WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_Next_ShippmentPage'))

			assert WebUI.verifyElementVisible(findTestObject('Object Repository/Payment_Page/Text_CashonDelivery_PaymentPage')) == true : "Assert passed."

			WebUI.click(findTestObject('Object Repository/Shipment_Page/Link_EditTrolley_ShipmmentPage'))

			WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Remove_AllitemsFromTrolleyPage'))

			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_Ok_Popup_RemoveItemsFromCart'))
		}
	}


	@Keyword
	def checkSubtotalPriceAtCartPageAndProceed() {
		/*
		 float amt = WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_SubTotalPriceViewTrolley')).substring(1, 4)
		 println("amount is" + amt)
		 int a = Integer.parseInt(amt)
		 println("now new number is " + a)*/

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_increase_QuantityCartPage'))
		//WebUI.click(findTestObject('Object Repository/Cart_Page/Button_increase_QuantityCartPage'))

		int  getSubTotalAmount = WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_SubTotalPriceViewTrolley')).substring(1, 3).toInteger()
		println("amount is  :" +  getSubTotalAmount)
		if( getSubTotalAmount< GlobalVariable.MinimumOrderAmount) {
			WebUI.clearText(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'))
			WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'), GlobalVariable.ProductQuantityAtCartPage)
			WebUI.click(findTestObject('Object Repository/Cart_Page/Link_UpdateTrolleyPage'))

			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_proceedToCheckout'))
		}
		else {
			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_proceedToCheckout'))
		}
	}

	@Keyword
	def applyDiscountCouponAtCheckoutPaymentPage() {
		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_Next_ShippmentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Radio_CashOnDelivery_PaymentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Dropdown_DiscountCoupon_CheckoutShipmentPage'))
		WebUI.sendKeys(findTestObject('Object Repository/Payment_Page/TextBox_DiscountCoupon_checkoutShipmentPage'), GlobalVariable.DiscoutCoupon)
		WebUI.click(findTestObject('Object Repository/Payment_Page/Button_ApplyDiscountCoupon_CheckoutShipmentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Checkbox_TermsAndCondition_PaymentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Button_ApplyDiscountCoupon_CheckoutShipmentPage'))

		WebUI.click(findTestObject('Object Repository/Payment_Page/Button_PlaceOrder_CheckoutShipmentPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Payment_Page/Text_SucessPageOfOrder')) == true :"Assert passed."
	}

	@Keyword
	def redirectToEditShipToAndShippingMethodPage() {
		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_Next_ShippmentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Checkbox_TermsAndCondition_PaymentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Link_EditShipTo_CheckoutPaymentPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Shipment_Page/Text_Customer_details_Page'))

		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_Next_ShippmentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Link_Edit_ShippingMethod_checkoutPaymentPage'))
		WebUI.click(findTestObject('Object Repository/Shipment_Page/Link_EditTrolley_ShipmmentPage'))

		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Remove_AllitemsFromTrolleyPage'))

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_Ok_Popup_RemoveItemsFromCart'))
	}

	@Keyword
	def redirectToPaypalPageFromPaymentPage() {


		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/Textbox_EmailAddress_shipmentPage'), GlobalVariable.EmailAddress)

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_FirstName_shipmmentPage'), GlobalVariable.FirstName)

		WebUI.sendKeys(findTestObject('Object Repository/EditAccountInformation_Page/TextField_LastName'), GlobalVariable.LastName)

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/Textbox_StreetAddress'), GlobalVariable.AddNew_Address_Street_Address)

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_city_ShipmentPage'), GlobalVariable.AddNew_Address_town)

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_postcode_ShippmentPage'), GlobalVariable.AddNew_Address_zip)

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/Textbox_PhoneNumber_shipmentPage'), GlobalVariable.Add_New_Addres_PhoneNumber)

		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_Next_ShippmentPage'))

		WebUI.click(findTestObject('Object Repository/Payment_Page/Radio_paypal_option_PaymentPage'))

		WebUI.click(findTestObject('Object Repository/Payment_Page/Checkbox_paypal_TermsAndCondition'))

		WebUI.click(findTestObject('Object Repository/Payment_Page/Button_paypal_paymentPage'))
	}


	@Keyword

	def generateOrderThroughPayPalFromPaymentpage() {
		WebUI.callTestCase(findTestCase('Test Cases/PaymentPage/TC_163(Verify_User_redirectToPaypal_LoginPage_AfterClickingOnPaypalButtonAtpaymentPage)'), [:],FailureHandling.STOP_ON_FAILURE)
		WebUI.switchToWindowIndex(1)
		WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_Paypal_Username'), GlobalVariable.PaypalUsername)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_Paypal_Next_Paypalpopup'))
		WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_paypal_Password'), GlobalVariable.PaypalPassword)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_PaypalLoginButton'))
		WebUI.scrollToElement(findTestObject('Object Repository/Cart_Page/Button_paypal_continue_paypalpop up'), 4)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_Accept_PaypalpopUp'))
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_paypal_continue_paypalpop up'))

		WebUI.switchToWindowIndex(0)
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Payment_Page/Text_SucessPageOfOrder')) == true :"Assert passed."
	}

	@Keyword
	def paymentOfOrderCashOnDelivery() {
		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_Next_ShippmentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Radio_CashOnDelivery_PaymentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Checkbox_TermsAndCondition_PaymentPage'))
		WebUI.click(findTestObject('Object Repository/Payment_Page/Button_placeOrder_CashOndelivery_paymentPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Payment_Page/Text_SucessPageOfOrder'))
	}


	@Keyword
	def addCardNumber() {

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/Textbox_EmailAddress_shipmentPage'), GlobalVariable.EmailAddress)

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_FirstName_shipmmentPage'), GlobalVariable.FirstName)

		WebUI.sendKeys(findTestObject('Object Repository/EditAccountInformation_Page/TextField_LastName'), GlobalVariable.LastName)

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/Textbox_StreetAddress'), GlobalVariable.AddNew_Address_Street_Address)

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_city_ShipmentPage'), GlobalVariable.AddNew_Address_town)

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/TextBox_postcode_ShippmentPage'), GlobalVariable.AddNew_Address_zip)

		WebUI.sendKeys(findTestObject('Object Repository/Shipment_Page/Textbox_PhoneNumber_shipmentPage'), GlobalVariable.Add_New_Addres_PhoneNumber)

		WebUI.click(findTestObject('Object Repository/Shipment_Page/Button_Next_ShippmentPage'))

		WebUI.click(findTestObject('Object Repository/Payment_Page/Radio_PayBycard_PaymentPage'))

		WebUI.click(findTestObject('Object Repository/Payment_Page/TextBox_CardNumber_PaymentPage'))

		WebUI.sendKeys(findTestObject('Object Repository/Payment_Page/TextBox_CardNumber_PaymentPage'), GlobalVariable.Card_Number)
	}







	@Keyword
	def redirectToHomePageFromOrderSucessPage() {

		WebUI.callTestCase(findTestCase('Test Cases/PaymentPage/TC_166(Verify_User_DopaymentWith_CashOnDeliveryOption_PaymentPage)'),[:],FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/Payment_Page/Link_ReturnHomepageFromSucessPage'))

		if(GlobalVariable.HomePageWindowTitle == WebUI.getWindowTitle()) {
			assert true
		}
		else {
			assert false
		}
	}
}
