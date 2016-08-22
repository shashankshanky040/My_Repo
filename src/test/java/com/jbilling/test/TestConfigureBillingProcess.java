package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AccountTypeField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.CollectionAgeingStep;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.textutilities.TextUtilities;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class }) @Test(groups = {"automation"})
public class TestConfigureBillingProcess extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Test Data Preparation for Billing Process
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.7 : Test Data Preparation for Billing Process")
	public void testConfigureBillingProcess() throws Exception {

		TestConfigureBillingProcess.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047248");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestConfigureBillingProcess.logger.debug("Navigate to Configuration Page");

		// Switching to Billing Process configuration item
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.BillingProcess);
		TestConfigureBillingProcess.logger.debug("Switching to Billing Process configuration item");

		// Add Billing Process
		this.confPage = this.confPage.addBillingProcess("BillingProcess", "cbp");
		TestConfigureBillingProcess.logger.debug("Add Billing Process");

		// Verify Text:Billing configuration saved successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Billing configuration", "saved successfully", TextComparators.contains);
		TestConfigureBillingProcess.logger.debug("Billing configuration saved successfully");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestConfigureBillingProcess.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestConfigureBillingProcess.logger.exitMethod();
	}
}