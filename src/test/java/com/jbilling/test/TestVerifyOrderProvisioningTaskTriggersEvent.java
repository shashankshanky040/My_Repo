package com.jbilling.test;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class TestVerifyOrderProvisioningTaskTriggersEvent extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	ITestResult result;

	/**
	 * Verify Order Provisioning Task Triggers Event
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 8.1 : Verify Order Provisioning Task Triggers Event")
	public void testVerifyOrderProvisioningTaskTriggersEvent() throws Exception {

		TestVerifyOrderProvisioningTaskTriggersEvent.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909911");

		// Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestVerifyOrderProvisioningTaskTriggersEvent.logger.debug("Navigate to Configuration Page");

		// Initiate And Complete The Process To Add The Plugin
		this.productsPage = this.productsPage.addPlugin("addPlugin", "ap");
		TestVerifyOrderProvisioningTaskTriggersEvent.logger.debug("Add The Plugin");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestVerifyOrderProvisioningTaskTriggersEvent.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerToAddOrder("");
		TestVerifyOrderProvisioningTaskTriggersEvent.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process To Add And Edit Customer With SIM
		this.ordersPage = this.customerPage.addAndEditCustomerWithSIM("createOrder", "co", this.pr.readTestData("TC_3.4_IDENTIFIER_TWO"));
		TestVerifyOrderProvisioningTaskTriggersEvent.logger.debug("Add And Edit Customer With SIM");

		// Click On Provisioning Button
		this.ordersPage = this.ordersPage.clickProvisioningButton();
		TestVerifyOrderProvisioningTaskTriggersEvent.logger.debug("Click On Provisioning Button");

		// Click On Provisioning Tab
		this.ordersPage = this.ordersPage.clickProvisioningTab();
		TestVerifyOrderProvisioningTaskTriggersEvent.logger.debug("Click On Provisioning Tab");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		TestVerifyOrderProvisioningTaskTriggersEvent.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestVerifyOrderProvisioningTaskTriggersEvent.logger.exitMethod();
	}

}
