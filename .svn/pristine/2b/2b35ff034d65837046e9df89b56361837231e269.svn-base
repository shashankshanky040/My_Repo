package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class }) @Test(groups = {"automation"})
public class TestConfigurePluginPreferencesForCommission extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify that user can configure the plug-in and preference required for
	 * running a comission process
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 16.3 : Verify that user can configure the plug-in "
			+ "and preference required for running a comission process")
	public void testConfigurePluginPreferencesForCommission() throws Exception {

		TestConfigurePluginPreferencesForCommission.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909929");

		// Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestConfigurePluginPreferencesForCommission.logger.debug("Navigate to Configuration Page");

		// Initiate And Complete The Process To Add The Plugin
		this.productsPage = this.productsPage.addPlugin("addPlugin", "ap");
		TestConfigurePluginPreferencesForCommission.logger.debug("Add The Plugin");

		// Select Configuration All
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.All);
		TestConfigurePluginPreferencesForCommission.logger.debug("Select Configuration All ");

		// Update And Verify Preference
		this.confPage = this.confPage.updatePreference("updatePreference", "up");
		TestConfigurePluginPreferencesForCommission.logger.debug("Update And Verify Preference");

		// Verify Current Page UI Component
		this.productsPage = this.productsPage.verifyUIComponent();
		TestConfigurePluginPreferencesForCommission.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestConfigurePluginPreferencesForCommission.logger.exitMethod();
	}

}