package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddMetaDataFields;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddMetaDataGroupFields;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup extends BrowserApp {
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
	public void checkCreateAssetMgmtMetaDataAndGroupForUser() throws Exception {

		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Meta Data from the list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.MetaFields);
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Select Meta Data from the list");

		// Click Asset field from list
		this.confPage = this.confPage.clickMetaDataFieldValue("ASSET");
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Select Meta Data from the list");

		// Click on +NEW button
		this.confPage = this.confPage.clickAddNewButton();
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Click on +NEW button");

		// Provide data in New Meta Field
		String name = this.confPage.setNewMetaData(AddMetaDataFields.DATA_FIELD, "addNewMetaField", "anmf");
		this.runTimeVariables.put("TC_37_META_NAME", name);

		// Verify Message For Created Account Type
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("MetaField", "created successfully.", TextComparators.contains);
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Verify Message For Created Account Type");

		// Validate Saved Test Data
		this.confPage = this.confPage.validateMetaSavedTestData(name);
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Validate Saved Account Type Test Data");

		// Click on +NEW button
		this.confPage = this.confPage.clickAddNewButton();
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Click on +NEW button");

		// Provide data in New Meta Field
		String secondname = this.confPage.setNewMetaData(AddMetaDataFields.DATA_TYPE, "addSecondMetaField", "asmf");
		this.runTimeVariables.put("TC_37_META_NAME_TWO", secondname);

		// Verify Message For Created Account Type
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("MetaField", "created successfully.", TextComparators.contains);
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Verify Message For Created Account Type");

		// Validate Saved Test Data
		this.confPage = this.confPage.validateMetaSavedTestData(secondname);
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Validate Saved Account Type Test Data");

		// Click on +NEW button
		this.confPage = this.confPage.clickAddNewButton();
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Click on +NEW button");

		// Provide data in New Meta Field
		String thirdname = this.confPage.setNewMetaData(AddMetaDataFields.DATA_DEFAULT_VALUE, "addthirdMetaField", "atmf");
		this.runTimeVariables.put("TC_37_META_NAME_THREE", thirdname);

		// Verify Message For Created Account Type
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("MetaField", "created successfully.", TextComparators.contains);
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Verify Message For Created Account Type");

		// Validate Saved Test Data
		this.confPage = this.confPage.validateMetaSavedTestData(thirdname);
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Validate Saved Account Type Test Data");

		// Select Meta Data Group field from the list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.MetaFieldGroups);
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Select Meta Data from the list");

		// Click Asset field from list
		this.confPage = this.confPage.clickMetaDataFieldValue("ASSET");
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Select Meta Data from the list");

		// Click on +NEW button
		this.confPage = this.confPage.clickAddNewButton();
		VerifyUserAbleToCreateAssetMgmtMetaFieldsAndGroup.logger.debug("Click on +NEW button");

		// Select multiple values and click on save changes button
		this.confPage = this.confPage.setNewMetaDataGroup(AddMetaDataGroupFields.GROUP_DATA_FIELD, "addMetaGroupName", "amdg", secondname,
				thirdname);
		
		// 
	}

}
