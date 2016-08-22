package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyAddProductwithDifferentPricingModel extends BrowserApp {
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
	@Test(description = "60.1", groups = { "globalRegressionPack" })
	public void VerifyAddProductwithDifferentPricing() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Product Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyAddProductwithDifferentPricingModel.logger.debug("Login Into Application And Navigate to Product Page");

		// Click Add Category button

		String testData = this.productsPage.addCategory("CreateProductCategoryData", "pcd");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Category");

		// Click Add Product Button and Add a product
		this.ProductID = this.productsPage.addProduct(AddProductField.DESCRIPTION, "addProductCategoryOne", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product with Description");

		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");

		Reporter.log("<br> Test Passed");
		VerifyAddProductwithDifferentPricingModel.logger.exitMethod();
	}

	@Test(description = "60.2", dependsOnMethods = "VerifyAddProductwithDifferentPricing")
	public void VerifyAddProductwithFlatPrice() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		/*
		 * // Login Into Application And Navigate to Product Tab
		 * this.productsPage = this.navPage.navigateToProductsPage();
		 * VerifyAddProductwithDifferentPricingModel
		 * .logger.debug("Login Into Application And Navigate to Product Page");
		 */

		// Click Add Product Button and Add a product
		this.ProductID = this.productsPage.addProduct(AddProductField.FLATPRICE, "addProductWithFlatPricing", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product");
		System.out.println("Product ID" + this.ProductID);

		Reporter.log("<br> Test Passed");
		VerifyAddProductwithDifferentPricingModel.logger.exitMethod();

		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");

	}

	@Test(description = "60.3", dependsOnMethods = "VerifyAddProductwithDifferentPricing")
	public void VerifyAddProductwithGraduatePrice() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");
		// Click Add Product Button and Add a product with Quantity
		this.ProductID = this.productsPage.addProduct(AddProductField.GRADUATEDPRICE, "addProductWithGraduatePricing", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product with garduate price and quantity");
		System.out.println("Product ID" + this.ProductID);

		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");

		Reporter.log("<br> Test Passed");
		VerifyAddProductwithDifferentPricingModel.logger.exitMethod();
	}

	@Test(description = "60.4", dependsOnMethods = "VerifyAddProductwithDifferentPricing")
	public void VerifyAddProductwithGraduatedCapPrice() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");
		// Click Add Product Button and Add a product with Quantity
		this.ProductID = this.productsPage.addProduct(AddProductField.GRADUATECAPPRICE, "addProductWithGraduateCapPricing", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product with garduate cap price and maximum");
		System.out.println("Product ID" + this.ProductID);

		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");

		Reporter.log("<br> Test Passed");
		VerifyAddProductwithDifferentPricingModel.logger.exitMethod();

	}

	@Test(description = "60.5", dependsOnMethods = "VerifyAddProductwithDifferentPricing")
	public void VerifyAddProductwithTimeOfDayPrice() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");
		// Click Add Product Button and Add a product with Time of Day Pricing
		this.ProductID = this.productsPage.addProduct(AddProductField.TIMEOFDAY, "addProductWithTimeOfDayPricing", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product with Time of day price and quantity");
		System.out.println("Product ID" + this.ProductID);

		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");

	}

	@Test(description = "60.6", dependsOnMethods = "VerifyAddProductwithDifferentPricing")
	public void VerifyAddProductwithTieredPricing() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");
		// Click Add Product Button and Add a product with Tiered Pricing
		this.ProductID = this.productsPage.addProduct(AddProductField.TIERED, "addProductWithTieredPricing", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product with Time of day price and quantity");
		System.out.println("Product ID" + this.ProductID);

		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");
	}

	@Test(description = "60.7", dependsOnMethods = "VerifyAddProductwithDifferentPricing")
	public void VerifyAddProductwithVolumePricing() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Click Add Product Button and Add a product with Volume Pricing
		this.ProductID = this.productsPage.addProduct(AddProductField.VOLUME, "addProductWithVolumePricing", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product with Time of day price and quantity");
		System.out.println("Product ID" + this.ProductID);

		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");
	}

	@Test(description = "60.8", dependsOnMethods = "VerifyAddProductwithDifferentPricing")
	public void VerifyAddwithPooledPricing() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");
		// Click Add Product Button and Add a product with Pooled Pricing
		this.ProductID = this.productsPage.addProduct(AddProductField.POOLED, "addProductWithPooledPricing", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product with Time of day price and quantity");
		System.out.println("Product ID" + this.ProductID);

		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");
	}

	@Test(description = "60.10", dependsOnMethods = "VerifyAddProductwithDifferentPricing")
	public void VerifyAddwithItemPercantageSelector() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");
		// Click Add Product Button and Add a product with Item Percentage
		// Selector Pricing
		this.ProductID = this.productsPage.addProduct(AddProductField.ITEMPAGESELECTOR, "addProductWithItemPercantageSelector", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product with Time of day price and quantity");
		System.out.println("Product ID" + this.ProductID);

		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");

	}

	@Test(description = "60.9", dependsOnMethods = "VerifyAddProductwithDifferentPricing")
	public void VerifyAddItemItemSelector() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");
		// Click Add Product Button and Add a product with Item Selector Pricing
		this.ProductID = this.productsPage.addProduct(AddProductField.ITEMSELECTOR, "addProductWithItemSelector", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product with Time of day price and quantity");
		System.out.println("Product ID" + this.ProductID);

		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");

	}

	@Test(description = "60.11", dependsOnMethods = "VerifyAddProductwithDifferentPricing")
	public void VerifyAddItemQuantityAdd() throws Exception {
		VerifyAddProductwithDifferentPricingModel.logger.enterMethod();
		Reporter.log("<br> Test Begins");
		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");
		// Click Add Product Button and Add a product with Quantity Add on
		// Pricing
		this.ProductID = this.productsPage.addProduct(AddProductField.QUANTITYADON, "addProductWithQuantityAdOn", "ap");
		VerifyAddProductwithDifferentPricingModel.logger.debug("Add a Product with Time of day price and quantity");
		System.out.println("Product ID" + this.ProductID);
		// Verify Message for Add Product
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product", "successfully", TextComparators.contains);
		VerifyAddProductwithDifferentPricingModel.logger.debug("Verify Message for Add product Successfully");
	}
}
