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

@Listeners({ TestRailsListener.class })
@Test(groups = {"automation"})
public class TestAddInfoToAccountType extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify ability to successfully add an Information Type to an Account Type
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.2 : Verify ability to successfully add an Information Type to an Account Type")
	public void testAddInfoToAccountType() throws Exception {

		TestAddInfoToAccountType.logger.enterMethod();
		Reporter.log("<br>Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047243");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestAddInfoToAccountType.logger.debug("Navigate to Configuration Page");

		// Add Information to Account Type
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.AccountType);
		this.confPage = this.confPage.selectAccountTypeName(this.pr.readTestData("TC_2.1_ACCOUNT_NAME_ONE"));
		TestAddInfoToAccountType.logger.debug("Add Information to Account Type");

		Reporter.log("<br> Enter information type name for account type " + this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"));
		String infoTypeName = this.confPage.addNewInformationToSelectedAccountType("AddInfoToAccountType", "aitac");
		this.propReader.updatePropertyInFile("TC_2.2_NAME", infoTypeName, "testData");
		TestAddInfoToAccountType.logger.debug("Enter information type name for account type");

		// Verify Text:Account Information Type Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Information Type", "created successfully",
				TextComparators.contains);
		TestAddInfoToAccountType.logger.debug("Account Information Type Is Created Successfully");

		// Validate Saved Account Information Type Test Data
		String accountInfo = this.pr.readTestData("TC_2.2_NAME");
		this.confPage = this.confPage.validatePeriodsSavedTestData(accountInfo);
		TestAddInfoToAccountType.logger.debug("Validate Saved Account Information Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestAddInfoToAccountType.logger.debug("Verify Current Page UI Component");

		TestAddInfoToAccountType.logger.debug("Verifying if account information type created successfully or not");

		Reporter.log("<br> Test Passed");
		TestAddInfoToAccountType.logger.exitMethod();
	}

	

}