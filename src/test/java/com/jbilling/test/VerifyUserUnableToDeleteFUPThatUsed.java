package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserUnableToDeleteFUPThatUsed extends BrowserApp {
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

	@Test(description = "TC 117 : Verify user is unable to delete an FUP that is in use", groups = { "globalRegressionPack" })
	public void TC117_UserUnableToDeleteFUPThatUsed() throws Exception {

		VerifyUserUnableToDeleteFUPThatUsed.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserUnableToDeleteFUPThatUsed.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Users from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.FreeUsagePools);
		VerifyUserUnableToDeleteFUPThatUsed.logger.debug("Select FreeUsagePools from Configuration list");

		// Try to delete free usage Pool "100 National Call Minutes"
		this.confPage = this.confPage.selectUsagePoolName100Calls("SelectUsagePoolName", "supn");
		VerifyUserUnableToDeleteFUPThatUsed.logger.debug("Select FreeUsagePools from Configuration list");

		// Verify Validation message
		this.confPage = this.confPage
				.valdationMessageDisplay("The Usage Pool has an error in the Id field: Usage Pool 100 cannot be deleted, it is in use");
		VerifyUserUnableToDeleteFUPThatUsed.logger
				.debug("Verify The Usage Pool has an error in the Id field: Usage Pool 100 cannot be deleted, it is in use");

		Reporter.log("<br> Test Passed");
		VerifyUserUnableToDeleteFUPThatUsed.logger.exitMethod();

	}

}
