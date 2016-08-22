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
public class TestCreateProductWithCommissions extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify that products with commisions can be made
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 16.2 : Verify that products with commisions can be made")
	public void testCreateProductWithCommissions() throws Exception {

		TestCreateProductWithCommissions.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909928");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		TestCreateProductWithCommissions.logger.debug("Navigate to Products Tab");

		// Initiate And Complete The Process To Create A Product Category
		String name = this.productsPage.addCategory("NewProductCategoryData", "pcd");
		TestCreateProductWithCommissions.logger.debug("Create A Product Category");

		// Initiate And Complete The Process To Add a Product With Commission
		this.productsPage = this.productsPage.addProductWithCommission("addProductTwo", "ap");
		TestCreateProductWithCommissions.logger.debug("Add a Product With Commission");

		Reporter.log("<br> Test Passed");
		TestCreateProductWithCommissions.logger.exitMethod();
	}

}