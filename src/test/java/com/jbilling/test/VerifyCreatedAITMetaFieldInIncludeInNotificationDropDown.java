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

public class VerifyCreatedAITMetaFieldInIncludeInNotificationDropDown extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	static String category = "";

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "TC 342 :Verify that created AIT meta fields are displayed in 'Include in notifications' droplist after editing.")
	public void addAITMetafieldToAccountType() throws Exception {

		// // click on Configuration page
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCreatedAITMetaFieldInIncludeInNotificationDropDown.logger.debug("Click on Configuration page");

		// Click on Payment Method link
		this.confPage = this.confPage.clickOnPaymentMethodLink();
		VerifyCreatedAITMetaFieldInIncludeInNotificationDropDown.logger.debug("Click on Payment Method link");

		// Add Payment Method Method
		String methodName = this.confPage.addPaymentMethod("testPaymentType", "pt");
		VerifyCreatedAITMetaFieldInIncludeInNotificationDropDown.logger.debug("Add Payment Method");

		// Add an account information Type
		String accountTypeName = this.confPage.addAccountType("addAccountInformationType", "aait");
		VerifyCreatedAITMetaFieldInIncludeInNotificationDropDown.logger.debug("Add an Account informationType");

		// Validate Added Account type saved data
		this.confPage = this.confPage.validateAccountTypeSavedTestData(accountTypeName);
		VerifyCreatedAITMetaFieldInIncludeInNotificationDropDown.logger.debug("Validate Added Account type Data");

		// Add Meta field to an account information Type
		String accountName = this.confPage.addAITMetaFiledToAccountType("addAccountInformationType", "aait", accountTypeName);
		VerifyCreatedAITMetaFieldInIncludeInNotificationDropDown.logger.debug("Add Metafield to an Account Type");

		// Validate Added metafield Account Information Type
		this.confPage = this.confPage.validateAccountInformationTypeSavedTestData(accountName);
		VerifyCreatedAITMetaFieldInIncludeInNotificationDropDown.logger.debug("Validate metaield in an account information type");

		// Click on Config Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCreatedAITMetaFieldInIncludeInNotificationDropDown.logger.debug("Click on config Page");

		// Verify added Metafiled account is preset in Include in Notification
		this.confPage = this.confPage.verifyAddedMetafieldIsDisplayingIncludeNotificationDropDown(accountTypeName, accountName);
		VerifyCreatedAITMetaFieldInIncludeInNotificationDropDown.logger
				.debug("Verify added Metafiled account is preset in Include in Notification");
	}
}
