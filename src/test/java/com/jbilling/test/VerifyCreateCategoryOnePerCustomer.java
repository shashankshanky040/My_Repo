package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyCreateCategoryOnePerCustomer extends BrowserApp {

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

	@Test(description = "TC 141 : Verify user can Create categories with One Per Customer ")
	public void createCategoryWithOnePerOrder() throws Exception {

		// Click on configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on Confioguration tab");

		// Click on Company link on the left panel
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Company);
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on the company link from the left panel");

		// Set child Company Name
		this.confPage = this.confPage.copyCompany("setCompanyName", "name");
		VerifyCreateCategoryOnePerCustomer.logger.debug("Set child Company Name");

		// Click on Product Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on Product tab");

		// Create category with one per order
		String categoryName = this.productsPage.createCategoryWithOneCustomer("addCategoryOnePerCustomer", "acopc");

		// Add product in Category with one per order
		String productDescription = this.productsPage.addProductInOnePerCustomerCategory("addFirstProductOnePerCustomer", "apopc",
				categoryName);
		VerifyCreateCategoryOnePerCustomer.logger.debug("Add product in category with one per order");

		// Click on Product Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on Product tab");

		// Add product in Category with one per order
		String productDescription1 = this.productsPage
				.addProductInOnePerCustomerCategory("addProductOnePerCustomer", "apopc", categoryName);
		VerifyCreateCategoryOnePerCustomer.logger.debug("Add product in category with one per order");

		// Click on Product Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on Product tab");

		// Add product in Category with one per order
		String productDescription2 = this.productsPage
				.addProductInOnePerCustomerCategory("addProductOnePerCustomer", "apopc", categoryName);
		VerifyCreateCategoryOnePerCustomer.logger.debug("Add product in category with one per order");
		//
		// // Click on Customer menu
		// this.customerPage = this.navPage.navigateToCustomersPage();
		//
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on customer menu");

		// Click on configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on Confioguration tab");

		// Click on Payment Method link
		this.confPage = this.confPage.clickOnPaymentMethodLink();
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on Payment Method link");

		// Add Payment Method Method
		String methodName = this.confPage.addPaymentMethod("testPaymentType", "pt");
		VerifyCreateCategoryOnePerCustomer.logger.debug("Add Payment Method");

		// Click on Account type Link
		this.confPage = this.confPage.clickOnAccountTypeLink();
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on Account type Link");
		// Add account type
		String accountType = this.confPage.createAccount(methodName, "accountCreate", "ac");
		VerifyCreateCategoryOnePerCustomer.logger.debug("Add account type");

		// Click on Customer Tab
		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on Customer Tab");

		// Create customer
		String loginName = this.customerPage.addCustomerWithMakePayment("customerCreate", "cc", accountType);
		VerifyCreateCategoryOnePerCustomer.logger.debug("Create Customer");

		// Create an Order
		this.customerPage = this.customerPage.createOrderForOnePerCustomer("AddorderPerCustomer", "aopc", productDescription);
		VerifyCreateCategoryOnePerCustomer.logger.debug("Create an order");

		// Click on Customer Tab
		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyCreateCategoryOnePerCustomer.logger.debug("Click on Customer Tab");

		// Add another product in existing Customer
		this.customerPage = this.customerPage.addProductInExistingCustomer("AddorderPerCustomer", "aopc", loginName, productDescription1);
		VerifyCreateCategoryOnePerCustomer.logger.debug("Add another product in existing customer");
	}
}
