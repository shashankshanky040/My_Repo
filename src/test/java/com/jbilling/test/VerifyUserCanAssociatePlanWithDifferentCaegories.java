package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
/**
 * Current Application Page Stack || LoginPage--> loginPage; NavigatorPage-->
 * navPage; HomePage--> homePage; ConfigurationPage--> confPage; AgentsPage-->
 * agentsPage; CustomersPage--> customerPage; ProductsPage--> productsPage;
 * PlansPage--> plansPage; OrdersPage--> ordersPage; InvoicePage--> invoicePage;
 * ReportsPage--> reportsPage; DiscountsPage--> discountsPage; FiltersPage-->
 * filtersPage; PaymentsPage--> paymentsPage; MessagesPage--> msgsPage;
 * 
 * @author Aishwarya Dwivedi
 * @since 1.0
 * @version 1.0
 */
public class VerifyUserCanAssociatePlanWithDifferentCaegories extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	static String category = "";

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "TC 143 : Verify user can associate plan with different (OPO/OPC) caegories.")
	public void validateMetaFiledtypeSelction() throws Exception {

		// Click on Product Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserCanAssociatePlanWithDifferentCaegories.logger.debug("Click on the Product Tab");

		// Add new category
		String categoryName1 = this.productsPage.createCategoryWithOneCustomer("addCategoryOnePerCustomer", "acopc");
		VerifyUserCanAssociatePlanWithDifferentCaegories.logger.debug("Add new category");

		// Click on Product Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserCanAssociatePlanWithDifferentCaegories.logger.debug("Click on the Product Tab");

		// Add new category
		String categoryName2 = this.productsPage.createCategoryWithOneOrder("addCategoryforOnePerOrder", "acopo");
		VerifyUserCanAssociatePlanWithDifferentCaegories.logger.debug("Add new category");

		// Add product in Category with one per order
		String description = this.productsPage.addProductInOnePerOrderCategory("addProdutcforOnePerOrder", "apopo", categoryName1);
		VerifyUserCanAssociatePlanWithDifferentCaegories.logger.debug("Add product in category with one per order");

		// Click on Plan Menu
		this.plansPage = this.navPage.navigateToPlanPage();
		VerifyUserCanAssociatePlanWithDifferentCaegories.logger.debug("Click on Plan Menu");

		// Add Product in plan
		String planDescription = this.plansPage.addProductInMultipleCategoryInPlan("addProductOnePerOrder", "ap", categoryName1,
				categoryName2, description);
		VerifyUserCanAssociatePlanWithDifferentCaegories.logger.debug("Create product in Plan");

		// Validate Added category in Plan
		this.plansPage = this.plansPage.verifyCategoryName(planDescription, categoryName1, categoryName2);
		VerifyUserCanAssociatePlanWithDifferentCaegories.logger.debug("Validate Added Category in plan");
	}
}
