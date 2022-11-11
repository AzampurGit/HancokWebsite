
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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class FooterLinks {

	@Keyword
	def redirectToFAQPageFromHomePageFooterlinks() {

		WebUI.click(findTestObject('Object Repository/Footer_links/Link_FAQ_FooterlinksHomepage'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_FAQ_FooterLinks')) == true : "Assert passed."
	}

	@Keyword
	def redirectToContactUsFromHomePageFooterLink() {

		WebUI.scrollToElement(findTestObject('Object Repository/Footer_links/Link_ContactUs_FooterLinks'), 2)
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_ContactUs_FooterLinks'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_ContactUs_FooterLinks_HomePage')) == true :"Assert passed."
	}

	@Keyword
	def redirectToDeliveryInformationPageFromHomePageFooterLink() {
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_DeliveryInformation_HomePageFooterLinks'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_DeliveryInformationPage_HomePageFooter')) == true :"Assert passed."
	}

	@Keyword
	def redirectToReturnPolicyPageFromHomePageFooter() {
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_Return_HomePageFooter'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_ReturnPolicyPageHomePageFooter')) == true
	}

	@Keyword
	def redirectToCovidInfPageFromHomePagefooter() {

		WebUI.click(findTestObject('Object Repository/Footer_links/Link_Covid-19_HomePageFooter'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_CovidInformation_HomePageFooters')) == true
	}

	@Keyword
	def redirectToClickAndCollectPageFromHomePageFooter() {
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_ClickAndCollect_HomePageFooters'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_ClickAndCollectPage_HomePagefooters')) == true
	}

	@Keyword
	def redirectToFindAStorePageFromHomePageFooterLinks() {
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_FindAStore_HomePageFooters'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_FindAStore_HomePageFooter')) == true
	}
	@Keyword

	def redirectToWholeSaleSweetsPageFromHomePageFooterLinks() {

		WebUI.click(findTestObject('Object Repository/Footer_links/Link_WholeSalesSweets_HomePageFooter'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_WholeSaleSweets_HomePageFooter')) == true
	}
	@Keyword
	def redirectToBespokePackagingPageFromHomePageFooter() {
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_BespokePack_PageFromHomePageFooter'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_bespoke_Pack_HomePageFooter')) == true : "Assert passed."
	}

	@Keyword
	def redirectToConfectionaryPageFromHomePageFooter() {
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_Confectionary_HomePageFooter'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_Confectionary_HomePageFooter')) == true :"Assert passed."
	}

	@Keyword
	def redirectToAboutUsFromHomePageFooter() {

		WebUI.click(findTestObject('Object Repository/Footer_links/Link_AboutUs_HomePageFooter'))
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_AboutUs_HomepageFooters')) == true
	}

	@Keyword
	def redirectToBlogFromHomePageFooter() {
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_Blog_HomePageFooter'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_Blog_HomePageFooter')) == true :"Assert passed."
	}
	@Keyword
	def redirectToCorporatePolicyPageFromHomePageFooter() {

		WebUI.click(findTestObject('Object Repository/Footer_links/Link_CorporatePolicy_HomePage_Footer'))
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_CorporatePolicy_HomePageFooter')) == true :"Assert passed."
	}

	@Keyword
	def redirectTofaceBookPageFromHomePageFooter() {
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_Facebook_HomePageFooter'))

		WebUI.switchToWindowIndex(1)
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Link_HomeButton_FacebookPage')) == true
	}

	@Keyword
	def redirectToInstagramPageFromHomePageFooter() {
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_instagram_HomePageFooter'))
		WebUI.switchToWindowIndex(1)
		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_Instgram_HomePageFooter'))
	}

	@Keyword
	def redirectToLinkedinPageFromHomePageFooter() {
		WebUI.click(findTestObject('Object Repository/Footer_links/Link_linkedin_HomepageFooter'))
		WebUI.switchToWindowIndex(1)

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_Linkedin_HomePageFooter')) == true
	}

	@Keyword
	def redirectToTwitterPageFromHomePageFooter() {

		WebUI.click(findTestObject('Object Repository/Footer_links/Link_Twitter_HomePageFooter'))

		WebUI.switchToWindowIndex(1)

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_Twitter_HomePageFooter')) == true
	}

	@Keyword
	def leaveFeedBackFromHomePageFooter() {

		WebUI.click(findTestObject('Object Repository/Footer_links/Button_feedback_HomepageFooter'))

		assert WebUI.verifyElementVisible(findTestObject('Object Repository/Footer_links/Text_feebackFromHomePageFooter')) == true : "Assert passed."
	}
}