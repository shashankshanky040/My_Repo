package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class }) @Test(groups = {"automation"})
public class TestCustomerStatusChangeAsCollection extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Test Case 12.1: Verify customer status changed as per the collection
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 12.1: Verify customer status changed as per the collection")
	public void testCustomerStatusChangeAsCollection() throws Exception {

		TestCustomerStatusChangeAsCollection.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909922");

		// Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestCustomerStatusChangeAsCollection.logger.debug("Navigate to Configuration Page");

		// Select Configuration Collections Option
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Collections);
		TestCustomerStatusChangeAsCollection.logger.debug("Select Configuration Collections Option");

		// Run Collections for date 03/01/2001
		this.confPage = this.confPage.runCollectionsForDate("03/01/2001");
		TestCustomerStatusChangeAsCollection.logger.debug("Run Collections for date 03/01/2001");

		// Navigating to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestCustomerStatusChangeAsCollection.logger.debug("Navigating to Customers Page");

		// Run Cycle One for Customer Status Verification
		this.customerPage = this.customerPage.statusCycle("customerInformationForCollectionCycleOne_One",
				"customerInformationForCollectionCycleOne_Two", "ci");
		TestCustomerStatusChangeAsCollection.logger.debug("Run Cycle One for Customer Status Verification");

		// Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestCustomerStatusChangeAsCollection.logger.debug("Navigate to Configuration Page");

		// Select Configuration Collections Option
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Collections);
		TestCustomerStatusChangeAsCollection.logger.debug("Select Configuration Collections Option");

		// Run Collections for date 03/20/2001
		this.confPage = this.confPage.runCollectionsForDate("03/20/2001");
		TestCustomerStatusChangeAsCollection.logger.debug("Run Collections for date 03/20/2001");

		// Navigating to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestCustomerStatusChangeAsCollection.logger.debug("Navigating to Customers Page");

		// Run Cycle Two for Customer Status Verification
		this.customerPage.statusCycle("customerInformationForCollectionCycleTwo_One", "customerInformationForCollectionTwo_Two", "ci");
		TestCustomerStatusChangeAsCollection.logger.debug("Run Cycle Two for Customer Status Verification");

		// Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestCustomerStatusChangeAsCollection.logger.debug("Navigate to Configuration Page");

		// Select Configuration Collections Option
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Collections);
		TestCustomerStatusChangeAsCollection.logger.debug("Select Configuration Collections Option");

		// Run Collections for date 03/25/2001
		this.confPage = this.confPage.runCollectionsForDate("03/25/2001");
		TestCustomerStatusChangeAsCollection.logger.debug("Run Collections for date 03/25/2001");

		// Navigating to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestCustomerStatusChangeAsCollection.logger.debug("Navigating to Customers Page");

		// Run Cycle Three for Customer Status Verification
		this.customerPage.statusCycle("customerInformationForCollectionCycleThree_One", "customerInformationForCollectionCycleThree_Two",
				"ci");
		TestCustomerStatusChangeAsCollection.logger.debug("Run Cycle Three for Customer Status Verification");


		Reporter.log("<br> Test Passed");
		TestCustomerStatusChangeAsCollection.logger.exitMethod();
	}

}