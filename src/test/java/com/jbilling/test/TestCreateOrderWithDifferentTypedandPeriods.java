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
public class TestCreateOrderWithDifferentTypedandPeriods extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "Test Case 11.1 :  Verify user is able to create orders belonging "
			+ "to different periods/type to be processed in billing process later.")
	public void testCreateOrderWithDifferentTypedandPeriods() throws Exception {

		TestCreateOrderWithDifferentTypedandPeriods.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909918");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Navigate to Customers Page");

		// Initiate And Complete The Process To Add a Customer
		String customer = this.customerPage.addCustomer(this.pr.readTestData("TC_2.1_ACCOUNT_NAME_ONE"),
				this.pr.readTestData("TC_2.1.1_METHOD_NAME_ONE"), "new_customer", "nc");
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Add a Customer");

		// Initiate And Complete The Process To Add The Other Customer
		String diffCustomer = this.customerPage.addCustomer(this.pr.readTestData("TC_2.1_ACCOUNT_NAME_ONE"),
				this.pr.readTestData("TC_2.1.1_METHOD_NAME_ONE"), "new_customer", "nc");
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Add The Other Customer");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Navigate to Products Tab");

		// Initiate And Complete The Process To Create A Product Category
		this.productsPage.addCategory("productCategoryWithDifferentPeriods", "pcat");
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Create A Product Category");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For

		this.customerPage = this.customerPage.selectcustomer(this.pr.readTestData("TC_6.2_CHILD_CUSTOMER_NAME"));
		this.customerPage = this.customerPage.clickCreateOrder();

		// Initiate And Complete The Process Of Creating Order For Selected
		// Customer
		this.ordersPage = this.customerPage.createOrderForCustomer("OrderWithDifferentPeriods", "co");
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Create Order For Selected Customer");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.customerPage = this.customerPage.selectcustomer(this.pr.readTestData("TC_6.2_CHILD_CUSTOMER_NAME"));
		this.customerPage = this.customerPage.clickCreateOrder();
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process Of Creating Order For Selected
		// Customer
		this.ordersPage = this.customerPage.createOrderForCustomer("OrderTwoWithDifferentPeriods", "co");
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Create Order For Selected Customer");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.customerPage = this.customerPage.selectcustomer(this.pr.readTestData("TC_6.2_CHILD_CUSTOMER_NAME"));
		this.customerPage = this.customerPage.clickCreateOrder();
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process Of Creating Order For Selected
		// Customer
		this.ordersPage = this.customerPage.createOrderForCustomer("OrderThreeWithDifferentPeriods", "co");
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Create Order For Selected Customer");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.customerPage = this.customerPage.selectcustomer(this.pr.readTestData("TC_6.2_CHILD_CUSTOMER_NAME"));
		this.customerPage = this.customerPage.clickCreateOrder();
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process Of Creating Order For Selected
		// Customer
		this.ordersPage = this.customerPage.createOrderForCustomer("OrderfourWithDifferentPeriods", "co");
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Create Order For Selected Customer");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		TestCreateOrderWithDifferentTypedandPeriods.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestCreateOrderWithDifferentTypedandPeriods.logger.exitMethod();
	}
}
