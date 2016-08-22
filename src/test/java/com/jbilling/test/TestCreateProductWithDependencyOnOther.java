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

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class TestCreateProductWithDependencyOnOther extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "Test Case 15.1 :  Verify that Products with dependencies on other " + "products can be created.")
	public void testCreateProductWithDependencyOnOther() throws Exception {

		TestCreateProductWithDependencyOnOther.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909925");

		// Login Into Application And Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		TestCreateProductWithDependencyOnOther.logger.debug("Login Into Application And Navigate to Products Tab");

		// Initiate And Complete The Process To Create Product Category with
		// Asset Management
		String assetCategory = this.productsPage.addProductCategoryWithAssetMgmt("CreateProductCategory", "ac");
		this.propReader.updatePropertyInFile("TC_3.2_CATEGORY_NAME", assetCategory, "testData");
		TestCreateProductWithDependencyOnOther.logger.debug("Create Product Category with Asset Management");

		// Verify Text:Saved New Product successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product category", "successfully", TextComparators.contains);
		TestCreateProductWithDependencyOnOther.logger.debug("Verify Text:Saved New Product successfully");

		// Validate Saved New Product successfully
		String savedCategoryName = this.pr.readTestData("TC_3.2_CATEGORY_NAME");
		this.confPage = this.confPage.validateCategoriesSavedTestData(savedCategoryName);
		TestCreateProductWithDependencyOnOther.logger.debug("Validate Saved New Product successfully");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestCreateProductWithDependencyOnOther.logger.debug("Verify Current Page UI Component");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		TestCreateProductWithDependencyOnOther.logger.debug("Navigate to Products Tab");

		// Initiate And Complete The Process To Create A Product Category
		String name = this.productsPage.addCategory("productCategory", "pcat");
		TestCreateProductWithDependencyOnOther.logger.debug("Create A Product Category");

		this.productsPage = this.productsPage.addProductOnDependency("addProductTwo", "ap", this.pr.readTestData("TC_3.2_CATEGORY_NAME"));

		TestCreateProductWithDependencyOnOther.logger.debug("Add The Product With Dependency");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		TestCreateProductWithDependencyOnOther.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestCreateProductWithDependencyOnOther.logger.exitMethod();
	}

}