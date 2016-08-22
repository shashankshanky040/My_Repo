package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class TestChangeOrderFeature extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify Order Changes feature works correctly
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 7.1 : Verify Order Changes feature works correctly")
	public void testChangeOrderFeature() throws Exception {
		TestChangeOrderFeature.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909910");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestChangeOrderFeature.logger.debug("Navigate to Customers Page");

		// Initiate And Complete The Process To Add a New Customer
		String xyz = this.customerPage.addCustomer(this.pr.readTestData("TC_2.1_ACCOUNT_NAME_ONE"),
				this.pr.readTestData("TC_2.1.1_METHOD_NAME_ONE"), "new_customer", "nc");
		TestChangeOrderFeature.logger.debug("Add a New Customer");

		// Initiate And Complete The Process Of Creating Order For Selected
		// Customer
		this.customerPage = this.customerPage.clickCreateOrder();
		this.ordersPage = this.customerPage.createOrderForCustomer("Customer A", "ca");
		TestChangeOrderFeature.logger.debug("Create Order For Selected Customer");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		TestChangeOrderFeature.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestChangeOrderFeature.logger.exitMethod();
	}

}