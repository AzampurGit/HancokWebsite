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
import com.kms.katalon.core.mobile.keyword.builtin.WaitForElementAttributeValueKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.WaitForPageLoadKeyword
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad

import internal.GlobalVariable

public class CartPage {

	@Keyword
	def openAndCloseCartpopup() {
		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Cart_icon'))

		if(GlobalVariable.Text_EmptyTrolley==WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_cartpopUp'))) {
			WebUI.click(findTestObject('Object Repository/Cart_Page/Link_CartIcon_close'))
			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def checkProductQuantityAddedInMiniCart() {

		WebUI.click(findTestObject('Object Repository/NewIN_Page/Link_NewIn_page'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Button_addToTrolley_FirstProduct_NewIn'))
		def getQuantity=WebUI.getText(findTestObject('Object Repository/Cart_Page/Ballon_cart_quantity_count'))
		println("Added Product Quantity is :"+getQuantity)
	}

	@Keyword
	def redirectToTrolleyPageFromMiniCart() {

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MyOrders_Page/Text_ShoppingTrolleyPage'))==true

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_RemoveItem_From_TrolleyPage'))
	}

	@Keyword
	def viewProductUnderStockForDeliveryAtCartPage() {

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_ViewStockForDeliveryProducts'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Text_Showing_CartPage'))==true:"Assert passed."

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_RemoveItem_From_TrolleyPage'))
	}

	@Keyword
	def viewProductUnderStockForCollectionAtCartPage() {

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_ViewStockForCollecctionProducts'))

		WebUI.click(findTestObject('Object Repository/Cart_Page/Radio_birmmingham_value_trolleyPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Button_ViewStockForCollecctionProducts'))==true

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_RemoveItem_From_TrolleyPage'))
	}

	@Keyword
	def RedirectToPDPFromTrolleyPage() {

		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_ProductName_TrolleyPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Text_AddedProduct_TrolleyPage'))==true:"assert passed."
	}

	@Keyword
	def viewProductCodeAtPDPPage() {

		def productCode=WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_ProductCode'))
		println("code is "+ productCode)
		
		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Remove_AllitemsFromTrolleyPage'))
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_Ok_Popup_RemoveItemsFromCart'))
	}

	@Keyword
	def clickOnBackLinkAtCartPage() {

		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Back_buttonTrolleyPage'))

		WebUI.back()

		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Remove_AllitemsFromTrolleyPage'))

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_Ok_Popup_RemoveItemsFromCart'))
	}

	@Keyword
	def editQuantityAtCartPage() {

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_increase_QuantityCartPage'))
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_decrease_Quantity'))
	}

	@Keyword
	def editQuantitywithNumberAtCartPage() {

		WebUI.clearText(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'))
		WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'),GlobalVariable.Product_quantity)
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Text_Update_QuantiryAtCartPage'))==true:"Assert passed."

		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_UpdateTrolleyPage'))
	}

	@Keyword
	def viewPriceOfCartproducts() {

		println("The price of Added product into Cart is : "+WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_Price_viewCartPage')))
	}

	@Keyword

	def addProductIntoCartWithoutLogin() {
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Link_NewIn_page'))
		//WebUI.click(findTestObject('Object Repository/NewIN_Page/Dropdown_filterOfProducts'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/NewIN_Page/Dropdown_filterOfProducts'),'price_desc', false)
		WebUI.waitForElementVisible(findTestObject('Object Repository/NewIN_Page/Button_addToTrolley_FirstProduct_NewIn'), 5)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/NewIN_Page/Button_addToTrolley_FirstProduct_NewIn'), FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.click(findTestObject('Object Repository/NewIN_Page/Button_addToTrolley_FirstProduct_NewIn'))
		}
		else if(WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Button_AddToTrolley_SecondProduct_NewIn'))) {
			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_AddToTrolley_SecondProduct_NewIn'))
		}
		else {
			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_ThirdProduct_NewInPage'))
		}

		//WebUI.click(findTestObject('Object Repository/NewIN_Page/Button_addToTrolley_FirstProduct_NewIn'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Cart_Page/Link_Cart_icon'),4)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Cart_icon'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Cart_Page/Button_view_trolley'), 4)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_view_trolley'))
	}

	@Keyword
	def viewSubtotalPriceViewTrolley() {

		println("The SubTotal Price of product is : "+WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_SubTotalPriceViewTrolley')).substring(1, 4))
	}

	@Keyword
	def viewVatPercentage() {
		println("The vat percentage of product is : "+WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_Product_vat')))
	}

	@Keyword
	def addProductToFavListViewTrolleyPage() {

		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_moveToFavViewTrolley'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_MyFavIcon'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Text_AddedProductInFavPageFromNewInPage'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))
	}

	@Keyword
	def removeProductFromTrolleyPage() {
		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_deleteProductFromTrolleyPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Text_Shopping_Trolley_Empty'))==true:"Assert passed."
	}

	@Keyword
	def viewProductsInStockTrolleyPage() {
		if(GlobalVariable.TextInstockTrolleyPage==WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_inStockTrolleyPage'))){
			assert true
		}else{
			assert false
		}
	}

	@Keyword
	def removeAllItemsFromTrolleyPage() {
		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Remove_AllitemsFromTrolleyPage'))
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_Ok_popup_deleteallTrolleyPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Text_Shopping_Trolley_Empty'))==true:"Assert passed."
	}

	@Keyword
	def checkTrolleySummaryPrice() {

		println("The subtotal price under Trolley Summary is : "+WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_SubTotalPriceTroleyPage')))
		println("The vat price under Trollecy Summary is : "+WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_vat_price_TrolletPage')))
	}

	@Keyword
	def checkOrderTotalPriceTrolleyPage() {

		println("The Order Total Price is :"+WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_Ordertotal_Price_trolleyPage')))
	}

	@Keyword
	def applyDiscountTrolleyPage() {
		WebUI.click(findTestObject('Object Repository/Cart_Page/Dropdown_discount_trolleyPage'))
		WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_discountCoupon'),GlobalVariable.DiscoutCoupon)
	}

	@Keyword
	def checkDeliveryDatesTrolleyPage() {
		println("Delivery dates for order is :"+WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_orderDate_trolleyPage')))
	}

	@Keyword
	def clickOnCheckoutButton() {

		WebUI.clearText(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'))
		WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'),GlobalVariable.Product_quantity)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_UpdateTrolleyPage'))
		int getSubTotalAmount=WebUI.getText(findTestObject('Object Repository/Cart_Page/Text_SubTotalPriceViewTrolley')).substring(1,3).toInteger()
		if(getSubTotalAmount<GlobalVariable.MinimumOrderAmount){
			WebUI.clearText(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'))
			WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'),GlobalVariable.ProductQuantityAtCartPage)
			WebUI.click(findTestObject('Object Repository/Cart_Page/Link_UpdateTrolleyPage'))

			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_proceedToCheckout'))
		}else{

			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_proceedToCheckout'))
		}

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Text_Secure_checkout_CheckoutPage'))==true:"Assert passed."
	}

	@Keyword
	def clickOnCheckoutWithPayPal() {

		WebUI.clearText(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'))
		WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_CartQuantityTrolleyPage'),GlobalVariable.ProductQuantityAtCartPage)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_UpdateTrolleyPage'))
		WebUI.waitForPageLoad(5)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_paypal_TrolleyPage'))
	}

	@Keyword

	def orderThroughPaypalCheckout() {

		WebUI.callTestCase(findTestCase('Test Cases/CartPage/TC_152(Verify_User_do_checkout_withPaypalCheckout)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(5)
		WebUI.switchToWindowIndex(1)
		WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_Paypal_Username'),GlobalVariable.PaypalUsername)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_Paypal_Next_Paypalpopup'))
		WebUI.sendKeys(findTestObject('Object Repository/Cart_Page/TextBox_paypal_Password'),GlobalVariable.PaypalPassword)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_PaypalLoginButton'))
		WebUI.scrollToElement(findTestObject('Object Repository/Cart_Page/Button_paypal_continue_paypalpop up'),3)
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_paypal_continue_paypalpop up'))

		WebUI.switchToWindowIndex(0)

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Text_reviewOrderPage'))==true:"Assert passed."

		WebUI.click(findTestObject('Object Repository/Cart_Page/CheckBox_TermsAndCondition'))

		WebUI.click(findTestObject('Object Repository/Cart_Page/Dropdown_deliveryMethod_ReviewOrder'))

		WebUI.selectOptionByIndex(findTestObject('Object Repository/Cart_Page/Dropdown_SelectDeliveryMethod_reviewOrder'),1)

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_PlaceOrder_ReviewOrderPage'))

		//assert WebUI.verifyElementVisible(findTestObject('Object Repository/Payment_Page/Text_SucessPageOfOrder'))== true:"Assert passed."

		if(GlobalVariable.ThankYouPage ==WebUI.getText(findTestObject('Object Repository/Payment_Page/Text_SucessPageOfOrder'), FailureHandling.CONTINUE_ON_FAILURE)) {

			assert true

			println("Paypal payment passed.")
		}
		else if(WebUI.verifyElementVisible(findTestObject('Object Repository/Cart_Page/Link_Remove_AllitemsFromTrolleyPage')) == true)
		{
			WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Remove_AllitemsFromTrolleyPage'))
			WebUI.click(findTestObject('Object Repository/Cart_Page/Button_OK_RemoveItemsFromTrolley'))
		}}
}
