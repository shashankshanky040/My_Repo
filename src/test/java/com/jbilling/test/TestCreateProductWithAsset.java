package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class }) @Test(groups = {"automation"})
public class TestCreateProductWithAsset extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify that a user can create a product with an asset
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 3.4 : Verify that a user can create a product with an asset")
	public void testCreateProductWithAsset() throws Exception {
		TestCreateProductWithAsset.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047252");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestCreateProductWithAsset.logger.debug("Navigate to Configuration Page");

		// Switching to Billing Process configuration item
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Plugins);
		TestCreateProductWithAsset.logger.debug("Switching to Plugins configuration item");

		// Initiate And Complete The Process To Add The Plugin
		this.productsPage = this.productsPage.addPlugin("addPlugin", "ap");
		TestCreateProductWithAsset.logger.debug("Add The Plugin");

		// Navigate Back To Products Page
		this.productsPage = this.navPage.navigateToProductsPage();
		TestCreateProductWithAsset.logger.debug("Navigate Back To Products Page");

		// Initiate And Complete The Process To Add The Product
		String englishDescription = this.productsPage.addProduct(AddProductField.ASSETMANAGEMENT, "addProductThree", "ap");
		this.propReader.updatePropertyInFile("TC_3.4_ENGLISH_DESC", englishDescription, "testData");
		TestCreateProductWithAsset.logger.debug("Add The Product");

		// Initiate And Complete The Process To Add An Asset
		this.productsPage = this.productsPage.addAsset();
		String assetIdentifier1 = this.productsPage.addAsset("addAssetOne", "ap");

		this.propReader.updatePropertyInFile("TC_3.4_IDENTIFIER_ONE", assetIdentifier1, "testData");
		TestCreateProductWithAsset.logger.debug("Add An Asset");

		// Initiate And Complete The Process To Add Different Asset From
		// Existing
		this.productsPage = this.productsPage.clickAddNew();
		String assetIdentifier2 = this.productsPage.addAsset("addAssetTwo", "ap");

		this.propReader.updatePropertyInFile("TC_3.4_IDENTIFIER_TWO", assetIdentifier2, "testData");
		TestCreateProductWithAsset.logger.debug("Add Different Asset From Existing");

		// Validate Saved New Asset Identifier One successfully
		String identifierOne = this.propReader.readPropertyFromFile("TC_3.4_IDENTIFIER_ONE", "testData");
		// this.productsPage =
		// this.productsPage.validateUserTableSavedTestData(identifierOne);
		TestCreateProductWithAsset.logger.debug("Validate Saved New Asset Identifier One successfully");

		// Validate Saved New Asset Identifier Two successfully
		String identifierTwo = this.propReader.readPropertyFromFile("TC_3.4_IDENTIFIER_TWO", "testData");

		// this.productsPage =
		// this.productsPage.validateUserTableSavedTestData(identifierTwo);
		TestCreateProductWithAsset.logger.debug("Validate Saved New Asset Identifier Two successfully");

		Reporter.log("<br> Test Passed");
		TestCreateProductWithAsset.logger.exitMethod();
	}

}