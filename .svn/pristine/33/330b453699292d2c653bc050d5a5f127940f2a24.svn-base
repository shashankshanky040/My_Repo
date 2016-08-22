package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
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
public class VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	static String category = "";

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "TC 343 : Verify that only one AIT meta-field per account type can be enabled at a time")
	public void validateMetaFiledtypeSelction() throws Exception {

		// Click On Configuration Menu
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime.logger.debug("Click on Configuration Page");

		// Click on Payment Method link
		this.confPage = this.confPage.clickOnPaymentMethodLink();
		VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime.logger.debug("Click on Payment Method link");

		// Add Payment Method Method
		String methodName = this.confPage.addPaymentMethod("testPaymentType", "pt");
		VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime.logger.debug("Add Payment Method");

		// Add an account information Type
		String accountTypeName = this.confPage.addAccountType("addAccountInformationType", "aait");
		VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime.logger.debug("Add an Account informationType");

		// Add Meta field to an account information Type
		String paymentAddress1 = this.confPage.addAITMetaFiledToAccountType("addAccountInformationType", "aait", accountTypeName);
		VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime.logger.debug("Add Metafield to an Account Type");

		// Click On Configuration Menu
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime.logger.debug("Click on Configuration Page");

		// Click on Account type link
		this.confPage = this.confPage.clickAccountTypeLink();
		VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime.logger.debug("Click on Account Type Link");

		// Add Meta field to an account information Type
		String paymentAddress2 = this.confPage.addAITMetaFiledToAccountType("addAccountInformationType", "aait", accountTypeName);
		VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime.logger.debug("Add Metafield to an Account Type");

		// Click On Configuration Menu
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime.logger.debug("Click on Configuration Page");

		// Verify User can not select multiple Payment Address
		this.confPage = this.confPage.verifyUserCannotSelectBothPaymentMethod(accountTypeName, paymentAddress1, paymentAddress2);
		VerifyOnlyOneAITMetaFieldAerAccountTypeCanBeEnabledAtTime.logger.debug("Verify User can not select multiple Payment Address");
	}
}