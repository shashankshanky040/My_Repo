package com.jbilling.test;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class TestReportForInvoice extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	ITestResult result;

	/**
	 * Verify correct report is displayed for invoice
	 * 
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 14.1 : Verify correct report is displayed.")
	public void testReportForInvoice() throws Exception {

		TestReportForInvoice.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909924");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestReportForInvoice.logger.debug("Navigate to Customers Page");

		String CustomerName = this.customerPage.addCustomerWithMakePayment("S_TC14.1_ReportForInvoices", "rfi",
				this.pr.readTestData("TC_3.5_ACCOUNT_NAME_ONE"));
		this.propReader.updatePropertyInFile("TC_14.1_CUSTOMER_NAME", CustomerName, "testData");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerToAddOrder(CustomerName);
		TestReportForInvoice.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process To Generate Invoice
		this.ordersPage = this.customerPage.generateInvoice("Customer A", "ca");
		TestReportForInvoice.logger.debug("Generate Invoice");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestReportForInvoice.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.invoicePage = this.customerPage.selectCustomerToMakePayment(CustomerName);
		TestReportForInvoice.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process To Make a Payment
		this.invoicePage = this.invoicePage.makePayment("payInvoice", "aa");
		TestReportForInvoice.logger.debug("Make a Payment");

		// Navigate To Reports Page
		this.reportsPage = this.navPage.navigateToReportsPage();
		TestReportForInvoice.logger.debug("Navigate To Reports Page");

		// Initiate And Complete The Process To Get Reports View
		this.reportsPage = this.reportsPage.getReportsView("selectReportType", "sra");
		TestReportForInvoice.logger.debug("Navigate To Reports Page");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		TestReportForInvoice.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestReportForInvoice.logger.exitMethod();
	}
}
