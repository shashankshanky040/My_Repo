package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class TestOrderProductWithDependencyOnOther extends BrowserApp {
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	String ProductID = "null";
	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Current Application Page Stack || LoginPage--> loginPage;
	 * NavigatorPage--> navPage; HomePage--> homePage; ConfigurationPage-->
	 * confPage; AgentsPage--> agentsPage; CustomersPage--> customerPage;
	 * ProductsPage--> productsPage; PlansPage--> plansPage; OrdersPage-->
	 * ordersPage; InvoicePage--> invoicePage; ReportsPage--> reportsPage;
	 * DiscountsPage--> discountsPage; FiltersPage--> filtersPage;
	 * PaymentsPage--> paymentsPage; MessagesPage--> msgsPage;
	 * 
	 * @author Aishwarya Dwivedi
	 * @since 1.0
	 * @version 1.0
	 */

	@Test(description = "Test Case 15.2 :  Verify that Products with dependencies on other products can be ordered.")
	public void testOrderProductWithDependencyOnOther() throws Exception {

		TestOrderProductWithDependencyOnOther.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909926");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestOrderProductWithDependencyOnOther.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.customerPage = this.customerPage.selectcustomer(this.pr.readTestData("TC_6.2_CHILD_CUSTOMER_NAME"));
		this.customerPage = this.customerPage.clickCreateOrder();
		TestOrderProductWithDependencyOnOther.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process To Order The Product Having
		// Dependency
		this.ordersPage = this.customerPage.orderProductHavingDependency("createOrderSecond", "co");
		TestOrderProductWithDependencyOnOther.logger.debug("Order The Product Having Dependency");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		TestOrderProductWithDependencyOnOther.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestOrderProductWithDependencyOnOther.logger.exitMethod();
	}
}