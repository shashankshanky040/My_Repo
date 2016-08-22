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
public class TestCreateDiscount extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();


/**
	 * Verify user is able to create discounts to be availed while making
	 * purchase.
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 6.3 : Verify user is able to create discounts to be availed while making purchase.")
	public void testCreateDiscount() throws Exception {

		TestCreateDiscount.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909909");

		// Navigate to Discounts Page
		this.discountsPage = this.navPage.navigateToDiscountsPage();
		TestCreateDiscount.logger.debug("Navigate to Discounts Page");

		// Click On Add New Discount Button
		this.discountsPage = this.discountsPage.clickAddNewButton();
		TestCreateDiscount.logger.debug("Click On Add New Discount Button");

		// Click On Save Changes Button
		this.discountsPage = this.discountsPage.clickSaveChangesButton();
		TestCreateDiscount.logger.debug("Click On Save Changes Button");

		// Validate Presence Of Displayed Error
		this.discountsPage = this.discountsPage.isValidationErrorAppeared();
		TestCreateDiscount.logger.debug("Validate Presence Of Displayed Error");

		// Initiate And Complete The Process To Create Discount
		String discountCodeDescription = this.discountsPage.createNewDiscount("addDiscount", "ad");
		this.propReader.updatePropertyInFile("TC_6.3_DISCOUNT_CODE_DESCRIPTION", discountCodeDescription, "testData");

		TestCreateDiscount.logger.debug("Create Discount");

		// Verify That Discount Is Created Successfully
		this.discountsPage = this.discountsPage.isDiscountCreatedSuccessfully();
		TestCreateDiscount.logger.debug("Verify That Discount Is Created Successfully");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		TestCreateDiscount.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		
		this.customerPage =this.customerPage.selectcustomer(this.pr.readTestData("TC_6.2_CHILD_CUSTOMER_NAME"));
		this.customerPage = this.customerPage.clickCreateOrder();
		TestCreateDiscount.logger.debug("Select Customer And Click Create Order");

		// Complete The Process To Create The Order For The Customer
		this.ordersPage = this.ordersPage.createOrder("createOrder", "co", this.pr.readTestData("TC_6.3_DISCOUNT_CODE_DESCRIPTION"));
		TestCreateDiscount.logger.debug("Create The Order For The Customer");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		TestCreateDiscount.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestCreateDiscount.logger.exitMethod();
	}
	
}
