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
public class TestLoginIntoCompany extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "Test Case 1.2:  Verify that users are able to login into the JBilling System using valid credential.")
	public void testLoginIntoCompany() throws Exception {
		TestLoginIntoCompany.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047237");

		// Logout From The Application
		this.loginPage = this.navPage.logoutApplication();
		TestLoginIntoCompany.logger.debug("Logout From The Application");
	
		this.runTimeVariables.put("ENVIRONMENT_UNDER_TEST", this.pr.readConfig("EnvironmentUnderTest"));
		this.runTimeVariables.put("ENVIRONMENT_URL_UNDER_TEST",
				this.pr.readConfig(this.runTimeVariables.get("ENVIRONMENT_UNDER_TEST") + "_URL"));

		// Login to the application
		this.homePage = this.loginPage.login(this.runTimeVariables.get("ENVIRONMENT_UNDER_TEST"));
		TestLoginIntoCompany.logger.debug("Login Into Application");

		Reporter.log("<br> Test Passed");
		TestLoginIntoCompany.logger.exitMethod();
	}
	
}