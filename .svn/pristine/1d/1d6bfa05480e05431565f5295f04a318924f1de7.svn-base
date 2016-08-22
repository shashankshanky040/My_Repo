package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

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

public class VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;
	static String category = "";

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "TC 53 : Verify User Is Able To Set Up Fee Product And Related Plug In To Be Used As CancellationFee", groups = {
			"globalRegressionPack" })
	public void SetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee() throws Exception {

		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		// Login Into Application And Navigate to Product Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger
				.debug("Login Into Application And Navigate to Product Page");

		// Initiate And Complete The Process To Create A Product Category
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.category = this.productsPage
				.addCategory("productCategory", "pcat");
		this.runTimeVariables.put("TC_53_CATEGORY_NAME",
				VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.category);
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.debug("Create A Product Category");

		// Validate Saved New Product successfully
		this.confPage = this.confPage.validateCategoriesSavedTestData(this.runTimeVariables.get("TC_53_CATEGORY_NAME"));
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.debug("Validate Saved New Product successfully");

		// Initiate And Complete The Process To Add The Product
		String description2 = this.productsPage.addProducts(AddProductField.FLAT, "addProductOneToAddDependencies", "pou");
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.debug("Add Different Product From Existing");

		// Initiate And Complete The Process To Add The Product
		String description3 = this.productsPage.Createanotherproduct(AddProductField.FLAT, "addProductTwoToAddDependencies", "pok");
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.debug("Add Different Product From Existing");

		// Navigate to Configuration Tab
		this.navPage.navigateToConfigurationPage();
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger
				.debug("Login Into Application And Navigate to Configuration Page");

		// Select plugins from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Plugins);
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.debug("Select plugins from Configuration list");

		// verify the page header
		this.confPage = this.confPage.verifyPluginscategoriesPageHeader();
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.debug("Add Plugin Page Header Verified");

		// Click in "17 Generic internal events listener" on plug in page and
		// click on Add New Button
		this.confPage = this.confPage.ClickOnEventListner();
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.debug("Select plugins from Configuration list");

		// verify the page header
		this.confPage = this.confPage.verifyAddPluginPageHeader();
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.debug("Add Plugin Page Header Verified");

		// Select Type,Order,and Click Save Plugin on Add new plug-in page
		this.confPage = this.confPage.enterTestDataInOnPlugnin("OrderPluginPageInfo", "oi");
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.debug("Select plugins from Configuration list");

		// Select OrderChangeStatuses from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.OrderChangeStatuses);
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger
				.debug("Select OrderChangeStatuses from Configuration list");

		// verify if checkbox of "Test Status"is uncheck and checkbox is
		// selected "Default(Apply)" status
		this.confPage = this.confPage.CheckboxOrderChangeStatuses();
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger
				.debug("Select OrderChangeStatuses from Configuration list");

		Reporter.log("<br> Test Passed");
		VerifyUserIsAbleToSetUpFeeProductAndRelatedPlugInToBeUsedAsCancellationFee.logger.exitMethod();

	}
}