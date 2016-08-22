package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

/**
 * Current Application Page Stack || LoginPage--> loginPage; NavigatorPage-->
 * navPage; HomePage--> homePage; ConfigurationPage--> confPage; AgentsPage-->
 * agentsPage; CustomersPage--> customerPage; ProductsPage--> productsPage;
 * PlansPage--> plansPage; OrdersPage--> ordersPage; InvoicePage--> invoicePage;
 * ReportsPage--> reportsPage; DiscountsPage--> discountsPage; FiltersPage-->
 * filtersPage; PaymentsPage--> paymentsPage; MessagesPage--> msgsPage;
 * 
 * @author Aishwarya Dwivedi
 * @since 1.0
 * @version 1.0
 */

public class VerifyValidityRulesDropDownIsAvailableInsteadofRuleTypeWhileCreatingMetafieldToAIT extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	static String category = "";

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "TC 340 : Verify that Validation Rule drop down field is available inplace of Rule type while creating meta-fields to the AIT")
	public void addAITMetafieldToAccountType() throws Exception {

		// // click on Configuration page
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyValidityRulesDropDownIsAvailableInsteadofRuleTypeWhileCreatingMetafieldToAIT.logger.debug("Click on Configuration page");

		// Click on Payment Method link
		this.confPage = this.confPage.clickOnPaymentMethodLink();
		VerifyValidityRulesDropDownIsAvailableInsteadofRuleTypeWhileCreatingMetafieldToAIT.logger.debug("Click on Payment Method link");

		// Add Payment Method Method
		String methodName = this.confPage.addPaymentMethod("testPaymentType", "pt");
		VerifyValidityRulesDropDownIsAvailableInsteadofRuleTypeWhileCreatingMetafieldToAIT.logger.debug("Add Payment Method");

		// Add an account information Type
		String accountTypeName = this.confPage.addAccountType("addAccountInformationType", "aait");
		VerifyValidityRulesDropDownIsAvailableInsteadofRuleTypeWhileCreatingMetafieldToAIT.logger.debug("Add an Account informationType");

		// Validate Added Account type saved data
		this.confPage = this.confPage.validateAccountTypeSavedTestData(accountTypeName);
		VerifyValidityRulesDropDownIsAvailableInsteadofRuleTypeWhileCreatingMetafieldToAIT.logger.debug("Validate Added Account type Data");

		// Verify Validation Drop down is is available inplace of Rule type
		// while creating meta field in AIT
		this.confPage = this.confPage.verifyVelidityRulesDropDown("addAccountInformationType", "aait", accountTypeName);
		VerifyValidityRulesDropDownIsAvailableInsteadofRuleTypeWhileCreatingMetafieldToAIT.logger
				.debug("Validate validity Rules Drop Down");
	}
}
