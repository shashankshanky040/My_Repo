package com.jbilling.test;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class TestVerifyInvoiceGeneration extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	ITestResult result;

	/**
	 * Generating an Invoice (Manually)
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 10.1 : Generating an Invoice (Manually) ")
	public void testVerifyInvoiceGeneration() throws Exception {

		TestVerifyInvoiceGeneration.logger.enterMethod();
		Reporter.log("Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909915");

		// Navigate to Orders Page
		this.ordersPage = this.navPage.navigateToOrdersPage();
		TestVerifyInvoiceGeneration.logger.debug("Navigate to Orders Page");

		// Filter for customer
		String loginName = this.filtersPage.filterOnLoginNameOrCustomerName("testVerifyInvoiceGeneration", "tvig");
		TestVerifyInvoiceGeneration.logger.debug("Set Login Name Or Customer Name");

		// Verify Invoice Generation For Chosen Customer
		this.ordersPage = this.ordersPage.verifyInvoiceGenerationForChoosenCustomer(loginName);
		TestVerifyInvoiceGeneration.logger.debug("Verify Invoice Generation For Chosen Customers");

		if (this.paymentsPage.isReviewPaymentButtonAppeared() == false) {
			throw new Exception("On paying invoice, no review payment button appeared resulting " + "into consideration that "
					+ "payment invoice page never loaded");
		}

		Reporter.log("Test Passed");
		TestVerifyInvoiceGeneration.logger.exitMethod();
	}

}
