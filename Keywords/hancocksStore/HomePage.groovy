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

public class HomePage {
	@Keyword
	def redirectToHomePage() {

		WebUI.click(findTestObject('Object Repository/HomePage/Link_HomePage_Logo'))

		if(WebUI.getWindowTitle() == GlobalVariable.Staging_url) {
			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def clickOnPreviousForwardButtonOnBannerImage() {

		WebUI.click(findTestObject('Object Repository/HomePage/Button_previous'))

		WebUI.click(findTestObject('Object Repository/HomePage/Button_Next'))
	}

	@Keyword
	def clickOnRadioBtnAtBannerImage() {

		WebUI.click(findTestObject('Object Repository/HomePage/Radio_buttons_Banner_Image'))
	}

	@Keyword
	def ScrollForwardBackwardButtonsOfHomePageProducts() {

		WebUI.click(findTestObject('Object Repository/HomePage/Scroller_buttons_left'))

		WebUI.click(findTestObject('Object Repository/HomePage/Scroller_buttons_right'))
	}

	@Keyword
	def openPDPpageofFirstProduct() {


		WebUI.click(findTestObject('Object Repository/HomePage/Link_First_product_homePage'))

		WebUI.waitForPageLoad(0)

		if(GlobalVariable.PDP_Page_Text == WebUI.getText(findTestObject('Object Repository/HomePage/Page_PDP_redirection'))) {
			assert true
		}
		else
			assert false
	}

	@Keyword
	def addToFavouriteFromHomePage() {


		WebUI.click(findTestObject('Object Repository/HomePage/Link_HomePage_Logo'))

		WebUI.click(findTestObject('Object Repository/HomePage/Button_Add_toFavourite'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Button_cross_AddFavPopUp'))

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_MyFavIcon'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/HomePage/Link_ProductName_FavListPage'))== true : "Assertion passed"

		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_Remove_item_From_MyFavPage'))
	}

	@Keyword
	def addToCartOfFirstProductFromHomePage() {

		WebUI.click(findTestObject('Object Repository/HomePage/Button_add_To cart'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/HomePage/MiniCart_Addedproduct')) == true : "Assert passed."
	}

	@Keyword
	def increaseOrdecreaseQuantityOfProduct() {

		WebUI.click(findTestObject('Object Repository/HomePage/Button_increase_quantity'))
		WebUI.click(findTestObject('Object Repository/HomePage/Button_decrease_quantity'))
	}

	@Keyword
	def clickOnImageShopNowAtHomePage() {

		WebUI.click(findTestObject('Object Repository/HomePage/Link_HomePage_Logo'))

		WebUI.click(findTestObject('Object Repository/HomePage/Image_shop_now_homepage'))
	}

	@Keyword

	def clickOnReadMoreLink() {

		WebUI.click(findTestObject('Object Repository/HomePage/Link_Read_more'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/HomePage/Text_AboutHancocks')) == true : "Assert passed."
	}

	@Keyword
	def expandBrandSectionAtHomePage() {

		WebUI.click(findTestObject('Object Repository/HomePage/Link_Expand_OurBrand_HomePage'))

		WebUI.waitForElementVisible(findTestObject('Object Repository/HomePage/Image_OurBrand'), 5)
		
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/HomePage/Image_OurBrand')) == true : "Assert passed."
	}


	@Keyword
	def viewReturnPolicyInformationAtHomePage() {

		WebUI.mouseOver(findTestObject('Login_Page/MouseOver_SignInButton'))
		WebUI.click(findTestObject('Object Repository/HomePage/Link_ReturnPolicyInformation_Homepage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/HomePage/Text_ReturnPolicy_HomePage')) == true : "Assert passed."
	}

	@Keyword
	def returnToHomePageFromReturnPolicyPage() {
		WebUI.callTestCase(findTestCase('Test Cases/Home_Page/TC_169(Verify_User_View_ReturnPolicyInformation_AtHomePageFromSigninHovering)'), [:],FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/HomePage/Link_Breadcrumbs_Home_ReturnPolicyPage'))
	}
}
