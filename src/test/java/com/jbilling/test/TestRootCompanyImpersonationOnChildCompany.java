package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AccountTypeField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.CollectionAgeingStep;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.textutilities.TextUtilities;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class }) @Test(groups = {"automation"})
public class TestRootCompanyImpersonationOnChildCompany extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

@Test(description = "Test Case 5.1: Verify that Root Company has ability to "
			+ "impersonate Child Company and view all & only information assigned to Child Company.")
	public void testRootCompanyImpersonationOnChildCompany() throws Exception {
		TestRootCompanyImpersonationOnChildCompany.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909906");

//		// Switch To Child Company
//		this.homePage = this.navPage.switchToChildCompany(this.runTimeVariables.get("TC_1.3_CHILD_COMPANY_COMPANYNAME"));
//		TestRootCompanyImpersonationOnChildCompany.logger.debug("Switch To Child Company");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		TestRootCompanyImpersonationOnChildCompany.logger.debug("Navigate to Products Page");

//		// Switch To Parent Company
//		this.homePage = this.navPage.switchToParentCompany();
//		TestRootCompanyImpersonationOnChildCompany.logger.debug("Switch To Parent Company");

		// Navigate To Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestRootCompanyImpersonationOnChildCompany.logger.debug("Navigate To Customers Page");

		// Verify Current Page UI Component
		this.customerPage = this.customerPage.verifyUIComponent();
		TestRootCompanyImpersonationOnChildCompany.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestRootCompanyImpersonationOnChildCompany.logger.exitMethod();

	}
}