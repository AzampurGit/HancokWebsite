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

public class MiniCart {

	@Keyword
	def checoutOrderFromMiniCart() {


		WebUI.click(findTestObject('Object Repository/HomePage/Button_add_To cart'))
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Link_MiniCart_view'))
		WebUI.click(findTestObject('Object Repository/MiniCart/Button_checkout_miniCart'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MyOrders_Page/Text_ShoppingTrolleyPage')) == true : "Assert passed."

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_RemoveItem_From_TrolleyPage'))
	}

	@Keyword
	def redirectToTrolleyPageFromMiniCart() {

		WebUI.click(findTestObject('Object Repository/HomePage/Button_add_To cart'))
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Link_MiniCart_view'))
		WebUI.click(findTestObject('Object Repository/MiniCart/Button_view_trolley'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MyOrders_Page/Text_ShoppingTrolleyPage')) == true : "Assert passed."

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_RemoveItem_From_TrolleyPage'))
	}

	@Keyword
	def redirectsToPDPFromMiniCart() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Button_AddToTrolleyCatePage'))
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Link_MiniCart_view'))
		WebUI.click(findTestObject('Object Repository/MiniCart/Link_pdpPageFromMiniCart'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MiniCart/Text_HariboGaint_AtPDP')) == true
	}
}
