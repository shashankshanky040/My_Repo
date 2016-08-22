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
public class TestConfigureCollectionPlugins extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * 
	 * Verify ability to configure Collections Plugins
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.6 : Verify ability to configure Collections Plugins")
	public void testConfigureCollectionPlugins() throws Exception {
		TestConfigureCollectionPlugins.logger.enterMethod();
		Reporter.log("Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047247");

		Reporter.log("<br> Get ID Generated for Second Step");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestConfigureCollectionPlugins.logger.debug("Navigate to Configuration Page");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Users);
		TestConfigureCollectionPlugins.logger.debug("Select Configuration");

		// Configure Permissions for Plugins
		String userName = this.pr.readTestData("TC_1.1_CREDENTIALS_USERNAME");
		this.confPage = this.confPage.configurePluginPermissions(userName, "plugin", "pid");
		TestConfigureCollectionPlugins.logger.debug("Configure Permissions for Plugins");

		// Navigate to Configuration Tab
	
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestConfigureCollectionPlugins.logger.debug("Navigate to Configuration Page");

		// Add Plugin in Collections
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Plugins);
		TestConfigureCollectionPlugins.logger.debug("Add Plugin in Collections");

		// Select Plugin Category
		this.confPage = this.confPage.selectPluginCategory("selectPluginCategory", "pc");
		TestConfigureCollectionPlugins.logger.debug("Select Plugin Category");

		// Add Plugin Under Generic Category
		this.confPage = this.confPage.addNewPluginInCategory("addPlugin", "ap", this.runTimeVariables);
		TestConfigureCollectionPlugins.logger.debug("Add Plugin Under Generic Category");

		// Verify Text:The new plugin with id has been saved successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("The new plug-in with id", "has been saved.", TextComparators.contains);
		TestConfigureCollectionPlugins.logger.debug("Verify Text:The new plugin with id has been saved successfully");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestConfigureCollectionPlugins.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestConfigureCollectionPlugins.logger.exitMethod();
	}
}