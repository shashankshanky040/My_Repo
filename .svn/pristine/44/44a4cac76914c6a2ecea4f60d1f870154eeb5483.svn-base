package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class }) @Test(groups = {"automation"})
public class TestConfigureOrderPeriod extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify ability to configure Order Periods
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.4 : Verify ability to configure Order Periods")
	public void testConfigureOrderPeriod() throws Exception {

		TestConfigureOrderPeriod.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047245");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestConfigureOrderPeriod.logger.debug("Navigate to Configuration Page");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.OrderPeriods);
		TestConfigureOrderPeriod.logger.debug("Select Configuration");

		// Configuring First Order period
		String orderPeriod1 = this.confPage.createNewOrderPeriod("firstOrderPeriod", "op");

		this.propReader.updatePropertyInFile("TC_2.4_ORDER_PERIOD1", orderPeriod1, "testData");
		TestConfigureOrderPeriod.logger.debug("Configuring First Order period");

		// Verify Text:Order Period Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Order Period", "created successfully", TextComparators.contains);
		TestConfigureOrderPeriod.logger.debug("Verify Text:Order Period Is Created Successfully");

		// Validate Saved Account Type Test Data

		String description1 = this.propReader.readPropertyFromFile("TC_2.4_ORDER_PERIOD1", "testData");
		this.confPage = this.confPage.validatePeriodsSavedTestData(description1);
		TestConfigureOrderPeriod.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestConfigureOrderPeriod.logger.debug("Verify Current Page UI Component");

		// Configuring Second Order period
		String orderPeriod2 = this.confPage.createNewOrderPeriod("secondOrderPeriod", "op");
		this.propReader.updatePropertyInFile("TC_2.4_ORDER_PERIOD2", orderPeriod2, "testData");
		TestConfigureOrderPeriod.logger.debug("Configuring Second Order period");

		// Verify Text:Order Period Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Order Period", "created successfully", TextComparators.contains);
		TestConfigureOrderPeriod.logger.debug("Verify Text:Order Period Is Created Successfully");

		// Validate Saved Account Type Test Data

		String description2 = this.propReader.readPropertyFromFile("TC_2.4_ORDER_PERIOD2", "testData");
		this.confPage = this.confPage.validatePeriodsSavedTestData(description2);
		TestConfigureOrderPeriod.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestConfigureOrderPeriod.logger.debug("Verify Current Page UI Component");

		// Configuring Third Order period
		String orderPeriod3 = this.confPage.createNewOrderPeriod("thirdOrderPeriod", "op");
		this.propReader.updatePropertyInFile("TC_2.4_ORDER_PERIOD3", orderPeriod3, "testData");
		TestConfigureOrderPeriod.logger.debug("Configuring Third Order period");

		// Verify Text:Order Period Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Order Period", "created successfully", TextComparators.contains);
		TestConfigureOrderPeriod.logger.debug("Verify Text:Order Period Is Created Successfully");

		// Validate Saved Account Type Test Data
		String description3 = this.propReader.readPropertyFromFile("TC_2.4_ORDER_PERIOD3", "testData");
		this.confPage = this.confPage.validatePeriodsSavedTestData(description3);
		TestConfigureOrderPeriod.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		TestConfigureOrderPeriod.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		TestConfigureOrderPeriod.logger.exitMethod();
	}

}