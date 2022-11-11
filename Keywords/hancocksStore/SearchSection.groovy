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

public class SearchSection {


	@Keyword
	def searchProduct() {

		WebUI.sendKeys(findTestObject('Object Repository/SearchSection/Textbox_Search'), GlobalVariable.ProductName)

		WebUI.click(findTestObject('Object Repository/SearchSection/Button_Search'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/SearchSection/Text_HariboGaint_AtSearch')) == true : "Assert passed."
	}

	@Keyword
	def searchProductWithSKU() {

		WebUI.sendKeys(findTestObject('Object Repository/SearchSection/Textbox_Search'),GlobalVariable.ProductSKU )

		WebUI.click(findTestObject('Object Repository/SearchSection/Button_Search'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/SearchSection/Text_HariboGaint_AtSearch')) == true : "Assert passed."
	}

	@Keyword
	def clickOnAddToTrolleyFromSearchSuggestion() {

		WebUI.sendKeys(findTestObject('Object Repository/SearchSection/Textbox_Search'), GlobalVariable.ProductName)

		WebUI.click(findTestObject('Object Repository/SearchSection/Button_addToTrolley_SearchSuggestions'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/SearchSection/Text_AddedHariboProductInCart_FromSearch')) == true : "Assert passed."
	}

	@Keyword
	def ViewMoreResultsFromSearchSuggestion() {

		WebUI.sendKeys(findTestObject('Object Repository/SearchSection/Textbox_Search'),GlobalVariable.ProductNameHalf )

		WebUI.click(findTestObject('Object Repository/SearchSection/Link_viewMoreResults_SearchSugg'))
	}
}
