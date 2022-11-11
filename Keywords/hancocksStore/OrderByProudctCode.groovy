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

public class OrderByProudctCode {

	@Keyword
	def redirectToOrderByProductCodePage() {

		WebUI.click(findTestObject('Object Repository/OrderByProduct_code/Redirection_Order_by_Product_code'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/OrderByProduct_code/Text_Order_By_ProductCodePage')) == true : "Assert passed."
	}

	@Keyword
	def addProductToCartThroughorderByProductCode() {
		WebUI.callTestCase(findTestCase('Test Cases/OrderByProductCode/TC_54(Verify_User_RedirectsToOrderByProductCodePage_FromMyAccount)'),  [:],FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/OrderByProduct_code/TextBox_Product_code'), GlobalVariable.Product_code)
		WebUI.sendKeys(findTestObject('Object Repository/OrderByProduct_code/Textbox_product_quantity'), GlobalVariable.Product_quantity)
		WebUI.click(findTestObject('Object Repository/OrderByProduct_code/Button_Add_row_product_code'))
		WebUI.click(findTestObject('Object Repository/OrderByProduct_code/Button_Add_to_trolley'))
	
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/OrderByProduct_code/Sucess_Msg_add_Product_withProductCode'))
		
		WebUI.click(findTestObject('Object Repository/MY_Favourites/Link_RemoveItem_From_TrolleyPage'))
	
			}

	@Keyword
	def removeRowforOrderProductCode() {
		WebUI.callTestCase(findTestCase('Test Cases/OrderByProductCode/TC_54(Verify_User_RedirectsToOrderByProductCodePage_FromMyAccount)'),  [:],FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/OrderByProduct_code/TextBox_Product_code'), GlobalVariable.Product_code)
		WebUI.sendKeys(findTestObject('Object Repository/OrderByProduct_code/Textbox_product_quantity'), GlobalVariable.Product_quantity)
		WebUI.click(findTestObject('Object Repository/OrderByProduct_code/Button_Add_row_product_code'))
		WebUI.click(findTestObject('Object Repository/OrderByProduct_code/Link_Remove_row'))
	}
}
