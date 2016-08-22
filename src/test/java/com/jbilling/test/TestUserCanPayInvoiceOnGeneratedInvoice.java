package com.jbilling.test;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class TestUserCanPayInvoiceOnGeneratedInvoice extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	ITestResult result;

	/**
	 * Verify user can pay invoice on a billing process generated invoice
	 * invoice is generated
	 * 
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 13.1 : Verify user can pay invoice on a billing process generated invoice")
	public void testUserCanPayInvoiceOnGeneratedInvoice() throws Exception {

		TestUserCanPayInvoiceOnGeneratedInvoice.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909923");

		// Login Into App And Navigate To Invoices Page
		this.invoicePage = this.navPage.navigateToInvoicesPage();
		TestUserCanPayInvoiceOnGeneratedInvoice.logger.debug("Navigate To Invoices Page");

		// Initiate And Complete The Process Of Pay Invoice
		this.invoicePage = this.invoicePage.payInvoice("payInvoice", "aa");
		TestUserCanPayInvoiceOnGeneratedInvoice.logger.debug("Pay Invoice");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		TestUserCanPayInvoiceOnGeneratedInvoice.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestUserCanPayInvoiceOnGeneratedInvoice.logger.exitMethod();
	}
}
