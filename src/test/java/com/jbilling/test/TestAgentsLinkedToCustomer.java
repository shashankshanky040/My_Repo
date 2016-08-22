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
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AccountTypeField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.CollectionAgeingStep;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;

@Listeners({ TestRailsListener.class })
@Test(groups = {"automation"})
public class TestAgentsLinkedToCustomer extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify Order Changes feature works correctly
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 16.1 : Verify that Agents can be made "
			+ "and linked to a customer")
	public void testAgentsLinkedToCustomer() throws Exception {

		TestAgentsLinkedToCustomer.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909927");
		
		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestAgentsLinkedToCustomer.logger.debug("Navigate to Configuration Page");

		// Set Configuration Preference Value
		this.confPage = this.confPage.setConfigurationPreference("setPreferenceValue", "pc");
		TestAgentsLinkedToCustomer.logger.debug("Set Configuration Preference Value");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		TestAgentsLinkedToCustomer.logger.debug("Select Configuration");

		// Add First Account Type
		String accountName = this.confPage.createAccountType("addAccountType", "aat");
		this.runTimeVariables.put("TC_2.1_ACCOUNT_NAME_ONE", accountName);


		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestAgentsLinkedToCustomer.logger.debug("Verify Current Page UI Component");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.PaymentMethod);
		TestAgentsLinkedToCustomer.logger.debug("Select Configuration");

		// Configure Payment Method to Account
		this.confPage = this.confPage.configurePaymentMethod("configurePaymentMethod", "pm");
		TestAgentsLinkedToCustomer.logger.debug("Configure Payment Method to Account");

		// Add Payment Details
		String methodName = this.confPage.addPaymentMethodDetails("testPaymentType", "pt");

		this.runTimeVariables.put("TC_2.1.1_METHOD_NAME_ONE", methodName);
		TestAgentsLinkedToCustomer.logger.debug("Add Payment Details");

		// Verify Text:Payment Method Type Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type", "created successfully", TextComparators.contains);
		TestAgentsLinkedToCustomer.logger.debug("Verify Payment Method Type Is Created Successfully");

		// Validate Saved Account Type Test Data

		String paymentMethod = this.propReader.readPropertyFromFile("TC_2.1.1_METHOD_NAME_ONE", "testData");
		this.confPage = this.confPage.validatePeriodsSavedTestData(paymentMethod);
		TestAgentsLinkedToCustomer.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestAgentsLinkedToCustomer.logger.debug("Verify Current Page UI Component");

		// Navigate To Agents Page
		this.agentsPage = this.navPage.navigateToAgentsPage();
		TestAgentsLinkedToCustomer.logger.debug("Navigate To Agents Page");

		// Initiate And Complete The Process To Add Agent
		String agent = this.agentsPage.addAgent("addAgent", "aa");

		this.propReader.updatePropertyInFile("TC_16.1_AGENT", agent, "testData");
		TestAgentsLinkedToCustomer.logger.debug("Add Agent");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestAgentsLinkedToCustomer.logger.debug("Navigate to Customers Page");

		// Initiate And Complete The Process To Add a New Customer
		String customerName = this.customerPage.addCustomer(this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"),
		this.runTimeVariables.get("TC_2.1.1_METHOD_NAME_ONE"), "new_customer", "nc");
		this.runTimeVariables.put("TC_6.1_CUSTOMER_NAME", customerName);
		TestAgentsLinkedToCustomer.logger.debug("Add a New Customer");

		// Verify Current Page UI Component
		this.customerPage = this.customerPage.verifyUIComponent();
		TestAgentsLinkedToCustomer.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestAgentsLinkedToCustomer.logger.exitMethod();
	}	
	
}