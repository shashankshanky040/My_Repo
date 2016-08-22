package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class TestAddAndEditProduct extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify user is able to add and edit a Product
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 3.3 : Verify user is able to add and edit a Product.")
	public void testAddAndEditProduct() throws Exception {
		TestAddAndEditProduct.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047251");

		// Login Into Application And Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		TestAddAndEditProduct.logger.debug("Login Into Application And Navigate to Products Tab");

		// Initiate And Complete The Process To Add The Product

		String description = this.productsPage.addProduct(AddProductField.FLAT, "addProductOne", "ap");
		TestAddAndEditProduct.logger.debug("Add The Product");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		TestAddAndEditProduct.logger.debug("Navigate to Products Tab");

		// Initiate And Complete The Process To Add Different Product From
		// Existing
		String description2 = this.productsPage.addProduct(AddProductField.LINEPERCENTAGE, "addProductTwo", "ap");
		TestAddAndEditProduct.logger.debug("Add Different Product From Existing");

		// Initiate And Complete The Process To Edit Existing Product
		this.productsPage = this.productsPage.editProduct("editProduct", "ap");
		TestAddAndEditProduct.logger.debug("Edit Existing Product");

		// Verify Text:Updated New Product successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Updated product", "successfully.", TextComparators.contains);
		TestAddAndEditProduct.logger.debug("Verify Text:Updated New Product successfully");

		Reporter.log("<br> Test Passed");
		TestAddAndEditProduct.logger.exitMethod();
	}

}