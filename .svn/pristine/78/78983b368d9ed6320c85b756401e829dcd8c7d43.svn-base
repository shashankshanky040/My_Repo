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

public class VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	static String category = "";

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "TC 51 : Verify User Able To Create Order Changes Statuses And Order Change Type Plugins", groups = {
			"globalRegressionPack" })
	public void createOrderChangesStatusesandorderchangetypeplugins() throws Exception {

		VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins.logger
				.debug("Login Into Application And Navigate to Configuration Page");

		// Select OrderChangeStatuses from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.OrderChangeStatuses);
		VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins.logger
				.debug("Select OrderChangeStatuses from Configuration list");

		// On Order Change Statuses page Data is entered with data
		this.confPage = this.confPage.setNumberOfRowsToTwo();
		VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins.logger
				.debug("On Order Change Statuses page Data is entered with data");

		// Verify Message For Created Order Changes Statuses
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Order Change Statuses updated", "", TextComparators.contains);
		VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins.logger.debug("Verify Message For Edit Payment Method Type");

		// Select plugins from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Plugins);
		VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins.logger.debug("Select plugins from Configuration list");

		// Click in "17 Generic internal events listener" on plug in page and
		// click on Add New Button
		this.confPage = this.confPage.ClickOnEventListner();
		VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins.logger.debug("Select plugins from Configuration list");

		// verify the page header
		this.confPage = this.confPage.verifyAddPluginPageHeader();
		VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins.logger.debug("Add Plugin Page Header Verified");

		// Select Type,Order,and Click Save Plugin on Add new plug-in page
		this.confPage = this.confPage.enterTestDataInOnPlugnin("OrderPluginPageInfo", "oi");
		VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins.logger.debug("Select plugins from Configuration list");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToCreateOrderChangesStatusesAndOrderChangeTypePlugins.logger.exitMethod();

	}
}