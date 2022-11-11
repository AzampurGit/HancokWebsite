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

public class WishlistPage {

	@Keyword
	def addproductIntoWishlistWithoutLogin() {

		WebUI.click(findTestObject('Object Repository/HomePage/Button_Add_toFavourite'))

		if(GlobalVariable.CustomerLoginText == WebUI.getText(findTestObject('Object Repository/WishlistPage/Text_Login'))) {
			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def addProductIntoWishlistWithLogin() {

		WebUI.click(findTestObject('Object Repository/NewIN_Page/Link_NewIn_page'))

		WebUI.click(findTestObject('Object Repository/HomePage/Button_Add_toFavourite'))

		WebUI.click(findTestObject('Object Repository/WishlistPage/Button_closeFromPopup'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_MyFavIcon'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/NewIN_Page/Text_AddedProductInFavPage')) == true :"Assert passed."

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))
	}

	@Keyword
	def removeProductFromFavouriteList() {


		WebUI.click(findTestObject('Object Repository/NewIN_Page/Link_NewIn_page'))

		WebUI.click(findTestObject('Object Repository/NewIN_Page/Button_add_toFav_NewIN'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Button_cross_AddFavPopUp'))

		WebUI.click(findTestObject('Object Repository/WishlistPage/Fav_list_icon'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/WishlistPage/Text_SucessMessage_deleteProductFromFavList')) == true : "Assert passed."
	}
}