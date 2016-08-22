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
public class TestCreateParentChildRelationInCustomersTab extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

/**
	 * Verify user can create a Parent/Child relationship within the Customer
	 * tab
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 6.2 : Verify user can create a Parent/Child relationship	within the Customer tab")
	public void testCreateParentChildRelationInCustomersTab() throws Exception {
		TestCreateParentChildRelationInCustomersTab.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909908");

		// Initiate And Complete The Process To Create a Child Customer
		String childCustomer = this.customerPage.addChildCustomer(this.pr.readTestData("TC_2.1_ACCOUNT_NAME_ONE"),
				this.pr.readTestData("TC_2.1.1_METHOD_NAME_ONE"), "addSecondCustomer", "ac");
		this.propReader.updatePropertyInFile("TC_6.2_CHILD_CUSTOMER_NAME", childCustomer, "testData");

		
		TestCreateParentChildRelationInCustomersTab.logger.debug("Create a Child Customer");

		// Verify Text:Customer Is Saved Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new customer", "successfully.", TextComparators.contains);
		TestCreateParentChildRelationInCustomersTab.logger.debug("Customer Is Saved Successfully");

		// Validate Saved New Customer Test Data
		this.customerPage = this.customerPage.validateSavedTestDataInTable(this.pr.readTestData("TC_6.2_CHILD_CUSTOMER_NAME"));
		TestCreateParentChildRelationInCustomersTab.logger.debug("Validate Saved New Customer Test Data");

		// Verify Current Page UI Component
		this.customerPage = this.customerPage.verifyUIComponent();
		TestCreateParentChildRelationInCustomersTab.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestCreateParentChildRelationInCustomersTab.logger.exitMethod();
	}
	
}
