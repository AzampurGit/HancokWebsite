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

public class EditAccountInformation {

	@Keyword
	def  redirectToEditAccountPage() {

		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForPageLoad(0)

		WebUI.waitForElementVisible(findTestObject('Object Repository/EditAccountInformation_Page/Link_EditAccount'),5);

		WebUI.click(findTestObject('Object Repository/EditAccountInformation_Page/Link_EditAccount'))

		if(GlobalVariable.EditAccountLabel == WebUI.getText(findTestObject('EditAccountInformation_Page/Text_Edit_account_page'))) {
			assert true
		}

		else {
			assert false
		}
	}

	@Keyword
	def updateFirstLastName() {

		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.callTestCase(findTestCase('EditAccountInformation/TC_05(Verify_User_Navigates_To_Edit_Account_Information_Page)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.clearText(findTestObject('EditAccountInformation_Page/TextField_FirstName'))

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_FirstName'), GlobalVariable.FirstNameUpdate)

		WebUI.clearText(findTestObject('EditAccountInformation_Page/TextField_LastName'))

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_LastName'), GlobalVariable.LastnameUpdate)

		WebUI.click(findTestObject('EditAccountInformation_Page/Button_Save'))

		WebUI.waitForPageLoad(GlobalVariable.waitTime)

		if (GlobalVariable.SavedAccountInformation == WebUI.getText(findTestObject('EditAccountInformation_Page/Text_sucessMessageSaved AccInformation'))) {

			assert true
		}

		else {
			assert false
		}
	}

	@Keyword
	def updatebusinesstypeConfectfield() {

		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForPageLoad(GlobalVariable.waitTime)

		WebUI.click(findTestObject('EditAccountInformation_Page/Link_EditAccount'))

		WebUI.selectOptionByIndex(findTestObject('EditAccountInformation_Page/Dropdown_Business_type'), GlobalVariable.DropdownIndexNumber)

		WebUI.click(findTestObject('EditAccountInformation_Page/Button_Save'))

		if (GlobalVariable.SavedAccountInformation == WebUI.getText(findTestObject('EditAccountInformation_Page/Text_sucessMessageSaved AccInformation'))) {

			assert true
		}

		else {
			assert false
		}
	}

	@Keyword
	def updateEmailid() {

		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForPageLoad(GlobalVariable.waitTime)

		WebUI.click(findTestObject('EditAccountInformation_Page/Link_EditAccount'))

		WebUI.click(findTestObject('EditAccountInformation_Page/Checkbox_EmailAddress'))

		WebUI.clearText(findTestObject('EditAccountInformation_Page/TextField_EmailAddress'))

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_EmailAddress'), GlobalVariable.EmailUpdate)

		WebUI.clearText(findTestObject('EditAccountInformation_Page/TextField_password'))

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_password'), GlobalVariable.PasswordUpdate)

		WebUI.click(findTestObject('EditAccountInformation_Page/Button_Save'))

		if (GlobalVariable.SavedAccountInformation == WebUI.getText(findTestObject('EditAccountInformation_Page/Text_sucessMessageSaved AccInformation'))) {

			assert true
		}

		else {
			assert false
		}
	}

	@Keyword
	def updatePassword() {

		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		//WebUI.waitForPageLoad(GlobalVariable.waitTime)

		WebUI.click(findTestObject('EditAccountInformation_Page/Link_EditAccount'))

		WebUI.click(findTestObject('Object Repository/EditAccountInformation_Page/CheckBox_changePassword'))

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_password'), GlobalVariable.PasswordUpdate)

		WebUI.sendKeys(findTestObject('Object Repository/EditAccountInformation_Page/TextBox_NewPassword_EditAccountPage'), GlobalVariable.PasswordUpdate)

		WebUI.sendKeys(findTestObject('Object Repository/EditAccountInformation_Page/TextBox_ConfirmPassword_EditAccountPage'), GlobalVariable.PasswordUpdate)

		WebUI.click(findTestObject('EditAccountInformation_Page/Button_Save'))

		if (GlobalVariable.SavedAccountInformation == WebUI.getText(findTestObject('EditAccountInformation_Page/Text_sucessMessageSaved AccInformation'))) {

			assert true
		}

		else {
			assert false
		}
	}

	@Keyword
	def redirectToEmailSubscrPage() {

		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForPageLoad(GlobalVariable.waitTime)

		WebUI.click(findTestObject('EditAccountInformation_Page/Link_EditAccount'))

		WebUI.clearText(findTestObject('EditAccountInformation_Page/TextField_password'))

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_password'), GlobalVariable.PasswordUpdate)

		WebUI.click(findTestObject('EditAccountInformation_Page/Button_Save'))

		if (GlobalVariable.EmailSubscPageText == WebUI.getText(findTestObject('Object Repository/EditAccountInformation_Page/Text_EmailSubscription_EditAccInfPage')) ) {

			assert true
		}

		else {

			assert false
		}
	}

	@Keyword
	def redirectToEditDefaultBillingAddressPage() {

		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('EditAccountInformation_Page/Link_default_billingAddress'))

		if (GlobalVariable.TextEditAddress == WebUI.getText(findTestObject('Object Repository/EditAccountInformation_Page/Text_EditAddressPage'))) {

			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def updateDefaultBillAddress() {
		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('EditAccountInformation_Page/Link_default_billingAddress'))

		WebUI.clearText(findTestObject('EditAccountInformation_Page/TextField_Phone_Number'))

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_Phone_Number'), GlobalVariable.Default_billing_Edit_phone_number)

		WebUI.click(findTestObject('EditAccountInformation_Page/Button_Save_Address'))

		if(GlobalVariable.Text_Save_New_Address == WebUI.getText(findTestObject('Object Repository/EditAccountInformation_Page/Text_Save_Address_sucessMessage'))) {
			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def redirectToEditDefaultDeliveryAddressPage() {
		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('EditAccountInformation_Page/Link_Default_Delivery_Address'))

		if(GlobalVariable.TextEditAddress == WebUI.getText(findTestObject('EditAccountInformation_Page/Text_Edit_Address_default_deliveryAddress'))) {
			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def updateDefaultDeliveryAddress() {

		WebUI.callTestCase(findTestCase('EditAccountInformation/TC_13(Verify_User_redirectsTo_EditAddressPage_ToEdit_DefaultDeliveryAddress)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_Default_Address_City'), GlobalVariable.Edit_Delivery_Address_Edit_City)

		WebUI.click(findTestObject('EditAccountInformation_Page/Button_Delivery_Save_Address'))

		if(GlobalVariable.Text_Save_New_Address == WebUI.getText(findTestObject('Object Repository/EditAccountInformation_Page/Text_Save_Address_sucessMessage'))) {
			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def redirectToAddressBookPage() {
		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('EditAccountInformation_Page/Link_Manage_Address'))

		if(GlobalVariable.Address_Book_Text == WebUI.getText(findTestObject('EditAccountInformation_Page/Text_AddressBook'))) {
			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def addNewAddress() {

		WebUI.callTestCase(findTestCase('EditAccountInformation/TC_15(Verify_User_RedirectsTo_AddressBook_Page)'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('EditAccountInformation_Page/Button_Add_New _Address'))

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_Phone_Number'), GlobalVariable.Add_New_Addres_PhoneNumber)

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_AddNew_Address_StreetAddress'), GlobalVariable.AddNew_Address_Street_Address)

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/TextField_Add_newAddress_Country'), GlobalVariable.AddNew_Address_Country)

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/AddNew_Address_Town'), GlobalVariable.AddNew_Address_town)

		WebUI.sendKeys(findTestObject('EditAccountInformation_Page/AddNew_Address_Zip'), GlobalVariable.AddNew_Address_zip)

		WebUI.click(findTestObject('EditAccountInformation_Page/Button_Save'))

		if (GlobalVariable.Text_Save_New_Address == WebUI.getText(findTestObject('EditAccountInformation_Page/GetText'))) {
			assert true
		} else {
			assert false
		}
	}

	@Keyword
	def redirectToAddressBook() {

		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('EditAccountInformation_Page/Link_AddressBook'))

		if(GlobalVariable.Address_Book_Text == WebUI.getText(findTestObject('EditAccountInformation_Page/Text_AddressBook'))) {
			assert true
		}
		else {
			assert false
		}
	}

	@Keyword
	def redirectToAccountInfPage() {

		WebUI.callTestCase(findTestCase('Login/TC_04(Verify_User_Can_Login_With_Valid_Credentials)'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('EditAccountInformation_Page/Link_AccountInformation'))

		if(GlobalVariable.EditAccountLabel == WebUI.getText(findTestObject('EditAccountInformation_Page/Text_Edit_account_page'))) {
			assert true
		}

		else {
			assert false
		}
	}


	@Keyword
	def updateCompanyNameInAccountPage() {

		WebUI.callTestCase(findTestCase('EditAccountInformation/TC_31(Verify_User_redirectTo_AccInfPage_whileClickOn_AccInformtionLink)'), [:], FailureHandling.STOP_ON_FAILURE)
		WebUI.clearText(findTestObject('Object Repository/EditAccountInformation_Page/TextBox_CompanyName_EditAccountPage'))
		WebUI.sendKeys(findTestObject('Object Repository/EditAccountInformation_Page/TextBox_CompanyName_EditAccountPage'), GlobalVariable.CompanyName)
		WebUI.click(findTestObject('EditAccountInformation_Page/Checkbox_Account_inf_Allow_remote_option'))

		WebUI.click(findTestObject('Object Repository/EditAccountInformation_Page/Button_Save'))

		if (GlobalVariable.SavedAccountInformation == WebUI.getText(findTestObject('EditAccountInformation_Page/Text_sucessMessageSaved AccInformation'))) {

			assert true
		}

		else {
			d
			assert false
		}
	}
}
