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
import com.kms.katalon.core.mobile.keyword.builtin.WaitForElementPresentKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.WaitForElementVisibleKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class NewInPage {

	@Keyword

	def redirectToNewInPage() {

		WebUI.click(findTestObject('Object Repository/NewIN_Page/Link_NewIn_page'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/NewIN_Page/Text_NewInPage')) == true : "Assert passed."
	}

	@Keyword

	def addProductToTrolleyFromNewInPage() {

		WebUI.callTestCase(findTestCase('Test Cases/NewIn_Page/TC_70(Verify_User_RedirectTo_NewInPage)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/NewIN_Page/Button_addToTrolley_FirstProduct_NewIn'))

		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Cart_icon'))

		WebUI.click(findTestObject('Object Repository/Cart_Page/Button_view_trolley'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/NewIN_Page/Text_MiniCart_AddedProductName')) == true : "Assert passed."

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_RemoveItem_From_TrolleyPage'))
	}

	@Keyword
	def viewShowingStockForDeliveryProductsAtNewInPage() {


		WebUI.callTestCase(findTestCase('Test Cases/NewIn_Page/TC_70(Verify_User_RedirectTo_NewInPage)'),[:],FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/NewIN_Page/Button_showing_stockforDelivery'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/NewIN_Page/Text_StockForDelivery_NewInPage')) == true : "Assert passed."
	}

	@Keyword

	def viewShowStockForCollectionProducts() {

		WebUI.callTestCase(findTestCase('Test Cases/NewIn_Page/TC_70(Verify_User_RedirectTo_NewInPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Button_show_stockForCollection'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Radio_select_locationUndershowstcokColl'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/NewIN_Page/Button_show_stockForCollection')) == true : "Assert passed."
	}

	@Keyword
	def selectFilterOfProducts() {
		WebUI.callTestCase(findTestCase('Test Cases/NewIn_Page/TC_72Verify_User_View_ShowStockForDeleivery_Products)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/NewIN_Page/Dropdown_filterOfProducts'),1)
	}

	@Keyword
	def selectFilterSectionForProducts() {

		WebUI.callTestCase(findTestCase('Test Cases/NewIn_Page/TC_70(Verify_User_RedirectTo_NewInPage)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/NewIN_Page/Dropdown_category_filter'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Checkbox_category_filter_option'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Dropdown_Brand_filter'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Checkbox_Brand_filter'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Drodown_dietary_filter'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Checkbox_dietary_filter_value'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/NewIN_Page/Text_Filter_SelectedCategory_NewInPage')) == true : "Assert passed."
	}

	@Keyword
	def addToFavouriteFromNewIN() {

		WebUI.click(findTestObject('Object Repository/NewIN_Page/Link_NewIn_page'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Button_add_toFav_NewIN'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Button_cross_AddFavPopUp'))
		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_MyFavIcon'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/NewIN_Page/Text_AddedProductInFavPage')) == true

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))
	}


	@Keyword
	def redirectToPDPPageFromNewIn() {

		WebUI.callTestCase(findTestCase('Test Cases/NewIn_Page/TC_70(Verify_User_RedirectTo_NewInPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Link_clickOnFirstProductNewInPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/NewIN_Page/Text_ProductName_PDP')) == true : "Assert passed."
	}

	@Keyword
	def viewProductInModeListView() {
		WebUI.callTestCase(findTestCase('Test Cases/NewIn_Page/TC_70(Verify_User_RedirectTo_NewInPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Button_filter_design_modelist'))
	}

	@Keyword
	def clickOnLoadMoreNewINPage() {
		WebUI.callTestCase(findTestCase('Test Cases/NewIn_Page/TC_70(Verify_User_RedirectTo_NewInPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Link_LoadMoreOfNewIN'))
	}

	@Keyword
	def clickOnShowMoreLinkNewINPage() {
		WebUI.callTestCase(findTestCase('Test Cases/NewIn_Page/TC_70(Verify_User_RedirectTo_NewInPage)'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.scrollToElement(findTestObject('Object Repository/NewIN_Page/Link_ShowMore'), 3)
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Link_ShowMore'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/NewIN_Page/Link_showLess_NewINPage'))
	}
	@Keyword
	def clickonShowLessLinkNewInPage() {
		WebUI.callTestCase(findTestCase('Test Cases/NewIn_Page/TC_80(Verify_User_Clicks_ShowMore_LinkAtNewInPage )'),[:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Link_showLess_NewINPage'))
	}
}