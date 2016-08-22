package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserAbleToConfigurePluginsForProvisioning extends BrowserApp {

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

	@Test(groups = { "globalRegressionPack" })
	public void configurePluginProvisionForUser() throws Exception {

		VerifyUserAbleToConfigurePluginsForProvisioning.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToConfigurePluginsForProvisioning.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Initiate And Complete The Process To Add The Plugin Under Order
		// Provisioning Task
		this.productsPage = this.productsPage.addPlugin("addPluginOPT", "apOPT");
		VerifyUserAbleToConfigurePluginsForProvisioning.logger.debug("Add The Plugin");

		// Adding Plugin Under Order Provisioning Task Line
		this.productsPage = this.productsPage.addPluginWithProvisionID("addPluginOPTL", "apOPTL");
		VerifyUserAbleToConfigurePluginsForProvisioning.logger.debug("Add The Plugin Inside");

		// Adding Plugin Under Asset Provisioning Task
		this.productsPage = this.productsPage.addPluginInsidePlugin("addPluginAPT", "apAPT");
		VerifyUserAbleToConfigurePluginsForProvisioning.logger.debug("Add The Plugin Inside");

		// Adding Plugin Under Payment Provisioning Task
		this.productsPage = this.productsPage.addPluginInsidePlugin("addPluginPPT", "apPPT");
		VerifyUserAbleToConfigurePluginsForProvisioning.logger.debug("Add The Plugin Inside");

		// Adding Plugin Under Provisioning Command Status Update Task
		this.productsPage = this.productsPage.addPluginInsidePlugin("addPluginPCT", "apPCT");
		VerifyUserAbleToConfigurePluginsForProvisioning.logger.debug("Add The Plugin Inside");

		// Logout From The Application
		this.loginPage = this.navPage.logoutApplication();
		VerifyUserAbleToConfigurePluginsForProvisioning.logger.debug("Logout From The Application");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToConfigurePluginsForProvisioning.logger.exitMethod();
	}
}
