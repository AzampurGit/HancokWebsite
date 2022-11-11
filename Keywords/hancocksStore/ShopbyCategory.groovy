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

public class ShopbyCategory {

	@Keyword
	def redirectToShopByCategoryPage() {
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))

		WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Breadcrumbs_getText_shopbycategory')) == true
	}

	@Keyword
	def openPDPPageFromShopByCategoryPage() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_category_firstProduct'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_ProductNameAtPDP_ShopByCategory')) == true : "Assert passed."
	}

	@Keyword
	def selectCategoryProductbyHovering() {

		WebUI.mouseOver(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		WebUI.mouseOver(findTestObject('Object Repository/ShopByCategory_Page/Link_hover_pickandMix'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_hover_Top50pick'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_SelectProductByHovering')) == true : "Assert passed."
	}

	@Keyword
	def productDropdownfilters() {
		WebUI.callTestCase(findTestCase('Test Cases/ShopByCategoryPage/TC_84(Verify_User_selectProductByHoveringonShopBycategoryItems)'), [:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/NewIN_Page/Dropdown_filterOfProducts'))
		WebUI.selectOptionByIndex(findTestObject('Object Repository/NewIN_Page/Dropdown_filterOfProducts'), 5)
	}
	@Keyword
	def categoryByShopFiltersForProducts() {
		WebUI.callTestCase(findTestCase('Test Cases/ShopByCategoryPage/TC_82(Verify_User_RedirectsToShopByCategoryPage)'), [:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Dropdown_filter_Brand_CategPage'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Checkbox_filter_brand_CategPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_BrandFilter_Name_AtNewInPage')) == true : "Assert passed."
	}
	@Keyword

	def addproductIntoFavPageFromNewInPage() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Button_Fav_product_CategPage'))
		WebUI.click(findTestObject('Object Repository/MY_Favourites/Button_cross_AddFavPopUp'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_MyFavIcon'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_ProductNameAtPDP_ShopByCategory')) == true :"Assert passed."

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))
	}

	@Keyword
	def openPDPFromCategoryPage() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_firstProduct_CategPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_ProductNameAtPDP_ShopByCategory')) == true : "Assert passed."
	}

	@Keyword
	def viewProductsInGridNewInPage() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Button_GridViewProducts_NewInPage'))
	}

	@Keyword
	def redirectToPDPClickONProdcutImageAtCategPage() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ProductImage_CategPage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_ProductNameAtPDP_ShopByCategory')) == true : "Assert passed."
	}

	@Keyword
	def clickLoadMoreLinkCategPage() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_LoadMore_CategPage'))
		WebUI.scrollToElement(findTestObject('Object Repository/ShopByCategory_Page/Link_LoadMore_CategPage'), 15)
		println(WebUI.getUrl())
	}

	@Keyword
	def increaseDecreaseQuantityOfProductAtCategoryPage() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Button_Increase_Quantity_CategPage'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Button_decrease_CategPage'))
	}

	@Keyword
	def addToTrolleyFromCategPage() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Button_AddToTrolleyCatePage'))

		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Cart_icon'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_AddedProduct_Minicart_CategoryPage'))
		WebUI.click(findTestObject('Object Repository/Cart_Page/Link_Cart_icon'))

		WebUI.click(findTestObject('Object Repository/MiniCart/Button_view_trolley'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_RemoveItem_From_TrolleyPage'))
	}

	@Keyword
	def clickOnShowStockForCollectionCategPage() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Button_ShowStocKForCollectionCategPage'), 4)
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Button_ShowStocKForCollectionCategPage'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Radio_Select_Birmingham_ShowStockcllectoin_Category'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_ShowStockForCollection_ShopByCategoryPage')) == true
	}

	@Keyword
	def openMiniCartCategPage() {

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_MiniCart_icon'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_Minicart_Empty')) == true :"Assert passed."
	}

	@Keyword
	def clickOnMoreInformationAtPDPCategPage() {

		if(WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_ShopBycategory'))
		}
		else if	(WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Button_PickAndMix_ShopByCategory'))) {
			WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Button_PickAndMix_ShopByCategory'))
		}
		else {
			WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Button_Choclate_ShopBycategory'))
		}

		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_firstProduct_CategPage'))
		WebUI.click(findTestObject('Object Repository/ShopByCategory_Page/Link_MoreInformation'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/ShopByCategory_Page/Text_MoreInformationLink_PDP_CategoryPage')) == true : "Assert passed."
	}
}
