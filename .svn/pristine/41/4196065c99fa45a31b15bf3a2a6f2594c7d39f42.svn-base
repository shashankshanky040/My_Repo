package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AccountTypeInfo;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PaymentMethodField;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyUserAbleToAddPaymentMethod extends BrowserApp {
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
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

	@Test(description = "Test Case 07: Verify that user is able to create a payment method using card.", priority = 1)
	public void TC07_AddPaymentMethodForCard() throws Exception {
		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyUserAbleToAddPaymentMethod.logger.debug("navigate to Paymentmethod");

		// Add Payment Method for Card
		String paymentMethodName = this.confPage.addPaymentMethodWithoutMetaFields(PaymentMethodField.REECURRING,
				"TC07_AddCardPaymentMethod", "apm");
		this.runTimeVariables.put("TC_07_PAYMENT_METHOD_NAME", paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Add Payment Method for Card");

		// Verify Payment Method Created Successfully Message Displayed
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type ", "created successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Created Account Type");

		// Validate Saved Payment Method Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Account Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "Test Case 08: Verify that user is able to create a payment method using ACH.", priority = 2)
	public void TC08_AddPaymentMethodForACH() throws Exception {
		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyUserAbleToAddPaymentMethod.logger.debug("navigate to Paymentmethod");

		// Add Payment Method for Card
		String paymentMethodName = this.confPage.addPaymentMethodWithoutMetaFields(PaymentMethodField.REECURRING,
				"TC08_CreatePaymentMethodACH", "apm");
		this.runTimeVariables.put("TC_08_PAYMENT_METHOD_NAME", paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Add Payment Method for Card");

		// Verify Payment Method Created Successfully Message Displayed
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type ", "created successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Created Account Type");

		// Validate Saved Payment Method Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Account Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 09 : Verify that user is able to create a payment method using Cheque", priority = 3)
	public void TC09_AddPaymentMethodForCheque() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Add Payment Method With Recurring For Cheque
		String paymentMethodName = this.confPage.addPaymentMethodWithoutMetaFields(PaymentMethodField.REECURRING,
				"TC09_addChequePaymentMethod", "apm");
		this.runTimeVariables.put("TC_09_PAYMENT_METHOD_NAME", paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Add Payment Method For Cheque With Recurring");

		// Verify Message For Created Account Type
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type", "created successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Created Account Type");

		// Validate Saved Payment Method Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Account Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 11.1 : Verify that user is able to create account type with credit limit and notification amount configured", dependsOnMethods = "TC09_AddPaymentMethodForCheque", priority = 4)
	public void TC11_1_AddAccountTypeWithCreditForThreePayMethod() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Set Configuration Preference Value
		this.confPage = this.confPage.setConfigurationPreference("setPreferenceValue", "pc");
		VerifyUserAbleToAddPaymentMethod.logger.debug("Set Configuration Preference Value");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Add Edit Delete Payment Method With Recurring
		String TC09_paymentMethodName = this.runTimeVariables.get("TC_09_PAYMENT_METHOD_NAME");
		String TC08_paymentMethodName = this.runTimeVariables.get("TC_08_PAYMENT_METHOD_NAME");
		String TC07_paymentMethodName = this.runTimeVariables.get("TC_07_PAYMENT_METHOD_NAME");
		String accountName = this.confPage.AddAccountTypeWithCreditDetailsForThreePay("TC11_AccountTypeWithCreditLimit", "atcl",
				TC09_paymentMethodName, TC08_paymentMethodName, TC07_paymentMethodName);
		this.runTimeVariables.put("TC_11.1_ACCOUNT_NAME", accountName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Add Edit Delete Payment Method With Recurring");

		// Verify Message For Company Details Changed
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Type", "created successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Account Type Created");

		// Validate Saved Account Type Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(accountName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Account Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 12.0 : Verify searching and sorting works as defined for 'Account Type'.", dependsOnMethods = "TC11_1_AddAccountTypeWithCreditForThreePayMethod", priority = 5)
	public void TC12_VerifySearchingAndSortingForAccountType() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Set Preference for ID 63
		// this.confPage = this.confPage.updatePreference("set63Preference",
		// "sp");
		VerifyUserAbleToAddPaymentMethod.logger.debug("Set Preference for ID 63");

		// Select Payment Method from Configuration list
		// this.confPage =
		// this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// TODO: Method to Sort for Account Name

		// String accountNameToSearch =
		// this.runTimeVariables.get("TC_11.1_ACCOUNT_NAME");
		// this.confPage =
		// this.confPage.searchAndSortFunctionalityOfAccType(accountNameToSearch);

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// this.confPage =
		// this.confPage.ReupdateJQGridPreference("reSet63Preference", "sp");
		VerifyUserAbleToAddPaymentMethod.logger.debug("Set Preference for ID 63");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 13 : Verify that user is able to edit account type and edit the payment methods associated with the account type.", dependsOnMethods = "TC09_AddPaymentMethodForCheque", priority = 6)
	public void TC13_AddAccountTypeWithCreditForThreePayMethod() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Edit Account Type To De-select One Payment Method
		String TC11_1_accountName = this.runTimeVariables.get("TC_11.1_ACCOUNT_NAME");
		String TC08_paymentMethodName = this.runTimeVariables.get("TC_08_PAYMENT_METHOD_NAME");
		this.confPage = this.confPage.editAccountTypeForGivenAccountDeselectPay(TC11_1_accountName, TC08_paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Edit Account Type To Deselect One Payment Method");

		// Verify Message For Updated Account Type
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Type", "updated successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Account Type Updated");

		// Edit Account Name And Select Three Payment Method
		String TC09_paymentMethodName = this.runTimeVariables.get("TC_09_PAYMENT_METHOD_NAME");
		String TC07_paymentMethodName = this.runTimeVariables.get("TC_07_PAYMENT_METHOD_NAME");
		String accountName = this.confPage.editAccountTypeForGivenAccountWithThreePay("TC13_EditAccountTypeName", "ea", TC11_1_accountName,
				TC09_paymentMethodName, TC08_paymentMethodName, TC07_paymentMethodName);
		this.runTimeVariables.put("TC_13_ACCOUNT_NAME", accountName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Edit Account Name And Select Three Payment Method");

		// Verify Message For Updated Account Type
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Type", "updated successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Account Type Updated");

		// Validate Saved Account Type Test Data
		// this.confPage =
		// this.confPage.validatePeriodsSavedTestData(accountName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Account Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 14 : Verify that user can create a new Account type using the Card payment method", dependsOnMethods = "TC07_AddPaymentMethodForCard", priority = 7)
	public void TC14_AddAccountTypeUsingCardPayMethod() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Verify Mandatory Field Message Appears
		this.confPage = this.confPage.verifyMandatoryFieldMessages("mandatoryFieldAccountType", "mfat");
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Mandatory Field Message Appears");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Add Edit Delete Payment Method With Recurring
		String TC07_paymentMethodName = this.runTimeVariables.get("TC_07_PAYMENT_METHOD_NAME");
		String accountName = this.confPage.createAccountTypeWithCreditDetails("TC14_AccountTypeWithCreditLimit", "atcl",
				TC07_paymentMethodName);
		this.runTimeVariables.put("TC_14_ACCOUNT_NAME", accountName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Add Edit Delete Payment Method With Recurring");

		// Verify Message For Company Details Changed
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Type", "created successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Account Type Created");

		// Validate Saved Account Type Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(accountName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Account Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 15 : Verify that user can create a new Account type using the ACH payment method", dependsOnMethods = "TC08_AddPaymentMethodForACH", priority = 8)
	public void TC15_AddAccountTypeUsingACHPayMethod() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Add Account Type With ACH Payment Type
		String TC08_paymentMethodName = this.runTimeVariables.get("TC_08_PAYMENT_METHOD_NAME");
		String accountName = this.confPage
				.createAccountTypeWithCreditDetails("TC15_AddPaymentMethodwithACH", "apm", TC08_paymentMethodName);
		this.runTimeVariables.put("TC_15_ACCOUNT_NAME", accountName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Add Edit Delete Payment Method With Recurring");

		// Verify Message For Created Account Type
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Type", "created successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Created Account Type");

		// Validate Saved Account Type Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(accountName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Account Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 16 : Verify that user can create a new Account type using the Cheque payment method", dependsOnMethods = "TC09_AddPaymentMethodForCheque", priority = 9)
	public void TC16_AddPaymentMethodUsingCheque() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Add Account Type With Credit Details For Cheque
		String TC09_paymentMethodName = this.runTimeVariables.get("TC_09_PAYMENT_METHOD_NAME");
		String accountName = this.confPage.createAccountTypeWithCreditDetails("TC16_addPaymentMethodwithCheque", "apm",
				TC09_paymentMethodName);
		this.runTimeVariables.put("TC_16_ACCOUNT_NAME", accountName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Add Account Type With Credit Details For Cheque");

		// Verify Message For Created Account Type
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Type", "created successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Created Account Type");

		// Validate Saved Account Type Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(accountName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Account Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 17 :Verify user is able to create payment card/cheque/ach payment method with 'All account Type' check-box checked.", priority = 10)
	public void TC17_AddPaymentMethodForCheque() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Add Payment Method With Recurring For Cheque
		String paymentMethodName = this.confPage.addPaymentMethodWithoutMetaFields(PaymentMethodField.ALL, "TC17_addChequePaymentMethod",
				"apm");
		this.runTimeVariables.put("TC_17_PAYMENT_METHOD_NAME", paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Add Payment Method For Cheque With Recurring");

		// Verify Message For Created Account Type
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type", "created successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Created Account Type");

		// Validate Saved Payment Method Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Account Type Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC_18  : Verify User able to get mandatory field validation message", dependsOnMethods = "TC17_AddPaymentMethodForCheque", priority = 11)
	public void TC18_VerifyPaymentMethodAvailableForAllCust() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Verify Payment Method Name is selected for account type
		String TC17_PaymentMethodName = this.runTimeVariables.get("TC_17_PAYMENT_METHOD_NAME");
		String accName = this.confPage.verifyPayMethodDefaultSelectedForAddingAccountType("TC18_AddAccountType", "aat",
				TC17_PaymentMethodName);
		this.runTimeVariables.put("TC_18_ACCOUNT_TYPE_NAME", accName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Payment Method Name is selected for account type");

		// Navigate to Customer Tab
		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Navigate to Customer Page");

		this.customerPage = this.customerPage.verifyPaymentAvailableForCustomer(accName, TC17_PaymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Mandatory Field Message Appears");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 19 : Verify that, this payment method is default selected for all the account types created in future.", dependsOnMethods = "TC15_AddAccountTypeUsingACHPayMethod", priority = 12)
	public void TC19_VerifyPayMethodIsDefaultSelectedForAllAccType() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// / Verify Payment Method Name is selected for account type
		String TC17_PaymentMethodName = this.runTimeVariables.get("TC_17_PAYMENT_METHOD_NAME");
		this.confPage = this.confPage.verifyPayMethodDefaultSelectedForAccountType(TC17_PaymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Payment Method Name is selected for account type");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 20 : Verify this created payment method works correctly for all the account types created in future.", dependsOnMethods = "TC09_AddPaymentMethodForCheque", priority = 13)
	public void TC20_VerifyPayMethodWorksForAllAccType() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Edit Payment Method With All Accounts
		String TC09_paymentMethodName = this.runTimeVariables.get("TC_09_PAYMENT_METHOD_NAME");
		this.confPage = this.confPage.editPaymentMethodWithAllAccountTypeChecked("TC20_EditPaymentMethodForAllAcount", "epmaa",
				TC09_paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Edit Payment Method With All Accounts");

		// Verify Message For Created Account Type
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type", "updated successfully", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Edit Payment Method Type");

		// Navigate to Customer Tab
		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Navigate to Customer Page");

		// Add Customer For Above Created Account Name In TC 15
		String TC18_AccountName = this.runTimeVariables.get("TC_18_ACCOUNT_TYPE_NAME");
		String customerName = this.customerPage.addCustomerWithMakePayment("TC20_VerifyPayment", "vp", TC18_AccountName);
		this.runTimeVariables.put("TC_20_CUSTOMER_NAME", customerName);

		// Verify Message For Created Customer
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new customer", "successfully.", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Created Customer");

		// Validate Saved Account Type Test Data
		this.customerPage = this.customerPage.validateSavedTestDataInTable(customerName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Customer Test Data");

		// Click on Make Payment Button
		this.customerPage = this.customerPage.clickMakePayment();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Click on Make Payment Button");

		// Make Payment For Above Created Payment Method in TC09
		this.paymentsPage = this.paymentsPage.MakePayment("TC20_VerifyPayment", "vp", TC09_paymentMethodName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Make Payment For Above Created Payment Method in TC09");

		// Verify Message For Created Payment
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Successfully processed", "new payment", TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Message For Created Payment");

		// Validate Saved Payment Test Data
		this.customerPage = this.customerPage.validateSavedTestDataInPaymentsTable(customerName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Payment Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

	@Test(description = "TC 36 : Verify that user can add account information type meta fields with the account type.", dependsOnMethods = "TC09_AddPaymentMethodForCheque", priority = 13)
	public void TC36_TestAddInfoToAccountType() throws Exception {

		VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
		Reporter.log("<br>Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047243");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Navigate to Configuration Page");

		// Add Information to Account Type
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		this.confPage = this.confPage.selectAccountName(this.runTimeVariables.get("TC_18_ACCOUNT_TYPE_NAME"));
		VerifyUserAbleToAddPaymentMethod.logger.debug("Add Information to Account Type");

		String infoTypeName = this.confPage.addNewInformationToSelectedAccountType(AccountTypeInfo.DISABLE_CHECKBOX,
				"TC36_AddInfoToAccType", "aiat");
		this.runTimeVariables.put("TC36_INFO_NAME", infoTypeName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Enter information type name for account type");

		// Verify Text : Account Information Type Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Information Type", "created successfully",
				TextComparators.contains);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Account Information Type Is Created Successfully");

		// Validate Saved Account Information Type Test Data
		this.confPage = this.confPage.validatePeriodsSavedTestData(infoTypeName);
		VerifyUserAbleToAddPaymentMethod.logger.debug("Validate Saved Account Information Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		VerifyUserAbleToAddPaymentMethod.logger.debug("Verify Current Page UI Component");

		VerifyUserAbleToAddPaymentMethod.logger.debug("Verifying if account information type created successfully or not");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToAddPaymentMethod.logger.exitMethod();
	}

}