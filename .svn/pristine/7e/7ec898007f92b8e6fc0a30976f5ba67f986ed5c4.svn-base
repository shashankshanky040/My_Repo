package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.CollectionAgeingStep;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class }) @Test(groups = {"automation"})
public class TestConfigureCollection extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	/**
	 * Verify ability to configure Collections
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.5 : Verify ability to configure Collections")
	public void testConfigureCollection() throws Exception {

		TestConfigureCollection.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047246");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		TestConfigureCollection.logger.debug("Navigate to Configuration Page");

		// Click Collections in Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Collections);
		TestConfigureCollection.logger.debug("Click Collections in Configuration");

		// Add Collection ID One
		this.confPage = this.confPage.addCollectionsAgeingStep(CollectionAgeingStep.FIRST, "collectionsStepOne", "ccd");
		TestConfigureCollection.logger.debug("Add Collection ID One");

		// Add Collection ID Two
		this.confPage = this.confPage.addCollectionsAgeingStep(CollectionAgeingStep.SECOND, "collectionsStepTwo", "ccd");
		TestConfigureCollection.logger.debug("Add Collection ID Two");

		// Add Collection ID Three
		this.confPage = this.confPage.addCollectionsAgeingStep(CollectionAgeingStep.THIRD, "collectionsStepThree", "ccd");
		TestConfigureCollection.logger.debug("Add Collection ID Three");

		// Add Collection ID Four
		this.confPage = this.confPage.addCollectionsAgeingStep(CollectionAgeingStep.FOURTH, "collectionsStepFour", "ccd");
		TestConfigureCollection.logger.debug("Add Collection ID Four");

		// Click Save Changes Button to Collections steps
		this.confPage = this.confPage.clickSaveChangesToCollections();
		TestConfigureCollection.logger.debug("Click Save Changes Button to Collections steps");

		// Verify Text:Collection configuration steps updated successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Collection configuration steps", "updated successfully",
				TextComparators.contains);
		TestConfigureCollection.logger.debug("Collection configuration steps updated successfully");

		this.graceId = this.confPage.getStep2ID();
		String graceId = this.confPage.getStep2ID();

		this.propReader.updatePropertyInFile("TC_2.5_GRACE_ID", graceId, "testData");

		Reporter.log("<br> Test Passed");
		TestConfigureCollection.logger.exitMethod();
	}

}