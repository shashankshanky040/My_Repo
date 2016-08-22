package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView extends BrowserApp {
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	static String category = "";
	static String description2 = "";

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

	@Test(description = "TC 124 : Verify That Discounts Are Correctly Displayed InJQGrid View", groups = { "globalRegressionPack" })

	public void DiscountsAreCorrectlyDisplayedInJQGridView() throws Exception {

		VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.navPage.navigateToConfigurationPage();
		VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView.logger.debug("Login Into Application And Navigate to Configuration tab");

		// Click on "Should use JQGrid for tables" from Preference list
		// Verify Preference and Preference 63 is displaying in header
		this.confPage = this.confPage.selectJQGridForTables();
		VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView.logger.debug("Click on Should use JQGrid for tables from  Preference list ");

		// Enter value in "Should use JQGrid for tables"
		this.confPage = this.confPage.enterValueInJQGrid("EnterValueJQGrid", "rte");
		VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView.logger.debug("Select Should use JQGrid for tables from Preference list");

		// Verify message Preferences 63 Updated Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Preference 63", "updated successfully", TextComparators.contains);
		VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView.logger.debug("Verify message Preferences 63 Updated Successfully");

		// Navigate to discount tab
		this.navPage.navigateToDiscountsPage();
		VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView.logger.debug("Navigate to discount tab");

		// Verify Discount Code with search text field , Description ,Discount
		// Type appears on the screen
		this.discountsPage.Verifydiscountstable();
		VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView.logger
				.debug("Verify Discount Code with search text field , Description ,Discount Type appears on the screen");

	}

	@Test(description = "TC 125 : Verify that JQGrid view gets turned off successfully.", dependsOnMethods = {
			"DiscountsAreCorrectlyDisplayedInJQGridView" }, priority = 2)
	public void VerifyThatJQGridViewGetsTurnedOffSuccessfully() throws Exception {

		// Navigate to Configuration Tab
		this.navPage.navigateToConfigurationPage();
		VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView.logger.debug("Navigate to Configuration tab");

		// Turned off JQGrid view
		this.confPage = this.confPage.changeJQGridForTables("EnterValueJQGrid", "rjy");
		VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView.logger.debug("Turned off JQGrid view ");

		// Verify message Preferences 63 Updated Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Preference 63", "updated successfully", TextComparators.contains);
		VerifytThatDiscountsAreCorrectlyDisplayedInJQGridView.logger.debug("Verify Message Preferences 63 Updated Successfully");

	}
}