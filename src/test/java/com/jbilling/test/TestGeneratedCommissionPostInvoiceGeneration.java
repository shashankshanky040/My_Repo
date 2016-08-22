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

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class TestGeneratedCommissionPostInvoiceGeneration extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify that correct commission is generated for the Agent after order
	 * invoice is generated
	 * 
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 16.4 : Verify that correct commission is generated for the " + "Agent after order invoice is generated")
	public void testGeneratedCommissionPostInvoiceGeneration() throws Exception {

		TestGeneratedCommissionPostInvoiceGeneration.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909930");

		// Navigate to Configuration Page
		this.agentsPage = this.navPage.navigateToAgentsPage();
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Navigate to Agents Page");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.customerPage = this.customerPage.selectcustomer(this.pr.readTestData("TC_6.2_CHILD_CUSTOMER_NAME"));
		this.customerPage = this.customerPage.clickCreateOrder();
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process To Generate Invoice
		this.ordersPage = this.customerPage.generateInvoice("Customer A", "ca");
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Generate Invoice");

		// Navigating to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Navigating to Configuration Page");

		// Selecting Agent Commission Process for its configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AgentCommissionProcess);
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Selecting Agent Commission Process for its configuration");

		// Add Billing Process
		this.confPage = this.confPage.addBillingProcess("BillingProcess", "cbp");
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Add Billing Process");

		// Run commission on added billing process
		this.confPage = this.confPage.clickRunCommmisionToBillingProcess();
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Run commission on added billing process");

		// Verify saved commission
		this.confPage = this.confPage.verifySavedCommision();
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Verify saved commission");

		// Navigating to Agents Page
		this.agentsPage = this.navPage.navigateToAgentsPage();
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Navigating to Agents Page");

		// Click Corresponding Agent Item
		this.agentsPage = this.agentsPage.clickAgentItem();
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Click Corresponding Agent Item");

		// Show Commission
		this.agentsPage = this.agentsPage.showCommission();
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Show Commission");

		// Verify Current Page UI Component
		this.agentsPage = this.agentsPage.verifyUIComponent();
		TestGeneratedCommissionPostInvoiceGeneration.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestGeneratedCommissionPostInvoiceGeneration.logger.exitMethod();
	}

}