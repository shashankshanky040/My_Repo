package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AccountTypeField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = {"automation"})
public class TestAddAccountType extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify ability to successfully configure and edit Account Types
	 * "Direct Customer" & "Distributor Account" >> Verify the ability to set
	 * Jasper invoice design as default for invoice download
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 2.1 : Verify ability to successfully configure and edit Account Types "
			+ "\"Direct Customer\" & \"Distributor Account\" >> Verify the ability to set Jasper"
			+ " invoice design as default for invoice download")
	public void testAddAccountType() throws Exception {
		TestAddAccountType.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047241");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestAddAccountType.logger.debug("Navigate to Configuration Page");

		// Set Configuration Preference Value
		this.confPage = this.confPage.setConfigurationPreference("setPreferenceValue", "pc");
		TestAddAccountType.logger.debug("Set Configuration Preference Value");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		TestAddAccountType.logger.debug("Select Configuration");

		// Add First Account Type
		String accountName = this.confPage.createAccountType("addAccountType", "aat");
		this.propReader.updatePropertyInFile("TC_2.1_ACCOUNT_NAME_ONE", accountName, "testData");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		TestAddAccountType.logger.debug("Select Configuration");

		// Add Second Account Type
		accountName = this.confPage.createAccountType("addSecondAccountType", "aat");
		this.propReader.updatePropertyInFile("TC_2.1_ACCOUNT_NAME_TWO", accountName, "testData");

		// Edit Second Account Type
		accountName = this.confPage.editAccountType(AccountTypeField.ACCOUNT_NAME, "addAccountType", "aat");
		TestAddAccountType.logger.debug("Edit Second Account Type");

		this.propReader.updatePropertyInFile("TC_2.1_ACCOUNT_NAME_TWO_EDIT", accountName, "testData");

		// Verify Text: Account Type Updated Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Type", "updated successfully", TextComparators.contains);
		TestAddAccountType.logger.debug("Verify Text: Account Type Updated Successfully");

		// Validate Saved Account Type Test Data
		String accountType = this.propReader.readPropertyFromFile("TC_2.1_ACCOUNT_NAME_TWO_EDIT", "testData");
		this.confPage = this.confPage.validatePeriodsSavedTestData(accountType);
		
		TestAddAccountType.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestAddAccountType.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestAddAccountType.logger.exitMethod();
	}

}