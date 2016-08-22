package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyUserAbleGetMandatoryFieldMessageForAccountType extends BrowserApp {
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

	@Test(description = "TC 11.2 : Verify User able to get mandatory field validation message")
	public void TC11_2_VerifyMandatoryFieldMessageForAccountType() throws Exception {

		VerifyUserAbleGetMandatoryFieldMessageForAccountType.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleGetMandatoryFieldMessageForAccountType.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyUserAbleGetMandatoryFieldMessageForAccountType.logger.debug("Select Payment Method from Configuration list");

		// Verify Mandatory Field Message Appears
		this.confPage = this.confPage.verifyMandatoryFieldMessages("mandatoryFieldAccountType", "mfat");
		VerifyUserAbleGetMandatoryFieldMessageForAccountType.logger.debug("Verify Mandatory Field Message Appears");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleGetMandatoryFieldMessageForAccountType.logger.exitMethod();
	}

}
