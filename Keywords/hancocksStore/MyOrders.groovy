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

public class MyOrders {

	@Keyword
	def redirectToMyOrdersPage() {
		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('MyOrders_Page/Link_My_Orders'))

		if(GlobalVariable.Text_MyOrderPage == WebUI.getText(findTestObject('Object Repository/MyOrders_Page/Text_MyOrder'))) {

			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def viewSelectedOrder() {

		WebUI.callTestCase(findTestCase('MyOrders/TC_17(Verify_User_redirects_To_MyOrder_Page)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/MyOrders_Page/Link_View_Order'))

		WebUI.getText(findTestObject('Object Repository/MyOrders_Page/Text_View_Order'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MyOrders_Page/Text_View_Order')) == true : "Assert passed."
	}

	@Keyword
	def reorderFromViewOrdersPage() {

		WebUI.callTestCase(findTestCase('MyOrders/TC_17(Verify_User_redirects_To_MyOrder_Page)'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/MyOrders_Page/Link_Reorder'))

		if(GlobalVariable.TextShopingTrolleyPage == WebUI.getText(findTestObject('Object Repository/MyOrders_Page/Text_ShoppingTrolleyPage'))) {
			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def printOrderLink() {
		WebUI.callTestCase(findTestCase('MyOrders/TC_18(Verify_User_view_Order_From_MyOrderPage)'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/MyOrders_Page/Link_Print_Order'))
	}

	@Keyword
	def paginationAtMyOrderPage() {

		WebUI.callTestCase(findTestCase('MyOrders/TC_17(Verify_User_redirects_To_MyOrder_Page)'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/MyOrders_Page/Link_Pagination'), GlobalVariable.DropdownIndexNumber)

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/MyOrders_Page/Link_Pagination')) == true : "Assertion passed."
	}
}