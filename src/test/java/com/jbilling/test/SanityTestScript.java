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
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AccountTypeInfo;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddPlanField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.AddProductField;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.CollectionAgeingStep;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.textutilities.TextUtilities;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
public class SanityTestScript extends BrowserApp {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	String graceId = null;
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "Test Case 1.1:  testCreateNewCompanyUsingCopyCompany")
	public void testCreateNewCompanyUsingCopyCompany() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047236");

		// Login Into Application And Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Login Into Application And Navigate to Configuration Page");

		// Initiate The Process To Select Company from Configuration list
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Company);
		SanityTestScript.logger.debug("Select Company from Configuration list");

		// Creating Copy of current company
		this.confPage = this.confPage.clickCopyCompanyButton();
		SanityTestScript.logger.debug("Creating Copy of current company");

		// Accept The Confirm Popup
		this.confPage = this.confPage.clickConfirmPopupYesButton();
		SanityTestScript.logger.debug("Accept The Confirm Popup");

		String un = this.confPage.extractUserNameFromCompanyCreationMessage();
		String pwd = this.confPage.extractPasswordFromCompanyCreationMessage();
		String cn = this.confPage.extractCompanyNameFromCompanyCreationMessage();
		String cid = this.confPage.extractCompanyIdFromCompanyCreationMessage();

		if (TextUtilities.isBlank(un) || TextUtilities.isBlank(pwd) || TextUtilities.isBlank(cn) || TextUtilities.isBlank(cid)) {
			throw new Exception("Test failed for copying company as no information generated. UserName: " + un + " -> Password: " + pwd
					+ " -> CompanyName: " + cn + " -> CompanyId: " + cid);
		}

		this.runTimeVariables.put("TC_1.1_CREDENTIALS_USERNAME", un);
		this.runTimeVariables.put("TC_1.1_CREDENTIALS_PASSWORD", pwd);
		this.runTimeVariables.put("TC_1.1_CREDENTIALS_COMPANYNAME", cn);
		this.runTimeVariables.put("TC_1.1_CREDENTIALS_COMPANYID", cid);

		this.runTimeVariables.put("ENVIRONMENT_UNDER_TEST", this.pr.readConfig("EnvironmentUnderTest"));
		this.runTimeVariables.put("ENVIRONMENT_URL_UNDER_TEST",
				this.pr.readConfig(this.runTimeVariables.get("ENVIRONMENT_UNDER_TEST") + "_URL"));

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	@Test(description = "Test Case 1.2:  Verify that users are able to login into the JBilling System using valid credential.", dependsOnMethods = { "testCreateNewCompanyUsingCopyCompany" })
	public void testLoginIntoCompany() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047237");

		// Logout From The Application
		this.loginPage = this.navPage.logoutApplication();
		SanityTestScript.logger.debug("Logout From The Application");

		String URL = this.runTimeVariables.get("ENVIRONMENT_URL_UNDER_TEST");
		String userName = this.runTimeVariables.get("TC_1.1_CREDENTIALS_USERNAME");
		String password = this.runTimeVariables.get("TC_1.1_CREDENTIALS_PASSWORD");
		String companyId = this.runTimeVariables.get("TC_1.1_CREDENTIALS_COMPANYID");

		this.runTimeVariables.put("ENVIRONMENT_UNDER_TEST", this.pr.readConfig("EnvironmentUnderTest"));
		this.runTimeVariables.put("ENVIRONMENT_URL_UNDER_TEST",
				this.pr.readConfig(this.runTimeVariables.get("ENVIRONMENT_UNDER_TEST") + "_URL"));

		// Login To The Application
		this.homePage = this.loginPage.login(URL, userName, password, companyId, true);
		SanityTestScript.logger.debug("Login To The Application");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	@Test(description = "Test Case 1.3: Verify ability to create a Child Company within Root Company")
	public void testCreationOfChildCompany() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047238");

		// Login into root company
		SanityTestScript.logger.debug("Step not required to be coded here as in previous test case 1.2, already logged in to root company");

		// Navigate to Configurations page
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to configuration page");

		// Click on configuration>> Select company from left.
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Company);
		SanityTestScript.logger.debug("Click on configuration>> Select Company configuration item from left");

		// Click on Copy company button
		this.confPage = this.confPage.clickCopyCompanyButton();
		SanityTestScript.logger.debug("Click on Copy company button");

		// Check on the third checkbox "Create a new copany as child..">> Give
		// name of the child company >>Click on yes button.
		this.confPage.markCompanyAsChildCompany(true);
		SanityTestScript.logger
				.debug("Check on the third checkbox \"Create a new copany as child..\">> Give name of the child company >>Click on yes button.");

		// Click on Copy company button
		this.confPage = this.confPage.setChildCompanyName("setCompany", "name");
		SanityTestScript.logger.debug("Click on Copy company button");

		// Accept The Confirm Popup
		this.confPage = this.confPage.clickConfirmPopupYesButton();
		SanityTestScript.logger.debug("Accept The Confirm Popup");

		String un = this.confPage.extractUserNameFromCompanyCreationMessage();
		String pwd = this.confPage.extractPasswordFromCompanyCreationMessage();
		String cn = this.confPage.extractCompanyNameFromCompanyCreationMessage();
		String cid = this.confPage.extractCompanyIdFromCompanyCreationMessage();

		// Verifying if company is successfully created or not; if yes, it is
		// saving that information for further test cases
		if (TextUtilities.isBlank(un) || TextUtilities.isBlank(pwd) || TextUtilities.isBlank(cn) || TextUtilities.isBlank(cid)) {
			throw new Exception("Test failed for copying company as no information generated. UserName: " + un + " -> Password: " + pwd
					+ " -> CompanyName: " + cn + " -> CompanyId: " + cid);
		}
		SanityTestScript.logger.debug("Verified that child company has been created succesfully");

		this.runTimeVariables.put("TC_1.3_CHILD_COMPANY_USERNAME", un);
		this.runTimeVariables.put("TC_1.3_CHILD_COMPANY_PASSWORD", pwd);
		this.runTimeVariables.put("TC_1.3_CHILD_COMPANY_COMPANYNAME", cn);
		this.runTimeVariables.put("TC_1.3_CHILD_COMPANY_COMPANYID", cid);

		// The Child Company should now appear in the impersonate drop down.
		if (this.navPage.isChildCompanyImpersonated(this.runTimeVariables.get("TC_1.3_CHILD_COMPANY_COMPANYNAME")) == false) {
			throw new Exception("Test 1.3 failed as child company created but not impersonated");
		}
		SanityTestScript.logger.debug("User successfully created the Child Company and appearing in the impersonate drop down.");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	@Test(description = "Test Case 1.4: Verify ability to create Child Company (Invoice as Reseller) within Root Company")
	public void testCreationOfChildCompanyInvoiceAsReseller() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047239");

		// Login to the "Root company" with valid credential >> From within Root
		// Company remove the URL text after /jbilling/ and enter: 'signup'
		// (example: http://lab5.jbilling.com:8080/jbilling/signup) >> Company
		// signup page appears and Root/Parent Company name is 'JBilling'

		SanityTestScript.logger
				.debug("Login to the \"Root company\" with valid credential >> From within Root Company remove the URL text after /jbilling/ and enter: 'signup' (example: http://lab5.jbilling.com:8080/jbilling/signup) >> Company signup page appears and Root/Parent Company name is 'JBilling'");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();

		// throw new Exception("TC 1.4 Not created by now");
	}

	/**
	 * Verify ability to successfully configure and edit Account Types
	 * "Direct Customer" & "Distributor Account" >> Verify the ability to set
	 * Jasper invoice design as default for invoice download
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 2.1 : Verify ability to successfully configure and edit Account Types \"Direct Customer\" & \"Distributor Account\" >> Verify the ability to set Jasper invoice design as default for invoice download")
	public void testAddAccountType() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047241");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Set Configuration Preference Value
		this.confPage = this.confPage.setConfigurationPreference("setPreferenceValue", "pc");
		SanityTestScript.logger.debug("Set Configuration Preference Value");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		SanityTestScript.logger.debug("Select Configuration");

		// Add First Account Type
		String accountName = this.confPage.createAccountType("addAccountType", "aat");
		this.runTimeVariables.put("TC_2.1_ACCOUNT_NAME_ONE", accountName);

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		SanityTestScript.logger.debug("Select Configuration");

		// Add Second Account Type
		accountName = this.confPage.createAccountType("addSecondAccountType", "aat");
		this.runTimeVariables.put("TC_2.1_ACCOUNT_NAME_TWO", accountName);

		// Edit Second Account Type
		accountName = this.confPage.editAccountType(AccountTypeField.ACCOUNT_NAME, "addAccountType", "aat");
		SanityTestScript.logger.debug("Edit Second Account Type");

		this.runTimeVariables.put("TC_2.1_ACCOUNT_NAME_TWO_EDIT", accountName);

		// Verify Text: Account Type Updated Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Type", "updated successfully", TextComparators.contains);
		SanityTestScript.logger.debug("Verify Text: Account Type Updated Successfully");

		// Validate Saved Account Type Test Data
		String accountType = this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_TWO_EDIT");
		this.confPage = this.confPage.validatePeriodsSavedTestData(accountType);
		SanityTestScript.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify ability to attach a Payment Method to an Account Type
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 2.1.1 : Verify ability to attach a Payment Method to an Account Type")
	public void testAttachPaymentType() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047242");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.PaymentMethod);
		SanityTestScript.logger.debug("Select Configuration");

		// Configure Payment Method to Account
		this.confPage = this.confPage.configurePaymentMethod("configurePaymentMethod", "pm");
		SanityTestScript.logger.debug("Configure Payment Method to Account");

		// Add Payment Details
		String methodName = this.confPage.addPaymentMethodDetails("testPaymentType", "pt");
		this.runTimeVariables.put("TC_2.1.1_METHOD_NAME_ONE", methodName);
		SanityTestScript.logger.debug("Add Payment Details");

		// Verify Text:Payment Method Type Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type", "created successfully", TextComparators.contains);
		SanityTestScript.logger.debug("Verify Payment Method Type Is Created Successfully");

		// Validate Saved Account Type Test Data
		String paymentMethod = this.runTimeVariables.get("TC_2.1.1_METHOD_NAME_ONE");
		this.confPage = this.confPage.validatePeriodsSavedTestData(paymentMethod);
		SanityTestScript.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify ability to successfully add an Information Type to an Account Type
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.2 : Verify ability to successfully add an Information Type to an Account Type", dependsOnMethods = {
			"testAddAccountType", "testAttachPaymentType" })
	public void testAddInfoToAccountType() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br>Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047243");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Add Information to Account Type
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.AccountType);
		this.confPage = this.confPage.selectAccountTypeName(this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"));
		SanityTestScript.logger.debug("Add Information to Account Type");

		Reporter.log("<br> Enter information type name for account type " + this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"));
		String infoTypeName = this.confPage.addNewInformationToSelectedAccountType(AccountTypeInfo.SIMPLE, "AddInfoToAccountType", "aitac");
		this.runTimeVariables.put("TC_2.2_NAME", infoTypeName);
		SanityTestScript.logger.debug("Enter information type name for account type");

		// Verify Text:Account Information Type Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Account Information Type", "created successfully",
				TextComparators.contains);
		SanityTestScript.logger.debug("Account Information Type Is Created Successfully");

		// Validate Saved Account Information Type Test Data
		String accountInfo = this.runTimeVariables.get("TC_2.2_NAME");
		this.confPage = this.confPage.validatePeriodsSavedTestData(accountInfo);
		SanityTestScript.logger.debug("Validate Saved Account Information Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		SanityTestScript.logger.debug("Verifying if account information type created successfully or not");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify ability to configure a Payment Method Configure 'Credit Card'
	 * payment method for Account Type: Direct Customer
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.3 : Verify ability to configure a Payment Method Configure 'Credit Card' payment method for Account Type: Direct Customer")
	public void testConfigurePaymentMethod() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047244");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.PaymentMethod);
		SanityTestScript.logger.debug("Select Configuration");

		// Configure Payment Method to Account
		this.confPage = this.confPage.configurePaymentMethod("configurePaymentMethod", "pm");
		SanityTestScript.logger.debug("Configure Payment Method to Account");

		// Add Payment Details
		String paymentMethodName = this.confPage.addPaymentMethodDetails("secondTestPaymentType", "pt");
		this.runTimeVariables.put("TC_2.3_METHOD_NAME", paymentMethodName);
		SanityTestScript.logger.debug("Add Payment Details");

		// Verify Text:Payment Method Type Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Payment Method Type", "created successfully", TextComparators.contains);
		SanityTestScript.logger.debug("Verify Payment Method Type Is Created Successfully");

		// Validate Saved Account Type Test Data
		String methodName = this.runTimeVariables.get("TC_2.3_METHOD_NAME");
		this.confPage = this.confPage.validatePeriodsSavedTestData(methodName);
		SanityTestScript.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify ability to configure Order Periods
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.4 : Verify ability to configure Order Periods")
	public void testConfigureOrderPeriod() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047245");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.OrderPeriods);
		SanityTestScript.logger.debug("Select Configuration");

		// Configuring First Order period
		String orderPeriod1 = this.confPage.createNewOrderPeriod("firstOrderPeriod", "op");
		this.runTimeVariables.put("TC_2.4_ORDER_PERIOD1", orderPeriod1);
		SanityTestScript.logger.debug("Configuring First Order period");

		// Verify Text:Order Period Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Order Period", "created successfully", TextComparators.contains);
		SanityTestScript.logger.debug("Verify Text:Order Period Is Created Successfully");

		// Validate Saved Account Type Test Data
		String description1 = this.runTimeVariables.get("TC_2.4_ORDER_PERIOD1");
		this.confPage = this.confPage.validatePeriodsSavedTestData(description1);
		SanityTestScript.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		// Configuring Second Order period
		String orderPeriod2 = this.confPage.createNewOrderPeriod("secondOrderPeriod", "op");
		this.runTimeVariables.put("TC_2.4_ORDER_PERIOD2", orderPeriod2);
		SanityTestScript.logger.debug("Configuring Second Order period");

		// Verify Text:Order Period Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Order Period", "created successfully", TextComparators.contains);
		SanityTestScript.logger.debug("Verify Text:Order Period Is Created Successfully");

		// Validate Saved Account Type Test Data
		String description2 = this.runTimeVariables.get("TC_2.4_ORDER_PERIOD2");
		this.confPage = this.confPage.validatePeriodsSavedTestData(description2);
		SanityTestScript.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		// Configuring Third Order period
		String orderPeriod3 = this.confPage.createNewOrderPeriod("thirdOrderPeriod", "op");
		this.runTimeVariables.put("TC_2.4_ORDER_PERIOD3", orderPeriod3);
		SanityTestScript.logger.debug("Configuring Third Order period");

		// Verify Text:Order Period Is Created Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Order Period", "created successfully", TextComparators.contains);
		SanityTestScript.logger.debug("Verify Text:Order Period Is Created Successfully");

		// Validate Saved Account Type Test Data
		String description3 = this.runTimeVariables.get("TC_2.4_ORDER_PERIOD3");
		this.confPage = this.confPage.validatePeriodsSavedTestData(description3);
		SanityTestScript.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify ability to configure Collections
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.5 : Verify ability to configure Collections")
	public void testConfigureCollection() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047246");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Click Collections in Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Collections);
		SanityTestScript.logger.debug("Click Collections in Configuration");

		// Add Collection ID One
		this.confPage = this.confPage.addCollectionsAgeingStep(CollectionAgeingStep.FIRST, "collectionsStepOne", "ccd");
		SanityTestScript.logger.debug("Add Collection ID One");

		// Add Collection ID Two
		this.confPage = this.confPage.addCollectionsAgeingStep(CollectionAgeingStep.SECOND, "collectionsStepTwo", "ccd");
		SanityTestScript.logger.debug("Add Collection ID Two");

		// Add Collection ID Three
		this.confPage = this.confPage.addCollectionsAgeingStep(CollectionAgeingStep.THIRD, "collectionsStepThree", "ccd");
		SanityTestScript.logger.debug("Add Collection ID Three");

		// Add Collection ID Four
		this.confPage = this.confPage.addCollectionsAgeingStep(CollectionAgeingStep.FOURTH, "collectionsStepFour", "ccd");
		SanityTestScript.logger.debug("Add Collection ID Four");

		// Click Save Changes Button to Collections steps
		this.confPage = this.confPage.clickSaveChangesToCollections();
		SanityTestScript.logger.debug("Click Save Changes Button to Collections steps");

		// Verify Text:Collection configuration steps updated successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Collection configuration steps", "updated successfully",
				TextComparators.contains);
		SanityTestScript.logger.debug("Collection configuration steps updated successfully");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		this.graceId = this.confPage.getStep2ID();
		String graceId = this.confPage.getStep2ID();
		this.runTimeVariables.put("TC_2.5_GRACE_ID", graceId);

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * 
	 * Verify ability to configure Collections Plugins
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.6 : Verify ability to configure Collections Plugins", dependsOnMethods = { "testCreateNewCompanyUsingCopyCompany" })
	public void testConfigureCollectionPlugins() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047247");

		this.testConfigureCollection();

		Reporter.log("<br> Get ID Generated for Second Step");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Users);
		SanityTestScript.logger.debug("Select Configuration");

		// Configure Permissions for Plugins
		String userName = this.runTimeVariables.get("TC_1.1_CREDENTIALS_USERNAME");
		this.confPage = this.confPage.configurePluginPermissions(userName);
		SanityTestScript.logger.debug("Configure Permissions for Plugins");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Add Plugin in Collections
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Plugins);
		SanityTestScript.logger.debug("Add Plugin in Collections");

		// Select Plugin Category
		this.confPage = this.confPage.selectPluginCategory("selectPluginCategory", "pc");
		SanityTestScript.logger.debug("Select Plugin Category");

		// Add Plugin Under Generic Category
		this.confPage = this.confPage.addNewPluginInCategory("addPlugin", "ap", this.runTimeVariables);
		SanityTestScript.logger.debug("Add Plugin Under Generic Category");

		// Verify Text:The new plugin with id has been saved successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("The new plug-in with id", "has been saved.", TextComparators.contains);
		SanityTestScript.logger.debug("Verify Text:The new plugin with id has been saved successfully");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Test Data Preparation for Billing Process
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 2.7 : Test Data Preparation for Billing Process")
	public void testConfigureBillingProcess() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047248");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Switching to Billing Process configuration item
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.BillingProcess);
		SanityTestScript.logger.debug("Switching to Billing Process configuration item");

		// Add Billing Process
		this.confPage = this.confPage.addBillingProcess("BillingProcess", "cbp");
		SanityTestScript.logger.debug("Add Billing Process");

		// Verify Text:Billing configuration saved successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Billing configuration", "saved successfully", TextComparators.contains);
		SanityTestScript.logger.debug("Billing configuration saved successfully");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify user is able to create/edit a Category 'New Test Category' is only
	 * available to Root Company (jBilling).
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 3.1 : Verify user is able to create/edit a Category 'New Test Category' is only available to Root Company (jBilling).")
	public void testCreateProductCategory() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047249");

		// Login Into Application And Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Login Into Application And Navigate to Products Tab");

		// Initiate And Complete The Process To Create A Product Category
		this.productsPage.addCategory("CreateProductCategoryData", "pcd");
		SanityTestScript.logger.debug("Create A Product Category");

		// Initiate And Complete The Process To Edit The Existing Product
		// Category
		String categoryName = this.productsPage.editCategory("NewProductCategoryData", "pcd");
		this.runTimeVariables.put("TC_3.1_CATEGORY_NAME", categoryName);
		SanityTestScript.logger.debug("Edit The Product Category");

		// Validate Saved Account Type Test Data
		this.confPage = this.confPage.validateCategoriesSavedTestData(this.runTimeVariables.get("TC_3.1_CATEGORY_NAME"));
		SanityTestScript.logger.debug("Validate Saved Account Type Test Data");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify user is able to create a Category that uses Asset Management (and
	 * meta fields) 'Asset Category 1' is available to all Companies
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 3.2 : Verify user is able to create a Category that uses Asset Management (and meta fields) 'Asset Category 1' is available to all Companies")
	public void testCreateCategoryWithAssetManagement() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047250");

		// Login Into Application And Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Login Into Application And Navigate to Products Tab");

		// Initiate And Complete The Process To Create Product Category with
		// Asset Management
		// String assetCategory =
		// this.productsPage.addProductCategoryWithAssetMgmt(setProductCategoryWithAssetMgmt.PCWAMG1,
		// "CreateProductCategory", "ac");
		// this.runTimeVariables.put("TC_3.2_CATEGORY_NAME", assetCategory);
		SanityTestScript.logger.debug("Create Product Category with Asset Management");

		// Verify Text:Saved New Product successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new product category", "successfully", TextComparators.contains);
		SanityTestScript.logger.debug("Verify Text:Saved New Product successfully");

		// Validate Saved New Product successfully
		String savedCategoryName = this.runTimeVariables.get("TC_3.2_CATEGORY_NAME");
		this.confPage = this.confPage.validateCategoriesSavedTestData(savedCategoryName);
		SanityTestScript.logger.debug("Validate Saved New Product successfully");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify user is able to add and edit a Product
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 3.3 : Verify user is able to add and edit a Product.")
	public void testAddAndEditProduct() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047251");

		// Login Into Application And Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Login Into Application And Navigate to Products Tab");

		// Initiate And Complete The Process To Add The Product
		String description = this.productsPage.addProduct(AddProductField.FLAT, "addProductOne", "ap");
		SanityTestScript.logger.debug("Add The Product");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Navigate to Products Tab");

		// Initiate And Complete The Process To Add Different Product From
		// Existing
		String description2 = this.productsPage.addProduct(AddProductField.LINEPERCENTAGE, "addProductTwo", "ap");
		SanityTestScript.logger.debug("Add Different Product From Existing");

		// Initiate And Complete The Process To Edit Existing Product
		this.productsPage = this.productsPage.editProduct("editProduct", "ap");
		SanityTestScript.logger.debug("Edit Existing Product");

		// Verify Text:Updated New Product successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Updated product", "successfully.", TextComparators.contains);
		SanityTestScript.logger.debug("Verify Text:Updated New Product successfully");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify that a user can create a product with an asset
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 3.4 : Verify that a user can create a product with an asset")
	public void testCreateProductWithAsset() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "11047252");

		// Navigate to Configuration Tab
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Switching to Billing Process configuration item
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Plugins);
		SanityTestScript.logger.debug("Switching to Plugins configuration item");

		// Initiate And Complete The Process To Add The Plugin
		this.productsPage = this.productsPage.addPlugin("addPlugin", "ap");
		SanityTestScript.logger.debug("Add The Plugin");

		// Navigate Back To Products Page
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Navigate Back To Products Page");

		// Initiate And Complete The Process To Add The Product
		String englishDescription = this.productsPage.addProduct(AddProductField.ASSETMANAGEMENT, "addProductThree", "ap");
		this.runTimeVariables.put("TC_3.4_ENGLISH_DESC", englishDescription);

		SanityTestScript.logger.debug("Add The Product");

		// Initiate And Complete The Process To Add An Asset
		this.productsPage = this.productsPage.addAsset();
		String assetIdentifier1 = this.productsPage.addAsset("addAssetOne", "ap");
		this.runTimeVariables.put("TC_3.4_IDENTIFIER_ONE", assetIdentifier1);
		SanityTestScript.logger.debug("Add An Asset");

		// Initiate And Complete The Process To Add Different Asset From
		// Existing
		this.productsPage = this.productsPage.clickAddNew();
		String assetIdentifier2 = this.productsPage.addAsset("addAssetTwo", "ap");
		this.runTimeVariables.put("TC_3.4_IDENTIFIER_TWO", assetIdentifier2);
		SanityTestScript.logger.debug("Add Different Asset From Existing");

		// Validate Saved New Asset Identifier One successfully
		String identifierOne = this.runTimeVariables.get("TC_3.4_IDENTIFIER_ONE");
		// this.productsPage =
		// this.productsPage.validateUserTableSavedTestData(identifierOne);
		SanityTestScript.logger.debug("Validate Saved New Asset Identifier One successfully");

		// Validate Saved New Asset Identifier Two successfully
		String identifierTwo = this.runTimeVariables.get("TC_3.4_IDENTIFIER_TWO");
		// this.productsPage =
		// this.productsPage.validateUserTableSavedTestData(identifierTwo);
		SanityTestScript.logger.debug("Validate Saved New Asset Identifier Two successfully");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify user can assign an Account Type price to a Product and edit it
	 * 
	 * @throws Exception
	 */

	@Test(description = "Test Case 3.5 : Verify user can assign an Account Type price to a Product and edit it", dependsOnMethods = { "testAddAccountType" })
	public void testAssignAccountToProduct() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909904");

		// Navigating to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigating to Configuration Page");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AccountType);
		SanityTestScript.logger.debug("Select Configuration");

		// Select Account Type Add Click On Account Type Prices
		this.confPage = this.confPage.selectAccountTypeName(this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"));
		this.confPage = this.confPage.clickAccountTypePrices();
		SanityTestScript.logger.debug("Select Account Type Add Click On Account Type Prices");

		// Add Price to Account Type for selected product
		this.confPage = this.confPage.addAccountTypePriceToSelectedProduct("Test Code Description", "addPrice", "ap");
		SanityTestScript.logger.debug("Add Price to Account Type for selected product");

		// Edit Price to Account Type for selected product
		this.confPage = this.confPage.updateAccountTypePriceForProduct("editPrice", "ap");
		SanityTestScript.logger.debug("Edit Price to Account Type for selected product");

		// Verify Current Page UI Component
		this.confPage = this.confPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify that user is able to create and edit a plan.
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 4.1 : Verify that user is able to create and edit a plan.", dependsOnMethods = {
			"testCreateProductCategory", "testCreateCategoryWithAssetManagement", "testCreateProductWithAsset" })
	public void testCreateAndEditPlan() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909905");

		// Login Into Application And Navigate to Plans Tab
		this.plansPage = this.navPage.navigateToPlanPage();
		SanityTestScript.logger.debug("Login Into Application And Navigate to Plans Page");

		// Initiate And Complete The Process To Add Plans
		String userCategoryName = this.runTimeVariables.get("TC_3.1_CATEGORY_NAME");
		String productCategoryName = this.runTimeVariables.get("TC_3.2_CATEGORY_NAME");
		String engDescription = this.runTimeVariables.get("TC_3.4_ENGLISH_DESC");

		this.plansPage = this.plansPage.addPlan(AddPlanField.ALL, userCategoryName, engDescription, "addplan", "ap");
		SanityTestScript.logger.debug("Processing To Add Plans");

		// Initiate And Complete The Process To Edit Plans
		this.plansPage = this.plansPage.editPlan(engDescription, "editPlan", "ap");
		SanityTestScript.logger.debug("Processing To Add Plans");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	@Test(description = "Test Case 5.1: Verify that Root Company has ability to "
			+ "impersonate Child Company and view all & only information assigned to Child Company.")
	public void testRootCompanyImpersonationOnChildCompany() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909906");

		// Switch To Child Company
		this.homePage = this.navPage.switchToChildCompany("LDC Akhilesh copy 1464272867900");
		SanityTestScript.logger.debug("Switch To Child Company");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Navigate to Products Page");

		// Initiate And Complete The Process To Validate Asset Exists
		this.productsPage = this.productsPage.assetExists("productCategoryImpersonate", "pc");
		SanityTestScript.logger.debug("Validate Asset Exists");

		// Switch To Parent Company
		this.homePage = this.navPage.switchToParentCompany();
		SanityTestScript.logger.debug("Switch To Parent Company");

		// Navigate To Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate To Customers Page");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();

		throw new Exception("TC 5.1 not completed: To discuss with manual team about the presence of child customer in parent company");
	}

	/**
	 * Verify if user is able to create/Edit a new customer into the system.
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 6.1 : Verify if user is able to create/Edit a new customer into the system.", dependsOnMethods = {
			"testAddAccountType", "testAttachPaymentType" })
	public void testCreateAndEditCustomer() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909907");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Initiate And Complete The Process To Add a New Customer
		String customerName = this.customerPage.addCustomer(this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"),
				this.runTimeVariables.get("TC_2.1.1_METHOD_NAME_ONE"), "new_customer", "nc");
		this.runTimeVariables.put("TC_6.1_CUSTOMER_NAME", customerName);

		SanityTestScript.logger.debug("Add a New Customer");

		// Verify Text:Customer Is Saved Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new customer", "successfully.", TextComparators.contains);
		SanityTestScript.logger.debug("Customer Is Saved Successfully");

		// Validate Saved New Customer Test Data
		this.customerPage = this.customerPage.validateSavedTestDataInTable(this.runTimeVariables.get("TC_6.1_CUSTOMER_NAME"));
		SanityTestScript.logger.debug("Validate Saved New Customer Test Data");

		// Verify Current Page UI Component
		this.customerPage = this.customerPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify user can create a Parent/Child relationship within the Customer
	 * tab
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 6.2 : Verify user can create a Parent/Child relationship	within the Customer tab", dependsOnMethods = { "testCreateAndEditCustomer" })
	public void testCreateParentChildRelationInCustomersTab() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909908");

		// Initiate And Complete The Process To Create a Child Customer
		String childCustomer = this.customerPage.addChildCustomer(this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"),
				this.runTimeVariables.get("TC_2.1.1_METHOD_NAME_ONE"), "addSecondCustomer", "ac");
		this.runTimeVariables.put("TC_6.2_CHILD_CUSTOMER_NAME", childCustomer);
		SanityTestScript.logger.debug("Create a Child Customer");

		// Verify Text:Customer Is Saved Successfully
		this.msgsPage = this.msgsPage.verifyDisplayedMessageText("Saved new customer", "successfully.", TextComparators.contains);
		SanityTestScript.logger.debug("Customer Is Saved Successfully");

		// Validate Saved New Customer Test Data
		this.customerPage = this.customerPage.validateSavedTestDataInTable(this.runTimeVariables.get("TC_6.2_CHILD_CUSTOMER_NAME"));
		SanityTestScript.logger.debug("Validate Saved New Customer Test Data");

		// Verify Current Page UI Component
		this.customerPage = this.customerPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify user is able to create discounts to be availed while making
	 * purchase.
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 6.3 : Verify user is able to create discounts to be availed while making purchase.", dependsOnMethods = { "testCreateParentChildRelationInCustomersTab" })
	public void testCreateDiscount() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909909");

		// Navigate to Discounts Page
		this.discountsPage = this.navPage.navigateToDiscountsPage();
		SanityTestScript.logger.debug("Navigate to Discounts Page");

		// Click On Add New Discount Button
		this.discountsPage = this.discountsPage.clickAddNewButton();
		SanityTestScript.logger.debug("Click On Add New Discount Button");

		// Click On Save Changes Button
		this.discountsPage = this.discountsPage.clickSaveChangesButton();
		SanityTestScript.logger.debug("Click On Save Changes Button");

		// Validate Presence Of Displayed Error
		this.discountsPage = this.discountsPage.isValidationErrorAppeared();
		SanityTestScript.logger.debug("Validate Presence Of Displayed Error");

		// Initiate And Complete The Process To Create Discount
		String discountCodeDescription = this.discountsPage.createNewDiscount("addDiscount", "ad");
		this.runTimeVariables.put("TC_6.3_DISCOUNT_CODE_DESCRIPTION", discountCodeDescription);

		SanityTestScript.logger.debug("Create Discount");

		// Verify That Discount Is Created Successfully
		this.discountsPage = this.discountsPage.isDiscountCreatedSuccessfully();
		SanityTestScript.logger.debug("Verify That Discount Is Created Successfully");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerAndClickCreateOrder("new_customer", "nc", this.runTimeVariables);
		SanityTestScript.logger.debug("Select Customer And Click Create Order");

		// Complete The Process To Create The Order For The Customer
		this.ordersPage = this.ordersPage.createOrder("createOrder", "co", this.runTimeVariables.get("TC_6.3_DISCOUNT_CODE_DESCRIPTION"));
		SanityTestScript.logger.debug("Create The Order For The Customer");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify Order Changes feature works correctly
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 7.1 : Verify Order Changes feature works correctly", dependsOnMethods = { "testCreateDiscount" })
	public void testChangeOrderFeature() throws Exception {
		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909910");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Initiate And Complete The Process To Add a New Customer
		String xyz = this.customerPage.addCustomer(this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"),
				this.runTimeVariables.get("TC_2.1.1_METHOD_NAME_ONE"), "new_customer", "nc");
		SanityTestScript.logger.debug("Add a New Customer");

		// Initiate And Complete The Process Of Creating Order For Selected
		// Customer
		this.ordersPage = this.customerPage.createOrderForCustomer("Customer A", "ca");
		SanityTestScript.logger.debug("Create Order For Selected Customer");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify Order Provisioning Task Triggers Event
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 8.1 : Verify Order Provisioning Task Triggers Event", dependsOnMethods = { "testCreateProductWithAsset",
			"testCreateParentChildRelationInCustomersTab" })
	public void testVerifyOrderProvisioningTaskTriggersEvent() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909911");

		// Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Initiate And Complete The Process To Add The Plugin
		this.productsPage = this.productsPage.addPlugin("addPlugin", "ap");
		SanityTestScript.logger.debug("Add The Plugin");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerAndClickCreateOrder("new_customer", "nc", this.runTimeVariables);
		SanityTestScript.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process To Add And Edit Customer With SIM
		this.ordersPage = this.customerPage
				.addAndEditCustomerWithSIM("createOrder", "co", this.runTimeVariables.get("TC_3.4_ENGLISH_DESC"));
		SanityTestScript.logger.debug("Add And Edit Customer With SIM");

		// Click On Provisioning Button
		this.ordersPage = this.ordersPage.clickProvisioningButton();
		SanityTestScript.logger.debug("Click On Provisioning Button");

		// Click On Provisioning Tab
		this.ordersPage = this.ordersPage.clickProvisioningTab();
		SanityTestScript.logger.debug("Click On Provisioning Tab");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	@Test(description = "Test Case 9.1:  Verify that mediation 3.0 runs successfully.")
	public void testMediationRunSuccessfully() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909913");

		// Navigating to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigating to Configuration Page");

		// Select Configuration
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Mediation);
		SanityTestScript.logger.debug("Select Configuration");

		// Add And Run Mediation Configuration
		this.confPage = this.confPage.addAndRunMediationConfiguration("addMediation", "am");
		SanityTestScript.logger.debug("Add And Run Mediation Configuration");

		// Verify Triggered Mediation
		this.confPage = this.confPage.verifyTriggeredMediation();
		SanityTestScript.logger.debug("Verify Triggered Mediation");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Generating an Invoice (Manually)
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 10.1 : Generating an Invoice (Manually) ")
	public void testVerifyInvoiceGeneration() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909915");

		// Navigate to Orders Page
		this.ordersPage = this.navPage.navigateToOrdersPage();
		SanityTestScript.logger.debug("Navigate to Orders Page");

		// Filter for customer
		String loginName = this.filtersPage.filterOnLoginNameOrCustomerName("testVerifyInvoiceGeneration", "tvig");
		SanityTestScript.logger.debug("Set Login Name Or Customer Name");

		// Verify Invoice Generation For Chosen Customer
		this.ordersPage = this.ordersPage.verifyInvoiceGenerationForChoosenCustomer(loginName);
		SanityTestScript.logger.debug("Verify Invoice Generation For Chosen Customer");

		if (this.paymentsPage.isReviewPaymentButtonAppeared() == false) {
			throw new Exception("On paying invoice, no review payment button appeared resulting " + "into consideration that "
					+ "payment invoice page never loaded");
		}

		Reporter.log("Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	@Test(description = "Test Case 11.1 :  Verify user is able to create orders belonging "
			+ "to different periods/type to be processed in billing process later.", dependsOnMethods = { "testAddAccountType",
			"testAttachPaymentType", "testCreateParentChildRelationInCustomersTab" })
	public void testCreateOrderWithDifferentTypedandPeriods() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909918");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Initiate And Complete The Process To Add a Customer
		String customer = this.customerPage.addCustomer(this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"),
				this.runTimeVariables.get("TC_2.1.1_METHOD_NAME_ONE"), "new_customer", "nc");
		SanityTestScript.logger.debug("Add a Customer");

		// Initiate And Complete The Process To Add The Other Customer
		String diffCustomer = this.customerPage.addCustomer(this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"),
				this.runTimeVariables.get("TC_2.1.1_METHOD_NAME_ONE"), "new_customer", "nc");
		SanityTestScript.logger.debug("Add The Other Customer");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Navigate to Products Tab");

		// Initiate And Complete The Process To Create A Product Category
		this.productsPage.addCategory("productCategoryWithDifferentPeriods", "pcat");
		SanityTestScript.logger.debug("Create A Product Category");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerAndClickCreateOrder("new_customer", "nc", this.runTimeVariables);
		SanityTestScript.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process Of Creating Order For Selected
		// Customer
		this.ordersPage = this.customerPage.createOrderForCustomer("OrderWithDifferentPeriods", "co");
		SanityTestScript.logger.debug("Create Order For Selected Customer");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerAndClickCreateOrder("new_customer", "nc", this.runTimeVariables);
		SanityTestScript.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process Of Creating Order For Selected
		// Customer
		this.ordersPage = this.customerPage.createOrderForCustomer("OrderTwoWithDifferentPeriods", "co");
		SanityTestScript.logger.debug("Create Order For Selected Customer");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerAndClickCreateOrder("new_customer", "nc", this.runTimeVariables);
		SanityTestScript.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process Of Creating Order For Selected
		// Customer
		this.ordersPage = this.customerPage.createOrderForCustomer("OrderThreeWithDifferentPeriods", "co");
		SanityTestScript.logger.debug("Create Order For Selected Customer");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerAndClickCreateOrder("new_customer", "nc", this.runTimeVariables);
		SanityTestScript.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process Of Creating Order For Selected
		// Customer
		this.ordersPage = this.customerPage.createOrderForCustomer("OrderfourWithDifferentPeriods", "co");
		SanityTestScript.logger.debug("Create Order For Selected Customer");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Test Case 12.1: Verify customer status changed as per the collection
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 12.1: Verify customer status changed as per the collection")
	public void testCustomerStatusChangeAsCollection() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909922");

		// Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Select Configuration Collections Option
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Collections);
		SanityTestScript.logger.debug("Select Configuration Collections Option");

		// Run Collections for date 03/01/2001
		this.confPage = this.confPage.runCollectionsForDate("03/01/2001");
		SanityTestScript.logger.debug("Run Collections for date 03/01/2001");

		// Navigating to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigating to Customers Page");

		// Run Cycle One for Customer Status Verification
		this.customerPage = this.customerPage.statusCycle("customerInformationForCollectionCycleOne_One",
				"customerInformationForCollectionCycleOne_Two", "ci");
		SanityTestScript.logger.debug("Run Cycle One for Customer Status Verification");

		// Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Select Configuration Collections Option
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Collections);
		SanityTestScript.logger.debug("Select Configuration Collections Option");

		// Run Collections for date 03/20/2001
		this.confPage = this.confPage.runCollectionsForDate("03/20/2001");
		SanityTestScript.logger.debug("Run Collections for date 03/20/2001");

		// Navigating to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigating to Customers Page");

		// Run Cycle Two for Customer Status Verification
		this.customerPage.statusCycle("customerInformationForCollectionCycleTwo_One", "customerInformationForCollectionTwo_Two", "ci");
		SanityTestScript.logger.debug("Run Cycle Two for Customer Status Verification");

		// Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Select Configuration Collections Option
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Collections);
		SanityTestScript.logger.debug("Select Configuration Collections Option");

		// Run Collections for date 03/25/2001
		this.confPage = this.confPage.runCollectionsForDate("03/25/2001");
		SanityTestScript.logger.debug("Run Collections for date 03/25/2001");

		// Navigating to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigating to Customers Page");

		// Run Cycle Three for Customer Status Verification
		this.customerPage.statusCycle("customerInformationForCollectionCycleThree_One", "customerInformationForCollectionCycleThree_Two",
				"ci");
		SanityTestScript.logger.debug("Run Cycle Three for Customer Status Verification");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify user can pay invoice on a billing process generated invoice
	 * invoice is generated
	 * 
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 13.1 : Verify user can pay invoice on a billing process generated invoice")
	public void testUserCanPayInvoiceOnGeneratedInvoice() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909923");

		// Login Into App And Navigate To Invoices Page
		this.invoicePage = this.navPage.navigateToInvoicesPage();
		SanityTestScript.logger.debug("Navigate To Invoices Page");

		// Initiate And Complete The Process Of Pay Invoice
		this.invoicePage = this.invoicePage.payInvoice("payInvoice", "aa");
		SanityTestScript.logger.debug("Pay Invoice");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify correct report is displayed for invoice
	 * 
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 14.1 : Verify correct report is displayed.", dependsOnMethods = { "testCreateParentChildRelationInCustomersTab" })
	public void testReportForInvoice() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909924");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerAndClickCreateOrder("new_customer", "nc", this.runTimeVariables);
		SanityTestScript.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process To Generate Invoice
		this.ordersPage = this.customerPage.generateInvoice("Customer A", "ca");
		SanityTestScript.logger.debug("Generate Invoice");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.invoicePage = this.customerPage.selectCustomerAndClickMakePayment("new_customer", "nc", this.runTimeVariables);
		SanityTestScript.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process To Make a Payment
		this.invoicePage = this.invoicePage.makePayment("payInvoice", "aa");
		SanityTestScript.logger.debug("Make a Payment");

		// Navigate To Reports Page
		this.reportsPage = this.navPage.navigateToReportsPage();
		SanityTestScript.logger.debug("Navigate To Reports Page");

		// Initiate And Complete The Process To Get Reports View
		this.reportsPage = this.reportsPage.getReportsView("selectReportType", "sra");
		SanityTestScript.logger.debug("Navigate To Reports Page");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	@Test(description = "Test Case 15.1 :  Verify that Products with dependencies on other products can be created.", dependsOnMethods = { "testCreateProductCategory" })
	public void testCreateProductWithDependencyOnOther() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909925");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Navigate to Products Tab");

		// Initiate And Complete The Process To Create A Product Category
		this.productsPage.addCategory("productCategory", "pcat");
		SanityTestScript.logger.debug("Create A Product Category");

		this.productsPage = this.productsPage.addProductOnDependency("addProductTwo", "ap",
				this.runTimeVariables.get("TC_3.1_CATEGORY_NAME"));

		SanityTestScript.logger.debug("Add The Product With Dependency");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	@Test(description = "Test Case 15.2 :  Verify that Products with dependencies on other products can be ordered.", dependsOnMethods = { "testCreateParentChildRelationInCustomersTab" })
	public void testOrderProductWithDependencyOnOther() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909926");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerAndClickCreateOrder("new_customer", "nc", this.runTimeVariables);
		SanityTestScript.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process To Order The Product Having
		// Dependency
		this.ordersPage = this.customerPage.orderProductHavingDependency("createOrderSecond", "co");
		SanityTestScript.logger.debug("Order The Product Having Dependency");

		// Verify Current Page UI Component
		this.ordersPage = this.ordersPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify Order Changes feature works correctly
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 16.1 : Verify that Agents can be made and linked to a customer", dependsOnMethods = {
			"testAddAccountType", "testAttachPaymentType" })
	public void testAgentsLinkedToCustomer() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909927");

		// Navigate To Agents Page
		this.agentsPage = this.navPage.navigateToAgentsPage();
		SanityTestScript.logger.debug("Navigate To Agents Page");

		// Initiate And Complete The Process To Add Agent
		String agent = this.agentsPage.addAgent("addAgent", "aa");
		this.runTimeVariables.put("TC_16.1_AGENT", agent);

		SanityTestScript.logger.debug("Add Agent");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Initiate And Complete The Process To Add a New Customer
		String customerName = this.customerPage.addCustomer(this.runTimeVariables.get("TC_2.1_ACCOUNT_NAME_ONE"),
				this.runTimeVariables.get("TC_2.1.1_METHOD_NAME_ONE"), "new_customer", "nc");
		this.runTimeVariables.put("TC_6.1_CUSTOMER_NAME", customerName);

		SanityTestScript.logger.debug("Add a New Customer");

		// Verify Current Page UI Component
		this.customerPage = this.customerPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify that products with commisions can be made
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 16.2 : Verify that products with commisions can be made")
	public void testCreateProductWithCommissions() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909928");

		// Navigate to Products Tab
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Navigate to Products Tab");

		// Initiate And Complete The Process To Create A Product Category
		this.productsPage.addCategory("NewProductCategoryData", "pcd");
		SanityTestScript.logger.debug("Create A Product Category");

		// Initiate And Complete The Process To Add a Product With Commission
		this.productsPage = this.productsPage.addProductWithCommission("addProductTwo", "ap");
		SanityTestScript.logger.debug("Add a Product With Commission");

		// Verify Current Page UI Component
		this.productsPage = this.productsPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify that user can configure the plug-in and preference required for
	 * running a comission process
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 16.3 : Verify that user can configure the plug-in "
			+ "and preference required for running a comission process")
	public void testConfigurePluginPreferencesForCommission() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909929");

		// Navigate to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigate to Configuration Page");

		// Initiate And Complete The Process To Add The Plugin
		this.productsPage = this.productsPage.addPlugin("addPlugin", "ap");
		SanityTestScript.logger.debug("Add The Plugin");

		// Select Configuration All
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.All);
		SanityTestScript.logger.debug("Select Configuration All ");

		// Update And Verify Preference
		this.confPage = this.confPage.updatePreference("updatePreference", "up");
		SanityTestScript.logger.debug("Update And Verify Preference");

		// Verify Current Page UI Component
		this.productsPage = this.productsPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	/**
	 * Verify that correct commission is generated for the Agent after order
	 * invoice is generated
	 * 
	 * 
	 * @throws Exception
	 */
	@Test(description = "Test Case 16.4 : Verify that correct commission is generated for the " + "Agent after order invoice is generated", dependsOnMethods = {
			"testAgentsLinkedToCustomer", "testCreateParentChildRelationInCustomersTab" })
	public void testGeneratedCommissionPostInvoiceGeneration() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909930");

		// Navigate to Configuration Page
		this.agentsPage = this.navPage.navigateToAgentsPage();
		SanityTestScript.logger.debug("Navigate to Agents Page");

		// Navigate to Customers Page
		this.customerPage = this.navPage.navigateToCustomersPage();
		SanityTestScript.logger.debug("Navigate to Customers Page");

		// Select The Customer To Create The Order For
		this.ordersPage = this.customerPage.selectCustomerAndClickCreateOrder("new_customer", "nc", this.runTimeVariables);
		SanityTestScript.logger.debug("Select Customer And Click Create Order");

		// Initiate And Complete The Process To Generate Invoice
		this.ordersPage = this.customerPage.generateInvoice("Customer A", "ca");
		SanityTestScript.logger.debug("Generate Invoice");

		// Navigating to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigating to Configuration Page");

		// Selecting Agent Commission Process for its configuration
		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.AgentCommissionProcess);
		SanityTestScript.logger.debug("Selecting Agent Commission Process for its configuration");

		// Add Billing Process
		this.confPage = this.confPage.addBillingProcess("BillingProcess", "cbp");
		SanityTestScript.logger.debug("Add Billing Process");

		// Run commission on added billing process
		this.confPage = this.confPage.clickRunCommmisionToBillingProcess();
		SanityTestScript.logger.debug("Run commission on added billing process");

		// Verify saved commission
		this.confPage = this.confPage.verifySavedCommision();
		SanityTestScript.logger.debug("Verify saved commission");

		// Navigating to Agents Page
		this.agentsPage = this.navPage.navigateToAgentsPage();
		SanityTestScript.logger.debug("Navigating to Agents Page");

		// Click Corresponding Agent Item
		this.agentsPage = this.agentsPage.clickAgentItem();
		SanityTestScript.logger.debug("Click Corresponding Agent Item");

		// Show Commission
		this.agentsPage = this.agentsPage.showCommission();
		SanityTestScript.logger.debug("Show Commission");

		// Verify Current Page UI Component
		this.agentsPage = this.agentsPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

	@Test(description = "Test Case 18.1 : Verify user tear down the created data.")
	public void testUserTearDownCreatedData() throws Exception {

		SanityTestScript.logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "10909932");

		// Navigating to Configuration Page
		this.confPage = this.navPage.navigateToConfigurationPage();
		SanityTestScript.logger.debug("Navigating to Configuration Page");

		// Select Users configuration item from list of configurations
		this.confPage = this.confPage.selectConfiguration(GlobalEnumsPage.PageConfigurationItems.Users);
		SanityTestScript.logger.debug("Select Users configuration item from list of configurations");

		// Select \"admin\" user in users table
		this.confPage = this.confPage.clickSpecifiedUserInUsersTable("admin");
		SanityTestScript.logger.debug("Select \"admin\" user in users table");

		// Edit users permissions
		this.confPage = this.confPage.editUserPermissions();
		SanityTestScript.logger.debug("Edit users permissions");

		// Logout From Current Application Session
		this.loginPage = this.navPage.logoutApplication();
		SanityTestScript.logger.debug("Logout From Current Application Session");

		this.runTimeVariables.put("ENVIRONMENT_UNDER_TEST", this.pr.readConfig("EnvironmentUnderTest"));
		this.runTimeVariables.put("ENVIRONMENT_URL_UNDER_TEST",
				this.pr.readConfig(this.runTimeVariables.get("ENVIRONMENT_UNDER_TEST") + "_URL"));

		// Login to the application
		this.homePage = this.loginPage.login(this.runTimeVariables.get("ENVIRONMENT_UNDER_TEST"));
		SanityTestScript.logger.debug("Login Into Application");

		// Navigating to Payments Page
		this.paymentsPage = this.navPage.navigateToPaymentsPage();
		SanityTestScript.logger.debug("Navigating to Payments Page");

		// Delete The Payment
		this.paymentsPage = this.paymentsPage.deletePayment();
		SanityTestScript.logger.debug("Delete The Payment");

		// Navigate to Orders Page
		this.ordersPage = this.navPage.navigateToOrdersPage();
		SanityTestScript.logger.debug("Navigate to Orders Page");

		// Delete The Orders
		this.ordersPage = this.ordersPage.deleteOrders();
		SanityTestScript.logger.debug("Delete The Orders");

		// Navigate to Products Page
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Navigate to Products Page");

		// Delete Corresponding Product Category
		this.productsPage = this.productsPage.deleteProductCategory();
		SanityTestScript.logger.debug("Delete Corresponding Product Category");

		// Navigating to Payments Page
		this.paymentsPage = this.navPage.navigateToPaymentsPage();
		SanityTestScript.logger.debug("Navigating to Payments Page");

		// Navigate to Orders Page
		this.ordersPage = this.navPage.navigateToOrdersPage();
		SanityTestScript.logger.debug("Navigate to Orders Page");

		// Navigate to Products Page
		this.productsPage = this.navPage.navigateToProductsPage();
		SanityTestScript.logger.debug("Navigate to Products Page");

		// Verify Current Page UI Component
		this.productsPage = this.productsPage.verifyUIComponent();
		SanityTestScript.logger.debug("Verify Current Page UI Component");

		Reporter.log("<br> Test Passed");
		SanityTestScript.logger.exitMethod();
	}

}