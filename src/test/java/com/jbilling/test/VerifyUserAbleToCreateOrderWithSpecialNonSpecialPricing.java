package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyUserAbleToCreateOrderWithSpecialNonSpecialPricing extends BrowserApp {

	public class VerifyUserAbleToAddPaymentMethod extends BrowserApp {
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
		 * @author Shashank
		 * @since 1.0
		 * @version 1.0
		 */
		public void TC98_UserAbleToCreateOrderWithSpecialNonSpecialPricing() {
			VerifyUserAbleToAddPaymentMethod.logger.enterMethod();
			Reporter.log("<br> Test Begins");

			this.result = Reporter.getCurrentTestResult();
			this.result.setAttribute("tcid", "");
			VerifyUserAbleToAddPaymentMethod.logger.debug("");

		}
	}
}
