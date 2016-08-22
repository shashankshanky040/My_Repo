package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class }) @Test(groups = {"automation"})
public class TestCreateCategoryWithAssetManagement extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify user is able to create a Category that uses Asset Management (and
	 * meta fields) 'Asset Category 1' is available to all Companies
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 3.2 : Verify user is able to create a Category that uses "
			+ "Asset Management (and meta fields) 'Asset Category 1' is available to all Companies")
	public void testCreateCategoryWithAssetManagement() throws Exception {

		TestCreateCategoryWithAssetManagement.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047250");

		// Login Into Application And Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		TestCreateCategoryWithAssetManagement.logger.debug("Login Into Application And Navigate to Products Tab");

		// Initiate And Complete The Process To Create Product Category with
		// Asset Management
		String assetCategory = this.productsPage.addProductCategoryWithAssetMgmt("CreateProductCategory", "ac");
		this.propReader.updatePropertyInFile("TC_3.2_CATEGORY_NAME", assetCategory, "testData");
		TestCreateCategoryWithAssetManagement.logger.debug("Create Product Category with Asset Management");

		// Verify Text:Saved New Product successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product category", "successfully", TextComparators.contains);
		TestCreateCategoryWithAssetManagement.logger.debug("Verify Text:Saved New Product successfully");

		// Validate Saved New Product successfully
		String savedCategoryName = this.propReader.readPropertyFromFile("TC_3.2_CATEGORY_NAME", "testData");
		this.confPage = this.confPage.validateCategoriesSavedTestData(savedCategoryName);
		TestCreateCategoryWithAssetManagement.logger.debug("Validate Saved New Product successfully");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestCreateCategoryWithAssetManagement.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestCreateCategoryWithAssetManagement.logger.exitMethod();
	}

}