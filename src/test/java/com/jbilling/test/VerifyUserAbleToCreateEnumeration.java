package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddNewEnumeration;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserAbleToCreateEnumeration extends BrowserApp {
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
	 * @author Shashank
	 * @since 1.0
	 * @version 1.0
	 */

	@Test(description = "Test Case 84: Verify that user is able to create Enumeration.", priority = 1)
	public void TC84_CreateEnumerations() throws Exception {
		VerifyUserAbleToCreateEnumeration.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToCreateEnumeration.logger.debug("Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Enumerations);
		VerifyUserAbleToCreateEnumeration.logger.debug("navigate to Enumerations");

		// Create Enumeration With a Verification of Mandatory Fields
		String enumerationName = this.confPage.createEnumeration(AddNewEnumeration.VERIFY_MANDATORY_FIELDS, "TC84_EnumValidateMessage",
				"evm");
		this.runTimeVariables.put("TC_84_ENUMERATION_NAME", enumerationName);
		VerifyUserAbleToCreateEnumeration.logger.debug("Create Enumeration With a Verification of Mandatory Fields");

		// Verify Enumeration Created Successfully Message Displayed
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Enumeration with Id", "saved successfully.", TextComparators.contains);
		VerifyUserAbleToCreateEnumeration.logger.debug("Verify Message For Created Enumeration");

		// Validate Data Saved For Created Enumeration
		this.confPage = this.confPage.validateEnumerationsSavedData(enumerationName);
		VerifyUserAbleToCreateEnumeration.logger.debug("Validate Data Saved For Created Enumeration");

		// Edit Created Enumeration Value
		String newEnumValue = this.confPage.editConfiguration(enumerationName, "TC84_EnumValidateMessage", "evm");
		this.runTimeVariables.put("TC_84_NEW_ENUMERATION_VALUE", newEnumValue);

		// Verify that error message displayed For saving Enumeration with
		// another Duplicate Value
		this.confPage = this.confPage.verifyDuplicateValueForEnumeration(enumerationName, "TC84_EnumValidateMessage", "evm");
		VerifyUserAbleToCreateEnumeration.logger
				.debug("Verify that error message displayed For saving Enumeration with another Duplicate Value");

		// Select Created Enumeration From Enumeration Table
		this.confPage = this.confPage.selectEnumerationsFromTable(enumerationName);
		VerifyUserAbleToCreateEnumeration.logger.debug("Select Created Enumeration From Enumeration Table");

		// This will click on NO for Delete Enumeration
		this.confPage = this.confPage.checkDeleteYesNo("NO");
		VerifyUserAbleToCreateEnumeration.logger.debug("click on NO for Delete Enumeration");

		// Validate Data Saved For Created Enumeration
		this.confPage = this.confPage.validateEnumerationsSavedData(enumerationName);
		VerifyUserAbleToCreateEnumeration.logger.debug("Validate Data Saved For Created Enumeration Presence");

	}
}
