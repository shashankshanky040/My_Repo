package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	static String category = "";
	static String description2 = "";

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

	@Test(description = "TC 76 : Verify User Is Able To Configure Product To Have 1 And 2 Dependencies", groups = {
			"globalRegressionPack" })
	public void ConfigureaPoductToHave1And2Dependencies() throws Exception {

		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Login Into Application And Navigate to Products Tab");

		// Initiate And Complete The Process To Create A Product Category
		String firstCatagory = this.productsPage.addCategory("productCategory", "pcet");
		this.runTimeVariables.put("TC_76_CATEGORY_NAME", VerifyUserIsAbleToAddlDependenciesOnProduct.category);
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Create A Product Category");

		// Validate Saved New Product successfully
		this.confPage = this.confPage.validateCategoriesSavedTestData(this.runTimeVariables.get("TC_76_CATEGORY_NAME"));
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Validate Saved New Product successfully");

		// Initiate And Complete The Process To Add The Product
		String firstProduct = this.productsPage.addProducts(AddProductField.FLAT, "addProductTwoToAddDependencies", "kol");
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Add The Product");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Navigate to Products Tab");

		// Initiate And Complete The Process To Create Second Product Category
		String secondCategory = this.productsPage.addCategory("NewProductCategoryData", "per");
		this.runTimeVariables.put("TC_43.1_CATEGORY_NAME", secondCategory);
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Create Second Product Category");

		// Validate Saved New Product successfully
		this.confPage = this.confPage.validateCategoriesSavedTestData(this.runTimeVariables.get("TC_76_CATEGORY_NAME"));
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Validate Saved New Product successfully");

		// Initiate And Complete The Process To Add Different Product From //
		// Existing
		String secondCatagory = this.productsPage.addProducts(AddProductField.FLAT, "addProductTwoToAddDependencies", "tgb");
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Add Different Product From Existing");

		// Initiate And Complete The Process To Again Add The Product
		String description3 = this.productsPage.Createanotherproduct(AddProductField.FLAT, "addProductTwoToAddDependencies", "idj");
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger
				.debug("Initiate And Complete The Process To Again Add The Product");

		// Click on existing product and Edit the product
		this.productsPage.EditProducts(firstCatagory, "OrderPluginPageInfo1", "oi", secondCategory);
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Click on existing product and Edit the product");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Navigate to Configuration Page");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.PaymentMethod);
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Select Configuration");

		// Configure Payment Method to Account
		this.confPage = this.confPage.SelectPaymentMethodTemplate("configurePaymentTemplateMethod", "pom");
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Configure Payment Method to Account");

		// Add Payment Details
		String methodName = this.confPage.addrecurringPaymentMethodDetails("TestPaymentType", "HFG");
		this.runTimeVariables.put("TC_2.1.1_METHOD_NAME_ONE", methodName);
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Add Payment Details");

		// Verify Text:Payment Method Type Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type", "created successfully", TextComparators.contains);
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Verify Payment Method Type Is Created Successfully");

		// Navigate to account type from left navigation

		this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Navigate to account type");

		// Create a new account type
		String accountTypename = this.confPage.accounttype("AccountTypeName", "oii", methodName);
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Create a new account type");

		// Navigate To Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Navigate To Customers Page");

		// Initiate And Complete The Process To Add a New Customer
		this.customerPage.addNewCustomer(accountTypename, methodName, "NewCustomerInfo", "ldr");
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Initiate And Complete The Process To Add a New Customer");

		// Initiate And Complete The Process to Edit customer

		this.customerPage.createOrderCustomer("EditCustomerInfo", "ysk");
		VerifyiyUserIsAbleToConfigureProductToHave1And2Dependencies.logger.debug("Initiate And Complete The Process to Edit customer");

	}

}
