package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserAbleToSubscribeToTheFUPPlan extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	static String category = "";
	String ProductID = "null";
	ITestResult result;

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

	@Test(description = " TC 115: Verify user is able to subscribe to the FUP plan ", priority = 1)

	public void TC115_AddPaymentMethodForACH() throws Exception {

		VerifyUserAbleToSubscribeToTheFUPPlan.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("navigate to Paymentmethod");

		// Add Payment Method for ACH
		String addACHPaymentMethod = this.confPage.addACHPaymentMethod("TC115_CreatePaymentMethodACH", "apm");
		this.runTimeVariables.put("TC_115_PAYMENT_METHOD_ACH", addACHPaymentMethod);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Add Payment Method for ACH");

		// Verify Payment Method Created Successfully Message Displayed
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type ", "created successfully", TextComparators.contains);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Verify Message For Created Payment type");

		// Validate Saved Payment Method Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(addACHPaymentMethod);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Validate Saved Payment Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.exitMethod();

	}

	@Test(description = "TC 115: Verify user is able to subscribe to the FUP plan", dependsOnMethods = "TC115_AddPaymentMethodForACH", priority = 2)
	public void TC115_AddAccountType() throws Exception {

		VerifyUserAbleToSubscribeToTheFUPPlan.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Select Payment Method from Configuration list");

		// Add Edit Delete Payment Method With Recurring and all account type
		String TC_115_PAYMENT_METHOD_ACH = this.runTimeVariables.get("TC_115_PAYMENT_METHOD_ACH");
		String accountName = this.confPage.addACHAccountType("TC115_AccountTypeACH", "atach", TC_115_PAYMENT_METHOD_ACH);
		this.runTimeVariables.put("TC_115_ACCOUNT_NAME", accountName);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Add Edit Delete Payment Method With Recurring and all account");

		// Verify Message For Payment saved
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Type", "created successfully", TextComparators.contains);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Verify Message For Account Type Created");

		// Validate Saved Account Type Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(accountName);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Validate Saved Account Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.exitMethod();
	}

	@Test(description = "TC 115: Verify user is able to subscribe to the FUP plan", dependsOnMethods = "TC115_AddAccountType", priority = 3)
	public void TC115_AddCustomer() throws Exception {

		VerifyUserAbleToSubscribeToTheFUPPlan.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Navigate to Customer Tab
		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Login Into Application And Navigate to Customer Page");

		// Initialize and add customer
		String TC_115_PAYMENT_METHOD_ACH = this.runTimeVariables.get("TC_115_PAYMENT_METHOD_ACH");
		String TC_115_ACCOUNT_NAME = this.runTimeVariables.get("TC_115_ACCOUNT_NAME");

		String customerName = this.customerPage.addACHCustomerType(TC_115_ACCOUNT_NAME, TC_115_PAYMENT_METHOD_ACH,
				"TC115_ACH_Cusotmer_Type", "achct");
		this.runTimeVariables.put("TC_115_CUSTOMER_NAME", customerName);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Add Edit Delete Payment Method With Recurring and all apyment");

		// Verify Message For Payment saved
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new customer", "successfully", TextComparators.contains);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Verify Message For New Customer Created");

		// Validate Saved custmer Test Data
		this.customerPage = this.customerPage.validateUsersSavedTestData(customerName);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Validate Saved Customer Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.exitMethod();
	}

	@Test(description = "TC 115: Verify user is able to subscribe to the FUP plan", dependsOnMethods = "TC115_AddCustomer", priority = 4)
	public void TC115_CreateOrder() throws Exception {

		VerifyUserAbleToSubscribeToTheFUPPlan.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Navigate to Customer Tab
		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Login Into Application And Navigate to Customer Page");

		// Initialize and add customer
		String TC_115_CUSTOMER_NAME = this.runTimeVariables.get("TC_115_CUSTOMER_NAME");
		this.customerPage = this.customerPage.createOrderForFUPCustomer(TC_115_CUSTOMER_NAME, "TC115_Create_Order", "co");
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Create Customer order");

		// Verify Message For Payment saved
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Created new order", "successfully", TextComparators.contains);
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Verify Message For order Created");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.exitMethod();
	}

	@Test(description = "TC 115: Verify user is able to subscribe to the FUP plan", dependsOnMethods = "TC115_AddCustomer", priority = 4)

	public void TC115_EditOrder() throws Exception {

		VerifyUserAbleToSubscribeToTheFUPPlan.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Navigate to Customer Tab
		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Login Into Application And Navigate to Customer Page");

		// Initialize and add customer
		String TC_115_CUSTOMER_NAME = this.runTimeVariables.get("TC_115_CUSTOMER_NAME");
		this.customerPage = this.customerPage.EditOrderForFUPCustomer(TC_115_CUSTOMER_NAME, "TC115_Edit_Order", "eco");
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.debug("Add Edit order");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToSubscribeToTheFUPPlan.logger.exitMethod();
	}

}