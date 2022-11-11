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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class MyFavourite {

	@Keyword
	def redirectToMyFavouritesPage() {

		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('My_Favourites/Link_My_Favourite'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MY_Favourites/Text_My_Fav_Page')) == true
	}

	@Keyword
	def addfirstProductToFavList() {
		WebUI.click(findTestObject('Object Repository/HomePage/Link_HomePage_Logo'))
		WebUI.click(findTestObject('Object Repository/HomePage/Button_Add_toFavourite'))
		WebUI.click(findTestObject('Object Repository/MY_Favourites/Button_cross_AddFavPopUp'))
		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_MyFavIcon'))
	}


	@Keyword
	def showFavouriteProductsOfShowStockDelivery() {

		WebUI.click(findTestObject('MY_Favourites/Button_viewFavProductsOfShowStockdelivery'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MY_Favourites/Text_My_Fav_Page')) == true

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))
	}

	@Keyword
	def showFavouriteProductsofShowStockCollection() {

		WebUI.click(findTestObject('MY_Favourites/Button_show_collection_prouducts'))

		WebUI.click(findTestObject('MY_Favourites/Radio_select_location'))

		assert WebUI.verifyElementVisible(findTestObject('MY_Favourites/Button_show_collection_prouducts')) == true : "Assertion passed."

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))
	}

	@Keyword
	def favProductRedirectToPdpPage() {

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Text_addedProduct_InFavList'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MY_Favourites/Text_ProductNameLink_MyFavourites'))	== true : "Assertion passed"

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_FavFrom_PDP'))
		
		WebUI.click(findTestObject('Object Repository/MY_Favourites/Button_cross_AddFavPopUp'))
	}

	@Keyword
	def increaseDecreaseQuantityOfFavProduct() {

		WebUI.click(findTestObject('My_Favourites/Button_increase_Quantity'))
		WebUI.click(findTestObject('My_Favourites/Button_decrease_Quantity'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))
	}

	@Keyword
	def addFavProductToTrolley() {

		WebUI.click(findTestObject('My_Favourites/Button_Add_to_Trolley'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MY_Favourites/Link_Prod_Name_InMiniCart')) == true : "Assert passed."

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))

		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Cart_icon'))

		WebUI.click(findTestObject('Object Repository/MiniCart/Button_view_trolley'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_RemoveItem_From_TrolleyPage'))
	}

	@Keyword
	def removeFavProduct() {


		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MY_Favourites/Text_ProductNameLink_MyFavourites')) == true : "Assert passed."
	}

	@Keyword
	def favouritePagePagination() {


		WebUI.selectOptionByIndex(findTestObject('My_Favourites/Dropdown_Fav_list_pagination'), GlobalVariable.DropdownIndexNumber)
	}
}
