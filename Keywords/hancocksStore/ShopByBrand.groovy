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

public class ShopByBrand {

	@Keyword
	def redirectsToShopByBrandPage() {

		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_ShopByBrand'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByBrand_Page/Text_ShopByBrandPage')) == true : "Assert passed."
	}

	@Keyword
	def ShopByBrandSearchFilters() {

		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_ShopByBrand'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Drodown_dietary_filter'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Checkbox_dietary_filter_value'))
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Dropdown_SweetType'))
		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Checkbox_sweetType_filter'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByBrand_Page/Text_dietaryFilter_shopbyBrand')) == true : "Assert passed."
	}

	@Keyword
	def redirectToPDPFromShopByBrandPage() {

		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_ShopByBrand'))
		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_ProductNameAt_shopByBrand'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByBrand_Page/Text_ProductHariboRhubarv_At_PDP_ShopbyBrand')) == true :"Assert passed."
	}

	@Keyword
	def selectCategoryAndProductByhovering() {

		WebUI.mouseOver(findTestObject('Object Repository/ShopByBrand_Page/Link_HoverOverShopByBrand'))
		WebUI.mouseOver(findTestObject('Object Repository/ShopByBrand_Page/Link_hover_shopByBrandCategory'))
		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_Hover_shopbyBrandCategorySubtype'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByBrand_Page/Text_Arizona_ShopByBrandPage')) == true : "Assert passed."
	}

	@Keyword
	def productDropdownFilterAtshopByBrandPage() {

		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_ShopByBrand'))
		WebUI.selectOptionByIndex(findTestObject('Object Repository/ShopByCategory_Page/Dropdown_product_filters'), 4)
	}

	@Keyword
	def addToFavFromShopByBrandPage() {

		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_ShopByBrand'))

		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Button_add_toFav'))
		WebUI.click(findTestObject('Object Repository/MY_Favourites/Button_cross_AddFavPopUp'))
		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_MyFavIcon'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_ProductName_AtFavPage_newInPage'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))
	}

	@Keyword
	def clickonImageOfProductAtShopByBrandPage() {
		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_ShopByBrand'))

		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_Product_Image_ShopByBrand'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByBrand_Page/Text_ProductHariboRhubarv_At_PDP_ShopbyBrand')) == true : "Assert passed."
	}

	@Keyword
	def clickOnLoadMoreShopByBrandPage() {

		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_ShopByBrand'))
		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_loadMore'))
	}

	@Keyword
	def increaseDecreaseQuantityOfProductShopByBrand() {

		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_ShopByBrand'))
		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Button_Increase_quantity'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Button_decrease_CategPage'))
		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Button_Increase_quantity'))
	}

	@Keyword
	def addProductsIntoCartFromShopByBrandPage() {

		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Link_ShopByBrand'))
		WebUI.click(findTestObject('Object Repository/ShopByBrand_Page/Button_add_toCart'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_AddedProduct_Minicart_CategoryPage')) == true : "Assert passed."
	}
}

