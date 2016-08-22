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

public class VerifyUserIsAbleToAddAnotherAITMetafiledToAcountType extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	static String category = "";

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "TC 341 : Verify that user is able to add another AIT meta-field  to the account type ")
	public void addAnotherAITMetafieldToExistingAccountType() throws Exception {

		// // click on Configuration page
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserIsAbleToAddAnotherAITMetafiledToAcountType.logger.debug("Click on Configuration page");

		// Click on Payment Method link
		this.confPage = this.confPage.clickOnPaymentMethodLink();
		VerifyUserIsAbleToAddAnotherAITMetafiledToAcountType.logger.debug("Click on Payment Method link");

		// Add Payment Method Method
		String methodName = this.confPage.addPaymentMethod("testPaymentType", "pt");
		VerifyUserIsAbleToAddAnotherAITMetafiledToAcountType.logger.debug("Add Payment Method");

		// Add an account information Type
		String accountTypeName = this.confPage.addAccountType("addAccountInformationType", "aait");
		VerifyUserIsAbleToAddAnotherAITMetafiledToAcountType.logger.debug("Add an Account informationType");

		// Validate Added Account type saved data
		this.confPage = this.confPage.validateAccountTypeSavedTestData(accountTypeName);
		VerifyUserIsAbleToAddAnotherAITMetafiledToAcountType.logger.debug("Validate Added Account type Data");

		// Add Meta field to an account information Type
		String accountName = this.confPage.addAITMetaFiledToAccountType("addAccountInformationType", "aait", accountTypeName);
		VerifyUserIsAbleToAddAnotherAITMetafiledToAcountType.logger.debug("Add Metafield to an Account Type");

		// Validate Added metafield Account Information Type
		this.confPage = this.confPage.validateAccountInformationTypeSavedTestData(accountName);
		VerifyUserIsAbleToAddAnotherAITMetafiledToAcountType.logger.debug("VAlidate metaield in an account information type");

		// click on Configuration tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserIsAbleToAddAnotherAITMetafiledToAcountType.logger.debug("Click on Configuration page");

		// Add Another AIT in Existing Account Type
		String accountName1 = this.confPage.addAnotherAITMetaFiledToExistingAccountType("addAccountInformationType", "aait",
				accountTypeName);

		// Validate Added metafield Account Information Type
		this.confPage = this.confPage.validateAccountInformationTypeSavedTestData(accountName1);
		VerifyUserIsAbleToAddAnotherAITMetafiledToAcountType.logger.debug("VAlidate metaield in an account information type");
	}
}
