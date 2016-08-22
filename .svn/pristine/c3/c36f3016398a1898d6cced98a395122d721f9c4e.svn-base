package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyUserAbleToEditDeletePaymentMethod extends BrowserApp {
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

	@Test(description = "TC 10 : Verify that user can edit and delete the created payment method")
	public void TC10_EditDeletePaymentMethodForCheque() throws Exception {

		VerifyUserAbleToEditDeletePaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToEditDeletePaymentMethod.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.PaymentMethod);
		VerifyUserAbleToEditDeletePaymentMethod.logger.debug("Select Payment Method from Configuration list");

		// Add Edit Delete Payment Method With Recurring
		this.confPage = this.confPage.addEditDeletePaymentMethod("TC10_AddEditDeletePaymentMethod", "aedpm");
		VerifyUserAbleToEditDeletePaymentMethod.logger.debug("Add Edit Delete Payment Method With Recurring");

		// Verify Message For Delete Method
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Deleted Payment Method Type", "successfully", TextComparators.contains);
		VerifyUserAbleToEditDeletePaymentMethod.logger.debug("Verify Message For Delete Method");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToEditDeletePaymentMethod.logger.exitMethod();
	}

}