package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class }) @Test(groups = {"automation"})
public class TestConfigurePaymentMethod extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify ability to configure a Payment Method Configure 'Credit Card'
	 * payment method for Account Type: Direct Customer
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.3 : Verify ability to configure a Payment Method Configure 'Credit Card' payment method for Account Type: Direct Customer")
	public void testConfigurePaymentMethod() throws Exception {

		TestConfigurePaymentMethod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047244");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestConfigurePaymentMethod.logger.debug("Navigate to Configuration Page");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.PaymentMethod);
		TestConfigurePaymentMethod.logger.debug("Select Configuration");

		// Configure Payment Method to Account
		this.confPage = this.confPage.configurePaymentMethod("configurePaymentMethod", "pm");
		TestConfigurePaymentMethod.logger.debug("Configure Payment Method to Account");

		// Add Payment Details
		String paymentMethodName = this.confPage.addPaymentMethodDetails("secondTestPaymentType", "pt");

		this.propReader.updatePropertyInFile("TC_2.3_METHOD_NAME", paymentMethodName, "testData");

		TestConfigurePaymentMethod.logger.debug("Add Payment Details");

		// Verify Text:Payment Method Type Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type", "created successfully", TextComparators.contains);
		TestConfigurePaymentMethod.logger.debug("Verify Payment Method Type Is Created Successfully");

		// Validate Saved Account Type Test Data

		String methodName = this.propReader.readPropertyFromFile("TC_2.3_METHOD_NAME", "testData");

		this.confPage = this.confPage.validatePeriodsSavedTestData(methodName);
		TestConfigurePaymentMethod.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestConfigurePaymentMethod.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestConfigurePaymentMethod.logger.exitMethod();
	}

}