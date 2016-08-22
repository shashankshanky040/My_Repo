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

public class VerifyUserAbleToConfigureOrderChangeStatuses extends BrowserApp {
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
	@Test(description = "TC 85 : Verify that user is able to Configure Order Change Statuses", groups = { "globalRegressionPack" })
	public void configureOrderChangeStatus() throws Exception {

		VerifyUserAbleToConfigureOrderChangeStatuses.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToConfigureOrderChangeStatuses.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Order Change Statuses from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.OrderChangeStatuses);
		VerifyUserAbleToConfigureOrderChangeStatuses.logger.debug("Select Order Change Statuses from Configuration list");

		// Enter Order Change Statuses "Processing", "Suspended" and Finished
		String OrderStatusUncheck = this.confPage.enterDataStatus("DataStatusInEnglishBox", "dsieb");
		this.runTimeVariables.put("TC_85_ORDER_STATUS", OrderStatusUncheck);
		VerifyUserAbleToConfigureOrderChangeStatuses.logger.debug("Entered Order Change Statuses Processing, Suspended and Finished");

		// Verify confirmation message for order status created
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Order Change Statuses updated", "Statuses updated",
				TextComparators.contains);
		VerifyUserAbleToConfigureOrderChangeStatuses.logger.debug("Verify Message For Order status when Not check applied ");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToConfigureOrderChangeStatuses.logger.exitMethod();

	}

}
