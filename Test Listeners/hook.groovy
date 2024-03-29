import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.util.KeywordUtil
class hook {
	
	
		def openBrowser() {
			WebUI.openBrowser('https://stage.mobipaid.com/en/register')
			WebUI.maximizeWindow()
		}
		
		def closeBrowser() {
			WebUI.closeBrowser()
		}
		
		@BeforeTestCase
		def BeforeTestCase(TestCaseContext testCaseContext) {
			KeywordUtil.logInfo('Test Case: ' + testCaseContext.getTestCaseId())
			this.openBrowser()
			/* println testCaseContext.getTestCaseId()
			println testCaseContext.getTestCaseVariables() */
		}
	
		@AfterTestCase
		def AfterTestCase(TestCaseContext testCaseContext) {
			KeywordUtil.logInfo('Test Case: ' + testCaseContext.getTestCaseId() + ' | ' + testCaseContext.getTestCaseStatus())
			this.closeBrowser()
		}
	
		@BeforeTestSuite
		def BeforeTestSuite(TestSuiteContext testSuiteContext) {
			KeywordUtil.logInfo('Test Suite: ' + testSuiteContext.getTestSuiteId())
		}
	
		@AfterTestSuite
		def AfterTestSuite(TestSuiteContext testSuiteContext) {
			KeywordUtil.logInfo('Test Suite: ' + testSuiteContext.getTestSuiteId() + ' | ' + testSuiteContext.getStatus())
		}
	}
