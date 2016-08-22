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
public class VerifyUserAbleToEditCompanyDetails extends BrowserApp {

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

	@Test(description = "TC 02: Verify that users can Edit Company details")
	public void TC02_EditCompanyDetails() throws Exception {

		VerifyUserAbleToEditCompanyDetails.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToEditCompanyDetails.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Initiate The Process To Select Company from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Company);
		VerifyUserAbleToEditCompanyDetails.logger.debug("Select Company from Configuration list");

		// Company Details are Edited
		this.confPage = this.confPage.editCompanyDetails("TC02_EditCompanyDetails", "cd");
		VerifyUserAbleToEditCompanyDetails.logger.debug("Company Details are Edited");

		// Verify Message For Company Details Changed
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Successfully saved", "Company information.", TextComparators.contains);
		VerifyUserAbleToEditCompanyDetails.logger.debug("Verify Message For Company Details Changed");

	}

}
