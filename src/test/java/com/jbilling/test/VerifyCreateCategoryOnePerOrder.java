package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyCreateCategoryOnePerOrder extends BrowserApp {
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

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
	 * @throws Exception
	 */

	@Test(description = "Test Case 140 : Verify user can Create categories with One Per Order.")
	public void createCategoryWithOnePerOrder() throws Exception {

		// Click on configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCreateCategoryOnePerOrder.logger.debug("Click on Confioguration tab");

		// Click on Company link on the left panel
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Company);
		VerifyCreateCategoryOnePerOrder.logger.debug("Click on the company link from the left panel");

		// Set child Company Name
		this.confPage = this.confPage.copyCompany("setCompanyName", "name");
		VerifyCreateCategoryOnePerOrder.logger.debug("Set child Company Name");

		// Click on Product Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyCreateCategoryOnePerOrder.logger.debug("Click on Product tab");

		// Create category with one per order
		String categoryName = this.productsPage.createCategoryWithOneOrder("addCategoryforOnePerOrder", "acopo");

		// Add product in Category with one per order
		String description = this.productsPage.addProductInOnePerOrderCategory("addProdutcforOnePerOrder", "apopo", categoryName);
		VerifyCreateCategoryOnePerOrder.logger.debug("Add product in category with one per order");

		// Click on Product Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyCreateCategoryOnePerOrder.logger.debug("Click on Product tab");

		// Add product in Category with one per order
		String description1 = this.productsPage.addProductInOnePerOrderCategory("addProdutcforOnePerOrder", "apopo", categoryName);
		VerifyCreateCategoryOnePerOrder.logger.debug("Add product in category with one per order");

		// click on plan Menu
		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyCreateCategoryOnePerOrder.logger.debug("Click on Plan Menu");

		// Add Product in plan
		String description2 = this.plansPage.addProductInPlan("addProductOnePerOrder", "ap", categoryName, description);
		VerifyCreateCategoryOnePerOrder.logger.debug("Create product in Plan");

		// click on plan Tab
		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyCreateCategoryOnePerOrder.logger.debug("Click on Plan Tab");
		// Add Product in plan
		String description3 = this.plansPage.addProductInPlan("addProductOnePerOrder", "ap", categoryName, description);
		VerifyCreateCategoryOnePerOrder.logger.debug("Create product in Plan");

		// Add Product in plan
		String description4 = this.plansPage.addProductInPlan("addProductOnePerOrder", "ap", categoryName, description);
		VerifyCreateCategoryOnePerOrder.logger.debug("Create product in Plan");

		// Click on configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyCreateCategoryOnePerOrder.logger.debug("Click on Confioguration tab");

		// Click on Payment Method link
		this.confPage = this.confPage.clickOnPaymentMethodLink();
		VerifyCreateCategoryOnePerOrder.logger.debug("Click on Payment Method link");

		// Add Payment Method Method
		String methodName = this.confPage.addPaymentMethod("testPaymentType", "pt");
		VerifyCreateCategoryOnePerOrder.logger.debug("Add Payment Method");

		// Click on Account type Link
		this.confPage = this.confPage.clickOnAccountTypeLink();
		VerifyCreateCategoryOnePerOrder.logger.debug("Click on Account type Link");
		// Add account type
		String accountType = this.confPage.createAccount(methodName, "accountCreate", "ac");
		VerifyCreateCategoryOnePerOrder.logger.debug("Add account type");

		// Click on Customer Tab
		this.customerPage = this.navPage.navigateToCustomersPage();
		VerifyCreateCategoryOnePerOrder.logger.debug("Click on Customer Tab");

		// Create customer
		String loginName = this.customerPage.addCustomerWithMakePayment("customerCreate", "cc", accountType);
		VerifyCreateCategoryOnePerOrder.logger.debug("Create Customer");

		// Create an Order
		this.customerPage = this.customerPage.createOrderForOnePerOrder("AddorderPerOrder", "ao", description, description1);
		VerifyCreateCategoryOnePerOrder.logger.debug("Create an order");

		// Verifying user is able to add second product
		this.customerPage = this.customerPage.verifyAddedProductInPlan(description, description2, description4);
		VerifyCreateCategoryOnePerOrder.logger.debug("Verifying user is able to add second product");
	}
}
