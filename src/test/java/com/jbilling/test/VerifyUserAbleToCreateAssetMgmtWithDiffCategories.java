package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.setProductCategoryWithAssetMgmt;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserAbleToCreateAssetMgmtWithDiffCategories extends BrowserApp {
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
	 */

	@Test(groups = { "globalRegressionPack" })
	public void checkCreateAssetMgmtWithDiffCategories() throws Exception {
		VerifyUserAbleToCreateAssetMgmtWithDiffCategories.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToCreateAssetMgmtWithDiffCategories.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Plug-Ins from the list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Plugins);
		VerifyUserAbleToCreateAssetMgmtWithDiffCategories.logger.debug("Select Plug in from the list");

		// Select Plugin Category
		this.confPage = this.confPage.selectPluginCategory("selectPluginCategory", "pc");
		VerifyUserAbleToCreateAssetMgmtWithDiffCategories.logger.debug("Select Plugin Category");

		// Add New plugin
		this.confPage = this.confPage.addNewPluginInCategory("addPlugin", "ap", this.runTimeVariables);
		VerifyUserAbleToCreateAssetMgmtWithDiffCategories.logger.debug("Add new plugin");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserAbleToCreateAssetMgmtWithDiffCategories.logger.debug("Login Into Application And Navigate to Products Tab");

		// Add product category
		this.productsPage.addProductCategoryWithAssetMgmt(setProductCategoryWithAssetMgmt.PCWAMG2, "CreateProductCategory", "ac");

		// Verify that product Category is successfully saved. and select that

		// Click on Edit button

		// Add product category
		this.productsPage.addProductCategoryWithAssetMgmt(setProductCategoryWithAssetMgmt.PCWAMG3, "CreateProductCategory", "ac");

		// Add product category
		this.productsPage.addProductCategoryWithAssetMgmt(setProductCategoryWithAssetMgmt.PCWAMG4, "CreateProductCategory", "ac");

	}

}