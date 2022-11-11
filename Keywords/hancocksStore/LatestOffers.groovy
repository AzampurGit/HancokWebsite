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

public class LatestOffers {


	@Keyword
	def redirectToLatestOffersPage() {

		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Link_Latestoffer'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/LatestOffers_Page/Text_LatestOfferPage')) == true
	}


	@Keyword
	def redirectToPDPFromLatestOfferPage() {

		WebUI.callTestCase(findTestCase('Test Cases/LatestOffersPage/TC_108(Verify_user_RedirectedTo_LatestOfferPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Link_Product_name'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByBrand_Page/Text_ProductHariboRhubarv_At_PDP_ShopbyBrand')) == true
	}


	@Keyword
	def clickOnLoadMoreLinkLatestOfferPage() {
		WebUI.callTestCase(findTestCase('Test Cases/LatestOffersPage/TC_108(Verify_user_RedirectedTo_LatestOfferPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Link_LoadMore_LatestOffers'))
	}

	@Keyword
	def increaseDescreaseProductQuantityLatestOffers() {
		WebUI.callTestCase(findTestCase('Test Cases/LatestOffersPage/TC_108(Verify_user_RedirectedTo_LatestOfferPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Button_Increase_quantity'))
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Button_decrease_quantity'))
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Button_Increase_quantity'))
	}

	@Keyword
	def addProductToCartLatestOffer() {

		WebUI.callTestCase(findTestCase('Test Cases/LatestOffersPage/TC_108(Verify_user_RedirectedTo_LatestOfferPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Button_add_to_cart'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/LatestOffers_Page/Text_miniCart_Hariboproduct_latestoffer'))

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_MiniCart_icon'))
		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_view_trolley'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_RemoveItem_From_TrolleyPage'))
	}
	@Keyword
	def SearchProductWithFilterLatestoffers() {

		WebUI.callTestCase(findTestCase('Test Cases/LatestOffersPage/TC_108(Verify_user_RedirectedTo_LatestOfferPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Dropdown_Brand_filter'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Checkbox_Brand_filter'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Dropdown_filter_Dietary_CategPage'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Checkbox_filter_Dietary_CategPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/LatestOffers_Page/Text_LatestOfferPage')) == true
	}

	@Keyword
	def viewStylesOfProductsLatestOffers() {

		WebUI.callTestCase(findTestCase('Test Cases/LatestOffersPage/TC_108(Verify_user_RedirectedTo_LatestOfferPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Button_ViewProducts_LatestOffersPage'))
	}

	
	
	
	@Keyword
	def addProductToFavouritePage() {

		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Link_Latestoffer'))
		WebUI.click(findTestObject('Object Repository/LatestOffers_Page/Button_add_tofavFromLatestOffer'))
		WebUI.click(findTestObject('Object Repository/MY_Favourites/Button_cross_AddFavPopUp'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_MyFavIcon'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/LatestOffers_Page/Text_miniCart_Hariboproduct_latestoffer'))  == true : "Assert passed."

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))
	}
}
