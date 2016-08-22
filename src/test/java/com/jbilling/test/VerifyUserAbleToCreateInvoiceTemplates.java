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

public class VerifyUserAbleToCreateInvoiceTemplates extends BrowserApp {
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
	@Test(description = "TC 75 : Verify that user is able to create new invoice templates.", groups = { "globalRegressionPack" })
	public void addInvoiceTemplate() throws Exception {

		VerifyUserAbleToCreateInvoiceTemplates.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToCreateInvoiceTemplates.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select InvoiceTemplates Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.InvoiceTemplates);
		VerifyUserAbleToCreateInvoiceTemplates.logger.debug("Select Invoice Templates from Configuration list");

		// Add New Invoice Template with name "Template-1"
		String AddinvoiceTemplates1 = this.confPage.addInvoiceTemplate("addInvoiceTemplateName", "additn");
		this.runTimeVariables.put("TC_75_AddinvoiceTemplates", AddinvoiceTemplates1);
		VerifyUserAbleToCreateInvoiceTemplates.logger.debug("Add New Invoice Templates");

		// Add New Invoice Template with name "Template-2"
		String AddinvoiceTemplates2 = this.confPage.addInvoiceTemplate("addInvoiceTemplateName", "additn");
		this.runTimeVariables.put("TC_75_AddinvoiceTemplates", AddinvoiceTemplates2);
		VerifyUserAbleToCreateInvoiceTemplates.logger.debug("Add New Invoice Templates");

		// Verify Message For Created Invoice Template
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Invoice Template ", "Created Invoice Template", TextComparators.contains);
		VerifyUserAbleToCreateInvoiceTemplates.logger.debug("Verify Message For Created Invoice Template");

		// Validate Saved Invoice Template Test Data
		this.confPage = this.confPage.validateInvoiceSavedTestData(AddinvoiceTemplates1);
		VerifyUserAbleToCreateInvoiceTemplates.logger.debug("Validate Saved Invoice Templates Test Data");

		// Validate Saved Invoice Template Test Data
		this.confPage = this.confPage.validateInvoiceSavedTestData(AddinvoiceTemplates2);
		VerifyUserAbleToCreateInvoiceTemplates.logger.debug("Validate Saved Invoice Templates Test Data");

		Reporter.log("<br> Test Passed");
		VerifyUserAbleToCreateInvoiceTemplates.logger.exitMethod();

	}

}
