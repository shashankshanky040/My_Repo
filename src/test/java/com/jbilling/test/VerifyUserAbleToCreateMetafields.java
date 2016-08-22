package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

public class VerifyUserAbleToCreateMetafields extends BrowserApp {

	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Current Application Page Stack || LoginPage--> loginPage;
	 * NavigatorPage--> navPage; HomePage--> homePage; ConfigurationPage-->
	 * confPage; MetaFields--> MetaFieldsPage; Customers--> customerPage;
	 *
	 * @author .....
	 * @since 1.0
	 * @version 1.0
	 */

	@Test()
	public void TC66_VerifyUserAbleToCreateMetafields() throws Exception {

		VerifyUserAbleToCreateMetafields.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		VerifyUserAbleToCreateMetafields.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Select Payment Method from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.MetaFields);
		VerifyUserAbleToCreateMetafields.logger.debug("Select Meta Fields from Configuration list");

		// Select Customer from Configuration list & Add click on add button
		this.confPage = this.confPage.createMetafield();
		VerifyUserAbleToCreateMetafields.logger.debug("Select Customer from Meta Fields list");

		// Browser Exit
		Reporter.log("<br> Test Passed");
		VerifyUserAbleToCreateMetafields.logger.exitMethod();

	}

}