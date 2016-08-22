package com.jbilling.framework.pageclasses;

import com.jbilling.framework.globals.GlobalController;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.interfaces.ElementField;
import com.jbilling.framework.interfaces.LocateBy;
import com.jbilling.framework.utilities.textutilities.TextUtilities;

public class NavigatorPage {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@LocateBy(xpath = "(//span[text()='Customers'])[2]")
	private ElementField LT_CUSTOMERS;

	@LocateBy(xpath = "//span[text()='Enrollment']")
	private ElementField LT_ENROLLMENT;

	@LocateBy(xpath = "//span[text()='Agents']")
	private ElementField LT_AGENTS;

	@LocateBy(xpath = "//span[text()='Invoices']")
	private ElementField LT_INVOICES;

	@LocateBy(xpath = "//span[text()='Payments']")
	private ElementField LT_PAYMENTS;

	@LocateBy(xpath = "//span[text()='Orders']")
	private ElementField LT_ORDERS;

	@LocateBy(xpath = "//span[text()='Billing']")
	private ElementField LT_BILLINGS;

	@LocateBy(xpath = "//span[text()='Mediation']")
	private ElementField LT_MEDIATION;

	@LocateBy(xpath = "//span[text()='EDI']")
	private ElementField LT_EDI;

	@LocateBy(xpath = "//span[text()='Reports']")
	private ElementField LT_REPORTS;

	@LocateBy(xpath = "//span[text()='Provisioning']")
	private ElementField LT_PROVISIONING;

	@LocateBy(xpath = "//span[text()='Discounts']")
	private ElementField LT_DISCOUNTS;

	@LocateBy(xpath = "//span[text()='Products']")
	private ElementField LT_PRODUCTS;

	@LocateBy(xpath = "//span[text()='Plans']")
	private ElementField LT_PLANS;

	@LocateBy(xpath = "//a[@href='/jbilling/config/index']")
	private ElementField LT_CONFIGURATION;

	@LocateBy(xpath = "//a[@class='logout']")
	private ElementField LT_LOGOUT;

	@LocateBy(xpath = "//a[@id='impersonate']")
	private ElementField LT_IMPERSONATE;

	@LocateBy(id = "impersonation-select")
	private ElementField DD_CHILD_ENTITY_TO_IMPERSONATE;

	@LocateBy(id = "impersonation-button")
	private ElementField BT_SELECT;

	@LocateBy(xpath = "//a[@class='dissimulate']")
	private ElementField LT_NEW_CHILD_COMPANY_NAME;

	public CustomersPage navigateToCustomersPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_CUSTOMERS, true);
		NavigatorPage.logger.debug("Navigating to Customers page DONE");

		return GlobalController.brw.initElements(CustomersPage.class);
	}

	public void navigateToEnrollmentPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ENROLLMENT, true);
		NavigatorPage.logger.debug("Navigating to Enrollment page DONE");
	}

	public AgentsPage navigateToAgentsPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_AGENTS, true);
		NavigatorPage.logger.debug("Navigating to Agents page DONE");

		return GlobalController.brw.initElements(AgentsPage.class);
	}

	public InvoicePage navigateToInvoicesPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_INVOICES, true);
		NavigatorPage.logger.debug("Navigating to Invoices page DONE");

		return GlobalController.brw.initElements(InvoicePage.class);
	}

	public PaymentsPage navigateToPaymentsPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PAYMENTS, true);
		NavigatorPage.logger.debug("Navigating to Payments page DONE");

		return GlobalController.brw.initElements(PaymentsPage.class);
	}

	public OrdersPage navigateToOrdersPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ORDERS, true);
		NavigatorPage.logger.debug("Navigating to Orders page DONE");

		return GlobalController.brw.initElements(OrdersPage.class);
	}

	public void navigateToBillingPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_BILLINGS, true);
		NavigatorPage.logger.debug("Navigating to Billings page DONE");
	}

	public void navigateToMediationPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_MEDIATION, true);
		NavigatorPage.logger.debug("Navigating to Mediation page DONE");
	}

	public void navigateToEDIPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_EDI, true);
		NavigatorPage.logger.debug("Navigating to EDI page DONE");
	}

	public ReportsPage navigateToReportsPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_REPORTS, true);
		NavigatorPage.logger.debug("Navigating to Reports page DONE");

		return GlobalController.brw.initElements(ReportsPage.class);
	}

	public void navigateToProvisioningPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PROVISIONING, true);
		NavigatorPage.logger.debug("Navigating to Provisioning page DONE");
	}

	public DiscountsPage navigateToDiscountsPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_DISCOUNTS, true);
		NavigatorPage.logger.debug("Navigating to Discounts page DONE");

		return GlobalController.brw.initElements(DiscountsPage.class);
	}

	public ProductsPage navigateToProductsPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PRODUCTS, true);
		NavigatorPage.logger.debug("Navigating to Products page DONE");

		return GlobalController.brw.initElements(ProductsPage.class);
	}

	public PlansPage navigateToPlanPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_PLANS, true);
		NavigatorPage.logger.debug("Navigating to Plans page DONE");

		return GlobalController.brw.initElements(PlansPage.class);
	}

	public ConfigurationPage navigateToConfigurationPage() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_CONFIGURATION, true);
		NavigatorPage.logger.debug("Navigating to Configuration page DONE");

		return GlobalController.brw.initElements(ConfigurationPage.class);
	}

	/**
	 * This method will Login Application
	 * 
	 * @throws Exception
	 */
	public LoginPage logoutApplication(String url) throws Exception {
		GlobalController.brw.navigateToUrl(url);
		NavigatorPage.logger.debug("Logged out of application");

		return GlobalController.brw.initElements(LoginPage.class);
	}

	/**
	 * This method will Logout Application
	 * 
	 * @throws Exception
	 */
	public LoginPage logoutApplication() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_LOGOUT);
		NavigatorPage.logger.debug("Logged out of application");

		return GlobalController.brw.initElements(LoginPage.class);
	}

	public void clickImpersonate() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_IMPERSONATE, true);
	}

	public void clickSelect() throws Exception {
		GlobalController.brw.clickLinkText(this.BT_SELECT, true);
	}

	public String getCompanyNameSwitched() throws Exception {
		String childCompanyName = GlobalController.brw.getText(this.LT_NEW_CHILD_COMPANY_NAME);

		return childCompanyName;
	}

	public HomePage switchToChildCompany(String companyName) throws Exception {
		this.clickImpersonate();
		GlobalController.brw.selectDropDown(this.DD_CHILD_ENTITY_TO_IMPERSONATE, companyName);
		this.clickSelect();
		return GlobalController.brw.initElements(HomePage.class);
	}

	public HomePage verifySwitchedToChildCompany(String companyName) throws Exception {
		String childComapnyName = this.getCompanyNameSwitched();
		if (TextUtilities.contains(childComapnyName, companyName) == false) {
			throw new Exception("Verification failed for company switched to child company [" + companyName + "]");
		}
		return GlobalController.brw.initElements(HomePage.class);
	}

	public boolean isChildCompanyImpersonated(String companyName) throws Exception {
		this.clickImpersonate();

		return GlobalController.brw.isValuePresentInDropDown(this.DD_CHILD_ENTITY_TO_IMPERSONATE, companyName);
	}

	public HomePage switchToParentCompany() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_NEW_CHILD_COMPANY_NAME);
		return GlobalController.brw.initElements(HomePage.class);
	}
}
