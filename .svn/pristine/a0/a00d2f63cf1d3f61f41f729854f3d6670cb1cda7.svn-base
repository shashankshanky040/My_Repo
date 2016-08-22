package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.MessagesPage;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyStatusofPreExistingandNewOrder extends BrowserApp {
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	String ProductID = "null";
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

	@Test(description = "107", groups = { "globalRegressionPack" })
	public void VerifyStatusofPreExistingandNewOrder() throws Exception {
		VerifyStatusofPreExistingandNewOrder.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configure Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyStatusofPreExistingandNewOrder.logger.debug("Login Into Application And Navigate to Configure Page");
		this.confPage = this.confPage.VerifyOrderStatus("VerifyOrderStatuses", "OS");
		// Verify Message for Add Product
		boolean msgsPage = MessagesPage.isErrorMessageAppeared();
		System.out.println("msgsPage" + msgsPage);
		VerifyStatusofPreExistingandNewOrder.logger.debug("Verify Message for Error for Flag Field");
		Reporter.log("<br> Test Passed");
		VerifyStatusofPreExistingandNewOrder.logger.exitMethod();
	}
}
