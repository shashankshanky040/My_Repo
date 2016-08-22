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

public class VerifySearchingSortingForFreeUsagePoolafterSwitchingConfigurationOnfromOff extends BrowserApp {

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

	@Test(description = "TC 114 : Verify searching and sorting works as defined for 'Free Usage Pool' after switching configuration 'On' from 'Off'", groups = {
			"globalRegressionPack" })
	public void configureFreeUsagePoolOnFromOff() throws Exception {

		VerifySearchingSortingForFreeUsagePoolafterSwitchingConfigurationOnfromOff.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifySearchingSortingForFreeUsagePoolafterSwitchingConfigurationOnfromOff.logger
				.debug("Login Into Application And Navigate to Configuration Page");

		// Initiate And Complete The Process To set preferences 63
		this.confPage = this.confPage.setConfigurationPreference("addPreferencesvalue1", "ap");
		VerifySearchingSortingForFreeUsagePoolafterSwitchingConfigurationOnfromOff.logger.debug("Add The value 1 in Preferences 63");

		// Verify Preferences 63 Updated Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Preference 63", "updated successfully", TextComparators.contains);
		VerifySearchingSortingForFreeUsagePoolafterSwitchingConfigurationOnfromOff.logger
				.debug("Verify Preferences 63 Updated Successfully");

		// Select Free Usage Pool from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.FreeUsagePools);
		VerifySearchingSortingForFreeUsagePoolafterSwitchingConfigurationOnfromOff.logger
				.debug("Select Free Usage Pool from Configuration list");

		// Navigate to configuration tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifySearchingSortingForFreeUsagePoolafterSwitchingConfigurationOnfromOff.logger
				.debug("Login Into Application And Navigate to Configuration Page");

		// Initiate And Complete The Process To set preferences 63 for JQ Grid

		this.confPage = this.confPage.setConfigurationPreferenceJQGrid("addPreferencesvalue0", "ap");
		VerifySearchingSortingForFreeUsagePoolafterSwitchingConfigurationOnfromOff.logger.debug("Add The value 0 in Preferences 63");

		// Verify Preferences 63 Updated Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Preference 63", "updated successfully", TextComparators.contains);
		VerifySearchingSortingForFreeUsagePoolafterSwitchingConfigurationOnfromOff.logger
				.debug("Verify Preferences 63 Updated Successfully");

		Reporter.log("<br> Test Passed");
		VerifySearchingSortingForFreeUsagePoolafterSwitchingConfigurationOnfromOff.logger.exitMethod();
	}
}
