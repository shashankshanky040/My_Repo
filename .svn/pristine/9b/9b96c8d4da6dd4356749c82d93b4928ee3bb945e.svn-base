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
public class TestCreateProductCategory extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify user is able to create/edit a Category 'New Test Category' is only
	 * available to Root Company (jBilling).
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 3.1 : Verify user is able to create/edit a Category 'New Test "
			+ "Category' is only available to Root Company (jBilling).")
	public void testCreateProductCategory() throws Exception {
		TestCreateProductCategory.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047249");

		// Login Into Application And Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		TestCreateProductCategory.logger.debug("Login Into Application And Navigate to Products Tab");

		// Initiate And Complete The Process To Create A Product Category
		String name = this.productsPage.addCategory("CreateProductCategoryData", "pcd");
		TestCreateProductCategory.logger.debug("Create A Product Category");

		// Initiate And Complete The Process To Edit The Existing Product
		// Category
		String categoryName = this.productsPage.editCategory("NewProductCategoryData", "pcd");
		TestCreateProductCategory.logger.debug("Edit The Product Category");
		this.propReader.updatePropertyInFile("TC_3.1_CATEGORY_NAME", categoryName, "testData");

		// Validate Saved Account Type Test Data
		this.confPage = this.confPage.validateCategoriesSavedTestData(this.propReader.readPropertyFromFile("TC_3.1_CATEGORY_NAME",
				"testData"));
		TestCreateProductCategory.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestCreateProductCategory.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestCreateProductCategory.logger.exitMethod();
	}

}